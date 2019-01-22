package com.cointribe.communication.preferences.model;

import java.sql.Time;

import com.cointribe.communication.preferences.util.TimeDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class PreferenceTime {

	@JsonFormat(pattern = "HH:mm")
	@JsonDeserialize(using =TimeDeserializer.class)
	private Time preference_time;

	public Time getPreference_time() {
		return preference_time;
	}

	public void setPreference_time(Time preference_time) {
		this.preference_time = preference_time;
	}

	public PreferenceTime() {}
	
	public PreferenceTime(Time preference_time) {
		super();
		this.preference_time = preference_time;
	}

	@Override
	public String toString() {
		return "PreferenceTime [preference_time=" + preference_time + "]";
	}
	
	
}
