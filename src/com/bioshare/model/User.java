package com.bioshare.model;

public class User {
	private int useID;
	private String name;
	private String firstName;
	private String login;
	private String password;
	private boolean isVendor;
	public int getUseID() {
		return useID;
	}
	public void setUseID(int useID) {
		this.useID = useID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Override
	public String toString() {
		return "User [useID=" + useID + ", name=" + name + ", firstName=" + firstName + ", login=" + login
				+ ", password=" + password + ", isVendor=" + isVendor + "]";
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isVendor() {
		return isVendor;
	}
	public void setVendor(boolean isVendor) {
		this.isVendor = isVendor;
	}

}
