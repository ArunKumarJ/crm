package com.app.security.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;

public class ApiExecutePermission implements PermissionEvaluatorDelegates {

	private static final Logger logger = LoggerFactory.getLogger(ApiExecutePermission.class);

	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject) {
		boolean hasPermission = false;
		if (targetDomainObject instanceof String && authentication instanceof CrmUserAuthentication) {
			CrmUserAuthentication crmUserAuthentication = (CrmUserAuthentication) authentication;
			for (GrantedAccess access : crmUserAuthentication.getAccesses()) {
				if (access.getAccess().equals(targetDomainObject) && access.isAllowed())
					hasPermission = true;
			}
		}

		if (!hasPermission) {
			String api = targetDomainObject instanceof String ? (String) targetDomainObject : "";
			Object principle = authentication instanceof CrmUserAuthentication ? ((CrmUserAuthentication) authentication).getPrincipal() : null;
			logger.error("access to API={} is denied to userIndex {}", api, principle);
		}

		return hasPermission;
	}

}
