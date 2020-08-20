package com.xworkz.military.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.military.entity.MilitaryEntity;

@Component
public class MilitaryDAOImpl implements MilitaryDAO {

	private static final Logger LOGGER = Logger.getLogger(MilitaryDAOImpl.class);

	public MilitaryDAOImpl() {
		LOGGER.info(":::::Created \t:::::" + this.getClass().getSimpleName());
	}

	private SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public List<MilitaryEntity> fetchAllByType(String type) {
		LOGGER.info(":::::Start : MilitaryDAOImpl Class:::::" + type);
		Session session = this.factory.openSession();
		try {
			LOGGER.info(":::::START : MilitaryDAOImpl Class fetchAllByType:::::" + type);

			Query query = session.getNamedQuery("fetchAllByType");
			Query query1 = query.setParameter("type", type);

			LOGGER.info(":::::Query Excute---->:::::" + query);

			List<MilitaryEntity> fetchedList = query.list();
			LOGGER.info(":::::SE list from daoimpl is :::::" + fetchedList);

			LOGGER.info(":::::End : MilitaryDAOImpl Class:::::");
			return fetchedList;
		} catch (Exception e) {
			LOGGER.info(":::::Exception in fetchAllByType:::::");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
