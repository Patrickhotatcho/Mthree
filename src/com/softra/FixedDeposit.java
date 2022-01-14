package com.softra;

public class FixedDeposit {
	private int acctNo;
	private int amount;
	private String maturityDate;
	public int getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(int acctNo) {
		this.acctNo = acctNo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}
	@Override
	public String toString() {
		return "FixedDeposit [acctNo=" + acctNo + ", amount=" + amount + ", maturityDate=" + maturityDate + "]";
	}
	
}
