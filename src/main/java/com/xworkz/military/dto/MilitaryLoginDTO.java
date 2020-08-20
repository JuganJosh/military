package com.xworkz.military.dto;

import java.io.Serializable;

import org.apache.log4j.Logger;

public class MilitaryLoginDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(MilitaryLoginDTO.class);

	public MilitaryLoginDTO() {
		LOGGER.info(":::::Created \t:::::" + this.getClass().getSimpleName());
	}

	private Integer muserId;
	private String muserEmail;
	private String muserPassword;
	private Integer muserPhoneNo;

	public Integer getMuserId() {
		return muserId;
	}

	public void setMuserId(Integer muserId) {
		this.muserId = muserId;
	}

	public String getMuserEmail() {
		return muserEmail;
	}

	public void setMuserEmail(String muserEmail) {
		this.muserEmail = muserEmail;
	}

	public String getMuserPassword() {
		return muserPassword;
	}

	public void setMuserPassword(String muserPassword) {
		this.muserPassword = muserPassword;
	}

	public Integer getMuserPhoneNo() {
		return muserPhoneNo;
	}

	public void setMuserPhoneNo(Integer muserPhoneNo) {
		this.muserPhoneNo = muserPhoneNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

}
