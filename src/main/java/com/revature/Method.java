package com.revature;

import java.util.List;
import java.util.Scanner;

import com.revature.People;
import com.revature.Account;
import com.revature.BankDao;

public class Method {
	
	static Scanner scan = new Scanner(System.in);
	static int UserId;
	static int AccountId;
	static String FirstName;
	static String LastName;
    static String UserName;
    static String PassWord;
    static String eMail;
    static double amount;
    static double Balance;
    static String AccountType;
    static String input;

    BankDao bdao = new BankDao();

    
    public Method(String firstName, String lastName,  String eMail, String userName, String passWord, double balance) {
    	FirstName = People.FirstName;
		LastName = People.LastName;
		UserName = People.UserName;
		PassWord = People.PassWord;
		this.eMail = People.eMail;
		Balance = Account.Balance;
	}

	public void LogIn(){
       
        //Prompt user to input UserName and PassWord
        System.out.print("UserName: ");
        UserName = scan.next();

        System.out.print("PassWord: ");
        PassWord = scan.next();
        
        //Connect to database
        bdao.LogIn();
    }

    public void NewAccount(){

        System.out.println("So you are a new user");

        //Prompt user to create account
        System.out.print("Enter your first name: ");
        FirstName = scan.next();
        
        System.out.print("Enter your last name: ");
        LastName = scan.next();
        
        System.out.print("Register an email address: ");
        eMail = scan.next();
        
        System.out.print("Create a UserName: ");
        UserName = scan.next();

        System.out.print("Create a PassWord: ");
        PassWord = scan.next();
        
        System.out.println("Which account are you opening today? \n1) Checking \n2) Saving");
        String input = scan.next();
        if(input.equals("1")) {
        	AccountType = "Checking";
        }
        if(input.equals("2")) {
        	AccountType = "Savings";
        	
        }
        
        UserId = 5;
        AccountId = 500;
        bdao.NewPeople();
        bdao.NewAccount();
        
        UserId = UserId++;
        AccountId = AccountId++;
    }
    
	 //Withdraw method return Balance
	public double Withdraw(){

        System.out.println("How much would you like to withdraw?");
        amount = scan.nextDouble();

        double NewBalance = Balance - amount;
        
        if(Balance < 0) {
        	System.out.println("Insufficent Funds");
        }
        else {
        	System.out.println("You withdrew $" + amount + ". Your new Balance is $" + NewBalance);
        	bdao.Withdraw();
        }
                
        bdao.Withdraw();
        
        return Balance;
    }

	//Deposit method return Balance
    public double Deposit(){

        System.out.println("How much would you like to deposit?");
        amount = scan.nextDouble();

        Balance = amount + Balance;

        System.out.println("You deposited $" + amount + ". Your new Balance is: $" + Balance);
        
        bdao.Deposite();
        
        return Balance;
    }
    
    //Transfer method 
    public double Transfer(){
        
        System.out.println("Which account would you like to transfer funds to?");
        //SELECT * FROM People INNER JOIN Account ON People.UserId = Account.UserId;
        System.out.println("1) Account2" + '\n' + "2) Account3");
        input = scan.next();
        
        System.out.println("How much are you transfering to your other account?");
        amount = scan.nextDouble();
        
        Balance = Balance - amount;
        
        //Changes the Balance in the 2nd account
        
        //double Balance2;
        //Balance2 = Balance2 + amount;
        //System.out.println("You transfered $" + amount + " from " + account1 + " to " + account2);
        
        return Balance;

    }

    //JointAccount method
    public void JointAccount(){


    }
    
    public void Cancel() {
    	//BankDao bdao = new BankDao();
    	List<People> people = bdao.ViewAll();
    	for(People a: people) {
    		System.out.println(a);
    	}
				
		System.out.println("Type the UserId of the account you want to close:");
		input = scan.next();
		
		bdao.DeletePeople();
		bdao.DeleteAccount();
		
		System.out.println("UserId " + input + " account has been closed.");
		
	}

    @Override
    public String toString() {
    	return "UserId = " + UserId + " AccountId =  " + AccountId + " FirstName = " + FirstName + " LastName = " + LastName +  " eMail =  " + eMail + " UserName = " + UserName + " PassWord =  " + PassWord + " Balance = " + Balance;
    }
}
