package com.meditail.api.controllers;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.meditail.api.dtos.EmailDto;
import com.meditail.api.services.EmailService;

@RestController
public class EmailController {

	private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

	@Autowired
	EmailService emailService;

	@PostMapping(value = "/send-email")
	public EmailDto emailHtmlTemplate(@RequestBody EmailDto email) throws IOException, MessagingException {
		emailService.sendEmail(email);
		return email;
	}

	@PostMapping(value = "/send-text-email")
	public EmailDto emailTextTemplate(@RequestBody EmailDto email) throws IOException, MessagingException {
		emailService.sendTextTemplateEmail(email);
		return email;
	}

	@PostMapping(value = "/send-html-email")
	public EmailDto emailInHtmlTemplate(@RequestBody EmailDto email) throws IOException, MessagingException {
		logger.info("send-html-email ");
		emailService.sendHtmlEmail(email);
		return email;
	}

	@PostMapping(value = "/send-emails")
	public Iterable<EmailDto> emailHtmlTemplate(@RequestBody List<EmailDto> emails)
			throws IOException, MessagingException {
		emailService.sendEmails(emails);
		return emails;
	}
}
