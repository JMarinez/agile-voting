package org.dominisoft.scrumdev.claro2020.domain;

public class Admin {
	private String userName;
	private String password;
	
	public Admin( String userName, String password) {
		if (userName.isEmpty() || password.isEmpty()) {
			throw new IllegalArgumentException("Llene los campos vacios.");
		}
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
