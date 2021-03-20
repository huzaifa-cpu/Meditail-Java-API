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

import com.meditail.api.models.Payment;
import com.meditail.api.services.PaymentService;

@RestController
public class PaymentController {

	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

	@Autowired
	private PaymentService paymentService;

	@GetMapping("/payments")
	public ResponseEntity<List<Payment>> getAll() {
		return ResponseEntity.ok(paymentService.getAll());
	}

	@GetMapping("/payment/{id}")
	public ResponseEntity<Payment> getOne(@PathVariable Long id) {
		return ResponseEntity.ok(paymentService.getOne(id));
	}

	@PostMapping("/payment")
	public void insert(@RequestBody Payment payment) {
		ResponseEntity.ok(paymentService.insert(payment));
	}

	@PostMapping("/payments")
	public ResponseEntity<List<Payment>> inserts(@RequestBody Payment payment) {
		paymentService.insert(payment);
		return ResponseEntity.ok(paymentService.getAll());
	}

	@PutMapping("/payment/{id}")
	public void update(@RequestBody Payment payment, @PathVariable Long id) {
		ResponseEntity.ok(paymentService.update(payment, id));
	}

	@PutMapping("/payments/{id}")
	public ResponseEntity<List<Payment>> updates(@RequestBody Payment payment, @PathVariable Long id) {
		paymentService.update(payment, id);
		return ResponseEntity.ok(paymentService.getAll());
	}

	@DeleteMapping("/payment/{id}")
	public void delete(@PathVariable Long id) {
		paymentService.delete(id);
	}

	@DeleteMapping("/payments/{id}")
	public ResponseEntity<List<Payment>> deletes(@PathVariable Long id) {
		paymentService.delete(id);
		return ResponseEntity.ok(paymentService.getAll());
	}

}
