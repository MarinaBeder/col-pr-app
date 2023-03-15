package com.Fintech.ColPro.AllBanks.DB_Banks;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BankCIB")
public class BankCIB_db {
	private static final long serialVersionUID = 7321374061017039662L;

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
	private int ccv = 0;
	private String username;

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

}
