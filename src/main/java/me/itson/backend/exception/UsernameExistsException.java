package me.itson.backend.exception;

public class UsernameExistsException extends RegisterException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5549353541049069979L;

	public UsernameExistsException() {
		super();
	}
	
	public UsernameExistsException(String message) {
		super(message);
	}

}