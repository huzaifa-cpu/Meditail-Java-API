package com.meditail.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meditail.api.models.ItemExpiry;
import com.meditail.api.repositories.ItemExpiryRepository;

@Service
public class ItemExpiryService {
	
	private static final Logger logger = LoggerFactory.getLogger(ItemExpiryService.class);

	@Autowired
	private ItemExpiryRepository itemExpiryRepository;

	public List<ItemExpiry> getAll() {
		return itemExpiryRepository.findAll();
	}

	public ItemExpiry getOne(Long id) {
		return itemExpiryRepository.findById(id).orElse(null);
	}

	public ItemExpiry insert(ItemExpiry itemExpiry) {
		return itemExpiryRepository.save(itemExpiry);
	}

	public ItemExpiry update(ItemExpiry itemExpiry, Long id) {
		ItemExpiry existingItemExpiry = getOne(id);
		if (existingItemExpiry != null) {
			existingItemExpiry.setId(itemExpiry.getId());
			existingItemExpiry.setDate(itemExpiry.getDate());
			existingItemExpiry.setSoldOut(itemExpiry.isSoldOut());
			existingItemExpiry.setItemCount(itemExpiry.getItemCount());
			existingItemExpiry.setState(itemExpiry.isState());
			existingItemExpiry.setStatus(itemExpiry.getStatus());
			existingItemExpiry.setCreatedDate(itemExpiry.getCreatedDate());
			existingItemExpiry.setUpdatedDate(itemExpiry.getUpdatedDate());
			existingItemExpiry.setDeletedDate(itemExpiry.getDeletedDate());
			existingItemExpiry.setCreatedBy(itemExpiry.getCreatedBy());
			existingItemExpiry.setUpdatedBy(itemExpiry.getUpdatedBy());
			existingItemExpiry.setDeletedBy(itemExpiry.getDeletedBy());
			existingItemExpiry.setItem(itemExpiry.getItem());
			return itemExpiryRepository.save(existingItemExpiry);
		} else {
			return null;
		}

	}

	public void delete(Long id) {
		ItemExpiry existingItemExpiry = getOne(id);
		if (existingItemExpiry != null) {
			itemExpiryRepository.delete(existingItemExpiry);
		}
	}

}
