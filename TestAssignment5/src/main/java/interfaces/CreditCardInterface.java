/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.Date;


/**
 *
 * @author hallur
 */
public interface CreditCardInterface {

    public void setId(int id);

    public int getId();

    public void setAccount(AccountInterface account);

    public AccountInterface getAccount();

    public void setLastUsed(Date lastUsed);

    public Date getLastUsed();

    public void setPinCode(int pinCode);

    public int getPinCode();

    public void setWrongPinCodeAttempts(int wrongPinCodeAttempts);

    public void addWrongPinCodeAttempt();

    public int getWrongPinCodeAttempts();

    public void resetWrongPinCodeAttempts();

    public void setBlocked(boolean blocked);

    public boolean isBlocked();
}
