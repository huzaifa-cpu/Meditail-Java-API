package com.meditail.api.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.meditail.api.models.Role;
import com.meditail.api.services.RoleService;

@RestController
public class RoleController {

	private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

	@Autowired
	private RoleService roleService;

	@GetMapping("/roles")
	public ResponseEntity<List<Role>> getAll() {
		return ResponseEntity.ok(roleService.getAll());
	}

	@GetMapping("/role/{id}")
	public ResponseEntity<Role> getOne(@PathVariable Long id) {
		return ResponseEntity.ok(roleService.getOne(id));
	}

	@PostMapping("/role")
	public void insert(@RequestBody Role role) {
		ResponseEntity.ok(roleService.insert(role));
	}

	@PostMapping("/roles")
	public ResponseEntity<List<Role>> inserts(@RequestBody Role role) {
		roleService.insert(role);
		return ResponseEntity.ok(roleService.getAll());
	}

	@PutMapping("/role/{id}")
	public void update(@RequestBody Role role, @PathVariable Long id) {
		ResponseEntity.ok(roleService.update(role, id));
	}

	@PutMapping("/roles/{id}")
	public ResponseEntity<List<Role>> updates(@RequestBody Role role, @PathVariable Long id) {
		roleService.update(role, id);
		return ResponseEntity.ok(roleService.getAll());
	}

	@DeleteMapping("/role/{id}")
	public void delete(@PathVariable Long id) {
		roleService.delete(id);
	}

	@DeleteMapping("/roles/{id}")
	public ResponseEntity<List<Role>> deletes(@PathVariable Long id) {
		roleService.delete(id);
		return ResponseEntity.ok(roleService.getAll());
	}

}
