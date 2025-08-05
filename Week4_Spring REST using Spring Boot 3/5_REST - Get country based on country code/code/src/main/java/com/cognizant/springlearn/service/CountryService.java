package com.cognizant.springlearn.service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.CountryList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {

    public Country getCountry(String code) {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        CountryList countryList = context.getBean("countryList", CountryList.class);

        Optional<Country> countryOpt = countryList.getCountryList().stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst();

        return countryOpt.orElse(null);
    }
}
