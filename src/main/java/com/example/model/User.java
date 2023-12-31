package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private String address;
	private String mobile;
	private String email;
	private String pincode;
	private String gender;
	private String photo;
//	private String fromdate;
//	private String todate;
	private String date;

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	/*
	 * public String getFromdate() { return fromdate; } public void
	 * setFromdate(String fromdate) { this.fromdate = fromdate; } public String
	 * getTodate() { return todate; } public void setTodate(String todate) {
	 * this.todate = todate; }
	 */
	public int getId() {
		return id;
	}
	public User() {}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + ", mobile=" + mobile + ", email=" + email
				+ ", pincode=" + pincode + ", gender=" + gender + "]";
	}
	public User(int id, String name, String address, String mobile, String email, String pincode, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.pincode = pincode;
		this.gender = gender;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	

}
