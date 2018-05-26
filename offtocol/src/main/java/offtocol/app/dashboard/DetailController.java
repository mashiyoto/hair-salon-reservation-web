package offtocol.app.dashboard;


import offtocol.domain.model.*;
import offtocol.domain.service.reservation.ReservationService;
import offtocol.domain.service.reservationLine.ReservationLineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
@RequestMapping("menu/{reservationId}")
public class DetailController {


	@Autowired
	ReservationService reservationService;

	@Autowired
	ReservationLineService reservationLineService;


	@GetMapping
	String showMenu(
		@PathVariable("reservationId") Integer reservationId,
		Model model
	) {

		Reservation reservation = reservationService.findReservation(reservationId);

		List<ReservationLine> reservationLines = reservationLineService.showReservationLines(reservation.getUuid());

		model.addAttribute("reservationLines", reservationLines);

		return "dashboard/menu";

	}


}
