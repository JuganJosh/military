package com.xworkz.military.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "MILITARY_USER_REGISTER_TABLE")
@Transactional
@NamedQueries({
		@NamedQuery(name = "fetchPersonalByEmailIdAndPassword", query = "SELECT temp FROM MilitaryLoginEntity temp WHERE muserEmail=:email AND muserPassword=:password"),
		@NamedQuery(name = "fetchPersonalByEmailI", query = "SELECT temp FROM MilitaryLoginEntity temp WHERE muserEmail=:email"),
		@NamedQuery(name = "updateEmailByPassword", query = "UPDATE MilitaryLoginEntity SET muserPassword =:password WHERE muserEmail =:email"),
})
public class MilitaryLoginEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(MilitaryLoginEntity.class);

	public MilitaryLoginEntity() {
		LOGGER.info(":::::Created \t:::::" + this.getClass().getSimpleName());
	}

	@Id
	@Column(name = "MUSER_ID")
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	private Integer muserId;
	@Column(name = "MUSER_EMAIL")
	private String muserEmail;
	@Column(name = "MUSER_PASSWORD")
	private String muserPassword;
	@Column(name = "MUSER_PHONENO")
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
