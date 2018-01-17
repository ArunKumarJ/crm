package com.app.rs.controller.acl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.exception.ObjectNotFoundException;
import com.app.domain.model.acl.AppAuthorty;
import com.app.services.acl.AclService;

@RestController
@RequestMapping("/acl/authority")
public class AppAuthorityController {

	@Autowired
	private AclService aclService;

	@GetMapping("/authorities")
	public List<AppAuthorty> getAll() {
		return aclService.getAuthorities();
	}

	@GetMapping("/{id}")
	public AppAuthorty get(@PathVariable("id") Integer id) {
		return aclService.getAuthority(id);
	}

	@PostMapping
	public AppAuthorty create(AppAuthorty authorty) {
		return aclService.getCreateAuthority(authorty);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable("id") Integer id, AppAuthorty authorty) {
		aclService.getUpdateAuthority(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		aclService.getDeleteAuthority(id);
	}
}
