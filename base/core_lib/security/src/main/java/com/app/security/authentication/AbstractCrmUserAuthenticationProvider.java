package com.app.security.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.Assert;

public abstract class AbstractCrmUserAuthenticationProvider implements AuthenticationProvider {

	private static final Logger logger = LoggerFactory.getLogger(AbstractCrmUserAuthenticationProvider.class);
	private boolean hideUserNotFoundExceptions;
	private Object preAuthenticationChecks;
	private boolean forcePrincipalAsString;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = (authentication.getPrincipal() == null) ? "NONE_PROVIDED" : authentication.getName();

		boolean cacheWasUsed = true;
		CrmUserDetails crmUserDetails = null;

		if (crmUserDetails == null) {
			cacheWasUsed = false;

			try {
				crmUserDetails = retrieveUser(username, (UsernamePasswordAuthenticationToken) authentication);
			} catch (UsernameNotFoundException notFound) {
				logger.debug("User '" + username + "' not found");

				if (hideUserNotFoundExceptions) {
					throw new BadCredentialsException("AbstractUserDetailsAuthenticationProvider.badCredentials , Bad credentials");
				} else {
					throw notFound;
				}
			}

			Assert.notNull(crmUserDetails, "retrieveUser returned null - a violation of the interface contract");
		}

		try {
			// preAuthenticationChecks.check(crmUserDetails);
			additionalAuthenticationChecks(crmUserDetails, (UsernamePasswordAuthenticationToken) authentication);
		} catch (AuthenticationException exception) {
			if (cacheWasUsed) {
				// There was a problem, so try again after checking
				// we're using latest data (i.e. not from the cache)
				cacheWasUsed = false;
				crmUserDetails = retrieveUser(username, (UsernamePasswordAuthenticationToken) authentication);
				// preAuthenticationChecks.check(crmUserDetails);
				additionalAuthenticationChecks(crmUserDetails, (UsernamePasswordAuthenticationToken) authentication);
			} else {
				throw exception;
			}
		}

		// postAuthenticationChecks.check(user);

		/*
		 * if (!cacheWasUsed) { this.userCache.putUserInCache(user); }
		 */

		Object principalToReturn = crmUserDetails;

		if (forcePrincipalAsString) {
			principalToReturn = crmUserDetails.getUserId();
		}

		return createSuccessAuthentication(principalToReturn, authentication, crmUserDetails);
	}

	protected Authentication createSuccessAuthentication(Object principalToReturn, Authentication authentication, CrmUserDetails crmUserDetails) {

		return null;
	}

	protected abstract void additionalAuthenticationChecks(CrmUserDetails crmUserDetails, UsernamePasswordAuthenticationToken authentication);

	protected abstract CrmUserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication);
}
