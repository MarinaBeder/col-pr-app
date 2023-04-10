package com.Fintech.CoPro.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Fintech.CoPro.domain.Message;
import com.Fintech.CoPro.domain.User;

public interface MessageRepository extends JpaRepository <Message, Long> {
	Message findByMessageNumber(String message_number);
}
