package com.Fintech.ColPro.AllBanks.Repositories_Banks;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Fintech.ColPro.AllBanks.DB_Banks.BankQNB_db;
import com.Fintech.ColPro.domain.User;

public interface BankQNB_Repository extends JpaRepository<BankQNB_db, Long> {
	Optional<BankQNB_db> findByUsername(String username);

	BankQNB_db findByNationalId(long nationalId);

	BankQNB_db findByVisaNumber(long visaNumber);

	BankQNB_db findByBankAccount(long bankAccount);
}
