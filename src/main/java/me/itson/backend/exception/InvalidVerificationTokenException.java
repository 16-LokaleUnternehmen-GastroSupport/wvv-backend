package me.itson.backend.exception;

public class InvalidVerificationTokenException extends RegisterException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7562196529931729044L;

	public InvalidVerificationTokenException() {
		super();
	}
	
	public InvalidVerificationTokenException(String message) {
		super(message);
	}

}