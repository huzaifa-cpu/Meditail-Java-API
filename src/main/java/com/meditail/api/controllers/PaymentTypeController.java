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

import com.meditail.api.models.PaymentType;
import com.meditail.api.services.PaymentTypeService;

@RestController
public class PaymentTypeController {

	private static final Logger logger = LoggerFactory.getLogger(PaymentTypeController.class);

	@Autowired
	private PaymentTypeService paymentTypeService;

	@GetMapping("/paymentTypes")
	public ResponseEntity<List<PaymentType>> getAll() {
		return ResponseEntity.ok(paymentTypeService.getAll());
	}

	@GetMapping("/paymentType/{id}")
	public ResponseEntity<PaymentType> getOne(@PathVariable Long id) {
		return ResponseEntity.ok(paymentTypeService.getOne(id));
	}

	@PostMapping("/paymentType")
	public void insert(@RequestBody PaymentType paymentType) {
		ResponseEntity.ok(paymentTypeService.insert(paymentType));
	}

	@PostMapping("/paymentTypes")
	public ResponseEntity<List<PaymentType>> inserts(@RequestBody PaymentType paymentType) {
		paymentTypeService.insert(paymentType);
		return ResponseEntity.ok(paymentTypeService.getAll());
	}

	@PutMapping("/paymentType/{id}")
	public void update(@RequestBody PaymentType paymentType, @PathVariable Long id) {
		ResponseEntity.ok(paymentTypeService.update(paymentType, id));
	}

	@PutMapping("/paymentTypes/{id}")
	public ResponseEntity<List<PaymentType>> updates(@RequestBody PaymentType paymentType, @PathVariable Long id) {
		paymentTypeService.update(paymentType, id);
		return ResponseEntity.ok(paymentTypeService.getAll());
	}

	@DeleteMapping("/paymentType/{id}")
	public void delete(@PathVariable Long id) {
		paymentTypeService.delete(id);
	}

	@DeleteMapping("/paymentTypes/{id}")
	public ResponseEntity<List<PaymentType>> deletes(@PathVariable Long id) {
		paymentTypeService.delete(id);
		return ResponseEntity.ok(paymentTypeService.getAll());
	}

}
