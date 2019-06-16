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
public interface AccountInterface {

    public void setId(int id);

    public int getId();

    public void setBalance(double balance);

    public double getBalance();

    public void deposit(double amount);

    public void withdraw(double amount);
}
