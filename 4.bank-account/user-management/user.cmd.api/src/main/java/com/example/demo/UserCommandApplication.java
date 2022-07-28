package com.example.demo;

import com.example.demo.configuration.AxonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication
@Import({AxonConfig.class})
public class UserCommandApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCommandApplication.class, args);
	}

}
