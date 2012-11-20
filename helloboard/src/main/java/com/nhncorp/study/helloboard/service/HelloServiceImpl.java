package com.nhncorp.study.helloboard.service;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl {

	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		System.out.println("Hello Spring!");
	}

}
