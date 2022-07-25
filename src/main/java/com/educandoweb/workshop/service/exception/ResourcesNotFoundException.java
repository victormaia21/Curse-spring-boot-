package com.educandoweb.workshop.service.exception;

public class ResourcesNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourcesNotFoundException(Object id) {
		super("O id " + id + " não foi encontrado");
	}

}
