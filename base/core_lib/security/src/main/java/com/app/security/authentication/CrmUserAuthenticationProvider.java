package com.app.security.authentication;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class CrmUserAuthenticationProvider extends AbstractCrmUserAuthenticationProvider {

	@Override
	protected void additionalAuthenticationChecks(CrmUserDetails crmUserDetails, UsernamePasswordAuthenticationToken authentication) {
		// TODO Auto-generated method stub

	}

	@Override
	protected CrmUserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) {
		// TODO Auto-generated method stub
		return null;
	}

}
