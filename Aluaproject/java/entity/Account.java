package entity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account { // create class Account

    @Id
    private Long id; // new variable

    private Integer password; // new variable
    private Integer cash;  // new variable
    private String fn; // new variable
    private String sn;// new variable

    public Account() { }// default constructor

    public Account(long id, int pass, int cash, String fn, String sn) { //constructor to include the personal information for new account
        this.id = id;
        this.password = pass;
        this.cash = cash;
        this.fn= fn;
        this.sn= sn;

    }

    public boolean checkPassword(int pass) { // method checkPassword for checking the password of an account
        if (this.password == pass) { // if password is identical with password given in db, it will work.(if else statement)
            return true;
        }
        else{
            return false; // other cases, it won't work.
        }
    }

    public int takeOff(int sum){ // method takeOff to get money
        int res;
        if(sum < 0) // if we put minus values, it will use the given formula
        {
            sum*=-1;
        }
        res=this.cash-sum; // sum the given money with money in db
        System.out.println("you have withdrawn " + sum + "\namount Account balance " + res);
        return this.cash=res; // return the balance
    }
    public int takeOn(int sum){ // method takeOn to put money
        int res;
        res=this.cash+sum; // obtain money from the ds
        System.out.println("you have put" +sum+"\namount Account balance " + res);
        return this.cash=res; // return the balance
    }
//    public int getCash()
//    {
//        return cash;
//    }
    public void makeTransaction(Account receiver, int sum) // method Transaction to transfer the money to other accounts
    {
        if(receiver.id / 10000000 != this.id /10000000) { // this is the if else statement to use commission
            this.takeOff(sum + 150);
            System.out.println("Commission is 150"); // in our atm oll transaction should include commission
        }

        else
            this.takeOff(sum);
        receiver.takeOn(sum);
    }
}