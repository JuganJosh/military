package com.xworkz.military.dto;

import java.io.Serializable;

import org.apache.log4j.Logger;

public class MilitaryDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(MilitaryDTO.class);

	public MilitaryDTO() {
		LOGGER.info(":::::Created \t:::::" + this.getClass().getSimpleName());
	}

	private Integer militaryId;
	private String countryName;
	private String militaryType;
	private String military;

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

	public String getMilitary() {
		return military;
	}

	public void setMilitary(String military) {
		this.military = military;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	@Override
	public String toString() {
		return "MilitaryDTO [militaryId=" + militaryId + ", countryName=" + countryName + ", militaryType="
				+ militaryType + ", military=" + military + "]";
	}

	public MilitaryDTO(Integer militaryId, String countryName, String militaryType, String military) {
		super();
		this.militaryId = militaryId;
		this.countryName = countryName;
		this.militaryType = militaryType;
		this.military = military;
	}

}
