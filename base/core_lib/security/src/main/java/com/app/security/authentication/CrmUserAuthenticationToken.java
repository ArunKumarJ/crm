package com.app.security.authentication;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class CrmUserAuthenticationToken extends AbstractCrmUserAuthenticationToken implements CrmUserAuthentication {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7702268521522221779L;

	public CrmUserAuthenticationToken(Collection<? extends GrantedAuthority> authorities, Collection<? extends GrantedAccess> accesses) {
		super(authorities, accesses);
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		if (isAuthenticated) {
			throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
		}
		super.setAuthenticated(false);
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

}
