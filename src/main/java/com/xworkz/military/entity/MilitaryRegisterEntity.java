package com.xworkz.military.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "MILITARY_REGISTER_TABLE")
public class MilitaryRegisterEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(MilitaryRegisterEntity.class);

	public MilitaryRegisterEntity() {
		LOGGER.info(":::::Created \t:::::" + this.getClass().getSimpleName());
	}

	@Id
	@Column(name = "MILITARY_ID")
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	private Integer militaryId;
	@Column(name = "MILITARY_NAME")
	private String countryName;
	@Column(name = "MILITARY_TYPE")
	private String militaryType;
	@Column(name = "MILITARY_EQUIPMENT")
	private String militaryEquipment;
	@Column(name = "MILITARY_PRICE")
	private Integer militaryPrice;
	@Column(name = "MILITARY_QUANTITY")
	private Integer militaryQuantity;
	@Column(name = "MILITARY_YEAR")
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
