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

        PreparedStatement save_statement = connection.prepareStatement("insert into carts (first_name , last_name , bank_name , cart_number,password ,cash, cvv2) values (?,?,?,?,?,?,?)");
        Cart test_cart = new Cart();
        save_statement.setString(1,cart.getFirst_name());
        save_statement.setString(2,cart.getLast_name());
        save_statement.setString(3,cart.getBank_name());
        save_statement.setString(4,cart.getCart_number());
        save_statement.setString(5,cart.getPassword());
        save_statement.setLong(6,cart.getCash());
        save_statement.setString(7,cart.getCvv2());
        save_statement.executeUpdate();


    }
    public void saveUser(User user ) throws SQLException {

        PreparedStatement save_statement = connection.prepareStatement("insert into users (first_name , last_name ,email, cart_number ) values (?,?,?,?)");
        save_statement.setString(1,user.getFirst_name());
        save_statement.setString(2,user.getLast_name());
        save_statement.setString(3,user.getEmail());
        save_statement.setString(4,user.getCart().getCart_number());
        save_statement.executeUpdate();
    }
    public boolean isDuplicateUser(User user) throws SQLException {
        User test_user = new User(user) ;
        PreparedStatement statement = connection.prepareStatement("select * from users where exists (select * from users where (cart_number = ? and email = ? )) ");
        statement.setString(1, user.getCart().getCart_number());
        statement.setString(2, user.getEmail());
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next() ;
    }
    public void upCash(Long cash , Cart cart) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("update carts set cash = ? where cart_number = ?");
        statement.setLong(1, cash);
        statement.setString(2,cart.getCart_number());
    }
    public boolean isValidUser(String email , String password ) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select * from users where exists (select * from users join carts on users.cart_number = carts.cart_number where users.email = ? and carts.password = ?)");
        statement.setString(1, email);
        statement.setString(2, password);

        ResultSet resultSet = statement.executeQuery();
        return resultSet.next() ;
    }


}
