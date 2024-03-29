package com.sm.status;

import java.io.Serializable;

public class Status implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean successful;
	private String message;

	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Status [successful=" + successful + ", message=" + message + "]";
	}
	
	

}
