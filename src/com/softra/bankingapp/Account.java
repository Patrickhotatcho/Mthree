package com.softra.bankingapp;

public abstract class Account {
	private int accountNumber;
	public double balance;
	private String dateOpened;
	
	public Account(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
	
	public Account(int accountNumber, double balance, String dateOpened) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.dateOpened = dateOpened;
	}
	protected abstract double calculateInterest(Account acct,boolean isSeniorCitizen);

	public double deposit() {
		return accountNumber;}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", dateOpened=" + dateOpened + "]";
	}



	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getDateOpened() {
		return dateOpened;
	}
	public void setDateOpened(String dateOpened) {
		this.dateOpened = dateOpened;
	}
	
	
	
}
