package com.example.demo.security;

public class JWTResponse {
	
	private String authenticationToken ;
	private String username ;
	
	
	
	public JWTResponse(String authenticationToken, String username) {
		
		this.authenticationToken = authenticationToken;
		this.username = username;
		
	}


	public JWTResponse() {
		
	}


	public String getAuthenticationToken() {
		return authenticationToken;
	}


	public void setAuthenticationToken(String authenticationToken) {
		this.authenticationToken = authenticationToken;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	
	
	

}
