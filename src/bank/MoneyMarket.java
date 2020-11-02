package bank;

/**
 * this class represents a moneymarket account
 * @author Prajna Kurkal, Sarah Law, Zill Soni
 */
public class MoneyMarket extends Account {
	private int withdrawls; 
	
	/**
	 * @param holder
	 * @param balance
	 * @param dateOpen
	 * constructor for moneymarket acc
	 */
	public MoneyMarket(Profile holder, double balance, Date dateOpen) {
		super(holder, balance, dateOpen);
		this.withdrawls = 0;
	}

	/**
     *determines monthly interest
     *@return monthly interest for checking account or 0
     */
    @Override
    public double monthlyInterest() {
    	return ( (0.65/100) / 12 ) * this.getBalance();
    }

    /**
     * determines monthly fee
     * @return either decremented balance or 0
     */
    @Override
    public double monthlyFee() {
    
        if(withdrawls >= 6 || this.getBalance() < 2500)
            return 12;
        else
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
	 * accessor method for withdrawls
	 * @return withdrawls value
	 */
	public int getWithdrawals() {
		return withdrawls;
	}
	
	/**
	 * @param withdrawals
	 * sets the withdrawls to a parameterized value
	 */
	public void incrementWithdrawls() {
		this.withdrawls++;
	}
	/**
	 * checks to see if the data fields of two Account objects are equal
	 * @return true if they are equal, false otherwise
	 */
	 @Override
	public boolean equals(Object obj) {
		if(obj instanceof Account && obj instanceof MoneyMarket) {
		MoneyMarket acc = (MoneyMarket) obj;
		if(super.equals(acc)) //&& this.withdrawls == acc.withdrawls)
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
		String numWithdrawls = "*" + withdrawls + "withdrawls*";
		return "*MoneyMarket*" + super.toString() + numWithdrawls;
	}
}
