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
public class Creditcard {
    private int discount;
    private boolean loyaltyCard = false;

    public Creditcard(int discount, boolean loyaltyCard) {
        this.discount = discount;
        this.loyaltyCard = loyaltyCard;
    }
    

    public boolean getLoyaltyCard() {
        return loyaltyCard;
    }

    public void setLoyaltyCard(boolean loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
    }
    
    

    public int getDiscount() {
        return discount;
    }
}
