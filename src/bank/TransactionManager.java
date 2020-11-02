package bank;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 TransactionManager class is the user interface class.
 It's run method is called by RunProject2 class to handle commands and data given by user.
 Commands handled from user are to open, close, deposit, deposit, print, and quit.
 Execution of each handled command is done in TransactionManager with the exception of "Q" to quit.
 @author Sarah Law, Zill Soni, Prajna Kurkal
 */
public class TransactionManager {
    /**
     Parses user input and handles input commands until user enters "Q" to quit.
     When user enters "Q" the program stops.
     For commands not handled, displays an error.
     For commands handled uses mostly methods in ****** class to execute.
     */
    public void run() {
        String openChecking = "OC";
        String openSavings =  "OS";
        String openMoneyMarket = "OM";
        String closeChecking = "CC";
        String closeSavings = "CS";
        String closeMoneyMarket = "CM";
        String depositChecking = "DC";
        String depositSavings = "DS";
        String depositMoneyMarket = "DM";
        String withdrawChecking = "WC";
        String withdrawSavings = "WS";
        String withdrawMoneyMarket = "WM";
        String printAccount = "PA";
        String printAccountInfoByDate = "PD";
        String printAccountInfoByLastName = "PL";
        String toQuit = "Q";
        String arrCommands [] = {openChecking, openSavings, openMoneyMarket,
                                closeChecking, closeSavings, closeMoneyMarket,
                                depositChecking, depositSavings,depositMoneyMarket,
                                withdrawChecking, withdrawSavings, withdrawMoneyMarket,
                                printAccount, printAccountInfoByDate, printAccountInfoByLastName, toQuit};

        // for input
        Scanner input = new Scanner(System.in);
        System.out.println("Transaction processing starts.....");
        
        AccountDatabase accountDatabase = new AccountDatabase();
        
        while (input.hasNext()) {
            String commandTotal = input.nextLine();

            Scanner parseCommand = new Scanner(commandTotal);
            parseCommand.useDelimiter(" ");

            String command = parseCommand.next();

            //check if valid command
            Boolean isValidCommand = false;
            for(int ii = 0; ii < arrCommands.length; ii++){
                if(command.equals(arrCommands[ii])){
                    isValidCommand = true;
                    break;
                }
            }
            if(!isValidCommand){
                System.out.println("Command '" + commandTotal + "' not supported!");
                continue;
            }

            //Handles Quit and Print
            //Check that Quit and Print only has the command and no other input
            if(command.equals(toQuit) || command.charAt(0) == 'P'){
                if(parseCommand.hasNext()){
                    System.out.println("Input data type mismatch.");
                    continue;
                }else{
                    if(command.equals(toQuit)){
                        //handle Quit
                        System.out.println("Transaction processing completed.");
                        break;
                    }else{
                        //handle Print
                        if(command.equals(printAccount)){
                            accountDatabase.printAccounts();
                        }
                        else if(command.equals(printAccountInfoByDate)){
                            accountDatabase.printByDateOpen();
                        } else if(command.equals(printAccountInfoByLastName)) {
                        	accountDatabase.printByLastName();
                        //} else {
                            //accountDatabase.printByLastName();
                        }
                        continue;
                    }
                }
            }

            String firstName = "";
            String lastName = "";

            try{
                firstName = parseCommand.next();
                lastName = parseCommand.next();
            } catch (InputMismatchException e){
                System.out.println("Input data type mismatch.");
                continue;
            } catch (NoSuchElementException e){
                //If there is not enough data
                System.out.println("Input data type mismatch.");
                continue;
            }

            Profile currentProfile = new Profile(firstName, lastName);

            //Handles Close
            //Check that Close only has command and First and Last Name
            if(command.charAt(0) == 'C' && parseCommand.hasNext()){
                //Check that no other inputs given
                System.out.println("Input data type mismatch.");
                continue;
            }

            if(command.charAt(0) == 'C'){
                //find account
                if(command.equals(closeChecking)) {
                	Checking closer = new Checking(currentProfile, 0.0, null, false);
                	boolean removed = accountDatabase.remove(closer);
                	if(removed)
                		System.out.println("Account removed from database");
                	else
                		System.out.println("Account could not be found/removed from the database");
                	
                } else if (command.equals(closeMoneyMarket)) {
                	MoneyMarket closer = new MoneyMarket(currentProfile, 0.0, null);
                	boolean removed = accountDatabase.remove(closer);
                	if(removed)
                		System.out.println("Account removed from database");
                	else
                		System.out.println("Account could not be found/removed from the database");
                } else if(command.equals(closeSavings)){
                	Savings closer = new Savings(currentProfile, 0.0, null, false);
                	boolean removed = accountDatabase.remove(closer);
                	if(removed)
                		System.out.println("Account removed from database");
                	else
                		System.out.println("Account could not be found/removed from the database");
                }

                continue;
            }

            //Handle Deposit and Withdraw
            //Parse the Money
            double money = 0;

            try{
                //For doubles that are not in 0.00, since the example allowed for it, it will be allowed
                //Check if enough data
                if(!parseCommand.hasNext()){
                    System.out.println("Input data type mismatch.");
                    continue;
                }
            money = parseCommand.nextDouble();
            }catch(NumberFormatException e){
                System.out.println("Input data type mismatch.");
                continue;
            } catch(InputMismatchException e){
                System.out.println("Input data type mismatch.");
                continue;
            } catch (NoSuchElementException e){
                //If there is not enough data
                System.out.println("Input data type mismatch.");
                continue;
            }

            //Check that Deposit and Withdraw have no other inputs given
            if((command.charAt(0) == 'D' || command.charAt(0) == 'W') && parseCommand.hasNext()){
                //Check that no other inputs given
                System.out.println("Input data type mismatch.");
                continue;
            }

            //Handle Deposit
            if(command.charAt(0) == 'D'){
            	if(command.equals(depositChecking)) {
	            	Checking dep = new Checking(currentProfile, 0.0, null, false);
	            	boolean deposited = accountDatabase.deposit(dep, money);
	            	if(deposited)
	            		System.out.println("$" + money + " deposited into account");
	            	else
	            		System.out.println("could not deposit into account"); 
	            }
            	else if(command.equals(depositSavings)) {
	            	Savings dep = new Savings(currentProfile, 0.0, null, false);
	            	boolean deposited = accountDatabase.deposit(dep, money);
	            	if(deposited)
	            		System.out.println("$" + money + " deposited into account");
	            	else
	            		System.out.println("could not deposit into account"); 
	            }
            	else if(command.equals(depositMoneyMarket)) {
	            	MoneyMarket dep = new MoneyMarket(currentProfile, 0.0, null);
	            	boolean deposited = accountDatabase.deposit(dep, money);
	            	if(deposited)
	            		System.out.println("$" + money + " deposited into account");
	            	else
	            		System.out.println("could not deposit into account"); 
	            }
                continue;
            }



            //Handle Withdraw
            if(command.charAt(0) == 'W'){
            	if(command.equals(withdrawChecking)) {
	            	Checking withdraw = new Checking(currentProfile, 0.0, null, false);
	            	int withdrawls = accountDatabase.withdrawal(withdraw, money);
	            	if(withdrawls == -1)
	            		System.out.println("account could not be found");
	            	else if(withdrawls == 1)
	            		System.out.println("insufficient funds"); 
	            	else
	            		System.out.println("$" + money + " withdrew");
	            }
            	else if(command.equals(withdrawSavings)) {
            		Savings withdraw = new Savings(currentProfile, 0.0, null, false);
	            	int withdrawls = accountDatabase.withdrawal(withdraw, money);
	            	if(withdrawls == -1)
	            		System.out.println("account could not be found");
	            	else if(withdrawls == 1)
	            		System.out.println("insufficient funds"); 
	            	else
	            		System.out.println("$" + money + " withdrew"); 
	            }
            	else if(command.equals(withdrawMoneyMarket)) {
            		MoneyMarket withdraw = new MoneyMarket(currentProfile, 0.0, null);
	            	int withdrawls = accountDatabase.withdrawal(withdraw, money);
	            	if(withdrawls == -1)
	            		System.out.println("account could not be found");
	            	else if(withdrawls == 1)
	            		System.out.println("insufficient funds"); 
	            	else
	            		System.out.println("$" + money + " withdrew"); 
	            }
                continue;
            }
            //Handle Open
            //Get Date
            int month = -1;
            int day = -1;
            int year = -1;

            try{
                String date = parseCommand.next();
                Scanner dateParser = new Scanner(date);
                dateParser.useDelimiter("/");

                //Get month, day, year
                month = dateParser.nextInt();
                day = dateParser.nextInt();
                year = dateParser.nextInt();

                if(dateParser.hasNext()){
                    System.out.println("Input data type mismatch.");
                    continue;
                }
            } catch(InputMismatchException e){
                System.out.println("Input data type mismatch.");
                continue;
            } catch(NumberFormatException e){
                System.out.println("Input data type mismatch.");
                continue;
            } catch (NoSuchElementException e){
                //If there is not enough data
                System.out.println("Input data type mismatch.");
                continue;
            }

            //Check date validity
            Date accountDate = new Date(month, day, year);
            if(!accountDate.isValid()){
                System.out.println(accountDate.toString() + "is not a valid date!");
                continue;
            }
            String accountAdded = "Account opened and added to the database.";
            String accountExists = "Account is already in the database.";
            boolean checkAccExists;
            
            //Check for command OM that no other inputs given
            if(command.equals("OM") && parseCommand.hasNext()){
                System.out.println("Input data type mismatch.");
                continue;
            }

            //Handle OM
            if(command.equals(openMoneyMarket)){
                MoneyMarket currentMoneyMarketAccount = new MoneyMarket(currentProfile, money, accountDate);
                checkAccExists = accountDatabase.add(currentMoneyMarketAccount);
                if(checkAccExists)
                	System.out.println(accountAdded);
                else
                	System.out.println(accountExists);
                continue;
            }

            //Handle other Open Account commands
            //Get either the checkings or savings boolean data field
            boolean checkingSavingBoolean = false;
            
            try{
                checkingSavingBoolean = parseCommand.nextBoolean();

            } catch (InputMismatchException e) {
                System.out.println("Input data type mismatch.");
                continue;
            } catch (NoSuchElementException e){
                //If there is not enough data
                System.out.println("Input data type mismatch.");
                continue;
            }

            //Check if other inputs, if there are then error
            if(parseCommand.hasNext()){
                System.out.println("Input data type mismatch.");
                continue;
            }
            //Handle OC
            if(command.equals(openChecking)){
                Checking currentChecking = new Checking(currentProfile, money, accountDate, checkingSavingBoolean);
                checkAccExists = accountDatabase.add(currentChecking);
                if(checkAccExists)
                	System.out.println(accountAdded);
                else
                	System.out.println(accountExists);
                continue;
            }
            //Handle OS
            if(command.equals(openSavings)){
                Savings currentSavings = new Savings(currentProfile, money, accountDate, checkingSavingBoolean);
                checkAccExists = accountDatabase.add(currentSavings);
                if(checkAccExists)
                	System.out.println(accountAdded);
                else
                	System.out.println(accountExists);
                continue;
            }
        }
    }
}
