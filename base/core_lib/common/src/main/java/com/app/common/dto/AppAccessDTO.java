package com.app.common.dto;

import java.io.Serializable;

public class AppAccessDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4710451643196560282L;
	
	private String access;

	public AppAccessDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the access
	 */
	public String getAccess() {
		return access;
	}

	/**
	 * @param access
	 *            the access to set
	 */
	public void setAccess(String access) {
		this.access = access;
	}

}
