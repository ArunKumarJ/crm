package com.app.security.authentication;

import java.io.Serializable;
import java.util.Map;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

public class CrmPermissionEvaluator implements PermissionEvaluator {

	private Map<String, PermissionEvaluatorDelegates> permissionMap;

	public CrmPermissionEvaluator(Map<String, PermissionEvaluatorDelegates> permissionMap) {
		this.permissionMap = permissionMap;
	}

	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		boolean hasPermission = false;
		if (authentication != null && targetDomainObject != null) {
			hasPermission = permissionMap.get(permission).hasPermission(authentication, targetDomainObject);
		}
		return hasPermission;
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
		return false;
	}

}
