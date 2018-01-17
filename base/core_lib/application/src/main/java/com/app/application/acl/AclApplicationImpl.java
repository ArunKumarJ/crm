package com.app.application.acl;

import java.util.List;

import com.app.common.annotation.Application;
import com.app.domain.model.acl.AppAccess;
import com.app.domain.model.acl.AppAuthorty;
import com.app.services.acl.AclService;

@Application
public class AclApplicationImpl implements AclApplication {

	private AclService aclService;

	@Override
	public List<AppAuthorty> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppAuthorty getAuthority(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppAuthorty getCreateAuthority(AppAuthorty authorty) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getUpdateAuthority(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getDeleteAuthority(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<AppAccess> getAccesses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppAccess getAccess(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppAccess getCreateAccess(AppAccess appAccess) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getUpdateAccess(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getDeleteAccess(Integer id) {
		// TODO Auto-generated method stub

	}

}
