package com.app.services.acl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.common.annotation.AppRequiresNewTxn;
import com.app.common.exception.ObjectNotFoundException;
import com.app.domain.model.acl.AppAccess;
import com.app.domain.model.acl.AppAccessRepository;
import com.app.domain.model.acl.AppAuthorityRepository;
import com.app.domain.model.acl.AppAuthorty;

@Service
public class AclServiceImpl implements AclService {

	@Autowired
	private AppAuthorityRepository appAuthorityRepository;
	@Autowired
	private AppAccessRepository appAccessRepository;

	@Override
	public List<AppAuthorty> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppAuthorty getAuthority(Integer id) {
		return appAuthorityRepository.findById(id);
	}

	@Override
	public AppAuthorty getCreateAuthority(AppAuthorty authorty) {
		appAuthorityRepository.persist(authorty);
		return authorty;
	}

	@Override
	public void getUpdateAuthority(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getDeleteAuthority(Integer id) throws ObjectNotFoundException {
		appAuthorityRepository.delete(appAuthorityRepository.getById(id));
	}

	@Override
	public List<AppAccess> getAccesses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppAccess getAccess(Integer id) {
		return appAccessRepository.findById(id);
	}

	@AppRequiresNewTxn
	@Override
	public AppAccess getCreateAccess(AppAccess appAccess) {
		appAccessRepository.persist(appAccess);
		return appAccess;
	}

	@AppRequiresNewTxn
	@Override
	public void getUpdateAccess(Integer id) {
		// TODO Auto-generated method stub

	}

	@AppRequiresNewTxn
	@Override
	public void getDeleteAccess(Integer id) throws ObjectNotFoundException {
		appAccessRepository.delete(appAccessRepository.getById(id));
	}

}
