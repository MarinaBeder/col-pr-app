package com.Fintech.CoPro.controller;

import java.io.UnsupportedEncodingException;



import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Fintech.CoPro.domain.userAccounts;
import com.Fintech.CoPro.domain.Message;
import com.Fintech.CoPro.domain.User;
import com.Fintech.CoPro.service.UserService;
import com.Fintech.CoPro.util.Utility;

@RestController
@RequestMapping("Co-Pro/SignUp")
public class SignUpController {
	@Autowired
	private UserService userService;
	
	
	
	
	//this for user register for the first page {national id and card number}
	@PostMapping("/IdVisaInfo")
	public ResponseEntity<?> registerNationalVisaNumber(@RequestBody userAccounts user)
	{
		      String message = userService.findNationalVisaInfo(user);
				return ResponseEntity.ok(message);
	}
	
	//this for user register for the first page {End Visa and Card Password}
    @PostMapping("/username/{NationalId}")
    public ResponseEntity<?> registeruserName(@RequestBody User user,
    		@PathVariable Long NationalId)
	  {
		  Message message = userService.vaildUsername(user,NationalId);
			return ResponseEntity.ok(message);
	   }
	//this for user register for the first page {username and Password}

	@PutMapping("/password/{NationalId}")

	public ResponseEntity<?> registerPassword(@RequestBody User user,
			@PathVariable Long NationalId)
	   {
		  Message message = userService.Password(user,NationalId);
			return ResponseEntity.ok(message);
		}
	
	//this for save all info of user

	@PostMapping("/SaveInfoUser")

	public ResponseEntity<?> registerInfoUser(@RequestBody userAccounts user)
	{
		  userAccounts message = userService.SignUpUser(user);
				  
			return ResponseEntity.ok( user);
	}

	
			


}
