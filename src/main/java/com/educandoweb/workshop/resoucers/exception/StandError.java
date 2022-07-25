package com.educandoweb.workshop.resoucers.exception;

import java.time.Instant;

public class StandError {

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
