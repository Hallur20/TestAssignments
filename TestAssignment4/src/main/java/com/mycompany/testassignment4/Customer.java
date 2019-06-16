/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testassignment4;

/**
 *
 * @author hallur
 */
public class Customer {

    private String name;
    private Creditcard creditCard;
    private Account account;
    private boolean coupon = false;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Creditcard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(Creditcard creditCard) {
        this.creditCard = creditCard;
    }

    public boolean isCoupon() {
        return coupon;
    }

    public void setCoupon(boolean coupon) {
        this.coupon = coupon;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
    
    
    

    public void purchaseCreditcard() {
        if (getCreditCard() == null) {
            System.out.println("you are buying a new credit card and account. 15% discounts today (coupons can't be used for new customers)");
            creditCard = new Creditcard(15, false);
            setAccount(new Account(0.00));
            return;
        }
        if (getCreditCard().getLoyaltyCard() == true && coupon == false) {
            System.out.println("you are replacing a loyalty credit card. 10% discount. ");
            creditCard = new Creditcard(10, false);
            return;
        }
        if (getCreditCard().getLoyaltyCard() == true && coupon == true) {
            System.out.println("you are replacing a loyalty credit card. 10% discount. Added 20% with coupon ");
            creditCard = new Creditcard(30, false);
            return;
        }
        if (getCreditCard().getLoyaltyCard() == false && coupon == true) {
            System.out.println("you are replacing a credit card. 20% discount with coupon ");
            creditCard = new Creditcard(20, false);
        }

    }

    public static void main(String[] args) {
        Customer c = new Customer("Hallur");
        c.setCoupon(true);
        c.purchaseCreditcard();
        c.purchaseCreditcard();
    }
}
