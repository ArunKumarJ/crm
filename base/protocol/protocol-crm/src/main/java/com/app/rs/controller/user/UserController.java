package com.app.rs.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.application.user.UserApplication;
import com.app.common.annotation.BeforeAuth;
import com.app.security.authentication.CrmUserAuthenticationToken;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserApplication userApplication;

	@Autowired
	private AuthenticationProvider authenticationProvider;

	@BeforeAuth
	@GetMapping("/users")
	public void getUsers() {
		CrmUserAuthenticationToken token = new CrmUserAuthenticationToken("principal", "userId", "credentials");
		Authentication authentication = authenticationProvider.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		userApplication.getUsers();
	}

	public AuthenticationProvider getAuthenticationProvider() {
		return authenticationProvider;
	}

	public void setAuthenticationProvider(AuthenticationProvider authenticationProvider) {
		this.authenticationProvider = authenticationProvider;
	}

}
