package com.softra.proxy;

import com.softra.bankingapp.Account;
import com.softra.bankingapp.FixedDeposit;
import com.softra.bankingapp.SavingAccount;

public interface IAccount {

	void saveAccount(SavingAccount acct);
	void saveAccount(FixedDeposit acct);
	void saveAccount(Account acct);
	void modifyAccount(Account acct);
	void modifyAccount(SavingAccount acct);
	void modifyAccount(FixedDeposit acct);
}
