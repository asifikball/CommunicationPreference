package com.cointribe.communication.preferences.model;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="preferences")
public class Preference implements Serializable{

	
	private static final long serialVersionUID = -7716187089080393036L;

	@Id
	@GeneratedValue
	@Column(name="preference_id")
	private int preference_id;
	
	@Column(name="preference_time")
	private Time preference_time;
	
	@Column(name="preference_type")
	private String preference_type;
	
	@Column(name="user_name")
	private String user_name;

	

	public int getPreference_id() {
		return preference_id;
	}

	public void setPreference_id(int preference_id) {
		this.preference_id = preference_id;
	}

	
	public Time getPreference_time() {
		return preference_time;
	}


	public void setPreference_time(Time p_time) {
		this.preference_time = p_time;
	}

	public String getPreference_type() {
		return preference_type;
	}

	public void setPreference_type(String preference_type) {
		this.preference_type = preference_type;
	}

	
	
public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

public Preference() {}

public Preference(int preference_id, Time preference_time, String preference_type, String user_name) {
	super();
	this.preference_id = preference_id;
	this.preference_time = preference_time;
	this.preference_type = preference_type;
	this.user_name = user_name;
}

@Override
public String toString() {
	return "Preference [preference_id=" + preference_id + ", preference_time=" + preference_time + ", preference_type="
			+ preference_type + ", user_name=" + user_name + "]";
}
	
	

	
	
}
