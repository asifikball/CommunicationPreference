package com.cointribe.communication.preferences.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cointribe.communication.preferences.model.Preference;

@Repository
public interface PreferenceDao extends JpaRepository<Preference, Integer>,PreferenceDaoCustom{

	
}
