package com.app.security.authentication;

import org.springframework.aop.framework.AopInfrastructureBean;
import org.springframework.security.core.Authentication;

public interface PermissionEvaluatorDelegates extends AopInfrastructureBean {

	public boolean hasPermission(Authentication authentication, Object targetDomainObject);
}
