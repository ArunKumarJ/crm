package com.app.security.authentication;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class CrmUserAuthenticationToken extends AbstractCrmUserAuthenticationToken implements CrmUserAuthentication {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7702268521522221779L;

	private Object principal;
	private Object userId;
	private Object credentials;

	public CrmUserAuthenticationToken(Object principal, Object userId, Object credentials) {
		super(null, null);
		this.principal = principal;
		this.userId = userId;
		this.credentials = credentials;
	}

	public CrmUserAuthenticationToken(Collection<? extends GrantedAuthority> authorities, Collection<? extends GrantedAccess> accesses, Object principal,
			Object userId, Object credentials) {
		super(authorities, accesses);
		this.principal = principal;
		this.userId = userId;
		this.credentials = credentials;
		super.setAuthenticated(true);
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
		return credentials;
	}

	@Override
	public Object getPrincipal() {
		return principal;
	}

	public Object getUserId() {
		return userId;
	}

}
