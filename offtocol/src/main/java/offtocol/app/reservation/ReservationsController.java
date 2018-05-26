package offtocol.app.reservation;


import java.time.LocalDate;
import java.time.LocalTime;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import offtocol.domain.model.*;
import offtocol.domain.service.reservation.*;
import offtocol.domain.service.room.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.annotation.Validated;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("reservations/{date}/{roomId}")
public class ReservationsController {



	@Autowired
	RoomService roomService;

	@Autowired
	ReservationService reservationService;

	@Autowired
	Cart cart;



	@ModelAttribute
	ReservationForm setUpForm() {

		ReservationForm form = new ReservationForm();

		form.setStartTime(
			LocalTime.of(14, 0)
		);

		return form;

	}



	@GetMapping
	String reserveForm(
		@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
		@PathVariable("date") LocalDate date,
		@PathVariable("roomId") Integer roomId,
		Model model
	) {

		ReservableRoomId reservableRoomId = new ReservableRoomId(roomId, date);

		List<Reservation> reservations = reservationService.findReservations(reservableRoomId);

		List<LocalTime> timeList = Stream
			.iterate(
				LocalTime.of(10, 0),
				t -> t.plusMinutes(60)
			)
			.limit(9)
			.collect(
				Collectors.toList()
			);

		model.addAttribute("room", roomService.findMeetingRoom(roomId));
		model.addAttribute("reservations", reservations);
		model.addAttribute("timeList", timeList);

		return "reservation/reserveForm";

	}




	@PostMapping
	String check(
		@Validated ReservationForm form,
		BindingResult bindingResult,
		@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date,
		@PathVariable("roomId") Integer roomId,
		Model model
	) {


		if (
			bindingResult.hasErrors()
		) {
			return reserveForm(date, roomId, model);
		}


		ReservableRoom reservableRoom = new ReservableRoom(
			new ReservableRoomId(roomId, date)
		);

		Reservation reservation = new Reservation();

		reservation.setReservableRoom(reservableRoom);

		reservation.setStartTime(
			form.getStartTime()
		);

		reservation.setEndTime(
			form.getStartTime().plusHours(1)
		);


		try {
			reservationService.check(reservation);
		}
		catch (UnavailableReservationException | AlreadyReservedException e) {
			model.addAttribute(
				"error",
				e.getMessage()
			);
			return reserveForm(date, roomId, model);
		}


		CartRoomAndDate cartRoomAndDate = new CartRoomAndDate();


		MeetingRoom room = roomService.findMeetingRoom(roomId);
		cartRoomAndDate.setRoom(room);

		cartRoomAndDate.setDate(date);

		cartRoomAndDate.setStartTime(
			form.getStartTime()
		);

		cartRoomAndDate.setEndTime(
			form.getStartTime().plusHours(1)
		);

		cart.add2(cartRoomAndDate);


		return "redirect:/confirm";


	}



}
