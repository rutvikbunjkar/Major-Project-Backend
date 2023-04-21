package com.majorProject.model;

public class PasswordDetail {
	private String username;
	private String oldpassword;
	
	private String password;
	private String confirmpassword;
	
	private int tpin;
	private int confirmtpin;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public int getTpin() {
		return tpin;
	}
	public void setTpin(int tpin) {
		this.tpin = tpin;
	}
	public int getConfirmtpin() {
		return confirmtpin;
	}
	public void setConfirmtpin(int confirmtpin) {
		this.confirmtpin = confirmtpin;
	}
	@Override
	public String toString() {
		return "PasswordDetail [username=" + username + ", oldpassword=" + oldpassword + ", password=" + password
				+ ", confirmpassword=" + confirmpassword + ", tpin=" + tpin + ", confirmtpin=" + confirmtpin + "]";
	}
	
	
}
