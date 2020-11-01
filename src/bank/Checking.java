package bank;

/**
 * this class represents a checking acc
 * @author Prajna Kurkal, Sarah Law, Zill Soni
 */
public class Checking extends Account {
	
	private boolean directDep;
    /**
     * constructor to instantiate a checking acc
     * @param holder
     * @param balance
     * @param dateOpen
     * @param directDep
     */
    public Checking(Profile holder, double balance, Date dateOpen, boolean directDep) {
	    super(holder, balance, dateOpen); 
	    this.directDep = directDep;
    }
    /**
     *determines monthly interest
     *@return monthly interest for checking account
     */
    @Override
	public double monthlyInterest() {
	   double interestRate = (.05/100)/12 * this.getBalance();
	   return interestRate;
	}

	/**
	 *determines monthly fee
	 *@return monthly fee or 0
	 */
	@Override
	public double monthlyFee() {
	   if(directDep == true || this.getBalance() >= 1500) {
		   return 0;
	   }
	   else {
		   return 25;
	   }
    }
	/**
	 * calculates new balance for each of the accounts after the fees and stuff
	 * @return new balance value
	 */
	public double getNewBalance() {
		double interest = this.monthlyInterest();
		double fee = this.monthlyFee();
		double newBalance = (this.getBalance() - fee) + interest;
		return newBalance;
	}
	
	/**
	 * checks to see if the data fields of two Account objects are equal
	 * @return true if they are equal, false otherwise
	 */
	 @Override
	public boolean equals(Object obj) {
		if(obj instanceof Account && obj instanceof Checking) {
		Checking acc = (Checking) obj;
		if(super.equals(acc)) //&& this.directDep == acc.directDep)
			return true;
		else
			return false;
		}
		return false;
	}
	/**
	 * returns the string representation of the account
	 * @return string of holder, balance, and date
	 */
	@Override
	public String toString() { 
		String typeOfChecking = "";
		if(directDep == true)
			typeOfChecking += "*direct deposit account*";
		return "*Checking*" + super.toString() + typeOfChecking;
	}	 
	
}


