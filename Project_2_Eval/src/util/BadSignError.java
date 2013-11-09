package util;

public class BadSignError extends Exception {

	//I have no idea what this does in java
	//	Dr carr had it in his code and his
	//  wisdom is far beyond mine
	//  so he must know what he is doing
	//  maybe we have to change this value 
	//  maybe we don't we shall see
	private static final long serialVersionUID = -7101999378596131661L;

	public BadSignError() {
		// TODO Auto-generated constructor stub
	}
	public BadSignError(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public BadSignError(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	public BadSignError(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
}
