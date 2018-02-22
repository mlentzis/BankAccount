/**
 * Michael Lentzis
 * CS176-01
 * Chapter 7
 * 
 * BankAccount class:
 * 
 * The bankAccount class is where the methods are produced to be used when accessed from the user.
 * 
 */ 


public class BankAccount
{
  
  private int accountNumber;
  private String name;
  private double balance;
  
  
  
  public BankAccount()
  {
    balance = 0;
  }
  
  public void deposit(double amount)
  {
    balance= balance + amount;
  }
  
  public void withdraw(double amount)
  {
    balance= balance - amount;
  }
  
  public double getBalance()
  {
    return balance;
  }
  public String getName()
  {
    return name;
  }
  public int getAccountNumber()
  {
    return accountNumber;
  }
  
  public void setAccountNumber(int accNumber)
  {
    accountNumber = accNumber;
  }
  public void setBalance(double bal)
  {
    balance = bal;
  }
  public void setName(String newName)
  {
    name = newName;
  }
  
  public String toString()
  {
    String values= "account number: " + accountNumber + "  account name: " + name+ "  account balance: " + balance;
    return values;
  }
} 

