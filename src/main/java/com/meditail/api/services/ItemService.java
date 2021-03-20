package com.meditail.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meditail.api.models.Item;
import com.meditail.api.repositories.ItemRepository;

@Service
public class ItemService {

	private static final Logger logger = LoggerFactory.getLogger(ItemService.class);

	@Autowired
	private ItemRepository itemRepository;

	public List<Item> getAll() {
		return itemRepository.findAll();
	}

	public Item getOne(Long id) {
		return itemRepository.findById(id).orElse(null);
	}

	public Item insert(Item item) {
		return itemRepository.save(item);
	}

	public Item update(Item item, Long id) {
		Item existingItem = getOne(id);
		if (existingItem != null) {
			existingItem.setId(item.getId());
			existingItem.setName(item.getName());
			existingItem.setExpiryDate(item.getExpiryDate());
			existingItem.setCostPerItem(item.getCostPerItem());
			existingItem.setTotalCount(item.getTotalCount());
			existingItem.setState(item.isState());
			existingItem.setStatus(item.getStatus());
			existingItem.setCreatedDate(item.getCreatedDate());
			existingItem.setUpdatedDate(item.getUpdatedDate());
			existingItem.setDeletedDate(item.getDeletedDate());
			existingItem.setCreatedBy(item.getCreatedBy());
			existingItem.setUpdatedBy(item.getUpdatedBy());
			existingItem.setDeletedBy(item.getDeletedBy());
			existingItem.setItemCategory(item.getItemCategory());
			existingItem.setMedicalStore(item.getMedicalStore());
			return itemRepository.save(existingItem);
		} else {
			return null;
		}

	}

	public void delete(Long id) {
		Item existingItem = getOne(id);
		if (existingItem != null) {
			itemRepository.delete(existingItem);
		}

	}

}
