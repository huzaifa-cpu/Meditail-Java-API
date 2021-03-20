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

import com.meditail.api.models.MedicalStore;
import com.meditail.api.services.MedicalStoreService;

@RestController
public class MedicalStoreController {

	private static final Logger logger = LoggerFactory.getLogger(MedicalStoreController.class);

	@Autowired
	private MedicalStoreService medicalStoreService;

	@GetMapping("/medicalStores")
	public ResponseEntity<List<MedicalStore>> getAll() {
		return ResponseEntity.ok(medicalStoreService.getAll());
	}

	@GetMapping("/medicalStore/{id}")
	public ResponseEntity<MedicalStore> getOne(@PathVariable Long id) {
		return ResponseEntity.ok(medicalStoreService.getOne(id));
	}

	@PostMapping("/medicalStore")
	public void insert(@RequestBody MedicalStore medicalStore) {
		ResponseEntity.ok(medicalStoreService.insert(medicalStore));
	}

	@PostMapping("/medicalStores")
	public ResponseEntity<List<MedicalStore>> inserts(@RequestBody MedicalStore medicalStore) {
		medicalStoreService.insert(medicalStore);
		return ResponseEntity.ok(medicalStoreService.getAll());
	}

	@PutMapping("/medicalStore/{id}")
	public void update(@RequestBody MedicalStore medicalStore, @PathVariable Long id) {
		ResponseEntity.ok(medicalStoreService.update(medicalStore, id));
	}

	@PutMapping("/medicalStores/{id}")
	public ResponseEntity<List<MedicalStore>> updates(@RequestBody MedicalStore medicalStore, @PathVariable Long id) {
		medicalStoreService.update(medicalStore, id);
		return ResponseEntity.ok(medicalStoreService.getAll());
	}

	@DeleteMapping("/medicalStore/{id}")
	public void delete(@PathVariable Long id) {
		medicalStoreService.delete(id);
	}

	@DeleteMapping("/medicalStores/{id}")
	public ResponseEntity<List<MedicalStore>> deletes(@PathVariable Long id) {
		medicalStoreService.delete(id);
		return ResponseEntity.ok(medicalStoreService.getAll());
	}

}
