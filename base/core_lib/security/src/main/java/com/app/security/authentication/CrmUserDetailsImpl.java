package com.app.security.authentication;

import static java.util.Collections.unmodifiableCollection;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

/**
 * 
 * @author KumaAr
 *
 */
public class CrmUserDetailsImpl implements CrmUserDetails {

	private Collection<GrantedAccess> accesses;
	private Collection<GrantedAuthority> authorities;
	private String userId;
	private String password;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;

	/**
	 * 
	 * @param accesses
	 * @param authorities
	 * @param userId
	 * @param password
	 * @param accountNonExpired
	 * @param accountNonLocked
	 * @param credentialsNonExpired
	 * @param enabled
	 */
	public CrmUserDetailsImpl(Collection<? extends GrantedAccess> accesses, Collection<? extends  GrantedAuthority> authorities, String userId, String password,
			boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {

		if (((userId == null) || "".equals(userId)) || (password == null)) {
			throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
		}
		this.accesses = unmodifiableCollection(accesses);
		this.authorities = unmodifiableCollection(authorities);
		this.userId = userId;
		this.password = password;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}

	@Override
	public Collection<? extends GrantedAccess> getAccesses() {

		return accesses;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return authorities;
	}

	@Override
	public String getUserId() {

		return userId;
	}

	@Override
	public String getPassword() {

		return password;
	}

	@Override
	public boolean isAccountNonExpired() {

		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {

		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return credentialsNonExpired;
	}

	@Override
	public boolean idEnabled() {

		return enabled;
	}

}
