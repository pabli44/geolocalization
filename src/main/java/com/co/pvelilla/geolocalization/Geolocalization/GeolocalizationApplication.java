package com.co.pvelilla.geolocalization.Geolocalization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class GeolocalizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeolocalizationApplication.class, args);
	}

}

