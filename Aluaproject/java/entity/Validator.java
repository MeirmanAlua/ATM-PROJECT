package entity;

public class Validator { // create class Validator

    public static boolean validateCardNumber(long cardNUmber) // method validateCardNumber to identify  type of card
    {
        long visa = cardNUmber/1000000000; // visa should be divisible to this number
        if (visa == 4) { // if id starts from 4
            System.out.println("VISA"); //it will print VISA
        }
        else if(visa == 5) { // If id starts from 5
            System.out.println("MASTERCARD"); // it will print MASTERCARD
        }
        else{
            System.out.println("Invalid card number"); // other cases, return  false with this statement
            return false;
        }
        return true;
    }
}
