package com.devsuperior.movieflix.security.exceptions;

public class ForbiddenException extends RuntimeException {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	public ForbiddenException( String message ) {
		super(message);
	}
}
