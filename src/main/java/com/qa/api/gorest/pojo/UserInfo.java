package com.qa.api.gorest.pojo;

public class UserInfo {
	
	private String first_name;
	private String last_name;
	private String gender;
	private String dob;
	private String email;
	private String phone;
	private String websites;
	private String address;
	private String status;
	
	private Links link; // we need to declare the Links class reference here and pass it into the constructor 
						//and also create getter and setter for the same.
	
	
	public UserInfo(String first_name, String last_name, String gender, String dob, String email, String phone,
			String websites, String address, String status,Links link) {
	
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
		this.phone = phone;
		this.websites = websites;
		this.address = address;
		this.status = status;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getWebsites() {
		return websites;
	}


	public void setWebsites(String websites) {
		this.websites = websites;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Links getLink() {
		return link;
	}


	public void setLink(Links link) {
		this.link = link;
	}
	
	

}
