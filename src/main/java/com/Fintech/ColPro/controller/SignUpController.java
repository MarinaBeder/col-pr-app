package com.Fintech.ColPro.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Fintech.ColPro.AllBanks.Services_Banks.CIB_Service;
import com.Fintech.ColPro.AllBanks.Services_Banks.QNB_Service;
import com.Fintech.ColPro.domain.Message;
import com.Fintech.ColPro.domain.User;
import com.Fintech.ColPro.service.UserService;

@RestController
@RequestMapping("api/signUp")
@CrossOrigin
public class SignUpController {
	@Autowired
	private UserService userService;

	// save all info of user
	@CrossOrigin
	@PostMapping("/saveUser")

	public ResponseEntity<?> registerUser(@RequestBody User user) {
		Message message = userService.saveUser(user);
		return ResponseEntity.ok(message);
	}

}
