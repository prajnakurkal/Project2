package bank;

/**
 * This class stores all the possible accounts that are registered with the bank
 * @author Prajna Kurkal, Sarah Law, Zill Soni
 */
public class AccountDatabase {
	private Account[] accounts;
	private int size;
	
	/**
	 * constructor for a new AccountDatabase
	 */
	public AccountDatabase() {
		accounts = new Account[5];
		size = 0;
	}
	/**
	 * accessor method for the amount of accounts that are registered
	 * @return size value
	 */
	public int getSize() {
		return size;
	}
	/**
	 * finds a specific account within the database
	 * @param account
	 * @return the index if the specific account is fount, -1 otherwise
	 */
	private int find(Account account) { 
		for(int i = 0; i < size; i++) {
			if(accounts[i].equals(account))
				return i;
		}
		int didNotFind = -1;
		return didNotFind; //to show the item was not found
	}
	/**
	 * grows the account database by 5 accounts when the capacity is full
	 */
	private void grow() { //assume size is full
		int newLength = accounts.length + 5;
		Account [] arr = new Account[newLength];
		for(int i = 0; i < size; i++)
			arr[i] = accounts[i];
		accounts = arr;
	}
	/**
	 * add's new accounts into the databases. first checks if account is present, and then
	 * proceeds to add account. automatically grows the database if the account is full.
	 * @param account that needs to be added
	 * @return true if account was able to be added, false otherwise
	 */
	public boolean add(Account account) { //return false if account exists
		int found = find(account);
		if(found != -1) //account exists
			return false;
		if(size == accounts.length)
			grow();
		accounts[size] = account;
		size++;
		return true;
	} 
	/**
	 * removes accounts from the database. first find where account is located, then 
	 * replace the value of that index and finally set last index to null. 
	 * @param account
	 * @return true if we can remove the account, false otherwise
	 */
	public boolean remove(Account account) { //return false if account doesn’t exist
		int found = find(account);
		if(found == -1)
			return false;
		accounts[found] = accounts[size - 1];
		accounts[size - 1] = null;
		size--;
		return true;
	} 
	/**
	 * deposits a certain amount into a desired account. also checks to see if that account exists
	 * @param account that needs money to be deposited
	 * @param amount the specific amount deposited
	 * @return true if the deposti went through, false otherwise
	 */
	public boolean deposit(Account account, double amount) {
		int found = find(account);
		if(found == -1)
			return false;
		accounts[found].credit(amount);
		return true;
	}
	//return 0: withdrawal successful, 1: insufficient funds, -1 account doesn’t exist
	/**
	 * first checks to see if a certain account exists in the database, then attempts to 
	 * withdraw a certain amount from that account
	 * @param account the account that needs money to be withdrew
	 * @param amount specific amount needed to be withdrawn
	 * @return
	 */
	public int withdrawal(Account account, double amount) { 
		int found = find(account);
		if(found == -1)
			return -1;
		Account acc = accounts[found];
		if(amount > acc.getBalance())
			return 1;
		else {
			acc.debit(amount);
			return 0;
		}
	}
	/**
	 * uses insertion sort to sort the database by date every account was opened
	 */
	private void sortByDateOpen() { //sort in ascending order   
		//insertion sort
		for (int j = 1; j < size; j++) {  
			Account keyAcc = accounts[j];
			Date key = keyAcc.getDate();  
			int i = j-1;
			Account compAcc = accounts[i];
			Date comp = compAcc.getDate();
			while ((i >= 0) && (comp.compareTo(key) == 1)) {  
				accounts [i+1] = accounts[i];  
				i--;  
			}  
			accounts[i+1] = keyAcc;  
	    }  
	} 
	/**
	 * uses selection sort to sort the database by client's last name in ascending order
	 */
	private void sortByLastName() { //sort in ascending order
		//selection sort
	    for (int j=0; j < size - 1; j++) {
	      int min = j;
	      for ( int k=j+1; k < size; k++ )
	        if ( accounts[k].getProfile().getLName().compareTo(accounts[min].getProfile().getLName() ) < 0) 
	        	min = k;  
	      //swap
	      Account temp = accounts[j];
	      accounts[j] = accounts[min];
	      accounts[min] = temp;
	    }			
	} 
	/**
	 * first sorts by date opened, then prints the database
	 */
	public void printByDateOpen() { 
		sortByDateOpen();
		for(int i = 0; i < size; i++)
			System.out.println(accounts[i]);
	}
	/**
	 * first sorts by last name, and then prints the database
	 */
	public void printByLastName() { 
		sortByLastName();
		for(int i = 0; i < size; i++)
			System.out.println(accounts[i]);
	}
	/**
	 * prints the database 
	 */
	public void printAccounts() { 
		for(int i = 0; i < size; i++)
			System.out.println(accounts[i]);
	}
}
