package offtocol.domain.model;


import java.io.Serializable;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;



@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart implements Serializable {



	private static final long serialVersionUID = 1L;



	private final Map<Integer, CartHouse> cartHouses = new LinkedHashMap<>();

	private final Map<Integer, CartItem> cartItems = new LinkedHashMap<>();

	private final Map<Integer, CartRoomAndDate> cartCases = new LinkedHashMap<>();



	public Collection<CartHouse> getCartHouses() {
		return cartHouses.values();
	}

	public Collection<CartItem> getCartItems() {
		return cartItems.values();
	}

	public Map<Integer, CartRoomAndDate> getCartCases2() {
		return cartCases;
	}

	public Collection<CartRoomAndDate> getCartCases() {
		return cartCases.values();
	}



	public Cart add3(CartHouse cartHouse) {
		cartHouses.put(1, cartHouse);
		return this;
	}



	public Cart add(CartItem cartItem) {

		Integer goodsId = cartItem.getGoods().getGoodsId();

		cartItems.put(goodsId, cartItem);

		return this;

	}



	public Cart add2(CartRoomAndDate cartRoomAndDate) {
		cartCases.put(1, cartRoomAndDate);
		return this;
	}



	public Cart clear() {
		cartItems.clear();
		return this;
	}




	public Cart remove(Integer goodsId) {
		cartItems.remove(goodsId);
		return this;
	}



	public boolean isEmpty() {
		return cartItems.isEmpty();
	}



	public int getTotalAmount() {

		int amount = 0;

		for (CartItem cartItem : cartItems.values()) {
			amount += cartItem.getGoods().getPrice();
		}

		return amount;

	}



	//This function makes a token for cart.
	public String calcSignature() {

		byte[] serialized = SerializationUtils.serialize(this);
		byte[] signature = null;

		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			signature = messageDigest.digest(serialized);
		} catch (
			NoSuchAlgorithmException ignored
		) {

		}

		return new String(Base64.encode(signature));

	}



}
