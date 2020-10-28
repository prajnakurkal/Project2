package bank;

import java.text.DecimalFormat;

/**
 * This class is a represtation of a client's basic bank account
 * @author Prajna Kurkal, Sarah Law, Zill Soni
 */

public abstract class Account {
	private Profile holder;
	private double balance;
	private Date dateOpen;
	
	/**
	 * constructor for the class, represents the opening of a account
	 * @param holder the profile of the person opening an account
	 * @param balance their starting balance
	 * @param dateOpen the date they open said account
	 */
	public Account(Profile holder, double balance, Date dateOpen) {
		this.holder = holder;
		this.balance = balance;
		this.dateOpen = dateOpen;
	}
	/**
	 * accessor method for the person who opened account
	 * @return holder value
	 */
	public Profile getProfile() {
		return holder;
	}
	/**
	 * accessor method for balance of account
	 * @return balance value
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * accessor method for the date the account was opened
	 * @return dateOpen value
	 */
	public Date getDate() {
		return dateOpen;
	}
	/**
	 * decrements the balance by a certain amount
	 * @param amount needed to decrement
	 */
	public void debit(double amount) { //decrease the balance by amount 
		balance -= amount;
	} 
	/**
	 * increase balance by certain amount
	 * @param amount needed to increment
	 */
	public void credit(double amount) {//increase the balance by amount
		balance += amount;
	} 
	/**
	 * @Override
	 * returns the string representation of the account
	 * @return string of holder, balance, and date
	 */
	public String toString() { 
		DecimalFormat df = new DecimalFormat("0.00");
		return "*" + holder + "* $" + df.format(balance) + "*" + dateOpen + "*";
	}
	/**
	 * @Override
	 * checks to see if the data fields of two Account objects are equal
	 * @return true if they are equal, false otherwise
	 */
	public boolean equals(Object obj) {
		if(obj instanceof Account) {
		Account acc = (Account) obj;
		if(this.holder.equals(acc.holder) && this.balance == acc.balance && this.dateOpen.equals(acc.dateOpen))
			return true;
		else
			return false;
		}
		return false;
	}
	/**
	 * abstract method that determines monthly interest for a specific type of account
	 * @return the decimal interest value
	 */
	public abstract double monthlyInterest();
	/**
	 * abstract method that determines monthly fee for a specific type of account
	 * @return decimal monthly fee value
	 */
	public abstract double monthlyFee();
	
	/**
	 * calculates new balance for each of the accounts after the fees and stuff
	 * @return new balance value
	 */
	public abstract double getNewBalance();
}
