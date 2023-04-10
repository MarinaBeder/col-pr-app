package com.Fintech.CoPro.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.Fintech.CoPro.domain.Message;
import com.Fintech.CoPro.repository.MessageRepository;
@Service
public class MessageService {
	@Autowired
	MessageRepository messageRepo;
	public String GetMessageContent(String MessageNumber) {
		Message message =messageRepo.findByMessageNumber(MessageNumber);
	 return message.getMessageContent();
	}
}
