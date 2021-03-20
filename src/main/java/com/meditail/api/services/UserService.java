package com.meditail.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meditail.api.models.User;
import com.meditail.api.repositories.UserRepository;

@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository UserRepository;

	public List<User> getAll() {
		return UserRepository.findAll();
	}

	public User getOne(Long id) {
		return UserRepository.findById(id).orElse(null);
	}

	public User insert(User user) {
		return UserRepository.save(user);
	}

	public User update(User user, Long id) {
		User existingUser = getOne(id);
		if (existingUser != null) {
			existingUser.setId(user.getId());
			existingUser.setMeditailId(user.getMeditailId());
			existingUser.setName(user.getName());
			existingUser.setImage(user.getImage());
			existingUser.setPhoneNumber(user.getPhoneNumber());
			existingUser.setEmail(user.getEmail());
			existingUser.setPassword(user.getPassword());
			existingUser.setState(user.isState());
			existingUser.setStatus(user.getStatus());
			existingUser.setCreatedDate(user.getCreatedDate());
			existingUser.setUpdatedDate(user.getUpdatedDate());
			existingUser.setDeletedDate(user.getDeletedDate());
			existingUser.setMedicalStore(user.getMedicalStore());
			existingUser.setRole(user.getRole());
			return UserRepository.save(existingUser);
		} else {
			return null;
		}

	}

	public void delete(Long id) {
		User existingUser = getOne(id);
		if (existingUser != null) {
			UserRepository.delete(existingUser);
		}
	}

}
