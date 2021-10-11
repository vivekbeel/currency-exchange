package com.learn.microservice.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.microservice.currencyexchangeservice.bean.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>{
	
	//@Query(value="select e from CurrencyExchange e where e.from=:from and e.to=:to")
	CurrencyExchange findByFromAndTo(String from,String to);

}
