package com.cointribe.communication.preferences.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cointribe.communication.preferences.model.UserPreference;
import com.cointribe.communication.preferences.service.PreferenceService;
import com.cointribe.communication.preferences.util.Constant;

@RestController
public class PreferencesController {

	Logger logger = LoggerFactory.getLogger(PreferencesController.class);
	@Autowired
	private PreferenceService preferenceService;

	@PostMapping("/user_name/{user_name}")
	public UserPreference registerStudentForCourse(@PathVariable String user_name,
			@RequestBody UserPreference newuserPreference) {

		try {
			preferenceService.setPreference(user_name, newuserPreference);
		} catch (Exception e) {
			logger.error("registerStudentForCourse :", e);
		}

		return newuserPreference;
	}

	@GetMapping("/user_name/{user_name}")
	public UserPreference retrieveUserPreference(@PathVariable String user_name) {
		UserPreference u_preference = null;
		try {
			u_preference = preferenceService.retrieveUserPreference(user_name);
		} catch (Exception e) {
			logger.error("retrieveUserPreference :", e);
		}
		return u_preference;
	}

	@GetMapping("/sendNotification/user_name/{user_name}/notification_type/{notification_type}")
	public String sendNotification(@PathVariable String user_name,
			@PathVariable String notification_type) {
		String msg="";
		try {
			msg=preferenceService.setNotification(user_name, notification_type);
		} catch (Exception e) {
			msg=Constant.Global_Failure_Message;
			logger.error("registerStudentForCourse :", e);
		}

		return msg;
	}
}
