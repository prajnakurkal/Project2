package bank;

/**
 * this class is a representation of a savings account
 * @author Prajna Kurkal, Sarah Law, Zill Soni
 */
public class Savings extends Account {
	private boolean isLoyal;
	
	/**
	 * initializes saving account
	 * @param holder
	 * @param balance
	 * @param dateOpen
	 * @param isLoyal
	 */
	public Savings(Profile holder, double balance, Date dateOpen, boolean isLoyal){
		super(holder, balance, dateOpen);
		this.isLoyal = isLoyal;
	}
    /**
     * determines monthly interest
     *@return monthly interest or 0 if an exception is caught
     */
    @Override
    public double monthlyInterest() {   
		double interest = 0;
		if(isLoyal == true) {
			interest = (.35/100)/12 * this.getBalance();
			return interest;
		}
			
		else {
			interest = (.35/100)/12 * this.getBalance();
			return interest;
		}
    }

	/**
	 * determines monthly fee for saving acc
	 *@return monthly fee for savings acc or 0
	 */
	@Override
	public double monthlyFee() {
		if(this.getBalance() < 300)
			return 5;
    return 0;
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
		if(obj instanceof Account && obj instanceof Savings) {
		Savings acc = (Savings) obj;
		if(super.equals(acc)) //&& this.isLoyal == acc.isLoyal)
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
		String typeOfSavings = "";
		if(isLoyal == true)
			typeOfSavings += "*special savings account*";
		return "*Savings*" + super.toString() + typeOfSavings;
	}
}
	
