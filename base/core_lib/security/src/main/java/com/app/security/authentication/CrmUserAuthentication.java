package com.app.security.authentication;

import java.util.Collection;

import org.springframework.security.core.Authentication;

public interface CrmUserAuthentication extends Authentication {

	Collection<? extends GrantedAccess> getAccesses();
}
