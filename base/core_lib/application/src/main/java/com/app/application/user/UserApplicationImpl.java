package com.app.application.user;

import org.springframework.security.access.prepost.PreAuthorize;

import com.app.common.annotation.Application;

@Application
public class UserApplicationImpl implements UserApplication {

	@Override
	@PreAuthorize("hasPermission('GH','execute')")
	public void getUsers() {
		System.out.println("Get User");
	}

}
