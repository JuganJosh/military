package com.xworkz.military.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.military.entity.MilitaryLoginEntity;


@Component
public class MilitaryLoginDAOImpl implements MilitaryLoginDAO {

	private static final Logger LOGGER = Logger.getLogger(MilitaryLoginDAOImpl.class);

	public MilitaryLoginDAOImpl() {
		LOGGER.info(":::::Created \t:::::" + this.getClass().getSimpleName());
	}

	private SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	public MilitaryLoginEntity fetchByEmailAndPassword(String muserEmail, String muserPassword) {
		LOGGER.info(":::::Start : MilitaryLoginDAOImpl Class Check EmailAndPassword():::::");
		LOGGER.info(":::::Start : personalEmail:::::" + muserEmail);
		LOGGER.info(":::::Start : personalPassword:::::" + muserPassword);
		Session session = this.factory.openSession();
		try {
			Query query = session.getNamedQuery("fetchPersonalByEmailIdAndPassword");

			query.setParameter("email", muserEmail);
			query.setParameter("password", muserPassword);

			// STEP 2: PROCESS
			Object result = query.uniqueResult();
			MilitaryLoginEntity entity = (MilitaryLoginEntity) result;
			LOGGER.info(entity);
			return entity;
		} catch (Exception e) {
			LOGGER.info(":::::Exception Handeled MilitaryLoginEntity:::::");
			e.printStackTrace();
		}
		LOGGER.info(":::::End : TempleLoginDAOImpl Class Check EmailAndPassword():::::");
		return null;
	}

}
