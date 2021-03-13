package kz.aitu.oop.assignment;

import java.util.Scanner;

import entity.Account;

public class CheckingAcc {


    //checking login
    public boolean checkAccount(int id) {
        Account account = connect.getAccountService().findById(id);
        // Account account=manager.find(Account.class,id);
        if (account != null) {
            System.out.println("your account not find");
            return false; //может надо добавить break
        }
        //checking password
        Scanner b = new Scanner(System.in);
        System.out.println("Input password");
        int pass = b.nextInt();
        if (account.checkPassword(pass)) {
            System.out.println("Access granted");
                return true;
        } else {
            System.out.println("Access denied");
                return false;
        }
    }
}
