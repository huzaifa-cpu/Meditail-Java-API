package com.meditail.api.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.meditail.api.models.Cart;
import com.meditail.api.services.CartService;

@RestController
public class CartController {

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private CartService cartService;

	@GetMapping("/carts")
	public ResponseEntity<List<Cart>> getAll() {
		return ResponseEntity.ok(cartService.getAll());
	}

	@GetMapping("/cart/{id}")
	public ResponseEntity<Cart> getOne(@PathVariable Long id) {
		return ResponseEntity.ok(cartService.getOne(id));
	}

	@PostMapping("/cart")
	public void insert(@RequestBody Cart cart) {
		ResponseEntity.ok(cartService.insert(cart));
	}

	@PostMapping("/carts")
	public ResponseEntity<List<Cart>> inserts(@RequestBody Cart cart) {
		cartService.insert(cart);
		return ResponseEntity.ok(cartService.getAll());
	}

	@PutMapping("/cart/{id}")
	public void update(@RequestBody Cart cart, @PathVariable Long id) {
		ResponseEntity.ok(cartService.update(cart, id));
	}

	@PutMapping("/carts/{id}")
	public ResponseEntity<List<Cart>> updates(@RequestBody Cart cart, @PathVariable Long id) {
		cartService.update(cart, id);
		return ResponseEntity.ok(cartService.getAll());
	}

	@DeleteMapping("/cart/{id}")
	public void delete(@PathVariable Long id) {
		cartService.delete(id);
	}

	@DeleteMapping("/carts/{id}")
	public ResponseEntity<List<Cart>> deletes(@PathVariable Long id) {
		cartService.delete(id);
		return ResponseEntity.ok(cartService.getAll());
	}

}
