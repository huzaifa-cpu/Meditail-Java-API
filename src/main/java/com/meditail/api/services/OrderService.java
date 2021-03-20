package com.meditail.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meditail.api.models.Order;
import com.meditail.api.repositories.OrderRepository;

@Service
public class OrderService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

	@Autowired
	private OrderRepository orderRepository;

	public List<Order> getAll() {
		return orderRepository.findAll();
	}

	public Order getOne(Long id) {
		return orderRepository.findById(id).orElse(null);
	}

	public Order insert(Order order) {
		return orderRepository.save(order);
	}

	public Order update(Order order, Long id) {
		Order existingOrder = getOne(id);
		if (existingOrder != null) {
			existingOrder.setId(order.getId());
			existingOrder.setState(order.isState());
			existingOrder.setStatus(order.getStatus());
			existingOrder.setCreatedDate(order.getCreatedDate());
			existingOrder.setUpdatedDate(order.getUpdatedDate());
			existingOrder.setDeletedDate(order.getDeletedDate());
			existingOrder.setCreatedBy(order.getCreatedBy());
			existingOrder.setUpdatedBy(order.getUpdatedBy());
			existingOrder.setDeletedBy(order.getDeletedBy());
			existingOrder.setMedicalStore(order.getMedicalStore());
			existingOrder.setDiscount(order.getDiscount());
			existingOrder.setCart(order.getCart());
			return orderRepository.save(existingOrder);
		} else {
			return null;
		}

	}

	public void delete(Long id) {
		Order existingOrder = getOne(id);
		if (existingOrder != null) {
			orderRepository.delete(existingOrder);
		}
	}

}
