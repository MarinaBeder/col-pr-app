package com.Fintech.ColPro.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Fintech.ColPro.AllBanks.DB_Banks.BankQNB_db;
import com.Fintech.ColPro.AllBanks.Repositories_Banks.BankCIB_Repository;
import com.Fintech.ColPro.AllBanks.Repositories_Banks.BankQNB_Repository;
import com.Fintech.ColPro.domain.Message;
import com.Fintech.ColPro.domain.User;
import com.Fintech.ColPro.repository.MessageRepository;
import com.Fintech.ColPro.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	UserRepository userRepo;
	@Autowired
	MessageRepository messageRepo;
	@Autowired
	BankCIB_Repository bankCIBRepo;
	@Autowired
	BankQNB_Repository bankQNBRepo;

	public Message saveUser(User user) {
		Optional<User> userFromApp = java.util.Optional.empty();

		try {
			userFromApp = userRepo.findByUsername(user.getUsername());
			/// User userNumberCardBank =
			/// userRepo.findByNumberCardBank(user.getNumberCardBank());
		} catch (Exception ex) {
			return messageRepo.findByMessageNumber("5");
			// invaild username from catch

		}
		if (userFromApp.isPresent()) {
			return messageRepo.findByMessageNumber("6");
			// invaild username
		}
		String encodePassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodePassword);
		userRepo.save(user);
		return messageRepo.findByMessageNumber("7");
		// vaild username and pasword
	}

	public User SignUpUser(User user) {

		String encodePassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodePassword);
		userRepo.save(user);
		return user;

	}

}
