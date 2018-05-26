package offtocol.app.goods;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import offtocol.domain.model.*;
import offtocol.domain.service.goods.GoodsService;
import offtocol.domain.service.house.HouseService;

import java.util.List;
import java.util.Collection;


@Controller
@RequestMapping("goods/{houseId}")
public class GoodsController {



	@Autowired
	GoodsService goodsService;

	@Autowired
	HouseService houseService;

	@Autowired
	Cart cart;



	@GetMapping
	String showGoods(
		@PathVariable("houseId") Integer houseId,
		Model model
	) {

		List<Goods> goodsList = goodsService.listGoods(houseId);
		House house = houseService.findHouse(houseId);

		model.addAttribute("goodsList", goodsList);
		model.addAttribute("house", house);

		cart.clear();

		CartHouse cartHouse = new CartHouse();
		cartHouse.setHouse(house);
		cart.add3(cartHouse);

		return "goods/listGoods";

	}



	@PostMapping
	String showGoods(
		@RequestParam("addedGoodsId") Integer goodsId,
		@PathVariable("houseId") Integer houseId,
		Model model
	) {


		List<Goods> goodsList = goodsService.listGoods(houseId);
		House house = houseService.findHouse(houseId);

		model.addAttribute("goodsList", goodsList);
		model.addAttribute("house", house);


		CartItem cartItem = new CartItem();
		Goods goods = goodsService.findOne(goodsId);

		cartItem.setGoods(goods);

		cart.add(cartItem);


		Collection<CartItem> cartItems = cart.getCartItems();
		model.addAttribute("cartItems", cartItems);


		return "goods/listGoods";


	}



	@PostMapping(params = "remove")
	String removeFromCart(
		@RequestParam("removedGoodsId") Integer goodsId,
		@PathVariable("houseId") Integer houseId,
		Model model
	) {


		List<Goods> goodsList = goodsService.listGoods(houseId);
		House house = houseService.findHouse(houseId);

		model.addAttribute("goodsList", goodsList);
		model.addAttribute("house", house);


		cart.remove(goodsId);


		Collection<CartItem> cartItems = cart.getCartItems();
		model.addAttribute("cartItems", cartItems);


		return "goods/listGoods";


	}



}
