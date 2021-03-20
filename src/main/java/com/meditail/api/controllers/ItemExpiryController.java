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

import com.meditail.api.models.ItemExpiry;
import com.meditail.api.services.ItemExpiryService;

@RestController
public class ItemExpiryController {

	private static final Logger logger = LoggerFactory.getLogger(ItemExpiryController.class);

	@Autowired
	private ItemExpiryService itemExpiryService;

	@GetMapping("/itemExpiries")
	public ResponseEntity<List<ItemExpiry>> getAll() {
		return ResponseEntity.ok(itemExpiryService.getAll());
	}

	@GetMapping("/itemExpiry/{id}")
	public ResponseEntity<ItemExpiry> getOne(@PathVariable Long id) {
		return ResponseEntity.ok(itemExpiryService.getOne(id));
	}

	@PostMapping("/itemExpiry")
	public void insert(@RequestBody ItemExpiry itemExpiry) {
		ResponseEntity.ok(itemExpiryService.insert(itemExpiry));
	}

	@PostMapping("/itemExpiries")
	public ResponseEntity<List<ItemExpiry>> inserts(@RequestBody ItemExpiry itemExpiry) {
		itemExpiryService.insert(itemExpiry);
		return ResponseEntity.ok(itemExpiryService.getAll());
	}

	@PutMapping("/itemExpiry/{id}")
	public void update(@RequestBody ItemExpiry itemExpiry, @PathVariable Long id) {
		ResponseEntity.ok(itemExpiryService.update(itemExpiry, id));
	}

	@PutMapping("/itemExpiries/{id}")
	public ResponseEntity<List<ItemExpiry>> updates(@RequestBody ItemExpiry itemExpiry, @PathVariable Long id) {
		itemExpiryService.update(itemExpiry, id);
		return ResponseEntity.ok(itemExpiryService.getAll());
	}

	@DeleteMapping("/itemExpiry/{id}")
	public void delete(@PathVariable Long id) {
		itemExpiryService.delete(id);
	}

	@DeleteMapping("/itemExpiries/{id}")
	public ResponseEntity<List<ItemExpiry>> deletes(@PathVariable Long id) {
		itemExpiryService.delete(id);
		return ResponseEntity.ok(itemExpiryService.getAll());
	}

}
