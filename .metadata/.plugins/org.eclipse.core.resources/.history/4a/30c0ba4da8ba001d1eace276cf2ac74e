package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity

@Table(name = "vendor_info")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")

public class Vendor {
	
	   @Id
	   private Long id;

	   @Column(nullable = false, unique = true)
	   private String vendorCode;

	   @Column(nullable = false)
	   private String vendorName;

	   @Column(nullable = false)
	   private String address;

	   @Column(nullable = false)
	   private String city;

	   @Column(nullable = false)
	   private String state;

	   @Column(nullable = false)
	   private String pincode;

	   @Column(nullable = false)
	   private String phone;

	   @Column(nullable = false)
	   private String email;
	   
	   public Vendor() {
		   id = (long) 1;
		   vendorCode = "123456";
		   vendorName = "Puja Goyal";
		   address = "Bara Chowk";
		   city = "Giridih";
		   state = "Jharkhand";
		   pincode = "815301";
		   phone = "9874563210";
		   email = "pujagoyal@gmail.com";
		   
		   
		
	   }
	   
	   public Vendor(Long id, String vendorCode, String vendorName, String address, String city, String state,
			String pincode, String phone, String email) {
		super();
		this.id = id;
		this.vendorCode = vendorCode;
		this.vendorName = vendorName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.phone = phone;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
