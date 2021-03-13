import entity.Account;
import entity.Validator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner; // library scanner

public class ATM {
    public static void main(String[] args) {
EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("atm");
EntityManager manager = entityManagerFactory.createEntityManager();
manager.getTransaction().begin();

//______
//Account account2 = new Account ();// first method to input the Data to db
//account2.inputData();
//manager.persist(account2);
//manager.getTransaction().commit();

//_____
//Account account1 = new Account(51234467, 8888, 10000, "Anel", "Zholaman", 902); second method to input the Data to db
//manager.persist(account1);
//manager.getTransaction().commit();
        Connecter connect = new Connecter("atm"); // create object to connect with class connecter
        connect.openTransaction(); // we start connection with db
        Scanner a = new Scanner(System.in); // first scanner to write the data in console
        int id; // new variable
        while (true)
        { // this loop will work infinitely until writing the existing id
            System.out.println("Input account id");
            id = a.nextInt();
            if (Validator.validateCardNumber(id)) // using validateCardNumber method
                break;
        }
        Account account = connect.getAccountService().find(id); // obtain account from the db
        if (account != null)
        { // if we do not find similar account in db, it will print the following statement
            // System.out.println("your account found");
        Scanner b = new Scanner(System.in); // second scanner to enter the password
        System.out.println("Input password"); //if we find similar account in db, it will ask to enter the password
        int pass = b.nextInt();

        if (account.checkPassword(pass))
        { // if checkPassword methods is true, it will print following
            System.out.println("Access granted");

            while (true)
            { // this loop will work infinitely until writing 0;
                System.out.println("Choose something\n1 - Withdraw money\n2 - Take on money\n3 - Make Transaction\n0 - Exit");
                int choice = a.nextInt(); // choose the needed service
                //-----------------------
                switch (choice)
                { // open switch cass
                    case 1: // if our choice is 1, we can get money from account in db
                        Scanner c = new Scanner(System.in);  // declaring third scanner
                        int sum;
                        while (true)
                        { // this loop will work infinitely until sum will be more than 0
                            System.out.println("Please input the sum what you want take off");
                            sum = c.nextInt(); //to write the quantity of money
                            if (sum > 0)
                                break;
                            System.out.println("Incorrect input"); // if number is less than 0, it will print this statement
                        }
                        account.takeOff(sum); // work of method takeoff
                        connect.getAccountService().save(account); // save the changes in db
                        break;
                    case 2: // next case
                        while (true)
                        { //this loop will work infinitely until sum will be more than 0
                            Scanner d = new Scanner(System.in); // declaring 4th scanner
                            System.out.println("Please input the sum what you want take on");
                            sum = d.nextInt(); // to write in input the quantity of money to put
                            if (sum > 0)
                                break;
                            System.out.println("Incorrect input"); // if number is less than 0, it will print this statement
                        }
                        account.takeOn(sum); // work of method take on
                        connect.getAccountService().save(account);
                        break;// save the changes in db
                    case 3:
                        System.out.println("Please input the sum what you want send (commission 150)");
                        System.out.println("From:");
                        int from = a.nextInt();// scanner to write the account of giver
                        Scanner d = new Scanner(System.in); // second scanner to enter the password
                        System.out.println("Input cvv"); //if we find similar account in db, it will ask to enter the password
                        int cvv = d.nextInt();
                        if (account.checkCVV(cvv))
                        { // if checkPassword methods is true, it will print following
                            System.out.println("Access granted");
                        }
                            else
                                {
                                System.out.println("Incorrect cvv");
                                break;
                                }
                        System.out.println("To:");
                        int to = a.nextInt(); //scanner to write the address in input
                        System.out.println("Sum:");
                        int money = a.nextInt();// scanner to write the quantity of money to send in input
                        Account accountFrom = connect.getAccountService().find(from); // find account of giver
                        Account accountTo = connect.getAccountService().find(to); // find account of receiver
                        accountFrom.makeTransaction(accountTo, money); // work of method Transaction
                        connect.getAccountService().save(accountFrom); // save the changes in db
                        connect.getAccountService().save(accountTo); // save the changes in db
                        break;
                    case 0:
                        System.exit(0); // stop the loop
                        break;
//
                }
            }
        } else {
            System.out.println("Access denied"); // other cases, access denied
        }
        }
         else
        {System.out.println("account with that id not found"); // other cases, account with that id not found
            connect.closeTransaction();
    }
}  }// close connection and stop program



