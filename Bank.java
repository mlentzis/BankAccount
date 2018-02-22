/**
 * Michael Lentzis
 * CS176-01
 * Chapter 7
 * 
 * Bank class:
 * 
 * The Bank class is where the inputs of the user determines the results of the bank accounts. 
 * The user has several options presented to them. As like any normal ATM machine, they can select any option which
 * branches out to other options depending on which ones they choose. 
 * 
 * ALGORITHM:
 * 
 * create 100 bank accounts
 * run ATM program
 * ask user to open bank account
 * ask user for account number
 * user inputs account number
 * ask user for name
 * user inputs name
 * ask user for initial balance
 * user inputs initial balance
 * loop back to options
 * 
 * ask user to: deposit, withdraw, balance, largest balance, total of bank accounts, quit or print
 * 
 * if deposit is selected: 
 * ask user for account number
 * user inputs account number
 * ask user how much they wish to deposit
 * user inputs amount to deposit
 * loop back to options
 * 
 * if withdraw is selected:
 * ask user to enter account 
 * user inputs account number
 * ask user to enter how much to withdraw
 * user inputs amount to withdraw
 * loop back to options
 * 
 * if balance is selected:
 * ask user to enter account number
 * user inputs account number
 * print out their balance
 * loop back to options
 * 
 * if largest balance is selected:
 * print out the largest balance 
 * print out the name of largest balance
 * print out the account number of largest balance
 * loop back to options
 * 
 * if total is selected:
 * print out the total of bank accounts
 * loop back to options
 * 
 * if quit is selected: 
 * print out thank you and have a nice day
 * end program
 * 
 * if print is selected:
 * print out all the bank accounts in the array with values
 * loop back to options
 *   
 */ 


import java.util.Scanner;

public class Bank
{
  //Variable
  private int currentSize;
  
  Scanner in = new Scanner(System.in);
  
  //Array
  final int ACCOUNT = 100;
  BankAccount[] account= new BankAccount[ACCOUNT];
  
  
  /**
   * sets the elements of the partially filled array when the user creates them
   * @param currentSize of array
   */ 
  public Bank()
  {
    currentSize = 0;
    for(int i=0; i< account.length; i++) 
    {
      account[i]= new BankAccount();
    }
  }
  
  /**
   * A switch where the user has the option to do any of the following below and input values and names
   * @param user inputs values and goes through options  
   */ 
  public void processBankRequest()
  {
    //variables of method
    final int OPEN_BANK = 1;
    final int DEPOSIT = 2;
    final int WITHDRAW = 3;
    final int  BALANCE = 4;
    final int LARGEST_BALANCE = 5;
    final int TOTAL = 6;
    final int QUIT = 7;
    final int PRINT= 8;
    double amount= 0;
    int accountNumber;
    String name;
    double balance;
    
    int bank = OPEN_BANK;
    
    while(bank != QUIT)
    {
      //tell user his options
      System.out.println("Welcome to Lentzis Bank! Would you like to: \n1- OPEN A BANK ACCOUNT \n2- DEPOSIT \n3- WITHDRAW \n4- YOUR BALANCE \n5- LARGEST BALANCE \n6- TOTAL OF BANK ACCOUNTS \n7- QUIT \n8- PRINT" );
      
      bank= in.nextInt();
      
      switch(bank)
      {
        //set up a bank account
        case OPEN_BANK:
          
          System.out.println("Enter your account number: ");
          accountNumber= in.nextInt();
          account[currentSize].setAccountNumber(accountNumber);
          
          System.out.println("Enter your first name: ");
          name = in.next();
          account[currentSize].setName(name);
          
          System.out.println("Enter the initial balance: ");
          balance= in.nextDouble();
          account[currentSize].setBalance(balance);
          
          currentSize++;
          System.out.println("\n");
          break;
          
          
          // user deposits money
        case DEPOSIT:
          
          System.out.println("Enter your account number: ");
          accountNumber= in.nextInt();
          System.out.println("How much do you wish to deposit?");
          amount= in.nextDouble();
          
          int searchedValue= accountNumber;
          int pos= 0;
          Boolean found = false;
          
          while(pos < currentSize && !found)
          {
            if (account[pos].getAccountNumber() == searchedValue)
            {
              found = true;
            }
            else 
            {
              pos++;
            }
          }
          if (found)
          {
            account[pos].deposit(amount);
          }
          else
          {
            System.out.println("Error");
          }
          
          System.out.println("\n");
          break;
          
          //user withdraws money
        case WITHDRAW:
          
          System.out.println("Enter your account number: ");
          accountNumber= in.nextInt();
          System.out.println("How much do you wish to withdraw?");
          amount= in.nextDouble();
          
          int searchedValue2= accountNumber;
          int pos2= 0;
          Boolean found2 = false;
          
          while(pos2 < currentSize && !found2)
          {
            if (account[pos2].getAccountNumber() == searchedValue2)
            {
              found2 = true;
            }
            else 
            {
              pos2++;
            }
          }
          if (found2)
          {
            account[pos2].withdraw(amount);
          }
          else
          {
            System.out.println("Error");
          }
          
          System.out.println("\n");
          break;
          
          //user asks for their balance
        case BALANCE:
          
          System.out.println("Enter your account number: ");
          accountNumber= in.nextInt();
          
          int searchedValue3= accountNumber;
          int pos3= 0;
          Boolean found3 = false;
          
          while(pos3 < currentSize && !found3)
          {
            if ( account[pos3].getAccountNumber() == searchedValue3)
            {
              found3 = true;
            }
            else 
            {
              pos3++;
            }
          }
          if (found3)
          {
            System.out.println("\nYour balance is: $"+ account[pos3].getBalance());
          }
          else
          {
            System.out.println("\nError");
          }
          
          System.out.println("\n");
          break;
          
          //user finds largest balance in bank
        case LARGEST_BALANCE:
          
          double largestBal= account[0].getBalance();
          String largestName= account[0].getName();
          double largestAcc= account[0].getAccountNumber();
          
          for(int i=1; i<account.length; i++)
          {
            if(account[i].getBalance() > largestBal)
            {
              largestBal= account[i].getBalance();
              largestName= account[i].getName();
              largestAcc= account[i].getAccountNumber();
            }
          }
          
          System.out.println("\nLargest Balance:\n\nName: " + largestName + "\nAccount number: "+ largestAcc +"\nBalance: $" + largestBal +"\n");
          break;
          
          //user finds total of all bank accounts
        case TOTAL:
          
          double total=0;
          for(int i= 0; i<account.length; i++)
          {
            double element= account[i].getBalance();
            total= total+ element;
          }
          
          System.out.println("\nThe total of all bank accounts is $" + total + "\n");
          break;
          
          //user quits program
        case QUIT: 
          
          System.out.println("\nThank you for choosing The Lentzis Banking Company. Goodbye!");
          System.exit(0);
          break;
          
          //user prints out all bank accounts with values
        case PRINT:
          for(int i=0; i<account.length; i++)
        {
          System.out.println(account[i].toString());
        }
          System.out.println("\n");
          break;  
      }
    }
  } 
}