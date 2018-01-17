package com.app.services.acl;

import java.util.List;

import com.app.common.exception.ObjectNotFoundException;
import com.app.domain.model.acl.AppAccess;
import com.app.domain.model.acl.AppAuthorty;

public interface AclService {

	List<AppAuthorty> getAuthorities();

	AppAuthorty getAuthority(Integer id);

	AppAuthorty getCreateAuthority(AppAuthorty authorty);

	void getUpdateAuthority(Integer id);

	void getDeleteAuthority(Integer id) throws ObjectNotFoundException;

	List<AppAccess> getAccesses();

	AppAccess getAccess(Integer id);

	AppAccess getCreateAccess(AppAccess appAccess);

	void getUpdateAccess(Integer id);

	void getDeleteAccess(Integer id) throws ObjectNotFoundException;

}
