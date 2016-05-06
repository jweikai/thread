package com.thread2.bank;

public class Client {
	public static void main(String[] args) {
		Account account = new Account();
		account.setBalance(1000);
		
		Company company = new Company(account);
		Thread comThread = new Thread(company);
		
		Bank bank = new Bank(account);
		Thread bankThread = new Thread(bank);
		
		System.out.printf("Account: Inital Balance: %f\n", account.getBalance());
		comThread.start();
		bankThread.start();
		try {
			comThread.join();
			bankThread.join();
			System.out.printf("Account: Final Balance: %f\n", account.getBalance());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
