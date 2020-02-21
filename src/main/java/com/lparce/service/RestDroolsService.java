package com.lparce.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lparce.model.Product;

@Service
public class RestDroolsService {

	private final KieContainer kieContainer;

	@Autowired
	public RestDroolsService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	public Product getProductDiscount(Product product) {
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(product);
		kieSession.fireAllRules();
		kieSession.dispose();
		return product;
	}

	public Product getProductDiscountA(Product product) {
		KieSession kieSession = kieContainer.newKieSession("rulesaSession");
		kieSession.insert(product);
		kieSession.fireAllRules();
		kieSession.dispose();
		return product;
	}
}