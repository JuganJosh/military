package com.xworkz.military.service;

import java.util.List;

import com.xworkz.military.dto.MilitaryDTO;

public interface MilitaryService {

	public List<MilitaryDTO> validateFetchByType(String type);

}
