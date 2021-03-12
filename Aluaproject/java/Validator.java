package entity;

public class Validator {

    public static boolean validateCardNumber(int cardNUmber)
    {
        int visa = cardNUmber/10000000;
        if (visa == 4) {
            System.out.println("VISA");
        }
        else if(visa == 5) {
            System.out.println("MASTERCARD");
        }
        else{
            System.out.println("Invalid card number");
            return false;
        }
        return true;
    }
}
