package com.softra.bankingapp;
import com.exp.InsufficientFundsException;

public class SavingAccount extends Account implements CurrencyConvertor {
	private boolean IsSalaryAccount;
	private int minBalance = 100;
	private int INTERESTRATE = 4;
	public SavingAccount(int accountNumber, boolean isSalaryAccount, int minBalance) throws InsufficientFundsException {
		super(accountNumber);
		this.IsSalaryAccount = isSalaryAccount;
		this.minBalance = minBalance;
		this.accountType = "Saving Account";
		if(!IsSalaryAccount && minBalance<100) {
			InsufficientFundsException er = new InsufficientFundsException("Insufficient lance for account creation. Min. balance is $100");
			throw er;
		}
		this.balance = minBalance;
	}
	
	public double deposit(double amount) {
		this.balance += amount;
		return this.balance;
	}
	
	public double withdraw(double amount) throws InsufficientFundsException {
		if(!this.IsSalaryAccount && minBalance>this.balance) {
			InsufficientFundsException er = new InsufficientFundsException("No enough money to withdraw. Current balance is "+ this.balance +". And you required to have min. balance ($"+this.minBalance+")");
			throw er;
		}
		if(this.IsSalaryAccount && this.balance<0) {
			InsufficientFundsException er = new InsufficientFundsException("No enough money to withdraw. Current balance is "+ this.balance +".");
			throw er;
		}
		
		this.balance -= amount;
		return this.balance;
	}
	 
	public double calculateInterest(Account acct,boolean isSeniorCitizen) {
		double interst = this.balance *INTERESTRATE/100;
		return interst;
	}
	
	

	public boolean isIsSalaryAccount() {
		return IsSalaryAccount;
	}

	public void setIsSalaryAccount(boolean isSalaryAccount) {
		IsSalaryAccount = isSalaryAccount;
	}

	public int getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(int minBalance) {
		this.minBalance = minBalance;
	}

	public int getINTERESTRATE() {
		return INTERESTRATE;
	}

	public void setINTERESTRATE(int iNTERESTRATE) {
		INTERESTRATE = iNTERESTRATE;
	}

	@Override
	public double convertUSDToAUD(double USD) {
		if(this.IsSalaryAccount)
			return USD*USDTOAUDRATE*0.01;
		else
			return USD*USDTOAUDRATE*0.02;
	}

	@Override
	public double convertAUDToUSD(double AUD) {
		if(this.IsSalaryAccount)
			return AUD*AUDTOUSDRATE*0.01;
		else
			return AUD*AUDTOUSDRATE*0.02;
	}

	@Override
	public double convertUSDToSGD(double USD) {
		if(this.IsSalaryAccount)
			return USD*USDTOSGDRATE*0.01;
		else
			return USD*USDTOSGDRATE*0.02;
	}

	@Override
	public double convertSGDToUSD(double SGD) {
		if(this.IsSalaryAccount)
			return SGD*SGDTOUSDRATE*0.01;
		else
			return SGD*SGDTOUSDRATE*0.02;
	}

	@Override
	public String getAccountType() {
		
		return this.accountType;
	}
	

}
