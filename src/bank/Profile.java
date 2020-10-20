package bank;

/**
 * This class creates and represents a profile for a client of the bank
 * @author Prajna Kurkal, Sarah Law, Zill Soni
 */

public class Profile {
	 private String fname;
	 private String lname;
	 
	 /**
	 * Constructor for Profile class
	 * @param fname represents first name of client
	 * @param lname last name of client
	 */
	public Profile(String fname, String lname) {
		 this.fname = fname;
		 this.lname = lname;
	}
	 /**
	 *accessor method for fname data field  
	 * @return fname value
	 */
	public String getFName() {
		 return fname;
	}
	 /**
	  * accessor method for lname data field
	 * @return lname value
	 */
	public String getLName() {
		 return lname;
	}
	/**
	 * @Override
	 * @return the string representation of the Profile class
	 */
	public String toString() {
		return fname + " " + lname;
	}
	/**
	 * @Override
	 * checks if the data fields of two Profile objects are equal to each other
	 * @return true if they are equal false otherwise
	 */
	public boolean equals(Object obj) {
		if(obj instanceof Profile)
		{
			Profile person = (Profile) obj;
			if(this.fname.equals(person.fname) && this.lname.equals(person.lname))
				return true;
			else
				return false;
		}
		else
			return false;
	}
}
