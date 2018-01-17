package com.app.rs.common.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author KumaAr
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private ObjectMapper mapper = new ObjectMapper();

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseBody
	public ResponseEntity<String> genericException(HttpMessageNotReadableException ex) throws JsonProcessingException {
		ex.printStackTrace();
		Error error = new Error();
		error.addErrorMessage("Invalid request parameter.");
		return new ResponseEntity<String>(mapper.writeValueAsString(error), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<String> genericException(Exception ex) throws JsonProcessingException {
		ex.printStackTrace();
		Error error = new Error();
		error.setErrorCode(100 + "");
		error.addErrorMessage(ex.getMessage());
		return new ResponseEntity<String>(mapper.writeValueAsString(error), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Error class to return error message in response.
	 * 
	 * @author Arun
	 *
	 */
	public class Error {
		private List<String> errorMessages = new ArrayList<>();
		private String errorCode;

		/**
		 * @return the errorMessage
		 */
		public List<String> getErrorMessages() {
			return errorMessages;
		}

		/**
		 * @param errorMessage
		 *            the errorMessage to set
		 */
		public void addErrorMessage(String errorMessage) {
			this.errorMessages.add(errorMessage);
		}

		/**
		 * @return the errorCode
		 */
		public String getErrorCode() {
			return errorCode;
		}

		/**
		 * @param errorCode
		 *            the errorCode to set
		 */
		public void setErrorCode(String errorCode) {
			this.errorCode = errorCode;
		}

	}
}
