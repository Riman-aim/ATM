package service;

import domain.Cart;
import domain.User;

import java.sql.SQLException;

public class Face {
    RunApp runApp ;

    public Face() throws SQLException {
        runApp = new RunApp();
    }

    public void firstFace(){
        System.out.println("welcome to ATM . \n 1:sign in \n 2:sign up  ");

    }
    public void signUpFace(){
        System.out.println("for sign up u should enter a couple of information . first of all you have to create a cart then a user the an account . ");

    }
    public void signInFace(){
        System.out.println("enter your email then yor password for cart . ");
    }
    public void touchSignIn(String email , String password) throws SQLException {
        runApp.signIn(email , password);
    }
    public void touchSignUp(Cart cart , User user ) throws SQLException {
        runApp.signUp(cart , user);
    }

    public void runAfterSignIn(){

    }
    public String createCartNumber () throws SQLException {
        return runApp.CreateCartNumber();
    }
    public String createCartCvv2 () throws SQLException {
        return  runApp.createCartCvv2();
    }
    public void finishSignUp() {
        System.out.println("you have successfully finished the sign up u have to sign in now .");
    }
    public void checkSignIn(String email , String password) throws SQLException {
        if (runApp.canEnterUser(email , password)) System.out.println("welcome");
        else System.out.println("u have entered either invalid info or u may sign in first ");
    }
}
