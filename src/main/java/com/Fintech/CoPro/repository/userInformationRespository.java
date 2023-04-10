package com.Fintech.CoPro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Fintech.CoPro.domain.userInformation;
import com.Fintech.CoPro.domain.userAccounts;

public interface userInformationRespository extends JpaRepository <userInformation, Long> {
	userInformation findByNationalId(Long nationalId);
	//userInformation findByUserInfoNationalId(long nationalId);
}
