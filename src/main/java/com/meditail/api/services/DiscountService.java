package com.meditail.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meditail.api.models.Discount;
import com.meditail.api.repositories.DiscountRepository;

@Service
public class DiscountService {

	private static final Logger logger = LoggerFactory.getLogger(DiscountService.class);

	@Autowired
	private DiscountRepository discountRepository;

	public List<Discount> getAll() {
		return discountRepository.findAll();
	}

	public Discount getOne(Long id) {
		return discountRepository.findById(id).orElse(null);
	}

	public Discount insert(Discount discount) {
		return discountRepository.save(discount);
	}

	public Discount update(Discount discount, Long id) {
		Discount existingDiscount = getOne(id);
		if (existingDiscount != null) {
			existingDiscount.setId(discount.getId());
			existingDiscount.setPercentageOfTotalAmount(discount.getPercentageOfTotalAmount());
			existingDiscount.setState(discount.isState());
			existingDiscount.setStatus(discount.getStatus());
			existingDiscount.setCreatedDate(discount.getCreatedDate());
			existingDiscount.setUpdatedDate(discount.getUpdatedDate());
			existingDiscount.setDeletedDate(discount.getDeletedDate());
			existingDiscount.setCreatedBy(discount.getCreatedBy());
			existingDiscount.setUpdatedBy(discount.getUpdatedBy());
			existingDiscount.setDeletedBy(discount.getDeletedBy());
			return discountRepository.save(existingDiscount);
		} else {
			return null;
		}

	}

	public void delete(Long id) {
		Discount existingDiscount = getOne(id);
		if (existingDiscount != null) {
			discountRepository.delete(existingDiscount);
		}

	}

}
