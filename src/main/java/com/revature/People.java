package com.revature;

public class People {

	int AdminId;
	int EmpId;
	int UserId;
	int AccountId;
	static String FirstName;
	static String LastName;
	static String eMail;
	static String UserName;
	static String PassWord;
	static String AccountType;
	static double Balance;

	public People(int userId, int accountId, String firstName, String lastName, String eMail,
			String userName, String passWord) {
		super();
		UserId = userId;
		AccountId = accountId;
		FirstName = firstName;
		LastName = lastName;
		this.eMail = eMail;
		UserName = userName;
		PassWord = passWord;
	}

	public People(int adminId, int empId, int userId, int accountId, String firstName, String lastName,
			String eMail, String userName, String passWord, String accountType, double balance) {
		super();
		AdminId = adminId;
		EmpId = empId;
		UserId = userId;
		AccountId = accountId;
		FirstName = firstName;
		LastName = lastName;
		this.eMail = eMail;
		UserName = userName;
		PassWord = passWord;
		AccountType = accountType;
		Balance = balance;
	}
	
	public People(String firstName, String lastName, String eMail, String userName, String passWord) {
		super();
		FirstName = firstName;
		LastName = lastName;
		this.eMail = eMail;
		UserName = userName;
		PassWord = passWord;
	}

	public int getAdminId() {
		return AdminId;
	}

	public void setAdminId(int adminId) {
		AdminId = adminId;
	}

	public int getEmpId() {
		return EmpId;
	}

	public void setEmpId(int empId) {
		EmpId = empId;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public int getAccountId() {
		return AccountId;
	}

	public void setAccountId(int accountId) {
		AccountId = accountId;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassWord() {
		return PassWord;
	}

	public void setPassWord(String passWord) {
		PassWord = passWord;
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
		return "People UserId=" + UserId + ", AccountId=" + AccountId + ", FirstName=" + FirstName + ", LastName=" + LastName 
				+ ", eMail=" + eMail + ", UserName=" + UserName + ", PassWord=" + PassWord + "]";
	}
}
