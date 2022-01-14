package com.softra.proxy;

import java.util.List;

import com.softra.bankingapp.*;

public interface IAccountService {
	void saveAccounts(List<Account> acct);
	void modifyAccounts(List<Account> acct);
	
}
