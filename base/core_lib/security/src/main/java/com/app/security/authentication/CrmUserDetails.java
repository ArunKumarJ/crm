package com.app.security.authentication;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public interface CrmUserDetails {

	public Collection<? extends GrantedAccess> getAccesses();

	public Collection<? extends GrantedAuthority> getAuthorities();

	public String getUserId();

	public String getPassword();

	public boolean isAccountNonExpired();

	public boolean isAccountNonLocked();

	public boolean isCredentialsNonExpired();

	public boolean idEnabled();

}
