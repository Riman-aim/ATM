package domain;

import java.util.Date;

public class Cart {
    private String first_name ;
    private String last_name ;
    private String cart_number ;
    private String password ;
    private String bank_name ;
    private String cvv2 ;
    private Long cash ;

    public Cart(String first_name, String last_name, String cart_number,String password, String bank_name, String cvv2) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.cart_number = cart_number;
        this.password = password;
        this.bank_name = bank_name;
        this.cvv2 = cvv2;
        this.cash = 0L;
    }
    public Cart(){}

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getCart_number() {
        return cart_number;
    }

    public void setCart_number(String cart_number) {
        this.cart_number = cart_number;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getCash() {
        return cash;
    }

    public void setCash(Long cash) {
        this.cash = cash;
    }
}
