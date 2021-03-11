package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account { // create class Account

    @Id
    private Integer id; //

    private Integer password; //
    private Integer cash; //

    public Account() { }//

    public Account(int id, int pass, int cash) {
        this.id = id;
        this.password = pass;
        this.cash = cash;

    }

    public boolean checkPassword(int pass) {
        if (this.password == pass) {
            return true;
        }
        else{
            return false;
        }
    }
    public int takeOff(int sum){
        int res;
        res=this.cash-sum;
        System.out.println("you have withdrawn " + sum + "\namount Account balance " + res);
        return this.cash=res;
    }
    public int takeOn(int sum){
        int res;
        res=this.cash+sum;
        System.out.println("you have withdrawn " +sum+"\namount Account balance " + res);
        return this.cash=res;
    }

    public int getCash(){
        return cash;
    }
}