package com.app.common.util;

/**
 * 
 * @author Arun Kumar
 *
 */
public enum AppError {

	ACCESS_NOT_FOUND(1001),
	USER_NOT_FOUND(2001);

	private Integer code;

	private AppError(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}
}
