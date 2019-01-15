package com.example.appointmentform.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AppointmentFormDto {
	private Integer id;
	
	@NotNull(message="Email Id cannot be null")
	@Size(min=5, max=50, message="email id must be between 5 to 20 characters")
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$|(^$)", message = "email should be in correct format")
	private String email;
	
	@NotNull(message="Name cannot be null")
	@Size(min=2, max=20, message="Name must be between 2 to 20 characters")
	private String name;
	
	private Integer age;
	
	@NotNull(message="Mobile Number cannot be null")
	@Pattern(regexp="(^[1-9]{1}[0-9]{9}$)|(^$)",message="Invalid Phone Number format")
	private String mobileNumber;
	
	private String time;
	private String day;
	private String date;
	private String location;
	private String symptoms;
	private String applicationDate;
	
	public AppointmentFormDto() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}

	@Override
	public String toString() {
		return "AppointmentFormDto [id=" + id + ", email=" + email + ", name=" + name + ", age=" + age
				+ ", mobileNumber=" + mobileNumber + ", time=" + time + ", day=" + day + ", date=" + date
				+ ", location=" + location + ", symptoms=" + symptoms + ", applicationDate=" + applicationDate + "]";
	}
}
