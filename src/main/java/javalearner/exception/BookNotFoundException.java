package javalearner.exception;

public class BookNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 4211469017538743672L;

	public BookNotFoundException(String message) {
		super(message);
	}
}
