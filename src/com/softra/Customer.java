package com.softra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component(value="bs1")
public class Customer {
	
	@Value(value="Ho")
	private String lname;
	@Value(value="Patrick")
	private String fname;
	@Value(value="10001")
	private int ssn;
	private ApplicationContext ctx;
	@Autowired
	private Account acct;
	private List<FixedDeposit> fdList;
	

	public Customer() {}
	public Customer(String lname, String fname, int ssn, Account acct) {
		super();
		this.lname = lname;
		this.fname = fname;
		this.ssn = ssn;
		this.acct = acct;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	
	
	public Account getAcct() {
		return acct;
	}

	public void setAcct(Account acct) {
		this.acct = acct;
	}
	

	public ApplicationContext getCtx() {
		return ctx;
	}
	public void setCtx(ApplicationContext ctx) {
		this.ctx = ctx;
	}
	public List<FixedDeposit> getFdList() {
		return fdList;
	}
	public void setFdList(List<FixedDeposit> fdList) {
		this.fdList = fdList;
	}
	

	@Override
	public String toString() {
		return "Customer [lname=" + lname + ", fname=" + fname + ", ssn=" + ssn + ", ctx=" + ctx + ", acct=" + acct
				+ ", fdList=" + fdList + "]";
	}
	public void doStartUp() {
		System.out.println("doStartUp() and now employee now will not be manage	");
		this.acct = null;
		//this.acct = ctx.getBean("acct1",Account.class);
	}
	public void doCleanUp() {
		System.out.println("doCleanUp() and now employee now will not be manage	");
		this.acct = null;
	}
	
	
	
}
