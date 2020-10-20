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
		withdrawls = 0;
	}

    /**
     *determines monthly interest
     *@return double
     */
    @Override
    public double monthlyInterest() {
    	return (2020-this.getDate().getYear())*0.65;
    }

    /**
     * determines monthly fee
     * @return either decremented balance or 0
     */
    @Override
    public double monthlyFee() {
    
        if(this.getBalance()>2500)
        {
            return this.getBalance()-12;
        }
        return 0;
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
	public void setWithdrawals(int withdrawals) {
		this.withdrawls = withdrawals;
	}
}
