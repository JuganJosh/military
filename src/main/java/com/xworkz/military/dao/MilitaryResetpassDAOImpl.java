package com.xworkz.military.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.xworkz.military.entity.MilitaryLoginEntity;

@Component
public class MilitaryResetpassDAOImpl implements MilitaryResetpassDAO {

	private static final Logger LOGGER = Logger.getLogger(MilitaryResetpassDAOImpl.class);

	public MilitaryResetpassDAOImpl() {
		LOGGER.info(":::::Created \t:::::" + this.getClass().getSimpleName());
	}

	private SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public MilitaryLoginEntity fetchByEmail(String muserEmail) {
		LOGGER.info(":::::Start : MilitaryResetpassDAOImpl fetchByEmail():::::");
		LOGGER.info(":::::Start : personalEmail:::::" + muserEmail);
		Session session = this.factory.openSession();
		try {
			Query query = session.getNamedQuery("fetchPersonalByEmailI");

			query.setParameter("email", muserEmail);
			// STEP 2: PROCESS
			Object result = query.uniqueResult();
			MilitaryLoginEntity entity = (MilitaryLoginEntity) result;
			LOGGER.info(entity);
			return entity;
		} catch (Exception e) {
			LOGGER.info(":::::Exception Handeled MilitaryLoginEntity:::::");
			e.printStackTrace();
		}
		LOGGER.info(":::::End : MilitaryResetpassDAOImpl fetchByEmail():::::");
		return null;
	}

	public int updateEmailByPassword(String muserEmail, String password) {
		LOGGER.info(":::::Start : MilitaryResetpassDAOImpl updateEmailByPassword():::::");
		LOGGER.info(":::::Start : personalEmail:::::" + muserEmail);
		LOGGER.info(":::::Start : personalEmail:::::" + password);
		Session session = this.factory.openSession();
		session.beginTransaction();
		try {
			LOGGER.info(":::::Start : try {} Block:::::" + password);
			Query query = session.getNamedQuery("updateEmailByPassword");
			query.setParameter("email", muserEmail);
			query.setParameter("password", password);
			int res = query.executeUpdate();
			session.getTransaction().commit();
			return res;
		} catch (Exception e) {
			LOGGER.info(":::::Exception Handeled MilitaryLoginEntity:::::");
			e.printStackTrace();
		}
		LOGGER.info(":::::End : MilitaryResetpassDAOImpl updateEmailByPassword():::::");
		return 0;
	}

}
