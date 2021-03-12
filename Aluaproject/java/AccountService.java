import entity.Account;

public class AccountService {
    private Connecter parentConnector;
    public AccountService(Connecter parentConnector){//to get connection to this entity/table
        this.parentConnector=parentConnector;
    }
    public Account find(Object primaryKey){ //first interface method
        return this.parentConnector.getManager().find(Account.class, primaryKey);
    }
    public void save(Account object){//second interface method
        this.parentConnector.getManager().persist(object);
    }
}

