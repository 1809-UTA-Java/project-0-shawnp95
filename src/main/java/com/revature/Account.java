package com.revature;

public class Account {

	static int AccountId;
	static int UserId;
	static String AccountType;
	static double Balance;

	public Account(int accountId, int userId, String accountType, double balance) {
		super();
		AccountId = accountId;
		UserId = userId;
		AccountType = accountType;
		Balance = balance;
	}

	public int getAccountId() {
		return AccountId;
	}

	public void setAccountId(int accountId) {
		AccountId = accountId;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getAccountType() {
		return AccountType;
	}

	public void setAccountType(String accountType) {
		AccountType = accountType;
	}

	public double getBalance() {
		return Balance;
	}

	public void setBalance(double balance) {
		Balance = balance;
	}

	@Override
	public String toString() {
		return "Account [AccountId=" + AccountId + ", UserId=" + UserId + ", AccountType=" + AccountType + ", Balance="
				+ Balance + "]";
	}
}
