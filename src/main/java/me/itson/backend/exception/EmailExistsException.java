package me.itson.backend.exception;

public class EmailExistsException extends IomException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6775255448526803400L;

	public EmailExistsException() {
		super();
	}

	public EmailExistsException(String message) {
		super(message);
	}
}
