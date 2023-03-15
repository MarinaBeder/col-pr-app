package com.Fintech.ColPro.domain;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UserAccounts")
public class UserAccounts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String bankName;
	private long nationalId = 1;
	private long visaNumber = 1;

	private long visaEnd = 0;
	private long visaPassword = 1;
	private long numberTryingVisaPassword = 0;

	private long bankAccount = 1;
	private long user_id = 0;
	private int ccv = 0;
	private String username;

	// @ManyToOne(cascade =CascadeType.ALL )
	// @JoinColumn(name ="user_id" ,referencedColumnName = "id")
	// private User user;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public long getNationalId() {
		return nationalId;
	}

	public void setNationalId(long nationalId) {
		this.nationalId = nationalId;
	}

	public long getVisaNumber() {
		return visaNumber;
	}

	public void setVisaNumber(long visaNumber) {
		this.visaNumber = visaNumber;
	}

	public long getVisaEnd() {
		return visaEnd;
	}

	public void setVisaEnd(long visaEnd) {
		this.visaEnd = visaEnd;
	}

	public long getVisaPassword() {
		return visaPassword;
	}

	public void setVisaPassword(long visaPassword) {
		this.visaPassword = visaPassword;
	}

	public long getNumberTryingVisaPassword() {
		return numberTryingVisaPassword;
	}

	public void setNumberTryingVisaPassword(long numberTryingVisaPassword) {
		this.numberTryingVisaPassword = numberTryingVisaPassword;
	}

	public long getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(long bankAccount) {
		this.bankAccount = bankAccount;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public int getCcv() {
		return ccv;
	}

	public void setCcv(int ccv) {
		this.ccv = ccv;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/*
	 * public User getUser() { return user; }
	 * 
	 * public void setUser(User user) { this.user = user; }
	 */

}
