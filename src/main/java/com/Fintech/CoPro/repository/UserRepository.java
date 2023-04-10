package com.Fintech.CoPro.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Fintech.CoPro.domain.User;
import com.Fintech.CoPro.domain.userAccounts;
@Repository

public interface UserRepository extends JpaRepository <User, Long> {

	Optional<User>findByUsername(String username);
   //User findByUserAccountNationalId(long nationalId);

	//User findByUserAccountNationalId(long nationalId);
	User findByUserInfoNationalId(Long nationalId);



}
