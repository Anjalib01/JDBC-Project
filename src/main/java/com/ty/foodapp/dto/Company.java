package com.ty.foodapp.dto;

public class Company {
	
	private int id;
	private String name;
	private String email;
	private Long contact;
	private int gstNo;
	private int establishedYear;
	private String about;
	public int getId() {
		return id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public int getGstNo() {
		return gstNo;
	}
	public void setGstNo(int gstNo) {
		this.gstNo = gstNo;
	}
	public int getEstablishedYear() {
		return establishedYear;
	}
	public void setEstablishedYear(int establishedYear) {
		this.establishedYear = establishedYear;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", email=" + email + ", contact=" + contact + ", gstNo=" + gstNo
				+ ", establishedYear=" + establishedYear + ", about=" + about + "]";
	}
	public Company(int id, String name, String email, Long contact, int gstNo, int establishedYear, String about) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.gstNo = gstNo;
		this.establishedYear = establishedYear;
		this.about = about;
	}
	public Company() {
		super();
	}
	
	
	

}
