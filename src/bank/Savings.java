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
		isLoyal = true;
	}
    /**
     * determines monthly interest
     *@return monthly interest or 0 if an exception is caught
     */
    @Override
    public double monthlyInterest() {
        try
        {
            
         return (2020-this.getDate().getYear())*0.25;
        }
         catch(Exception e)
        {
            System.out.println("Number Format Exception");
    }
    return 0;

    }

	/**
	 * determines monthly fee for saving acc
	 *@return monthly fee for savings acc or 0
	 */
	@Override
	public double monthlyFee() {
	    try{
	    if(this.getBalance()>300)
	    {
	        return this.getBalance()-5;
	    }
	    }
	    catch(Exception e)
	    {
	        System.out.println("Number Format Exception");
	        }
	        return 0;
	    }
	}
	
