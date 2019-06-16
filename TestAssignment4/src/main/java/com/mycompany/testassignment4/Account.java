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
public class Account {

    private Customer customer;
    private Double balance;
    private int monthlyInterest;
    private int yearlyInterest;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    
    
    public Account(Double balance) {
        this.balance = balance;
    }

    public int getMonthlyInterest() {
        if (getBalance() >= 0 && getBalance() <= 100) {
            return 3;
        }
        if (getBalance() > 100 && getBalance() <= 1000) {
            return 5;
        }
        if(getBalance() > 1000){
            return 7;
        }
        return 0;
    }

}
