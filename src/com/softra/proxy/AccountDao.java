package com.softra.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.softra.bankingapp.Account;
import com.softra.bankingapp.FixedDeposit;
import com.softra.bankingapp.SavingAccount;

@Component(value="acctdao")
public class AccountDao implements IAccount {

	@Autowired
	private JdbcTemplate template;
	@Override
	public void saveAccount(SavingAccount acct) {
		// TODO Auto-generated method stub
		String insert = "INSERT INTO savingaccount VALUES(?,?,?)";
		template.update(insert,acct.getAccountNumber(),acct.getMinBalance(),acct.isIsSalaryAccount());
	}
	@Override
	public void saveAccount(FixedDeposit acct) {
		// TODO Auto-generated method stub
		String insert = "INSERT INTO fixeddeposit VALUES(?,?,?)";
		template.update(insert,acct.getAccountNumber(),acct.getDepositAmount(),acct.getTenure());
	}
	@Override
	public void saveAccount(Account acct) {
		// TODO Auto-generated method stub
		String insert = "INSERT INTO account VALUES(?,?,?)";
		template.update(insert,acct.getAccountNumber(),acct.getAccountType(),acct.balance);
	}

	@Override
	public void modifyAccount(Account acct) {
		
	}
	@Override
	public void modifyAccount(SavingAccount acct) {
		
	}
	@Override
	public void modifyAccount(FixedDeposit acct) {
		
	}


}
