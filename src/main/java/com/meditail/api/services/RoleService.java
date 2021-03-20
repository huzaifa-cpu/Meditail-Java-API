package com.meditail.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meditail.api.models.Role;
import com.meditail.api.repositories.RoleRepository;

@Service
public class RoleService {

	private static final Logger logger = LoggerFactory.getLogger(RoleService.class);
	
	@Autowired
	private RoleRepository RoleRepository;

	public List<Role> getAll() {
		return RoleRepository.findAll();
	}

	public Role getOne(Long id) {
		return RoleRepository.findById(id).orElse(null);
	}

	public Role insert(Role role) {
		return RoleRepository.save(role);
	}

	public Role update(Role role, Long id) {
		Role existingRole = getOne(id);
		if (existingRole != null) {
			existingRole.setId(role.getId());
			existingRole.setName(role.getName());
			existingRole.setState(role.isState());
			existingRole.setStatus(role.getStatus());
			existingRole.setCreatedDate(role.getCreatedDate());
			existingRole.setUpdatedDate(role.getUpdatedDate());
			existingRole.setDeletedDate(role.getDeletedDate());
			existingRole.setCreatedBy(role.getCreatedBy());
			existingRole.setUpdatedBy(role.getUpdatedBy());
			existingRole.setDeletedBy(role.getDeletedBy());
			return RoleRepository.save(existingRole);
		} else {
			return null;
		}

	}

	public void delete(Long id) {
		Role existingRole = getOne(id);
		if (existingRole != null) {
			RoleRepository.delete(existingRole);
		}
	}

}
