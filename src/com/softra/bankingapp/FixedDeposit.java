package com.softra.bankingapp;
import com.exp.InsufficientFundsException;

public class FixedDeposit extends Account{
	private double depositAmount;
	private int tenure;
	private double interestEarned;
	

	public FixedDeposit(int accountNumber, double depositAmount, int tenure) throws InsufficientFundsException {
		super(accountNumber);
		this.depositAmount = depositAmount;
		this.tenure = tenure;
		this.balance = depositAmount;
		this.accountType = "Fixed Deposit";
		if(depositAmount<50) {
			InsufficientFundsException er = new InsufficientFundsException("Insufficient Balance for account creation. Min. balance is $50");
			throw(er);
		}
		if(tenure<1 || tenure>5) {
			InsufficientFundsException er = new InsufficientFundsException("Tenure must between 1 year to 5 years");
			throw(er);
		}
	}



	public double getDepositAmount() {
		return depositAmount;
	}



	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}



	public int getTenure() {
		return tenure;
	}



	public void setTenure(int tenure) {
		this.tenure = tenure;
	}



	public double getInterestEarned() {
		return interestEarned;
	}



	public void setInterestEarned(double interestEarned) {
		this.interestEarned = interestEarned;
	}



	@Override
	public double calculateInterest(Account acct,boolean isSeniorCitizen) {
		double interestRate = 0;
		switch(tenure) {
			case 1:
			case 2:
			{
				if(isSeniorCitizen)
					interestRate = 4;
				else
					interestRate = 4.5;
				break;
			}
			case 3:
			case 4:
			{
				if(isSeniorCitizen)
					interestRate = 5;
				else
					interestRate = 5.5;
				break;
			}
			case 5:
			{
				if(isSeniorCitizen)
					interestRate = 6;
				else
					interestRate = 6.5;
				break;
			}
		}
		return balance*interestRate/100;
			
		
	}



	@Override
	public String getAccountType() {
		
		return this.accountType;
	}



}
