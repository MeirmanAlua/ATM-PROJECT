import entity.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args){
//        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("atm");
//        EntityManager manager=entityManagerFactory.createEntityManager();
//        manager.getTransaction().begin();

//        Account account =new Account(12345, 1234, 10000);
//        manager.persist(account);
//        manager.getTransaction().commit();
  Connecter connect = new Connecter("atm");
  connect.startTransaction();

        Scanner a=new Scanner(System.in);
        System.out.println("Input account id");
        int id=a.nextInt();
       Account account = connect.getAccountService().findById(id);
       // Account account=manager.find(Account.class,id);
        if (account!=null) {
//            System.out.println("your account not find");
//


            Scanner b = new Scanner(System.in);
            System.out.println("Input password");
            int pass = b.nextInt();

            if (account.checkPassword(pass)) {
                System.out.println("Access granted");

                Scanner ans =new Scanner(System.in);
                System.out.println("if you want take money give answer y/n");
                String yn=ans.nextLine();

                if (yn.equals("Yes") | yn.equals("yes")) {
                    Scanner c = new Scanner(System.in);
                    System.out.println("Please input the sum what you want take off");
                    int sum = c.nextInt();
                    account.takeOff(sum);
                    connect.getAccountService().save(account);

                }
                if (yn.equals("No") | yn.equals("no") | yn.equals('n')){
                    System.out.println("You want give money?");
                    String yn2=ans.nextLine();
                    if (yn2.equals("yes")){
                        Scanner c = new Scanner(System.in);
                        System.out.println("Please input the sum what you want take on");
                        int sum = c.nextInt();
                        account.takeOn(sum);
                        connect.getAccountService().save(account);

                    } else if (yn2.equals("No")){
                        System.out.println("Cash in your account "+account.getCash());
                    }
                } else{
                    System.out.println("not correct answer");
                }
            } else {
                System.out.println("Access denied");
            }
}
        else{
            System.out.println("account with that id not find");
        }
        connect.endTransaction();
    }
}