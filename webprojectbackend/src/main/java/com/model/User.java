package com.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
public class User implements Serializable{		//this class will be used as repository+service
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id // primary key
	@NotNull(message="Email ID cannot be Blank")
	@Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$", message="Email ID should be correct")
	private String email;
	
	@NotNull(message="Name cannot be Blank")
	private String name;
	
	@NotNull(message="Password cannot be Blank")
	@Size(min=3,max=10)
	private String password;
	
	private boolean enabled;
	
	@NotNull(message="Role cannot be Blank")
	private String role;
	
	@NotNull(message="Address cannot be Blank")
	private String address;
	
	@NotNull(message="Phone cannot be Blank")
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
