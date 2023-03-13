package com.passport.exception;

public class AppointmentNotFoundException extends Exception{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AppointmentNotFoundException() {
	        super();
	    }
	 public AppointmentNotFoundException(String message) {
	        super(message);
	    }
	 public AppointmentNotFoundException(String message, Throwable cause) {
	        super(message, cause);
	    }
	 public AppointmentNotFoundException(Throwable cause) {
	        super(cause);
	    }
	 protected AppointmentNotFoundException(String message, Throwable cause,
             boolean enableSuppression,
             boolean writableStackTrace) {
super(message, cause, enableSuppression, writableStackTrace);
}
}
