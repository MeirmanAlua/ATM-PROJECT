package kz.aitu.oop.assignment;

import entity.Account;
import java.util.Scanner;

public class CreateAcc {

    public static int getCountsOfDigits(long number) { //count the quantity of digits in the number
        int count = (number == 0) ? 1 : 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    void CreateAcc(int login, int password){

        if (getCountsOfDigits(password) == 4 && getCountsOfDigits(login) == 16) { //

            EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("atm");
            EntityManager manager=entityManagerFactory.createEntityManager();
            manager.getTransaction().begin();
            Account account = new Account(login, password, 10000);
            manager.persist(account);
            manager.getTransaction().commit();
        } else {
            System.out.println("impossible password.\nEnter 4-digits password");
        }
    }
}