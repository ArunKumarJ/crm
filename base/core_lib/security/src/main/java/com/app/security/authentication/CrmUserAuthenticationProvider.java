package com.app.security.authentication;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class CrmUserAuthenticationProvider extends AbstractCrmUserAuthenticationProvider {

	@Override
	protected void additionalAuthenticationChecks(CrmUserDetails crmUserDetails, UsernamePasswordAuthenticationToken authentication) {
		// TODO Auto-generated method stub

	}

	@Override
	protected CrmUserDetails retrieveUser(String username, CrmUserAuthentication authentication) {
		CrmUserDetails userDetails = null;
		try {
			userDetails = new CrmUserDetailsImpl(authentication.getAccesses(), authentication.getAuthorities(), username, "password", false, false, false, false);
		} catch (Exception e) {
			throw new AuthenticationServiceException(e.getMessage());
		}
		return userDetails;
	}

}
