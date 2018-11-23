package org.cap.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class PassRequestBean {
	
	private int requestId;
	private String employeeId;
	private String firstName;
	private String lastName;
	private String gender;
	private String address;
	private String email;
	private LocalDate dateOfJoining;
	private String location;
	private String pickuploc;
	private LocalTime pickuptime;
	private String designation;
	private String status="pending";
	
	public PassRequestBean() {
		
	}
	
	
	public PassRequestBean(int requestId, String employeeId, String firstName, String lastName, String gender,
			String address, String email, LocalDate dateOfJoining, String location, String pickuploc,
			LocalTime pickuptime, String designation) {
		super();
		this.requestId = requestId;
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.dateOfJoining = dateOfJoining;
		this.location = location;
		this.pickuploc = pickuploc;
		this.pickuptime = pickuptime;
		this.designation = designation;
	}


	public PassRequestBean(int requestId, String employeeId, String firstName, String lastName, String gender,
			String address, String email, LocalDate dateOfJoining, String location, String pickuploc,
			LocalTime pickuptime, String designation, String status) {
		super();
		this.requestId = requestId;
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.dateOfJoining = dateOfJoining;
		this.location = location;
		this.pickuploc = pickuploc;
		this.pickuptime = pickuptime;
		this.designation = designation;
		this.status = status;
	}


	public PassRequestBean(int requestId, String employeeId, String firstName, String lastName, String gender,
			String address, String email, LocalDate dateOfJoining, String location, String pickuploc,
			LocalTime pickuptime) {
		super();
		this.requestId = requestId;
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.dateOfJoining = dateOfJoining;
		this.location = location;
		this.pickuploc = pickuploc;
		this.pickuptime = pickuptime;
	}
	
	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPickuploc() {
		return pickuploc;
	}
	public void setPickuploc(String pickuploc) {
		this.pickuploc = pickuploc;
	}
	public LocalTime getPickuptime() {
		return pickuptime;
	}
	public void setPickuptime(LocalTime pickuptime) {
		this.pickuptime = pickuptime;
	}
	@Override
	public String toString() {
		return "PassRequestBean [requestId=" + requestId + ", employeeId=" + employeeId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", address=" + address + ", email=" + email
				+ ", dateOfJoining=" + dateOfJoining + ", location=" + location + ", pickuploc=" + pickuploc
				+ ", pickuptime=" + pickuptime + "]";
	}
	

}
