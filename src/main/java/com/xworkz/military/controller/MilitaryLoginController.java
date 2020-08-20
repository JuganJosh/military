package com.xworkz.military.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.military.service.MilitaryLoginService;

@Component
@RequestMapping("/")
public class MilitaryLoginController {

	private static final Logger LOGGER = Logger.getLogger(MilitaryLoginController.class);

	public MilitaryLoginController() {
		LOGGER.info(":::::Created \t:::::" + this.getClass().getSimpleName());
	}

	@Autowired
	private MilitaryLoginService militaryLoginService;

	@RequestMapping(value = "/login.odc", method = RequestMethod.POST)
	public String militaryLogin(@RequestParam String muserEmail, String muserPassword, Model model) {
		try {
			LOGGER.info(":::::Start Invoked militaryLogin() method:::::");
			LOGGER.info(":::::Start MuserEmail:::::" + muserEmail);
			LOGGER.info(":::::Start MuserPassword:::::" + muserPassword);
			int check = this.militaryLoginService.ValidatefetchByEmailAndPassword(muserEmail, muserPassword);
			if (check == 0) {
				model.addAttribute("muserEmail", muserEmail);
				return "userhome";
			} else {
				model.addAttribute("value", "Email Or Password Not Matching");
				return "login";
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		LOGGER.info(":::::End Invoked militaryLogin() method:::::");
		return null;
	}

}
