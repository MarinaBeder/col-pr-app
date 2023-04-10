package com.Fintech.CoPro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Fintech.CoPro.domain.userAccounts;
import com.Fintech.CoPro.domain.User;

public interface userAccountsRepository extends JpaRepository <userAccounts, Long> {

	//userAccounts findByNationalId(long nationalId);
	userAccounts findByVisaNumber(long visaNumber);
	//userAccounts findByUserInfoNationalId(long nationalId);
	//userAccounts findByUserInfoNationalId(long nationalId);
	userAccounts findByUserInfoNationalId(Long nationalId);


}
