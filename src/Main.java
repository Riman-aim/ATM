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
//        Face face = new Face();
//        face.firstTouchFace();
        Scanner string_scanner = new Scanner(System.in);
        Scanner int_scanner = new Scanner(System.in);
        User user = new User() ;
        Cart cart = new Cart() ;
        String first_name = string_scanner.nextLine();
        String last_name = string_scanner.nextLine();
        String cart_number = runApp.CreateCartNumber();
        String bank_name = string_scanner.nextLine();
        String cvv2 = runApp.createCartCvv2();
        cart = new Cart(first_name,last_name,cart_number,bank_name,cvv2);
        runApp.signCart(cart);
    }
}