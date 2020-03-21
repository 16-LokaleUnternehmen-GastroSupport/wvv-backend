package me.itson.backend.exception;

public class InvalidCredentialException extends RegisterException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7042523843731323982L;

	public InvalidCredentialException() {
		super();
	}
	
	public InvalidCredentialException(String message) {
		super(message);
	}
}
