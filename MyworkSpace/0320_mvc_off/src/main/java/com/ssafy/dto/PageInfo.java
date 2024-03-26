package com.ssafy.dto;

public class PageInfo {
	private boolean forward;
	private String path;
	
	public PageInfo(boolean forward, String path) {
		super();
		this.forward = forward;
		this.path = path;
	}

	public boolean isForward() {
		return forward;
	}

	public void setForward(boolean forward) {
		this.forward = forward;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "PageInfo [forward=" + forward + ", path=" + path + "]";
	}
}
