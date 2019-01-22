package com.cointribe.communication.preferences.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserPreference {


	private List<PreferenceTime> sms;

	private List<PreferenceTime> emails;

	private List<PreferenceTime> app_notifications;

	public UserPreference() {
	}

	public List<PreferenceTime> getSms() {
		return sms;
	}

	public void setSms(List<PreferenceTime> sms) {
		this.sms = sms;
	}

	public List<PreferenceTime> getEmails() {
		return emails;
	}

	public void setEmails(List<PreferenceTime> emails) {
		this.emails = emails;
	}

	public List<PreferenceTime> getApp_notifications() {
		return app_notifications;
	}

	public void setApp_notifications(List<PreferenceTime> app_notifications) {
		this.app_notifications = app_notifications;
	}

	public UserPreference(List<PreferenceTime> sms, List<PreferenceTime> emails,
			List<PreferenceTime> app_notifications) {
		super();
		this.sms = sms;
		this.emails = emails;
		this.app_notifications = app_notifications;
	}

	@Override
	public String toString() {
		return "UserPreference [sms=" + sms + ", emails=" + emails + ", app_notifications=" + app_notifications + "]";
	}

	

}
