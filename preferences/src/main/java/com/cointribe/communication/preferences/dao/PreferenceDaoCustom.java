package com.cointribe.communication.preferences.dao;

import java.sql.Time;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cointribe.communication.preferences.model.Preference;
@Repository
public interface PreferenceDaoCustom {

	List<Time> getPreferenceList(String user_name,String preference_type)throws Exception;
}
