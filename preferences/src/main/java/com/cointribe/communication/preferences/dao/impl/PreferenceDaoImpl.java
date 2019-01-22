package com.cointribe.communication.preferences.dao.impl;

import java.sql.Time;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cointribe.communication.preferences.dao.PreferenceDaoCustom;

@Repository
@Transactional
public class PreferenceDaoImpl implements PreferenceDaoCustom{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Time> getPreferenceList(String user_name,String preference_type) throws Exception {
		
		Query query=entityManager.createNativeQuery("select preference_time from preferences where user_name=? and preference_type=? order by preference_id");
		query.setParameter(1, user_name);
		query.setParameter(2, preference_type);
		return query.getResultList();
	}

}
