/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import entities.Account;
import interfaces.ATMInterface;
import interfaces.CreditCardInterface;
import interfaces.DataMapperInterface;
import mysql.DataMapper;

/**
 *
 * @author hallur
 */
public class ATM implements ATMInterface {

    DataMapper dm;

    @Override
    public void setDataMapper(DataMapperInterface dataMapper) {
        this.dm = (DataMapper) dataMapper;
    }

    @Override
    public boolean insert(CreditCardInterface creditCard, int pincode) throws Exception {
        if (creditCard.getPinCode() == pincode) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void eject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deposit(double amount) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean withdraw(double amount) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double balance() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
