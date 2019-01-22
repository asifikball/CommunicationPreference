package com.cointribe.communication.preferences.service;

import org.springframework.stereotype.Service;

import com.cointribe.communication.preferences.model.UserPreference;
@Service
public interface PreferenceService {

	void setPreference(String user_id,UserPreference userPreference)throws Exception;
	UserPreference retrieveUserPreference(String user_name)throws Exception;
	String setNotification(String user_name,String notification_type)throws Exception;
}
