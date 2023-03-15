package com.Fintech.ColPro.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Fintech.ColPro.domain.User;
import com.Fintech.ColPro.dto.AuthCredentialsRequest;
import com.Fintech.ColPro.service.MessageService;
import com.Fintech.ColPro.service.UserService;
import com.Fintech.ColPro.util.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;

@RestController
@RequestMapping("api/auth")
@CrossOrigin

public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManagerr;
	@Autowired
	private JwtUtil jwtUtili;
	@Autowired
	UserService userService;

	/*
	 * public AuthController(AuthenticationManager authenticationManager,JwtUtil
	 * jwtUtil) { this.authenticationManager = authenticationManager; this.jwtUtil =
	 * jwtUtil; }
	 */
	// @CrossOrigin
	@CrossOrigin
	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody AuthCredentialsRequest request) {
		try {
			Authentication authenticate = authenticationManagerr.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

			User user = (User) authenticate.getPrincipal();
			user.setPassword(null);// to donot show password in postman for security
			return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, jwtUtili.generateToken(user))// .build();
					.body(user);
		} catch (BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	@GetMapping("/validate")
	public ResponseEntity<?> validateToken1(@RequestParam String token, @AuthenticationPrincipal User user)
			throws ExpiredJwtException {

		try {
			Boolean isTokenValid = jwtUtili.vaildateToken(token, user);
			return ResponseEntity.ok(isTokenValid);
		}

		catch (ExpiredJwtException ex) {
			return ResponseEntity.ok(false);
		}

	}

	// @CrossOrigin
	@GetMapping("view")
	public String hh() {
		return "api/auth";

	}
}
