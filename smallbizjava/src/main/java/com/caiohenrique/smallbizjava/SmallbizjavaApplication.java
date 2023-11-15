package com.caiohenrique.smallbizjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.caiohenrique.smallbizjava.domain.enums.Priority;
import com.caiohenrique.smallbizjava.domain.enums.Profile;

@SpringBootApplication
public class SmallbizjavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmallbizjavaApplication.class, args);
		
		Profile profile = Profile.toEnum(2);
		System.out.println(profile.getDescription());
		
		Priority priority = Priority.toEnum(2);
		System.out.println(priority.getDescription());
		
		
	}

}
