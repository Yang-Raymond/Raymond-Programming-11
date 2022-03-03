import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){
        

    }
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        this.name = name;
        this.accountNumber = accountNumber;
        this.deposits = new ArrayList<>();
        this.withdraws = new ArrayList<>();
        
        //checks if deposit is greater than 0, then deposits the money into the checking account if True
        if (checkDeposit > 0){
            deposit(checkDeposit,new Date(), CHECKING);
        }
        
        //checks if deposit is greater than 0, then deposits the money into the savings account if True
        if (checkDeposit>0){
            deposit(checkDeposit,new Date(), SAVING);
        }
    }

    public double deposit(double amt, Date date, String account){
        //add deposit to arraylist
        deposits.add(new Deposit(amt, date, account));

        //remove amount from balance
        if (account.equals(CHECKING)){
            this.checkBalance += amt;
        }
        else{
            this.savingBalance += amt;
        }
        // return the balance
        return account.equals(CHECKING) ? this.checkBalance : this.savingBalance;
    }
    public double withdraw(double amt, Date date, String account){
        //add withdraw to arraylist
        withdraws.add(new Withdraw(amt, date, account));
        //if a customer tries to withdraw over overdraft restriction, it fails
        if (checkOverdraft(amt, account)){
            System.out.println("Withdraw failed, Overdraft!");
            return account.equals(CHECKING) ? this.checkBalance : this.savingBalance;
        }
        //withdraw from account
        if (account.equals(CHECKING)){
            this.checkBalance -= amt;
        }
        else{
            this.savingBalance -= amt;
        }
        //return balance
        return account.equals(CHECKING) ? this.checkBalance : this.savingBalance;
    }
    private boolean checkOverdraft(double amt, String account){
        double balance = account.equals(CHECKING) ? this.checkBalance : this.savingBalance;

        if (balance - amt < OVERDRAFT){
            return true;
        }
            
        return false;
    }
    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}
