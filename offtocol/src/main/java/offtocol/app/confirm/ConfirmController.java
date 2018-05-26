package offtocol.app.confirm;


import offtocol.domain.model.*;

import offtocol.domain.service.reservation.ReservationService;
import offtocol.domain.service.reservationLine.ReservationLineService;
import offtocol.domain.service.room.RoomService;
import offtocol.domain.service.user.ReservationUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

import org.springframework.security.core.annotation.AuthenticationPrincipal;




@Controller
@RequestMapping("confirm")
public class ConfirmController {




	@Autowired
	RoomService roomService;

	@Autowired
	ReservationService reservationService;

	@Autowired
	ReservationLineService reservationLineService;

	@Autowired
	Cart cart;



	@GetMapping
	String confirm(Model model) {


		Collection<CartHouse> cartHouses = cart.getCartHouses();
		model.addAttribute("cartHouses", cartHouses);

		Collection<CartRoomAndDate> cartCases = cart.getCartCases();
		model.addAttribute("cartCases", cartCases);

		Collection<CartItem> cartItems = cart.getCartItems();
		model.addAttribute("cartItems", cartItems);

		int amount = cart.getTotalAmount();
		model.addAttribute("amount", amount);

		//A token for cart is made in order to send when the reserve botton is clicked.
		model.addAttribute("sig", cart.calcSignature());


		return "order/confirm";


	}




	@PostMapping
	String reserve(
		@AuthenticationPrincipal ReservationUserDetails userDetails,
		@RequestParam String signature
	) {



		//A token for cart is made in order to check if this token is same as the token send.
		if (!Objects.equals(cart.calcSignature(), signature)) {
			throw new InvalidCartException("This cart is invalid.");
		}



		Reservation reservation = new Reservation();


		String uuid2 = UUID
			.randomUUID()
			.toString();

		reservation.setUuid(uuid2);


		User user = userDetails.getUser();
		reservation.setUser(user);


		CartRoomAndDate cartRoomAndDate = cart.getCartCases2().get(1);

		Integer roomId = cartRoomAndDate.getRoom().getRoomId();

		LocalDate date = cartRoomAndDate.getDate();

		ReservableRoom reservableRoom = new ReservableRoom(
			new ReservableRoomId(roomId, date)
		);

		reservation.setReservableRoom(reservableRoom);


		reservation.setStartTime(
			cartRoomAndDate.getStartTime()
		);


		reservation.setEndTime(
			cartRoomAndDate.getEndTime()
		);


		reservation.setReservationDate(
			LocalDate.now()
		);


		reservationService.reserve(reservation);



		Collection<CartItem> cartItems = cart.getCartItems();


		for (CartItem cartItem : cartItems) {

			ReservationLine reservationLine = new ReservationLine();

			reservationLine.setUuid(uuid2);

			Goods goods = cartItem.getGoods();
			reservationLine.setGoods(goods);

			reservationLineService.reserve(reservationLine);

		}



		cart.clear();

		return "order/finish";



	}




}
