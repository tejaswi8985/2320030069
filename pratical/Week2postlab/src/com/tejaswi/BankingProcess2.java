package com.tejaswi;

public class BankingProcess2 {
	
		private UserLoginManager2 loginManager;
		public BankingProcess2()
		{
		loginManager = UserLoginManager2.getInstance();
		}
		public void viewBalance() {
		if(loginManager.isLoggedIn()) {
		
		System.out.println("Balance: $1000");
		}
		else {
		System.out.println("Please log in to view your Balance");
		}
		}
		public void deposit(double amount) {
		if(loginManager.isLoggedIn()) {

		System.out.println("$"+amount+"deposit successfully");
		}
		else {
		System.out.println("Please log in to make a deposit.");
		}
		}
		public void withdraw(double amount) {
		if(loginManager.isLoggedIn()) {
	
		System.out.println("$"+amount+"withdraw successfully");
		}
		else {
		System.out.println("Please log in to make a withdraw");
		}
		}


}
