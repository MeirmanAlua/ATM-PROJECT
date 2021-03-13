package entity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Scanner;

@Entity
public class Account { // create class Account

    @Id
    private Integer id; // new variable

    private Integer password; // new variable
    private Integer cash;  // new variable
    private String fn; // new variable
    private String sn;// new variable
    private Integer cvv;

    public Account() {
    }// default constructor

    public Account(int id, int pass, int cash, String fn, String sn, int cvv) { //constructor to include the personal information for new account
        this.id = id;
        this.password = pass;
        this.cash = cash;
        this.fn = fn;
        this.sn = sn;
        this.cvv = cvv;

    }

    public boolean checkPassword(int pass) { // method checkPassword for checking the password of an account
        if (this.password == pass) { // if password is identical with password given in db, it will work.(if else statement)
            return true;
        } else {
            return false; // other cases, it won't work.
        }
    }

    public boolean checkCVV(int cvv) { // method checkPassword for checking the password of an account
        if (this.cvv == cvv) { // if password is identical with password given in db, it will work.(if else statement)
            return true;
        } else {
            return false; // other cases, it won't work.
        }
    }


    public int takeOff(int sum) { // method takeOff to get money
        int res;
        if (sum < 0) // if we put minus values, it will use the given formula
        {
            sum *= -1;
        }
        res = this.cash - sum; // sum the given money with money in db
        System.out.println("you have withdrawn " + sum + "\namount Account balance " + res);
        return this.cash = res; // return the balance
    }

    public int takeOn(int sum) { // method takeOn to put money
        int res;
        res = this.cash + sum; // obtain money from the ds
        System.out.println("you have put" + sum + "\namount Account balance " + res);
        return this.cash = res; // return the balance
    }

    //    public int getCash()
//    {
//        return cash;
//    }
    public void makeTransaction(Account receiver, int sum) // method Transaction to transfer the money to other accounts
    {
        if (receiver.id / 10000000 != this.id / 10000000) { // this is the if else statement to use commission
            this.takeOff(sum + 150);
            System.out.println("Commission is 150"); // in our atm oll transaction should include commission
        } else
            this.takeOff(sum);
        receiver.takeOn(sum);
    }


    public void inputData() {
        System.out.println("Register new id:");
        Scanner t = new Scanner(System.in);
        int id = t.nextInt();
        this.id = id;
        Scanner y = new Scanner(System.in);
        System.out.println("Create the password for new user:");
        int pass = y.nextInt();
        this.password = pass;
        System.out.println("Enter amount of money for new user:");
        Scanner u = new Scanner(System.in);
        int cash = u.nextInt();
        this.cash = cash;
        System.out.println("Enter the first name of new user:");
        Scanner i = new Scanner(System.in);
        String fn = i.nextLine();
        this.fn = fn;
        System.out.println("Enter the second name of new user:");
        Scanner o = new Scanner(System.in);
        String sn = o.nextLine();
        this.sn = sn;
        System.out.println("Enter the cvv code for new user:");
        Scanner p = new Scanner(System.in);
        int cvv = p.nextInt();
        this.cvv = cvv;
    }

}