package com.xworkz.military.service;

import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.xworkz.military.dao.MilitaryResetpassDAO;
import com.xworkz.military.entity.MilitaryLoginEntity;

import net.bytebuddy.utility.RandomString;

@Service
public class MilitaryResetpassServiceImpl implements MilitaryResetpassService {

	private static final Logger LOGGER = Logger.getLogger(MilitaryResetpassServiceImpl.class);

	public MilitaryResetpassServiceImpl() {
		LOGGER.info(":::::Created \t:::::" + this.getClass().getSimpleName());
	}

	@Autowired
	private MilitaryResetpassDAO militaryResetpassDAO;
	
	@Autowired
	private JavaMailSender mailSender;

	public int ValidatefetchByEmail(String muserEmail) {
		LOGGER.info(":::::Start : MilitaryResetpassServiceImpl ValidatefetchByEmail():::::");
		LOGGER.info(":::::Start : MuserEmail validateAndCreate():::::" + muserEmail);
		try {
			if (!muserEmail.isEmpty()) {
				LOGGER.info(":::::MuserEmail is valid:::::");

				MilitaryLoginEntity militaryLoginEntity = new MilitaryLoginEntity();
				militaryLoginEntity = militaryResetpassDAO.fetchByEmail(muserEmail);
				LOGGER.info(":::::Successfully All class and interface:::::");
				if (militaryLoginEntity != null) {
					LOGGER.info(":::::militaryLoginEntity is valid:::::");

					char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
					StringBuilder sb = new StringBuilder(8);
					Random random = new Random();
					for (int i = 0; i < 8; i++) {
						char c = chars[random.nextInt(chars.length)];
						sb.append(c);
					}
					String password = sb.toString();
					

					LOGGER.info(":::::militaryLoginEntity is valid:::::" + password);
					int result = militaryResetpassDAO.updateEmailByPassword(muserEmail, password);
					System.out.println(result);
					if (result > 0) {
						String email = muserEmail;
						String pass = password;
						String text = "Your EmailId Is : "+email+"\n Your Password Is : "+password;
						System.out.println(email);
						System.out.println(pass);
						
						SimpleMailMessage messageSend = new SimpleMailMessage();
						messageSend.setTo(email);
						messageSend.setSubject(pass);
						messageSend.setText(text);
						mailSender.send(messageSend);
						return 0;
					} else {
						return 1;
					}
				} else {
					return 1;
				}
			} else {
				LOGGER.info(":::::MuserEmail is not valid:::::");
				return 1;
			}
		} catch (Exception e) {
			LOGGER.error(":::::Start : Exception MilitaryResetpassServiceImpl Handeler:::::" + e);
			e.printStackTrace();
		}
		LOGGER.info(":::::End : MilitaryResetpassServiceImpl ValidatefetchByEmail():::::");
		return 1;
	}

}
