package com.Fintech.ColPro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Fintech.ColPro.domain.User;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

	User findByNationalId(long nationalId);
	// User findByVisaNumber(String visaNumber);

}
