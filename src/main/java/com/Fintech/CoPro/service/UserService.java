package com.Fintech.CoPro.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Optional;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Fintech.CoPro.domain.userAccounts;
import com.Fintech.CoPro.domain.Message;
import com.Fintech.CoPro.domain.User;
import com.Fintech.CoPro.domain.userInformation;
import com.Fintech.CoPro.repository.userAccountsRepository;
import com.Fintech.CoPro.repository.userInformationRespository;
import com.Fintech.CoPro.repository.MessageRepository;
import com.Fintech.CoPro.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	UserRepository userRepo;
	@Autowired
	userAccountsRepository userAccountRepo;
	
	@Autowired
	MessageRepository messageRepo;
	@Autowired
	userInformationRespository userInfoRepo;

	public String findNationalVisaInfo(userAccounts user) {
		userAccounts IdVisaInfo;
    System.out.println("userA" + userAccountRepo.findByVisaNumber(user.getVisaNumber()));

		try {

			IdVisaInfo = userAccountRepo.findByUserInfoNationalId(user.getNationalId());
			/// User userNumberCardBank =
			/// userRepo.findByNumberCardBank(user.getNumberCardBank());
			System.out.println("IdCardInfo.getNumberCardBank()" + IdVisaInfo.getVisaEnd());
			System.out.println("user.getNumberCardBank()" + user.getVisaNumber());
			LocalDate today = LocalDate.now();
			LocalDate visaEnd = IdVisaInfo.getVisaEnd();
			if (IdVisaInfo.isAccountNonLocked()) {

				if (IdVisaInfo.getVisaNumber() == user.getVisaNumber()
				
						&&(IdVisaInfo.getVisaEnd().equals( user.getVisaEnd())
						&& (today.isAfter(visaEnd) || today.isEqual(visaEnd)))) {
							System.out.println("cccccccccccccccccccccccccccccccc");

				
				
					if (IdVisaInfo.getVisaPassword() == user.getVisaPassword()) {
						long RemainingOpportunities=3;

						IdVisaInfo.setRemainingOpportunities(RemainingOpportunities);
						userAccountRepo.save(IdVisaInfo);

						return "this card and national id is vaild";
					} 
					else {
						if(IdVisaInfo.getRemainingOpportunities()==0) {
							IdVisaInfo.setLocked(false);
							userAccountRepo.save(IdVisaInfo);

							return "please contach with bank your account is blocked";

						}
						long RemainingOpportunities=IdVisaInfo.getRemainingOpportunities() - 1;

						IdVisaInfo.setRemainingOpportunities(RemainingOpportunities);
						System.out.println("oooooooooooo"+RemainingOpportunities);

						System.out.println("ppppp"+RemainingOpportunities);

						String str = Long.toString(RemainingOpportunities);
						userAccountRepo.save(IdVisaInfo);
						return "your apportunties is "+str ;

					}
				} 
				
				
				
				else {
					return "this card is invaild22222";

				}
			}
			else {
				return "your account is blocked";

			}
			
		} catch (Exception ex) {
			return "this national Id doesn't existsssssssssssss";
		}

	}

	public Message vaildUsername(User user,long NationalId) {
		Optional<User> userFromApp = java.util.Optional.empty();
		userInformation userFromApp2=null;
		try {
			userFromApp = userRepo.findByUsername(user.getUsername());
			userFromApp2 = userInfoRepo.findByNationalId(NationalId);

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
		user.setUserInfo(userFromApp2);
		userRepo.save(user);
		return messageRepo.findByMessageNumber("7");
		// vaild username and pasword
	}
	public Message Password(User user,Long NationalId) {
		User userFromApp = null;
		try {
			userFromApp = userRepo.findByUserInfoNationalId(NationalId);
		String encodePassword = passwordEncoder.encode(user.getPassword());
		userFromApp.setPassword(encodePassword);
		userRepo.save(userFromApp);
		return messageRepo.findByMessageNumber("7");}
		catch (Exception ex) {
			return messageRepo.findByMessageNumber("5");
			// invaild username from catch

		}
		
		
	}

	public userAccounts SignUpUser(userAccounts user) {
		userInformation userinfo=userInfoRepo.findByNationalId(user.getNationalId());
		user.setUserInfo(userinfo);
		userAccountRepo.save(user);
		return null;
	}
	
	
}
