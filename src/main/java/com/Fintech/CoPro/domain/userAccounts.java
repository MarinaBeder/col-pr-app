package com.Fintech.CoPro.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.time.LocalDate;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="userAccounts")
public class userAccounts  implements UserDetails {
	private static final long serialVersionUID = 7321374061017039662L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private long nationalId ;
	private long visaNumber ;
	private LocalDate visaEnd ;
	private long visaPassword = 1;
	private long remainingOpportunities;

	private boolean locked=true;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(referencedColumnName = "nationalId")
	private userInformation userInfo;
	
	public userInformation getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(userInformation userInfo) {
		this.userInfo = userInfo;
	}

	public long getNationalId() {
		return nationalId;
	}

	public void setNationalId(long nationalId) {
		this.nationalId = nationalId;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * public String getEmail() { return email; } public void setEmail(String email)
	 * { this.email = email; }
	 */
	

	

	public long getVisaNumber() {
		return visaNumber;
	}

	public void setVisaNumber(long visaNumber) {
		this.visaNumber = visaNumber;
	}

	

	public void setVisaEnd(LocalDate visaEnd) {
		this.visaEnd = visaEnd;
	}

	

	public LocalDate getVisaEnd() {
		return visaEnd;
	}

	public long getVisaPassword() {
		return visaPassword;
	}

	public void setVisaPassword(long visaPassword) {
		this.visaPassword = visaPassword;
	}

	public long getRemainingOpportunities() {
		return remainingOpportunities;
	}

	public void setRemainingOpportunities(long remainingOpportunities) {
		this.remainingOpportunities = remainingOpportunities;
	}
	



	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return isLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}



	



	

}
