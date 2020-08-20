package com.xworkz.military.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.military.dto.MilitaryDTO;
import com.xworkz.military.dto.MilitaryRegisterDTO;
import com.xworkz.military.service.MilitaryRegisterService;

@Component
@RequestMapping("/")
public class MilitaryRegisterController {

	private static final Logger LOGGER = Logger.getLogger(MilitaryRegisterController.class);

	public MilitaryRegisterController() {
		LOGGER.info(":::::Created \t:::::" + this.getClass().getSimpleName());
	}

	@Autowired
	private MilitaryRegisterService militaryRegisterService;

	@RequestMapping(value = "/register.odc", method = RequestMethod.POST)
	public String militaryRegister(MilitaryRegisterDTO militaryRegisterDTO, Model model) {
		try {
			LOGGER.info(":::::Start Invoked militaryRegister() method:::::");
			LOGGER.info(":::::Start MilitaryDTO:::::" + militaryRegisterDTO);
			int check = this.militaryRegisterService.validateAndCreate(militaryRegisterDTO);
			if (check == 0) {
				model.addAttribute("militaryRegisterDTO", militaryRegisterDTO);
				return "success";
			} else {
				LOGGER.info(":::::Data is Not Validated Back to Main Page:::::");
				return "index";
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		LOGGER.info(":::::End Invoked militaryRegister() method:::::");
		return null;
	}

}
