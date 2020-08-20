package com.xworkz.military.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.military.entity.MilitaryRegisterEntity;

@Component
public class MilitaryRegisterDAOImpl implements MilitaryRegisterDAO {

	private static final Logger LOGGER = Logger.getLogger(MilitaryRegisterDAOImpl.class);

	public MilitaryRegisterDAOImpl() {
		LOGGER.info(":::::Created \t:::::" + this.getClass().getSimpleName());
	}

	private SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public void save(MilitaryRegisterEntity militaryRegisterEntity) {
		LOGGER.info(":::::Start : MilitaryRegisterDAOImpl Class save():::::");
		LOGGER.info(":::::Start : MilitaryRegisterEntity:::::"+militaryRegisterEntity);
		Session session = this.factory.openSession();
		try {
			LOGGER.info(":::::Begin the Transaction:::::");
			session.beginTransaction();
			LOGGER.info(":::::Save the Entity::::::" + militaryRegisterEntity);
			session.save(militaryRegisterEntity);
			// session.save(visitEntity);
			LOGGER.info(":::::Commit the Transcation:::::");
			session.getTransaction().commit();
			LOGGER.info(":::::Inserted successfully:::::");
			LOGGER.info(":::::End of the Save Method:::::");

		} catch (Exception e) {
			LOGGER.error(":::::Create is Unsuccesssfully And RollBack:::::");
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
			LOGGER.info(":::::Using Finally Session is Closed:::::");
		}
		LOGGER.info(":::::End : MilitaryRegisterDAOImpl Class save():::::");

	}

}
