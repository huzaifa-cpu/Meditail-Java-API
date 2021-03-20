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

import com.meditail.api.models.Item;
import com.meditail.api.services.ItemService;

@RestController
public class ItemController {

	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

	@Autowired
	private ItemService itemService;

	@GetMapping("items")
	public ResponseEntity<List<Item>> getAll() {
		return ResponseEntity.ok(itemService.getAll());
	}

	@GetMapping("/item/{id}")
	public ResponseEntity<Item> getOne(@PathVariable Long id) {
		return ResponseEntity.ok(itemService.getOne(id));
	}

	@PostMapping("/item")
	public void insert(@RequestBody Item item) {
		ResponseEntity.ok(itemService.insert(item));
	}

	@PostMapping("/items")
	public ResponseEntity<List<Item>> inserts(@RequestBody Item item) {
		itemService.insert(item);
		return ResponseEntity.ok(itemService.getAll());
	}

	@PutMapping("/item/{id}")
	public void update(@RequestBody Item item, @PathVariable Long id) {
		ResponseEntity.ok(itemService.update(item, id));
	}

	@PutMapping("/items/{id}")
	public ResponseEntity<List<Item>> updates(@RequestBody Item item, @PathVariable Long id) {
		itemService.update(item, id);
		return ResponseEntity.ok(itemService.getAll());
	}

	@DeleteMapping("/item/{id}")
	public void delete(@PathVariable Long id) {
		itemService.delete(id);
	}

	@DeleteMapping("/items/{id}")
	public ResponseEntity<List<Item>> deletes(@PathVariable Long id) {
		itemService.delete(id);
		return ResponseEntity.ok(itemService.getAll());
	}

}
