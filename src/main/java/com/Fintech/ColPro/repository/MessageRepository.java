package com.Fintech.ColPro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Fintech.ColPro.domain.Message;
import com.Fintech.ColPro.domain.User;

public interface MessageRepository extends JpaRepository<Message, Long> {
	Message findByMessageNumber(String message_number);
}
