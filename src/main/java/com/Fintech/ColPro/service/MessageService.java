package com.Fintech.ColPro.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.Fintech.ColPro.domain.Message;
import com.Fintech.ColPro.repository.MessageRepository;

@Service
public class MessageService {
	@Autowired
	MessageRepository messageRepo;

	public String GetMessageContent(String MessageNumber) {
		Message message = messageRepo.findByMessageNumber(MessageNumber);
		return message.getMessageContent();
	}
}
