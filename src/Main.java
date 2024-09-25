import domain.Cart;
import domain.User;
import repository.DatabaseQueries;
import service.Face;
import service.RunApp;

import java.sql.*;
import java.util.Scanner;

//import static repository.DatabaseQueries.save_cart;
import static util.Methods.generate_random_cart_cvv2;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        RunApp runApp = new RunApp();
        Face face = new Face();
        Scanner string_scanner = new Scanner(System.in);
        Scanner number_scanner = new Scanner(System.in);

        face.firstFace();
        int option = number_scanner.nextInt();
        if (option==1){
            face.signInFace();
            String email = string_scanner.next();
            String password = string_scanner.next();
            face.touchSignIn(email,password);
            face.checkSignIn(email,password);
        }
        else {
            face.signUpFace();
            String first_name = string_scanner.next();
            String last_name = string_scanner.next();
            String password = string_scanner.next();
            String bank_name = string_scanner.next();
            String email = string_scanner.next();

            String cartnumber =face.createCartNumber();
            String cvv2  =face.createCartCvv2();

            Cart cart = new Cart(first_name , last_name ,cartnumber , password , bank_name , cvv2 );
            User user = new User(email , cart);
            face.touchSignUp(cart , user);
            face.finishSignUp();
            System.out.println("finish");


        }







    }
}