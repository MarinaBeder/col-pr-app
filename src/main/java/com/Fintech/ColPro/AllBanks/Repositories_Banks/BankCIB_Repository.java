package com.Fintech.ColPro.AllBanks.Repositories_Banks;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Fintech.ColPro.AllBanks.DB_Banks.BankCIB_db;
import com.Fintech.ColPro.AllBanks.DB_Banks.BankQNB_db;
import com.Fintech.ColPro.domain.User;

public interface BankCIB_Repository extends JpaRepository<BankCIB_db, Long> {
	Optional<BankCIB_db> findByUsername(String username);

	BankCIB_db findByNationalId(long nationalId);

	BankCIB_db findByVisaNumber(long visaNumber);

	BankCIB_db findByBankAccount(long bankAccount);

}
