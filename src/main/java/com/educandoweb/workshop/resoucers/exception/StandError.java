package com.educandoweb.workshop.resoucers.exception;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StandError implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant timestamp;
	private Integer status;
	private String error;
	private String mensseger;
	private String path;
	
	public StandError() {
	}

	public StandError(Instant timestamp, Integer status, String error, String mensseger, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.mensseger = mensseger;
		this.path = path;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMensseger() {
		return mensseger;
	}

	public void setMensseger(String mensseger) {
		this.mensseger = mensseger;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
