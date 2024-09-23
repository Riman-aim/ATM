package util;

import domain.Cart;
import domain.User;

import java.util.Random;

public class Methods {
    public static String  generate_random_cart_number (){
        Random random = new Random();
        String [] digits = new String [12];
        for (int i = 0; i < 12; i++) {
            digits[i] = String.valueOf (random.nextInt(9) );
        }
        String answer = "" ;
        for (int i = 0; i < digits.length; i++) {
            answer += digits[i];
        }
        return answer;

    }
    public static String generate_random_cart_cvv2(){
        Random random = new Random();
        String answer = "" ;
        String [] digits = new String [4];
        for (int i = 0; i < 4; i++) {
            digits[i] = String.valueOf (random.nextInt(9) );
        }
        for (int i = 0; i < 4; i++) {
            answer += digits[i];
        }
        return answer;
    }
}
