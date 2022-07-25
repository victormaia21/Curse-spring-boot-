package com.educandoweb.workshop.resoucers.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.workshop.service.exception.DatabaseException;
import com.educandoweb.workshop.service.exception.ResourcesNotFoundException;

@ControllerAdvice
public class ResourcesExceptionHandle {

	@ExceptionHandler(ResourcesNotFoundException.class)
	public ResponseEntity<StandError>exception(ResourcesNotFoundException e, HttpServletRequest request) {
		String error = "Id não existente";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandError sr = new StandError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(sr);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandError>database(DatabaseException e, HttpServletRequest request) {
		String error = "Error no banco de dados";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandError sr = new StandError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(sr);
		
	}
}
