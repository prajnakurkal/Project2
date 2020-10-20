package bank;

/**
 * This class instantiates an object that represents the date of a transaction, 
 * then compares the dates, and check its validity
 * @author Prajna Kurkal, Sarah Law, Zill Soni
 */
public class Date implements Comparable<Date> {
	private int year;
	private int month;
	private int day;
	
	/**
	 * @param year 
	 * @param month
	 * @param day
	 * Date constructor
	 */
	public Date(int month, int day, int year) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	/**
	 * accessor method for month
	 * @return month value
	 */
	public int getMonth() {
		return month;
	}
	/**
	 * accessor method for day 
	 * @return day value
	 */
	public int getDay() {
		return day;
	}
	/**
	 * accessor method for year
	 * @return year value
	 */
	public int getYear() {
		return year;
	}
	/**
	 * compares two Date objects to see if they're equal, or if one comes 
	 * before/after the other
	 * @return 0 for if the two Date's are equal, 1 if the current date is greater
	 * than the date in question, and -1 if it's less tha
	 */
	public int compareTo(Date date) { //return 0, 1, or -1 
		if(this.year < date.year)
			return -1; //it's less than
		else if(this.year > date.year)
			return 1;
		else { //the years are equal
			if(this.month < date.month)
				return -1;
			else if(this.month > date.month)
				return 1;
			else { //months are equal
				if(this.day < date.day)
					return -1;
				else if(this.day > date.day)
					return 1;
				else //days are equal
					return 0;
			}
		}
	} 
	/**
	 * @Override
	 * @return the string representation of Date
	 * represents the date as a string
	 */
	public String toString() { //in the format mm/dd/yyyy
		return month + "/" + day + "/" + year;
	} 
	/**
	 * checks if a possible date is valid
	 * @return true if Date is valid, false otherwise
	 */
	public boolean isValid() { 
		if(month <= 0 || month > 12)
			return false;
		if(year < 0)
			return false;
		if(month == 1 || month == 2 || month == 3 || month == 5 || month == 7 || month == 8 
		   || month == 10 || month == 12) { //all the months with 31 days + february bc it has 28/29 days
			if(month == 2) { //february
				if(year % 4 == 0) {
					if(year % 100 == 0 && year % 400 != 0)
						return false;
					else {
						if(day > 29 || day <= 0)
							return false;
						else 
							return true;
					}
				}
				else {
					if(day > 28 || day <= 0)
						return false;
					else
						return true;
				}
			}
			else { // for all the other non february months
				if(day > 31 || day < 0)
					return false;
				else 
					return true;
			}
		}
		else { // all the months with 30 days
			if(day > 30 || day <= 0)
				return false;
			else
				return true;
		}
	}
	/**
	 *@Override
	 *checks if the data fields of two objects are equal
	 *@return true if objects are equal false otherwise
	 */
	public boolean equals(Object obj) {
		if(obj instanceof Date){
			Date date = (Date) obj;
			if(this.month == date.month && this.day == date.day && this.year == date.year)
				return true;
			else
				return false;
		}
		else
			return false;
	}
}
