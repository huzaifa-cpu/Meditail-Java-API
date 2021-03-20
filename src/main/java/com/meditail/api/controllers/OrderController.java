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

import com.meditail.api.models.Order;
import com.meditail.api.services.OrderService;

@RestController
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;

	@GetMapping("/orders")
	public ResponseEntity<List<Order>> getAll() {
		return ResponseEntity.ok(orderService.getAll());
	}

	@GetMapping("/order/{id}")
	public ResponseEntity<Order> getOne(@PathVariable Long id) {
		return ResponseEntity.ok(orderService.getOne(id));
	}

	@PostMapping("/order")
	public void insert(@RequestBody Order order) {
		ResponseEntity.ok(orderService.insert(order));
	}

	@PostMapping("/orders")
	public ResponseEntity<List<Order>> inserts(@RequestBody Order order) {
		orderService.insert(order);
		return ResponseEntity.ok(orderService.getAll());
	}

	@PutMapping("/order/{id}")
	public void update(@RequestBody Order order, @PathVariable Long id) {
		ResponseEntity.ok(orderService.update(order, id));
	}

	@PutMapping("/orders/{id}")
	public ResponseEntity<List<Order>> updates(@RequestBody Order order, @PathVariable Long id) {
		orderService.update(order, id);
		return ResponseEntity.ok(orderService.getAll());
	}

	@DeleteMapping("/order/{id}")
	public void delete(@PathVariable Long id) {
		orderService.delete(id);
	}

	@DeleteMapping("/orders/{id}")
	public ResponseEntity<List<Order>> deletes(@PathVariable Long id) {
		orderService.delete(id);
		return ResponseEntity.ok(orderService.getAll());
	}

}
