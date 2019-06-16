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
public class ATM {
    private Account account;
    
    

    public void deposit(int amount, Account account) {
      account.setBalance(account.getBalance()+amount);
    }

    public void withdraw(int amount, Account account) {
        account.setBalance(account.getBalance()-amount);
    }

    public void showBalance() {

    }

    public void showMonthlyInterestRate() {

    }

    public void showYearlyInterestRate() {

    }

    public void insert(Customer customer) {

    }

    public void extract(Customer customer) {

    }
}
