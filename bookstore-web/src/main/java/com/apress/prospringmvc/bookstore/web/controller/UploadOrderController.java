package com.apress.prospringmvc.bookstore.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apress.prospringmvc.bookstore.web.UploadOrderForm;

@Controller
public class UploadOrderController {

	private Logger logger = LoggerFactory
			.getLogger(UploadOrderController.class);

	@RequestMapping(value = "/order/upload", method = { RequestMethod.POST })
	public String handleUpload(UploadOrderForm form) {

		logFile(form.getOrder().getOriginalFilename(), form.getOrder()
				.getSize());

		return "redirect:/customer/account";
	}

	private void logFile(String name, long size) {
		this.logger.info("Received order: {}, size {}", name, size);
	}
}
