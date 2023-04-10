package com.Fintech.CoPro.util;

import org.springframework.context.annotation.Bean;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomPasswordEncoder {
private PasswordEncoder passwordEncoder;
	
 public CustomPasswordEncoder() {
		this.passwordEncoder=new BCryptPasswordEncoder();
		
	}
 @Bean
	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}
	//password encoder is bean in configuration class so it is accessible
//@Bean
//public PasswordEncoder getPasswordEncoder()
	
}
