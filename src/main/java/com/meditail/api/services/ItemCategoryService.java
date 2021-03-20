package com.meditail.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meditail.api.models.ItemCategory;
import com.meditail.api.repositories.ItemCategoryRepository;

@Service
public class ItemCategoryService {

	private static final Logger logger = LoggerFactory.getLogger(ItemCategoryService.class);

	@Autowired
	private ItemCategoryRepository itemCategoryRepository;

	public List<ItemCategory> getAll() {
		return itemCategoryRepository.findAll();
	}

	public ItemCategory getOne(Long id) {
		return itemCategoryRepository.findById(id).orElse(null);
	}

	public ItemCategory insert(ItemCategory itemCategory) {
		return itemCategoryRepository.save(itemCategory);
	}

	public ItemCategory update(ItemCategory itemCategory, Long id) {
		ItemCategory existingItemCategory = getOne(id);
		if (existingItemCategory != null) {
			existingItemCategory.setId(itemCategory.getId());
			existingItemCategory.setName(itemCategory.getName());
			existingItemCategory.setState(itemCategory.isState());
			existingItemCategory.setStatus(itemCategory.getStatus());
			existingItemCategory.setCreatedDate(itemCategory.getCreatedDate());
			existingItemCategory.setUpdatedDate(itemCategory.getUpdatedDate());
			existingItemCategory.setDeletedDate(itemCategory.getDeletedDate());
			existingItemCategory.setCreatedBy(itemCategory.getCreatedBy());
			existingItemCategory.setUpdatedBy(itemCategory.getUpdatedBy());
			existingItemCategory.setDeletedBy(itemCategory.getDeletedBy());
			return itemCategoryRepository.save(existingItemCategory);
		} else {
			return null;
		}

	}

	public void delete(Long id) {
		ItemCategory existingItemCategory = getOne(id);
		if (existingItemCategory != null) {
			itemCategoryRepository.delete(existingItemCategory);
		}
	}

}
