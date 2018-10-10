package com.revature;

import java.beans.Statement;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.BankDao;
import com.revature.People;
import com.revature.Account;

public class App extends Method {

	public App(String firstName, String lastName, String eMail, String userName, String passWord, double balance) {
		super(firstName, lastName, eMail, userName, passWord, balance);

	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String input;
		String input2;
		String input3;
		int transaction = 0;

		// Declare Connection and Statement Objects
		Connection myConnection = null;
		Statement myStatement = null;
		
		BankDao bdao = new BankDao();

		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			myConnection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.56.105:1521:xe", "Bank", "drama555");

			// Creates a file named Transactions.txt so that the transactions can be recorded.
			String fileName = "Transactions.txt";
			try(FileWriter fw = new FileWriter(fileName)) {
	            
				App person = new App(FirstName, LastName, eMail, UserName, PassWord, Balance);

				System.out.println("Welcome to the Banking App!");
				System.out.println("Are you a: \n1) Customer \n2) Employee \n3) Admin");
				input = scan.next();

				if (input.equals("1")) {
					System.out.println("Hello Customer! \nWhat would you like to do?");
					System.out.println("1) Log In \n2) Create an account");
					input2 = scan.next();

					if (input2.equals("1")) {
						person.LogIn();

						do {
							System.out.println("What would you like to do?");
							System.out.println("1) Withdraw" + "\n" + "2) Deposit" + "\n" + "3) Transer funds");
							input3 = scan.next();

							// Withdraw method
							// take money out of current account
							if (input3.equals("1")) {
								person.Withdraw();
								transaction++;
								fw.write(transaction + ") " + UserName + " withdrew " + amount + "\n");
							}

							// Deposit method
							// add money to account
							if (input3.equals("2")) {
								person.Deposit();
								transaction++;
								fw.write(transaction + ") " + UserName + " deposited " + amount + "\n");
							}

							// Transfer method
							// take money from one account to another
							if (input3.equals("3")) {
								person.Transfer();
								transaction++;
								fw.write(transaction + ") " + UserName + " transfered " + amount
										+ " to another account\n");
							}

							// Apply for joint account
							person.JointAccount();

							System.out.println("Would you like to continue or exit?");
							System.out.println("1) Continue" + "\n" + "2)Exit");
							input3 = scan.next();
						} while (input3.equals("1"));
					}

					if (input2.equals("2")) {
						person.NewAccount();

						do {
							System.out.println("What would you like to do?");
							System.out.println("1) Withdraw" + "\n" + "2) Deposit" + "\n" + "3) Transer funds");
							input3 = scan.next();

							// Withdraw method
							// take money out of current account
							if (input3.equals("1")) {
								person.Withdraw();
								transaction++;
								fw.write(transaction + ") " + UserName + " withdrew " + amount + "\n");
							}

							// Deposit method
							// add money to account
							if (input3.equals("2")) {
								person.Deposit();
								transaction++;
								fw.write(transaction + ") " + UserName + " deposited " + amount + "\n");
							}

							// Transfer method
							// take money from one account to another
							if (input3.equals("3")) {
								person.Transfer();
								transaction++;
								fw.write(transaction + ") " + UserName + " transfered " + amount
										+ " to another account\n");
							}

							// Apply for joint account
							person.JointAccount();

							System.out.println("Would you like to continue or exit?");
							System.out.println("1) Continue" + "\n" + "2)Exit");
							input3 = scan.next();
						} while (input3.equals("1"));
					}
				}

				if (input.equals("2")) {
					person.LogIn();

					do {
						System.out.println("Hello Employee \nWhat would you like to do today?");
						System.out.println(
								"1) View all user accounts \n2) View all acount balances \n3) All personal information \n4) Approve/Deny Applications");
						input2 = scan.next();

						// View every account information
						if (input2.equals("1")) {
							List<People> people = bdao.ViewAll();
							for (People a : people) {
								System.out.println(a);
							}
						}

						// view account balances
						if (input2.equals("2")) {
							List<Account> account = bdao.GetAccount();
							for (Account a : account) {
								System.out.println(a);
							}
						}

						// view personal information
						if (input2.equals("3")) {
							List<People> people = bdao.GetPeople();
							for (People a : people) {
								System.out.println(a);
							}
						}

						// approve/deny open applications for accounts
						if (input2.equals("4")) {

						}

						System.out.println("Would you like to continue or exit?");
						System.out.println("1) Continue" + "\n" + "2)Exit");
						input2 = scan.next();
					} while (input2.equals("1"));
				}

				if (input.equals("3")) {
					person.LogIn();

					do {
						System.out.println("Hello. What would you like to do?");
						System.out.println("1) Withdraw \n2) Deposit \n3)Transfer \n4) Approve/Deny Accounts \n5)Cancel Accounts");
						input2 = scan.next();
						if (input2.equals("1")) {
							person.Withdraw();
							transaction++;
							fw.write(transaction + ") " + UserName + " withdrew " + amount + "\n");
						}

						if (input2.equals("2")) {
							person.Deposit();
							transaction++;
							fw.write(transaction + ") " + UserName + " deposited " + amount + "\n");
						}

						if (input2.equals("3")) {
							person.Transfer();
							transaction++;
							fw.write(transaction + ") " + UserName + " transfered " + amount
									+ " to another account\n");
						}

						if (input2.equals("4")) {

						}

						if (input2.equals("5")) {

						}

						System.out.println("Would you like to continue or exit?");
						System.out.println("1) Continue" + "\n" + "2)Exit");
						input2 = scan.next();
					} while (input2.equals("1"));

				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}

			System.out.println("Goodbye!");

		} catch (SQLException ex) {
			ex.getMessage();
		}
	}

}