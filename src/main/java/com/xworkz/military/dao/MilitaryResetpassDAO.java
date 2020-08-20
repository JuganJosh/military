package com.xworkz.military.dao;

import com.xworkz.military.entity.MilitaryLoginEntity;

public interface MilitaryResetpassDAO {

	public MilitaryLoginEntity fetchByEmail(String muserEmail);

	public int updateEmailByPassword(String muserEmail, String password);

}
