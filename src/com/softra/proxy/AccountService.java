package com.softra.proxy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.softra.bankingapp.Account;
import com.softra.bankingapp.Customer;
import com.softra.bankingapp.FixedDeposit;
import com.softra.bankingapp.SavingAccount;

@Component(value="Aservice")
public class AccountService implements IAccountService {

	@Autowired
	private AccountDao acctdao;
	@Override
	public void saveAccounts(List<Account> accts) {
		System.out.println("Inside Service layer "+this.acctdao);//Logging statement
		for(Account acct:accts) {
			acctdao.saveAccount(acct);
			if(acct instanceof SavingAccount) {
				acctdao.saveAccount((SavingAccount)acct);
			}
			else if(acct instanceof FixedDeposit) {
				acctdao.saveAccount((FixedDeposit)acct);
			}
		}
		
	}


	@Override
	public void modifyAccounts(List<Account> acct) {
		// TODO Auto-generated method stub
		
	}


}
