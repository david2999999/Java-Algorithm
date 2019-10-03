class BankAccount
{
    private double balance; // account balance
    
    public BankAccount(double openingBalance) // constructor
        {
            balance = openingBalance;
        }
        
    public void deposit(double amount) // makes deposit
        {
            balance = balance + amount;
        }
        
    public void withdraw(double amount) // makes withdrawal
        {
            balance = balance - amount;
        }
        
    public void display() // displays balance
        {
            System.out.println(“balance=” + balance);
        }
} // end class BankAccount