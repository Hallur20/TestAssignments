/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author hallur
 */
public interface ATMInterface {

    public void setDataMapper(DataMapperInterface dataMapper);

    public boolean insert(CreditCardInterface creditCard, int pincode) throws Exception;

    public void eject();

    public boolean deposit(double amount) throws Exception;

    public boolean withdraw(double amount) throws Exception;

    public double balance() throws Exception;
}
