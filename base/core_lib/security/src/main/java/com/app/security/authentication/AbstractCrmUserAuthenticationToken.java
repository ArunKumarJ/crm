package com.app.security.authentication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public abstract class AbstractCrmUserAuthenticationToken extends AbstractAuthenticationToken implements CrmUserAuthentication {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3413753876540806129L;

	private Collection<GrantedAccess> accesses;

	public AbstractCrmUserAuthenticationToken(Collection<? extends GrantedAuthority> authorities, Collection<? extends GrantedAccess> accesses) {
		super(authorities);

		if (accesses == null) {
			accesses = Collections.emptyList();
			return;
		}

		for (GrantedAccess access : accesses) {
			if (access == null) {
				throw new IllegalArgumentException("Access collection cannot contain any null elements");
			}
		}

		ArrayList<GrantedAccess> temp = new ArrayList<>(accesses.size());
		temp.addAll(accesses);
		this.accesses = Collections.unmodifiableList(temp);

	}

	@Override
	public Collection<GrantedAccess> getAccesses() {
		return accesses;
	}

}
