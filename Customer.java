package com.example.customer.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//import org.hibernate.validator.constraints.Range;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true)
	
	private long id;
	
	private String customerName;
	
	
	//email should be in valid email format

    @NotNull
	@Column(unique=true)
	@Pattern (regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$" , message = "Email should be in correct fomate")
	private String customerEmail;
	
    @NotNull
	@Column(unique=true)
	@Size(min=10, max=10, message="Mobile_no should be exactily 10 digit.")
	private String customerMobile;
	
	@Column(name ="customerAddress")
	private String customerAddress;
	
	public Customer(long id, String customerName, String customerEmail, String customerMobile, String customerAddress) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerMobile = customerMobile;
		this.customerAddress = customerAddress;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the customerEmail
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}
	/**
	 * @param customerEmail the customerEmail to set
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	/**
	 * @return the customerMobile
	 */
	public String getCustomerMobile() {
		return customerMobile;
	}
	/**
	 * @param customerMobile the customerMobile to set
	 */
	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}
	/**
	 * @return the customerAddress
	 */
	public String getCustomerAddress() {
		return customerAddress;
	}
	/**
	 * @param customerAddress the customerAddress to set
	 */
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + ", customerEmail=" + customerEmail
				+ ", customerMobile=" + customerMobile + ", customerAddress=" + customerAddress + "]";
	}
	

}
