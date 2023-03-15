package com.Fintech.ColPro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Fintech.ColPro.domain.User;
import com.Fintech.ColPro.domain.UserAccounts;

public interface UserAccountsrRepository extends JpaRepository<UserAccounts, Long> {

}
