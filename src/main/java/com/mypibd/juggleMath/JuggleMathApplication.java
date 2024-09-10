package com.mypibd.juggleMath;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public abstract class JuggleMathApplication {

	public static void main(String[] args) {
		SpringApplication.run(JuggleMathApplication.class, args);
	}

}
