package com.Fintech.ColPro.AllBanks.Services_Banks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fintech.ColPro.AllBanks.DB_Banks.BankCIB_db;
import com.Fintech.ColPro.AllBanks.Repositories_Banks.BankCIB_Repository;
import com.Fintech.ColPro.domain.Message;
import com.Fintech.ColPro.domain.User;
import com.Fintech.ColPro.domain.UserAccounts;
import com.Fintech.ColPro.repository.MessageRepository;
import com.Fintech.ColPro.repository.UserAccountsrRepository;
import com.Fintech.ColPro.repository.UserRepository;

@Service
public class CIB_Service {
	@Autowired
	BankCIB_Repository CIB_Repo;
	@Autowired
	MessageRepository messageRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	UserAccountsrRepository userAccountsRepo;

	// UserAccounts userAccounts;
	public Message findNationalCardInfo(UserAccounts user) {
		try {
			BankCIB_db IdCardInfo;
			// System.out.println("user.getBankAccount() "+user.getBankAccount());
			// System.out.println("user.getBankAccount() "+user.getNationalId());
			// System.out.println("user.getBankAccount() "+user.getVisaNumber());

			IdCardInfo = CIB_Repo.findByBankAccount(user.getBankAccount());
			/// System.out.println("IdCardInfo "+IdCardInfo);
			if (IdCardInfo.getVisaNumber() == user.getVisaNumber()
					&& IdCardInfo.getNationalId() == user.getNationalId()) {

				BankCIB_db CardInfo;
				CardInfo = CIB_Repo.findByVisaNumber(user.getVisaNumber());
				/// System.out.println(CardInfo.getNumberTryingVisaPassword());
				if (CardInfo.getNumberTryingVisaPassword() >= 3) {
					//// System.out.println("111");

					return messageRepo.findByMessageNumber("13");// "this account is blocked contact with our services";

				}

				if (CardInfo.getVisaEnd() == user.getVisaEnd()) {
					if (CardInfo.getVisaPassword() != user.getVisaPassword()) {
						CardInfo.setNumberTryingVisaPassword(CardInfo.getNumberTryingVisaPassword() + 1);
////				        System.out.println("2222");
						CIB_Repo.save(CardInfo);
						return messageRepo.findByMessageNumber("14");// "try again to enter password";

					} else {
						CardInfo.setNumberTryingVisaPassword(0);
						CIB_Repo.save(CardInfo);
						user.setUser_id(userRepo.findByNationalId(user.getNationalId()).getId());
						userAccountsRepo.save(user);

						return messageRepo.findByMessageNumber("15");// "correct password ";
					}
				}

				return messageRepo.findByMessageNumber("16");// "invaild info about end of visa";
				// return messageRepo.findByMessageNumber("9");//"this card and national id is
				// vaild";
			} else {

				return messageRepo.findByMessageNumber("10"); // "invaild information";
			}
		} catch (Exception ex) {
			return messageRepo.findByMessageNumber("11");// "this BankAccount doesn't exist";
		}

	}

}
