package com.lparce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lparce.model.Product;
import com.lparce.service.RestDroolsService;

import java.math.BigDecimal;
import java.util.Date;

@RestController
public class RestDroolsController {
	private static final Logger log = LoggerFactory.getLogger(RestDroolsController.class);
	private final RestDroolsService restDroolsService;

	@Autowired
	public RestDroolsController(RestDroolsService restDroolsService) {
		this.restDroolsService = restDroolsService;
	}

	@RequestMapping(value = "/getDiscount", method = RequestMethod.GET, produces = "application/json")
	public Product getQuestions(@RequestParam(required = true) String type) {

		Product product = new Product();
		product.setType(type);
		product.setAmount(new BigDecimal(12.2));
		product.setDate(new Date());
		log.debug("product {} ",product);
		restDroolsService.getProductDiscount(product);
		log.debug("product {} ",product);
		return product;
	}

	@RequestMapping(value = "/getDiscounta", method = RequestMethod.GET, produces = "application/json")
	public Product getQuestionsA(@RequestParam(required = true) String type) {

		Product product = new Product();
		product.setType(type);
		product.setAmount(new BigDecimal(16.2));
		log.debug("product {} ",product);
		restDroolsService.getProductDiscountA(product);
		log.debug("product {} ",product);
		return product;
	}

}
