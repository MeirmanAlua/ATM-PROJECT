package kz.aitu.oop.assignment;

import entity.Account;

import java.util.Scanner;

public class ATM {

    public static void main(String[] args){

//creating new account
        Scanner num = new Scanner(System.in);
        int login = num.nextInt();//
        int password = num.nextInt();
        CreateAcc first= new CreateAcc();
        first.CreateAcc(login, password);


//join to db
        Connecter connect = new Connecter("atm");
        connect.startTransaction();
//join to account
        Scanner a=new Scanner(System.in);
        System.out.println("Input account id");
        int id=a.nextInt();
//Checking account
        CheckingAcc f = new CheckingAcc();
        if (f.checkAccount(id) ==false){
            //break; надо остановить весь последующий код или ввести данные еще раз
        }
//CASES
//CASES
// CASES
// CASES
        connect.endTransaction();
    }
}
