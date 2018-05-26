package offtocol.app.house;


import offtocol.domain.model.House;
import offtocol.domain.service.house.HouseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
@RequestMapping("houses")
public class HousesController {


	@Autowired
	HouseService houseService;


	@GetMapping
	String listHouses(
		Model model
	) {

		List<House> houses = houseService.findAll();

		model.addAttribute("houses", houses);

		return "house/listHouses";

	}


}
