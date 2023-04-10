package com.Fintech.CoPro.service;

import java.util.Optional;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Fintech.CoPro.domain.User;
import com.Fintech.CoPro.repository.UserRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	//@Autowired
	//private CustomPasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepo;
	 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User>userOpt=userRepo.findByUsername(username);
		
		return userOpt.orElseThrow(()->new UsernameNotFoundException("Invaild credntials"));
	}

}
