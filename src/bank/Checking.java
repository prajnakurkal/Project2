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
	    directDep=false;
    }
    /**
     *determines monthly interest
     *@return monthly interest for checkings or 0
     */
    @Override
	public double monthlyInterest() {
	    
	    try{return (2020-this.getDate().getYear())*0.05;}
	    catch(Exception e)
	    {
	        System.out.println("Number Format Exception");
	    }
	    return 0;
	}

	/**
	 *determines monthly fee
	 *@return monthly fee or 0
	 */
	@Override
	public double monthlyFee() {
	   try{ if(this.getBalance()>1500)
	    {
	        return this.getBalance()-25;
	    }}
	    catch(Exception e)
	    {
	        System.out.println("Number Format Exception");
	        }
	        return 0;
	    }
}


