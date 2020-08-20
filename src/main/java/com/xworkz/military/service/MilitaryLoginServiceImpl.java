package com.xworkz.military.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.military.dao.MilitaryLoginDAO;
import com.xworkz.military.entity.MilitaryLoginEntity;

@Service
public class MilitaryLoginServiceImpl implements MilitaryLoginService {

	private static final Logger LOGGER = Logger.getLogger(MilitaryLoginServiceImpl.class);

	public MilitaryLoginServiceImpl() {
		LOGGER.info(":::::Created \t:::::" + this.getClass().getSimpleName());
	}

	@Autowired
	private MilitaryLoginDAO militaryLoginDAO;

	public int ValidatefetchByEmailAndPassword(String muserEmail, String muserPassword) {
		LOGGER.info(":::::Start : MilitaryLoginServiceImpl validateAndCreate():::::");
		LOGGER.info(":::::Start : MuserEmail validateAndCreate():::::" + muserEmail);
		LOGGER.info(":::::Start : MuserPassword validateAndCreate():::::" + muserPassword);
		int valid = 1;
		try {
			if (!muserEmail.isEmpty() && !muserPassword.isEmpty()) {
				LOGGER.info(":::::MuserEmail is valid:::::");

				MilitaryLoginEntity militaryLoginEntity = new MilitaryLoginEntity();
				militaryLoginEntity = militaryLoginDAO.fetchByEmailAndPassword(muserEmail, muserPassword);
				
				if (militaryLoginEntity != null) {
					LOGGER.info(":::::militaryLoginEntity is Not Empty:::::");
					return 0;
				} else {
					LOGGER.info(":::::militaryLoginEntity is Empty:::::");
					return 1;
				}
			} else {
				LOGGER.info(":::::MuserEmail is not valid:::::");
				return 1;
			}
		} catch (Exception e) {
			LOGGER.error(":::::Start : Exception Handler:::::" + e);
			e.printStackTrace();
		}
		LOGGER.info(":::::End : MilitaryLoginServiceImpl validateAndCreate():::::");
		return 0;
	}

}
