package com.meditail.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meditail.api.models.PaymentType;
import com.meditail.api.repositories.PaymentTypeRepository;

@Service
public class PaymentTypeService {
	
	private static final Logger logger = LoggerFactory.getLogger(PaymentTypeService.class);

	@Autowired
	private PaymentTypeRepository paymentTypeRepository;

	public List<PaymentType> getAll() {
		return paymentTypeRepository.findAll();
	}

	public PaymentType getOne(Long id) {
		return paymentTypeRepository.findById(id).orElse(null);
	}

	public PaymentType insert(PaymentType paymentType) {
		return paymentTypeRepository.save(paymentType);
	}

	public PaymentType update(PaymentType paymentType, Long id) {
		PaymentType existingPaymentType = getOne(id);
		if (existingPaymentType != null) {
			existingPaymentType.setId(paymentType.getId());
			existingPaymentType.setName(paymentType.getName());
			existingPaymentType.setState(paymentType.isState());
			existingPaymentType.setStatus(paymentType.getStatus());
			existingPaymentType.setCreatedDate(paymentType.getCreatedDate());
			existingPaymentType.setUpdatedDate(paymentType.getUpdatedDate());
			existingPaymentType.setDeletedDate(paymentType.getDeletedDate());
			existingPaymentType.setCreatedBy(paymentType.getCreatedBy());
			existingPaymentType.setUpdatedBy(paymentType.getUpdatedBy());
			existingPaymentType.setDeletedBy(paymentType.getDeletedBy());
			return paymentTypeRepository.save(existingPaymentType);
		} else {
			return null;
		}

	}

	public void delete(Long id) {
		PaymentType existingPaymentType = getOne(id);
		if (existingPaymentType != null) {
			paymentTypeRepository.delete(existingPaymentType);
		}
	}

}
