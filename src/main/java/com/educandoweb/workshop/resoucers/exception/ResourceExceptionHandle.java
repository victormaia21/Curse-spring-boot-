package com.educandoweb.workshop.resoucers.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.workshop.service.exception.DataBaseException;
import com.educandoweb.workshop.service.exception.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandle {

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandError>excessão(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Id não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandError stand = new StandError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(stand);
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandError>excessão(DataBaseException e, HttpServletRequest request) {
		String error = "Não pode excluir do banco de dados";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandError stand = new StandError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(stand);
	}
}
