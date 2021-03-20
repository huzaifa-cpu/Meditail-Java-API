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

import com.meditail.api.models.ItemCategory;
import com.meditail.api.services.ItemCategoryService;

@RestController
public class ItemCategoryController {

	private static final Logger logger = LoggerFactory.getLogger(ItemCategoryController.class);

	@Autowired
	private ItemCategoryService itemCategoryService;

	@GetMapping("/itemCategories")
	public ResponseEntity<List<ItemCategory>> getAll() {
		return ResponseEntity.ok(itemCategoryService.getAll());
	}

	@GetMapping("/itemCategory/{id}")
	public ResponseEntity<ItemCategory> getOne(@PathVariable Long id) {
		return ResponseEntity.ok(itemCategoryService.getOne(id));
	}

	@PostMapping("/itemCategory")
	public void insert(@RequestBody ItemCategory itemCategory) {
		ResponseEntity.ok(itemCategoryService.insert(itemCategory));
	}

	@PostMapping("/itemCategories")
	public ResponseEntity<List<ItemCategory>> inserts(@RequestBody ItemCategory itemCategory) {
		itemCategoryService.insert(itemCategory);
		return ResponseEntity.ok(itemCategoryService.getAll());
	}

	@PutMapping("/itemCategory/{id}")
	public void update(@RequestBody ItemCategory itemCategory, @PathVariable Long id) {
		ResponseEntity.ok(itemCategoryService.update(itemCategory, id));
	}

	@PutMapping("/itemCategories/{id}")
	public ResponseEntity<List<ItemCategory>> updates(@RequestBody ItemCategory itemCategory, @PathVariable Long id) {
		itemCategoryService.update(itemCategory, id);
		return ResponseEntity.ok(itemCategoryService.getAll());
	}

	@DeleteMapping("/itemCategory/{id}")
	public void delete(@PathVariable Long id) {
		itemCategoryService.delete(id);
	}

	@DeleteMapping("/itemCategories/{id}")
	public ResponseEntity<List<ItemCategory>> deletes(@PathVariable Long id) {
		itemCategoryService.delete(id);
		return ResponseEntity.ok(itemCategoryService.getAll());
	}

}
