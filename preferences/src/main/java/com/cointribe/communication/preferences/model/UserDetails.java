package com.cointribe.communication.preferences.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="user_details")
public class UserDetails  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1900011229482091104L;

	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="user_name")
	private String user_name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone_number")
	private long phone_number;
	
	public UserDetails() {}

	public UserDetails(int user_id, String user_name, String email, long phone_number) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.email = email;
		this.phone_number = phone_number;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

	@Override
	public String toString() {
		return "UserDetails [user_id=" + user_id + ", user_name=" + user_name + ", email=" + email + ", phone_number="
				+ phone_number + "]";
	}

	
}
