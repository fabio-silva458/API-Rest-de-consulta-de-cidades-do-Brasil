package com.rudsong.citiesapi.countries.repository;

import com.rudsong.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Countryrepository extends JpaRepository<Country, Long> {

}
