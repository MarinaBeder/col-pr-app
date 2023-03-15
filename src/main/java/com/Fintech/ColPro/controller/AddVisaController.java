package com.Fintech.ColPro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Fintech.ColPro.AllBanks.Services_Banks.CIB_Service;
import com.Fintech.ColPro.AllBanks.Services_Banks.QNB_Service;
import com.Fintech.ColPro.domain.Message;
import com.Fintech.ColPro.domain.User;
import com.Fintech.ColPro.domain.UserAccounts;
import com.Fintech.ColPro.repository.UserRepository;
import com.Fintech.ColPro.service.UserService;

@RestController
@RequestMapping("addVisa")
public class AddVisaController {
	@Autowired
	private UserService userService;
	@Autowired
	CIB_Service CIB_Service;
	@Autowired
	QNB_Service QNB_Service;

	@PostMapping("")
	public ResponseEntity<?> registerNationalCardNumber(@RequestBody UserAccounts userAccounts) {
		Message message = null;
		String BankName = userAccounts.getBankName();
		switch (BankName) {
		case "Bank CIB":
			message = CIB_Service.findNationalCardInfo(userAccounts);
			break;

		case "Bank QNB":
			message = QNB_Service.findNationalCardInfo(userAccounts);
			break;

		}
		return ResponseEntity.ok(message);

	}

}
