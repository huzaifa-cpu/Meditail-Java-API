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

import com.meditail.api.models.Discount;
import com.meditail.api.services.DiscountService;

@RestController
public class DiscountController {

	private static final Logger logger = LoggerFactory.getLogger(DiscountController.class);

	@Autowired
	private DiscountService discountService;

	@GetMapping("/discounts")
	public ResponseEntity<List<Discount>> getAll() {
		return ResponseEntity.ok(discountService.getAll());
	}

	@GetMapping("/discount/{id}")
	public ResponseEntity<Discount> getOne(@PathVariable Long id) {
		return ResponseEntity.ok(discountService.getOne(id));
	}

	@PostMapping("/discount")
	public void insert(@RequestBody Discount discount) {
		ResponseEntity.ok(discountService.insert(discount));
	}

	@PostMapping("/discounts")
	public ResponseEntity<List<Discount>> inserts(@RequestBody Discount discount) {
		discountService.insert(discount);
		return ResponseEntity.ok(discountService.getAll());
	}

	@PutMapping("/discount/{id}")
	public void update(@RequestBody Discount discount, @PathVariable Long id) {
		ResponseEntity.ok(discountService.update(discount, id));
	}

	@PutMapping("/discounts/{id}")
	public ResponseEntity<List<Discount>> updates(@RequestBody Discount discount, @PathVariable Long id) {
		discountService.update(discount, id);
		return ResponseEntity.ok(discountService.getAll());
	}

	@DeleteMapping("/discount/{id}")
	public void delete(@PathVariable Long id) {
		discountService.delete(id);
	}

	@DeleteMapping("/discounts/{id}")
	public ResponseEntity<List<Discount>> deletes(@PathVariable Long id) {
		discountService.delete(id);
		return ResponseEntity.ok(discountService.getAll());
	}

}
