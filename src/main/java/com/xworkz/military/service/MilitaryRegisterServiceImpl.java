package com.xworkz.military.service;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.military.dao.MilitaryRegisterDAO;
import com.xworkz.military.dto.MilitaryRegisterDTO;
import com.xworkz.military.entity.MilitaryRegisterEntity;

@Service
public class MilitaryRegisterServiceImpl implements MilitaryRegisterService {

	private static final Logger LOGGER = Logger.getLogger(MilitaryRegisterServiceImpl.class);

	public MilitaryRegisterServiceImpl() {
		LOGGER.info(":::::Created \t:::::" + this.getClass().getSimpleName());
	}

	@Autowired
	private MilitaryRegisterDAO militaryRegisterDAO;
	
	//private Integer totalPrice;

	public int validateAndCreate(MilitaryRegisterDTO militaryRegisterDTO) {
		LOGGER.info(":::::Start : MilitaryRegisterServiceImpl validateAndCreate():::::"+militaryRegisterDTO);
		int valid = 1;
		try {
			if (Objects.nonNull(militaryRegisterDTO)) {
				String countryName = militaryRegisterDTO.getCountryName();
				if (Objects.nonNull(countryName) && !countryName.isEmpty()) {
					LOGGER.info(":::::CountryName is valid:::::");
					valid = 0;
				} else {
					LOGGER.info(":::::CountryName is not valid:::::");
					valid = 1;
				}
				String militaryType = militaryRegisterDTO.getMilitaryType();
				if (Objects.nonNull(militaryType) && !militaryType.isEmpty()) {
					LOGGER.info(":::::MilitaryType is valid:::::");
					valid = 0;
				} else {
					LOGGER.info(":::::MilitaryType is not valid:::::");
					valid = 1;
				}
				String militaryEquipment = militaryRegisterDTO.getMilitaryEquipment();
				if (Objects.nonNull(militaryEquipment) && !militaryEquipment.isEmpty()) {
					LOGGER.info(":::::MilitaryEquipment is valid:::::");
					valid = 0;
				} else {
					LOGGER.info(":::::MilitaryEquipment is not valid:::::");
					valid = 1;
				}
				Integer militaryPrice = militaryRegisterDTO.getMilitaryPrice();
				if (Objects.nonNull(militaryPrice)) {
					LOGGER.info(":::::MilitaryPrice is valid:::::");
					valid = 0;
				} else {
					LOGGER.info(":::::MilitaryPrice is not valid:::::");
					valid = 1;
				}
				Integer militarytotalPrice = militaryRegisterDTO.getMilitaryPrice();
				if (Objects.nonNull(militarytotalPrice)) {
					LOGGER.info(":::::militarytotalPrice is valid:::::");
					valid = 0;
				} else {
					LOGGER.info(":::::militarytotalPrice is not valid:::::");
					valid = 1;
				}
				Integer militaryQuantity = militaryRegisterDTO.getMilitaryQuantity();
				if (Objects.nonNull(militaryQuantity)) {
					LOGGER.info(":::::MilitaryQuantity is valid:::::");
					valid = 0;
				} else {
					LOGGER.info(":::::MilitaryQuantity is not valid:::::");
					valid = 1;
				}
				String militaryYear = militaryRegisterDTO.getMilitaryYear();
				if (Objects.nonNull(militaryYear) && !militaryYear.isEmpty()) {
					LOGGER.info(":::::MilitaryYear is valid:::::");
					valid = 0;
				} else {
					LOGGER.info(":::::MilitaryYear is not valid:::::");
					valid = 1;
				}
				if (valid == 0) {
					LOGGER.info(":::::All Fields Are valid:::::");
					//LOGGER.info(":::::Start : Total Price Calculate :::::");
					//this.totalPrice = militaryPrice;
					//LOGGER.info(":::::SEndart : Total Price Calculate :::::");
					LOGGER.info(":::::militaryRegisterDTO to militaryRegisterEntity:::::");
					MilitaryRegisterEntity militaryRegisterEntity = new MilitaryRegisterEntity();
					BeanUtils.copyProperties(militaryRegisterDTO, militaryRegisterEntity);
					militaryRegisterDAO.save(militaryRegisterEntity);
					return valid;
				}
			}
		} catch (Exception e) {
			LOGGER.error(":::::Start : Exception Handler:::::" + e);
			e.printStackTrace();
		}
		LOGGER.info(":::::End : MilitaryRegisterServiceImpl validateAndCreate():::::");
		return valid;
	}

}
