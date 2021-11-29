package com.devsuperior.movieflix.security.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException( String message ) {
		super(message);
	}
}
