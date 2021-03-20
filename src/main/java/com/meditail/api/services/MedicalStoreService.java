package com.meditail.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meditail.api.models.MedicalStore;
import com.meditail.api.repositories.MedicalStoreRepository;

@Service
public class MedicalStoreService {
	
	private static final Logger logger = LoggerFactory.getLogger(MedicalStoreService.class);

	@Autowired
	private MedicalStoreRepository medicalStoreRepository;

	public List<MedicalStore> getAll() {
		return medicalStoreRepository.findAll();
	}

	public MedicalStore getOne(Long id) {
		return medicalStoreRepository.findById(id).orElse(null);
	}

	public MedicalStore insert(MedicalStore medicalStore) {
		return medicalStoreRepository.save(medicalStore);
	}

	public MedicalStore update(MedicalStore medicalStore, Long id) {
		MedicalStore existingMedicalStore = getOne(id);
		if (existingMedicalStore != null) {
			existingMedicalStore.setId(medicalStore.getId());
			existingMedicalStore.setAddress(medicalStore.getAddress());
			existingMedicalStore.setName(medicalStore.getName());
			existingMedicalStore.setImage(medicalStore.getImage());
			existingMedicalStore.setMedicalStoreUsername(medicalStore.getMedicalStoreUsername());
			existingMedicalStore.setState(medicalStore.isState());
			existingMedicalStore.setStatus(medicalStore.getStatus());
			existingMedicalStore.setCreatedDate(medicalStore.getCreatedDate());
			existingMedicalStore.setUpdatedDate(medicalStore.getUpdatedDate());
			existingMedicalStore.setDeletedDate(medicalStore.getDeletedDate());
			existingMedicalStore.setCreatedBy(medicalStore.getCreatedBy());
			existingMedicalStore.setUpdatedBy(medicalStore.getUpdatedBy());
			existingMedicalStore.setDeletedBy(medicalStore.getDeletedBy());
			return medicalStoreRepository.save(existingMedicalStore);
		} else {
			return null;
		}

	}

	public void delete(Long id) {
		MedicalStore existingMedicalStore = getOne(id);
		if (existingMedicalStore != null) {
			medicalStoreRepository.delete(existingMedicalStore);
		}
	}

}
