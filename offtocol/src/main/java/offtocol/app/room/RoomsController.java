package offtocol.app.room;


import java.time.LocalDate;

import java.util.List;
import java.util.Collection;

import offtocol.domain.model.*;

import offtocol.domain.service.goods.*;
import offtocol.domain.service.house.*;
import offtocol.domain.service.room.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("rooms/{houseId}")
public class RoomsController {



	@Autowired
	RoomService roomService;

	@Autowired
	HouseService houseService;

	@Autowired
	GoodsService goodsService;

	@Autowired
	Cart cart;



	@GetMapping
	String listRooms(
		@PathVariable("houseId") Integer houseId,
		Model model
	) {


		if (cart.isEmpty()) {

			List<Goods> goodsList = goodsService.listGoods(houseId);
			House house = houseService.findHouse(houseId);
			Collection<CartItem> cartItems = cart.getCartItems();

			model.addAttribute("goodsList", goodsList);
			model.addAttribute("house", house);
			model.addAttribute("cartItems", cartItems);

			return "Goods/listGoods";

		}


		LocalDate today = LocalDate.now();
		model.addAttribute("date", today);

		List<ReservableRoom> rooms = roomService.findReservableRooms(today, houseId);
		model.addAttribute("rooms", rooms);

		House house = houseService.findHouse(houseId);
		model.addAttribute("house", house);

		int amount = cart.getTotalAmount();
		model.addAttribute("amount", amount);


		return "room/listRooms";


	}



	@GetMapping(path = "{date}")
	String listRooms(
		@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate localDate,
		@PathVariable("houseId") Integer houseId,
		Model model
	) {


		List<ReservableRoom> rooms = roomService.findReservableRooms(localDate, houseId);
		model.addAttribute("rooms", rooms);

		House house = houseService.findHouse(houseId);
		model.addAttribute("house", house);

		int amount = cart.getTotalAmount();
		model.addAttribute("amount", amount);


		return "room/listRooms";


	}



}
