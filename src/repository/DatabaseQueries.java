package repository;


import domain.Cart;
import domain.User;

import java.sql.*;

import static util.Methods.generate_random_cart_cvv2;
import static util.Methods.generate_random_cart_number;

public class DatabaseQueries {
    static Connection connection  = null ;

    public DatabaseQueries() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/databaseinit", "root", "javad1384");
    }


    public Boolean checkForNotExistenceOfCartNumber (String number  ) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select * from carts where exists (select cart_number from carts where cart_number = ?)");
        statement.setString(1, number);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next() ;
    }


    public void save_cart(Cart cart) throws SQLException {

        PreparedStatement save_statement = connection.prepareStatement("insert into carts (first_name , last_name , bank_name , cart_number , cvv2) values (?,?,?,?,?)");
        Cart test_cart = new Cart();
        save_statement.setString(1,cart.getFirst_name());
        save_statement.setString(2,cart.getLast_name());
        save_statement.setString(3,cart.getBank_name());
        save_statement.setString(4,cart.getCart_number());
        save_statement.setString(5,cart.getCvv2());
        save_statement.executeUpdate();


    }
    public void saveUser(User user ) throws SQLException {
        User test_user = new User();
        PreparedStatement save_statement = connection.prepareStatement("inset into users (first_name , last_name ,cart_number, cart_number ) values (?,?,?,?)");
        save_statement.setString(1,test_user.getFirst_name());
        save_statement.setString(2,test_user.getLast_name());
        save_statement.setString(3,test_user.getEmail());
        save_statement.setString(4,test_user.getCart().getCart_number());
    }
    public boolean isDuplicateUser(User user) throws SQLException {
        User test_user = new User(user) ;
        PreparedStatement statement = connection.prepareStatement("select * from users where exists (select * from users where (cart_number = ? and email = ? )) ");
        statement.setString(1, user.getCart().getCart_number());
        statement.setString(2, user.getEmail());
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next() ;
    }


}
