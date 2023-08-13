package com.student.manage;

public class Student {
	private int id;
	private String name;
	private String Phone;
	private String city;
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
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String name, String phone, String city) {
		super();
		this.id = id;
		this.name = name;
		Phone = phone;
		this.city = city;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", Phone=" + Phone + ", city=" + city + "]";
	}
	public Student(String name, String phone, String city) {
		super();
		this.name = name;
		Phone = phone;
		this.city = city;
	}
	
}
