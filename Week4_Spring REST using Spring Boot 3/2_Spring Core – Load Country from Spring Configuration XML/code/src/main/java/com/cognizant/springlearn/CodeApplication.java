package com.cognizant.springlearn;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class CodeApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(CodeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CodeApplication.class, args);
	}

	@PostConstruct
	public void displayCountries() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		CountryList countryList = context.getBean("countryList", CountryList.class);
		for (Country country : countryList.getCountryList()) {
			LOGGER.debug("Country : {}", country);
		}
	}
}
