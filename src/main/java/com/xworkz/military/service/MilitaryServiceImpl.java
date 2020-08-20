package com.xworkz.military.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.military.dao.MilitaryDAO;
import com.xworkz.military.dto.MilitaryDTO;
import com.xworkz.military.entity.MilitaryEntity;

@Service
public class MilitaryServiceImpl implements MilitaryService {

	private static final Logger LOGGER = Logger.getLogger(MilitaryServiceImpl.class);

	public MilitaryServiceImpl() {
		LOGGER.info(":::::Created \t:::::" + this.getClass().getSimpleName());
	}

	@Autowired
	private MilitaryDAO militaryDAO;

	public List<MilitaryDTO> validateFetchByType(String type) {
		try {
			LOGGER.info("Start :MilitaryServiceImpl Class validateFetchByType : " + type);
			List<MilitaryEntity> fetchedEntity = militaryDAO.fetchAllByType(type);

			if (Objects.nonNull(fetchedEntity)) {
				LOGGER.info("List is found and its size is : " + fetchedEntity.size());
				List<MilitaryDTO> list = new ArrayList<MilitaryDTO>();
				for (MilitaryEntity fetch : fetchedEntity) {
					MilitaryDTO dto = new MilitaryDTO();
					LOGGER.info("Copying data from dto to entity");
					BeanUtils.copyProperties(fetch, dto);
					list.add(dto);
					LOGGER.info("Adding all the dto's to list" + list);
				}
				return list;
			} else {
				LOGGER.info("Any List found in the Entity");
				return null;
			}
		} catch (Exception e) {
			LOGGER.info("wrong Service" + e);
		}
		return null;
	}

}
