package com.xworkz.military.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "MILITARY_TABLE")
@NamedQueries({
		@NamedQuery(name = "fetchAllByType", query = "select cont from MilitaryEntity cont where military=:type"),

})
public class MilitaryEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(MilitaryEntity.class);

	public MilitaryEntity() {
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
	@Column(name = "MILITARY")
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
		return "MilitaryEntity [militaryId=" + militaryId + ", countryName=" + countryName + ", militaryType="
				+ militaryType + ", military=" + military + "]";
	}

	public MilitaryEntity(Integer militaryId, String countryName, String militaryType, String military) {
		super();
		this.militaryId = militaryId;
		this.countryName = countryName;
		this.militaryType = militaryType;
		this.military = military;
	}

}
