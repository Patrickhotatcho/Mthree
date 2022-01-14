package com.softra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="acct")
public class Account {
	
	@Value(value="1")
	private int acctNo;
	@Value(value="0")
	private int balance;
	
	public Account() {}
	public Account(int acctNo, int balance) {
		super();
		this.acctNo = acctNo;
		this.balance = balance;
	}
	public int getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(int acctNo) {
		this.acctNo = acctNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [acctNo=" + acctNo + ", balance=" + balance + "]";
	}
	
	
	
}
