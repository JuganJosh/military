package com.xworkz.military.dto;

import java.io.Serializable;

import org.apache.log4j.Logger;

public class MilitaryRegisterDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(MilitaryRegisterDTO.class);

	public MilitaryRegisterDTO() {
		LOGGER.info(":::::Created \t:::::" + this.getClass().getSimpleName());
	}

	private Integer militaryId;
	private String countryName;
	private String militaryType;
	private String militaryEquipment;
	private Integer militaryPrice;
	private Integer militaryQuantity;
	private String militaryYear;

	public Integer getMilitaryId() {
		return militaryId;
	}

	public void setMilitaryId(Integer militaryId) {
		this.militaryId = militaryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getMilitaryType() {
		return militaryType;
	}

	public void setMilitaryType(String militaryType) {
		this.militaryType = militaryType;
	}

	public String getMilitaryEquipment() {
		return militaryEquipment;
	}

	public void setMilitaryEquipment(String militaryEquipment) {
		this.militaryEquipment = militaryEquipment;
	}

	public Integer getMilitaryPrice() {
		return militaryPrice;
	}

	public void setMilitaryPrice(Integer militaryPrice) {
		this.militaryPrice = militaryPrice;
	}

	public Integer getMilitaryQuantity() {
		return militaryQuantity;
	}

	public void setMilitaryQuantity(Integer militaryQuantity) {
		this.militaryQuantity = militaryQuantity;
	}

	public String getMilitaryYear() {
		return militaryYear;
	}

	public void setMilitaryYear(String militaryYear) {
		this.militaryYear = militaryYear;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

}
