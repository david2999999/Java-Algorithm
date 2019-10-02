public class Account {
    int userNumber;
    String userLastName;
    String userFirstName;
    double userBalance;

    public boolean deposit( double amount ){
        double newBalance;
        if ( amount < 0.0 ){
            return false; /* Can't deposit negative amount */
        } else {
            synchronized( this ){
                newBalance = userBalance + amount;
                userBalance = newBalance;
            }
            return true;
        }
    }

    public boolean withdraw( double amount ){
        double newBalance;
        synchronized( this ){
            if ( amount < 0.0 || amount > userBalance ){
                return false;
            } else {
                newBalance = userBalance - amount;
                userBalance = newBalance;
                return true;
            }
        }
    }
}