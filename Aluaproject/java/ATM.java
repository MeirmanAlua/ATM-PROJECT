import entity.Account;
import entity.Validator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("atm");
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        //   int login=12345;
        //    Scanner passw=new Scanner(System.in);
        //    int a= passw.nextInt();


//        Account account2 =new Account( 50000000, 4444, 10000);
//        manager.persist(account2);
//        manager.getTransaction().commit();
        Connecter connect = new Connecter("atm");
        connect.openTransaction();

        Scanner a = new Scanner(System.in);
        int id;
        while (true) {
            System.out.println("Input account id");
            id = a.nextInt();
            if (Validator.validateCardNumber(id))
                break;
        }
        Account account = connect.getAccountService().find(id);
        // Account account=manager.find(Account.class,id);
        if (account != null) {
//            System.out.println("your account not find");
//

            Scanner b = new Scanner(System.in);
            System.out.println("Input password");
            int pass = b.nextInt();

            if (account.checkPassword(pass)) {
                System.out.println("Access granted");

                while (true) {
                    System.out.println("Choose something\n1 - Withdraw money\n2 - Take on money\n3 - Make Transaction\n0 - Exit");
                    int choice = a.nextInt();
                    //-----------------------

                    switch (choice) {

                        case 1:
                            Scanner c = new Scanner(System.in);
                            int sum;
                            while (true) {
                                System.out.println("Please input the sum what you want take off");
                                sum = c.nextInt();
                                if (sum > 0)
                                    break;
                                System.out.println("Incorrect input");
                            }
                            account.takeOff(sum);
                            connect.getAccountService().save(account);
//Withdraw
                            break;
                        case 2:
                            while (true) {
                                Scanner d = new Scanner(System.in);
                                System.out.println("Please input the sum what you want take on");
                                sum = d.nextInt();
                                if (sum > 0)
                                    break;
                                System.out.println("Incorrect input");
                            }
                            account.takeOn(sum);
                            connect.getAccountService().save(account);
                        case 3:
                            System.out.println("Please input the sum what you want send");
                            System.out.println("From:");
                            int from = a.nextInt();
                            System.out.println("To:");
                            int to = a.nextInt();
                            System.out.println("Sum:");
                            int money = a.nextInt();
                            Account accountFrom = connect.getAccountService().find(from);
                            Account accountTo = connect.getAccountService().find(to);
                            accountFrom.makeTransaction(accountTo, money);
                            connect.getAccountService().save(accountFrom);
                            connect.getAccountService().save(accountTo);
                            break;
                        case 0:
                            System.exit(0);
                            break;
                    }
//                     System.out.println("Do you want to continue? \n1 - Yes \n2 - No") {
//                        Scanner qwer = new Scanner(System.in);
//                        int q = qwer.nextInt();
//                        if (q==1) return true
//                        else if
//                        (q == 2)  {System.exit(0);
//                        }
                }
            } else {
                System.out.println("Access denied");
            }
        }
                else {
                    System.out.println("account with that id not find");
                }
                connect.closeTransaction();
            }
        }



                //-----------------------


//                Scanner ans =new Scanner(System.in);
//                System.out.println("if you want take money give answer y/n");
//                String yn=ans.nextLine();
//
//                if (yn.equals("Yes") | yn.equals("yes")) {
//                    Scanner c = new Scanner(System.in);
//                    int sum;
//                    while(true)
//                    {
//                        System.out.println("Please input the sum what you want take off");
//                        sum = c.nextInt();
//                        if(sum > 0)
//                            break;
//                        System.out.println("Incorrect input");
//                    }
//                    account.takeOff(sum);
//                    connect.getAccountService().save(account);
//
//                }
//                if (yn.equals("No") | yn.equals("no") | yn.equals('n')){
//                    System.out.println("You want give money?");
//                    String yn2=ans.nextLine();
//                    if (yn2.equals("yes")){
//                        Scanner c = new Scanner(System.in);
//                        System.out.println("Please input the sum what you want take on");
//                        int sum = c.nextInt();
//                        account.takeOn(sum);
//                        connect.getAccountService().save(account);
//
//                    } else if (yn2.equals("No")){
//                        System.out.println("Cash in your account "+account.getCash());
//                    }
//                } else{
//                    System.out.println("not correct answer");
//                }
//            } else {
//                System.out.println("Access denied");
//            }
//}
//        else{
//            System.out.println("account with that id not find");
//        }
//        connect.closeTransaction();
//    }
//}
