package com.meditail.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meditail.api.models.Cart;
import com.meditail.api.repositories.CartRepository;

@Service
public class CartService {

	private static final Logger logger = LoggerFactory.getLogger(CartService.class);

	@Autowired
	private CartRepository cartRepository;

	public List<Cart> getAll() {
		return cartRepository.findAll();
	}

	public Cart getOne(Long id) {
		return cartRepository.findById(id).orElse(null);
	}

	public Cart insert(Cart cart) {
		return cartRepository.save(cart);
	}

	public Cart update(Cart cart, Long id) {
		Cart existingCart = getOne(id);
		if (existingCart != null) {
			existingCart.setId(cart.getId());
			existingCart.setTotalCostOfItems(cart.getTotalCostOfItems());
			existingCart.setState(cart.isState());
			existingCart.setStatus(cart.getStatus());
			existingCart.setCreatedDate(cart.getCreatedDate());
			existingCart.setUpdatedDate(cart.getUpdatedDate());
			existingCart.setDeletedDate(cart.getDeletedDate());
			existingCart.setCreatedBy(cart.getCreatedBy());
			existingCart.setUpdatedBy(cart.getUpdatedBy());
			existingCart.setDeletedBy(cart.getDeletedBy());
			existingCart.setItems(cart.getItems());
			return cartRepository.save(existingCart);
		} else {
			return null;
		}

	}

	public void delete(Long id) {
		Cart existingCart = getOne(id);
		if (existingCart != null) {
			cartRepository.delete(existingCart);
		}
	}

}
