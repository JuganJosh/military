package com.xworkz.military.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.military.dto.MilitaryDTO;
import com.xworkz.military.service.MilitaryService;

@Component
@RequestMapping("/")
public class MilitaryController {

	private static final Logger LOGGER = Logger.getLogger(MilitaryController.class);

	private List<MilitaryDTO> seList;

	@Autowired
	private MilitaryService militaryService;

	@PostConstruct
	public void init() {
		LOGGER.info(":::::Start init()::::::");
		seList = militaryService.validateFetchByType("MILITARY");
		LOGGER.info("::::::End init():::::");
	}

	public MilitaryController() {
		LOGGER.info(":::::Created \t:::::" + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/militarylanding.odc", method = RequestMethod.GET)
	public String militarylanding(Model model) {
		LOGGER.info(":::::Start Invoked militarylanding() method:::::");
		// LOGGER.info(seList);
		model.addAttribute("selist", seList);
		LOGGER.info(":::::End Invoked militarylanding() method:::::");
		return "index";
	}

}
