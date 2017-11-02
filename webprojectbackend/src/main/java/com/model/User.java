package com.model;

import java.io.Serializable;
import javax.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
public class User implements Serializable{		//this class will be used as repository+service
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id // primary key
	private String email;
	private String name;
	private String password;
	private boolean enabled;
	private String role;
	private String address;
	private String phone;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	

}
