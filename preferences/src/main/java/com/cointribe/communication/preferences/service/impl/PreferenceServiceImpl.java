package com.cointribe.communication.preferences.service.impl;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cointribe.communication.preferences.dao.PreferenceDao;
import com.cointribe.communication.preferences.model.Preference;
import com.cointribe.communication.preferences.model.PreferenceTime;
import com.cointribe.communication.preferences.model.UserPreference;
import com.cointribe.communication.preferences.service.PreferenceService;
import com.cointribe.communication.preferences.util.Constant;

@Service
@Transactional
public class PreferenceServiceImpl implements PreferenceService {
	
	Logger logger = LoggerFactory.getLogger(PreferenceServiceImpl.class);
	
	@Autowired
	PreferenceDao preferenceDao;

	@Override
	public void setPreference(String user_name, UserPreference userPreference) throws Exception
	{
		List<PreferenceTime> smsPreferenceList= userPreference.getSms();
		List<PreferenceTime> emailPreferenceList= userPreference.getEmails();
		List<PreferenceTime> appPreferenceList= userPreference.getApp_notifications();
		
		if(smsPreferenceList !=null)
		{
			setPreference(smsPreferenceList,user_name,"sms");
		}
		if(emailPreferenceList !=null)
		{
			setPreference(emailPreferenceList,user_name,"emails");
		}
		if(appPreferenceList !=null)
		{
			setPreference(appPreferenceList,user_name,"app_notifications");
		}
		
		
	}
	
	private void setPreference(List<PreferenceTime> preferenceList,String user_name,String entity)throws Exception
	{
		for(PreferenceTime preferenceinfo:preferenceList)
		{
			Preference preference=new Preference();
			preference.setPreference_time(preferenceinfo.getPreference_time());
			preference.setPreference_type(entity);
			preference.setUser_name(user_name);
			
			logger.info("User Name :"+user_name+"Notification Type "+entity+" Preference Time"+preferenceinfo.getPreference_time());
			preferenceDao.save(preference);
		}
	}

	@Override
	public UserPreference retrieveUserPreference(String user_name) throws Exception {
		
		UserPreference userPreference =new UserPreference();
		userPreference.setSms(getPreference(user_name,"sms"));
		userPreference.setEmails(getPreference(user_name,"emails"));
		userPreference.setApp_notifications(getPreference(user_name,"app_notifications"));
		return userPreference;
	}
	
	private List<PreferenceTime> getPreference(String user_name,String preference_type)throws Exception
	{
		List<PreferenceTime> pTimeLst=new ArrayList<>();
		List<Time> preference=preferenceDao.getPreferenceList(user_name,preference_type);
		for(Time preferenceinfo:preference)
		{
			PreferenceTime pTime=new PreferenceTime();
			pTime.setPreference_time(preferenceinfo);
			pTimeLst.add(pTime);
		}
		return pTimeLst;
	}

	public String setNotification(String user_name,String notification_type)throws Exception
	{
		boolean validatePreference= getvalidatePreference(user_name,notification_type);
		String msg="";
		
		if(validatePreference)
		{
			//SendNotification(String user_name,String notification_type)
			//For integrating with SMTP/SMS gateway
			msg=Constant.Valid_preference;
		}
		else
		{
			msg=Constant.InValid_preference;
		}
		return msg;
	}
	
	private boolean getvalidatePreference(String user_name,String notification_type)throws Exception
	{
		List<Time> preference=preferenceDao.getPreferenceList(user_name,notification_type);
		
		Time current_time=Time.valueOf(LocalTime.now());
		
		if(preference.contains(current_time))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
