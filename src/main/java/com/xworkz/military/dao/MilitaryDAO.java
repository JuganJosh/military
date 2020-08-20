package com.xworkz.military.dao;

import java.util.List;

import com.xworkz.military.entity.MilitaryEntity;

public interface MilitaryDAO {

	public List<MilitaryEntity> fetchAllByType(String type);

}
