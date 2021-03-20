package com.meditail.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meditail.api.models.Payment;
import com.meditail.api.repositories.PaymentRepository;

@Service
public class PaymentService {
	
	private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

	@Autowired
	private PaymentRepository paymentRepository;

	public List<Payment> getAll() {
		return paymentRepository.findAll();
	}

	public Payment getOne(Long id) {
		return paymentRepository.findById(id).orElse(null);
	}

	public Payment insert(Payment payment) {
		return paymentRepository.save(payment);
	}

	public Payment update(Payment payment, Long id) {
		Payment existingPayment = getOne(id);
		if (existingPayment != null) {
			existingPayment.setId(payment.getId());
			existingPayment.setTotalAmount(payment.getTotalAmount());
			existingPayment.setTax(payment.getTax());
			existingPayment.setDiscountAmount(payment.getDiscountAmount());
			existingPayment.setState(payment.isState());
			existingPayment.setStatus(payment.getStatus());
			existingPayment.setCreatedDate(payment.getCreatedDate());
			existingPayment.setUpdatedDate(payment.getUpdatedDate());
			existingPayment.setDeletedDate(payment.getDeletedDate());
			existingPayment.setCreatedBy(payment.getCreatedBy());
			existingPayment.setUpdatedBy(payment.getUpdatedBy());
			existingPayment.setDeletedBy(payment.getDeletedBy());
			existingPayment.setMedicalStore(payment.getMedicalStore());
			existingPayment.setPaymentType(payment.getPaymentType());
			return paymentRepository.save(existingPayment);
		} else {
			return null;
		}

	}

	public void delete(Long id) {
		Payment existingPayment = getOne(id);
		if (existingPayment != null) {
			paymentRepository.delete(existingPayment);
		}
	}

}
