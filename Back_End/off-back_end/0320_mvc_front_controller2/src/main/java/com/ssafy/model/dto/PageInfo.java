package com.ssafy.model.dto;

public class PageInfo {
	// FrontController에서 subController를 부를때 정보 제공
	
	private boolean forward;
	private String path; // 경로 제공
	
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
	
}
