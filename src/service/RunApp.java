package service;

import domain.Cart;
import domain.User;
import repository.DatabaseQueries;

import java.sql.SQLException;

import static util.Methods.generate_random_cart_cvv2;
import static util.Methods.generate_random_cart_number;

public class RunApp {
    DatabaseQueries databaseQueries=null ;
    public RunApp() throws SQLException {
        databaseQueries = new DatabaseQueries() ;
    }


    public String CreateCartNumber() throws SQLException {

        while (true){
            String cart_number = generate_random_cart_number();
            if (!databaseQueries.checkForNotExistenceOfCartNumber(cart_number)){
                return cart_number;
            }

        }
    }
    public String createCartCvv2(){
        return generate_random_cart_cvv2();
    }

    public void initUser(){

    }
    public void signUp(Cart cart , User user ) throws SQLException {
        this.signCart(cart);
        this.signUser(user);
    }
    public void signIn() throws SQLException {

    }


    public void signUser(User user  ) throws SQLException {
        if (canInitUser(user))
            databaseQueries.saveUser(user);

        else
            throw new RuntimeException("this user information is duplicated .");
    }


    private boolean canInitUser(User user ) throws SQLException {
        if (!databaseQueries.isDuplicateUser(user))
            return true ;
        return false ;
    }

    public void signCart(Cart cart ) throws SQLException {
        databaseQueries.save_cart(cart);
    }


}
