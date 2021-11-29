package com.devsuperior.movieflix.security.exceptions;

public class UnAuthorizedException extends RuntimeException {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	public UnAuthorizedException( String message ) {
		super(message);
	}
}
