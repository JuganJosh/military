package com.xworkz.military.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.military.service.MilitaryResetpassService;

@Component
@RequestMapping("/")
public class MilitaryResetpassController {

	private static final Logger LOGGER = Logger.getLogger(MilitaryResetpassController.class);

	public MilitaryResetpassController() {
		LOGGER.info(":::::Created \t:::::" + this.getClass().getSimpleName());
	}
	
	@Autowired
	private  MilitaryResetpassService militaryResetpassService;
	
	@RequestMapping(value = "/resetpass.odc", method = RequestMethod.POST)
	public String militaryResetpass(@RequestParam String muserEmail, Model model) {
		try {
			LOGGER.info(":::::Start Invoked militaryResetpass() method:::::");
			LOGGER.info(":::::Start MuserEmail:::::" + muserEmail);
			int check = this.militaryResetpassService.ValidatefetchByEmail(muserEmail);
			LOGGER.info(":::::Check@@@@@@@@@@@@:::::"+check);
			if (check == 0) {
				LOGGER.info(":::::Successfully All class and interface:::::");
				return "login";
			} else {
				model.addAttribute("value", "Email Not Matching");
				return "resetpassword";
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		LOGGER.info(":::::End Invoked militaryResetpass() method:::::");
		return null;
	}

}
