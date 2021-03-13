import entity.Account;

public class AccountService {  // create Accountservice
    private Connecter parentConnector; // extended class of connecter
    public AccountService(Connecter parentConnector) // constructor
    {//to get connection to this entity/table
        this.parentConnector=parentConnector;
    }
    public Account find(Object primaryKey){        //first interface method
        return this.parentConnector.getManager().find(Account.class, primaryKey);
    }
    public void save(Account object) {//second interface method to save the acctions with db
        this.parentConnector.getManager().persist(object);
    }
}

