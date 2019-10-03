class BankApp
{
    public static void main(String[] args)
        {
            BankAccount ba1 = new BankAccount(100.00); // create acct
            
            System.out.print(“Before transactions, “);
            ba1.display(); // display balance
            
            ba1.deposit(74.35); // make deposit
            ba1.withdraw(20.00); // make withdrawal
            
            System.out.print(“After transactions, “);
            ba1.display(); // display balance
        } // end main()
} // end class BankApp