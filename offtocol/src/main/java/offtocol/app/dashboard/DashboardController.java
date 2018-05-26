package offtocol.app.dashboard;


import java.util.List;

import offtocol.domain.model.*;
import offtocol.domain.service.reservation.ReservationService;
import offtocol.domain.service.user.ReservationUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.core.annotation.AuthenticationPrincipal;



@Controller
@RequestMapping("dash")
public class DashboardController {


	@Autowired
	ReservationService reservationService;


	@GetMapping
	String listReservations(
		@AuthenticationPrincipal ReservationUserDetails userDetails,
		Model model
	)	{

		User user = userDetails.getUser();

		List<Reservation> reservations = reservationService.showReservationsAtDashboard(
			user.getUsername()
		);

		model.addAttribute("reservations", reservations);

		return "dashboard/dashboard";

	}


}
