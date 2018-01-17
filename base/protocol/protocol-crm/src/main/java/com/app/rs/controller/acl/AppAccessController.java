package com.app.rs.controller.acl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.exception.ObjectNotFoundException;
import com.app.domain.model.acl.AppAccess;
import com.app.services.acl.AclService;

@RestController
@RequestMapping("/acl/access")
public class AppAccessController {

	@Autowired
	private AclService aclService;

	@GetMapping("/accesses")
	public List<AppAccess> getAll() {
		return aclService.getAccesses();
	}

	@GetMapping("/{id}")
	public AppAccess get(@PathVariable("id") Integer id) {
		return aclService.getAccess(id);
	}

	@PostMapping
	public AppAccess create(@RequestBody AppAccess access) {
		return aclService.getCreateAccess(access);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable("id") Integer id, @RequestBody AppAccess appAccess) {
		aclService.getUpdateAccess(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		aclService.getDeleteAccess(id);
	}
}
