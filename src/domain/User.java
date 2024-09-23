package domain;

public class User {
    private int id ;
    private String first_name ;
    private String last_name ;
    private String email ;
    Cart cart ;

    public User(int id,  String email, Cart cart) {

        this.first_name = cart.getFirst_name();
        this.last_name = cart.getLast_name();
        this.email = email;
        this.cart = cart;

    }
    public User(){

    }
    public User (User user ){
        this.first_name = user.getFirst_name();
        this.last_name = user.getLast_name();
        this.email = user.getEmail();
        this.cart = user.getCart();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }


}
