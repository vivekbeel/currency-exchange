package com.learn.microservice.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learn.microservice.currencyexchangeservice.bean.CurrencyExchange;
import com.learn.microservice.currencyexchangeservice.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	CurrencyExchangeRepository currencyExchangeRepository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retriveCurrencyExchange(@PathVariable String from,@PathVariable String to) {
		 //CurrencyExchange currencyExchange= new CurrencyExchange(1, from, to, BigDecimal.valueOf(75));
		CurrencyExchange currencyExchange= currencyExchangeRepository.findByFromAndTo(from, to);
		if(currencyExchange==null)
			throw new RuntimeException("unable to find data for "+from +" to "+to);
		String port=environment.getProperty("local.server.port");
		 currencyExchange.setEnvironment(port);
		return currencyExchange;
	}
}
