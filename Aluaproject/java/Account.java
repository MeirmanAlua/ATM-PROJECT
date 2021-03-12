package entity;
import java.util.ArrayList;
import java.util.List;
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
        if(sum < 0)
        {
            sum*=-1;
        }
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
    public void makeTransaction(Account receiver, int sum)
    {
        if(receiver.id / 10000000 != this.id /10000000) {
            this.takeOff(sum + 150);
            System.out.println("Commission is 150");
        }

        else
            this.takeOff(sum);
        receiver.takeOn(sum);
    }
}