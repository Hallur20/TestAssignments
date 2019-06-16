/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import interfaces.AccountInterface;
import interfaces.CreditCardInterface;
import java.sql.Date;



/**
 *
 * @author hallur
 */
public class CreditCard implements CreditCardInterface{
    private int id;
    private int account_id;
    private Date last_used;
    private int pin_code;
    private int wrong_pin_code_attempts;
    private boolean blocked;
    private Account account;

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setAccount(AccountInterface account) {
        this.account = new Account(account.getId(), account.getBalance());
    }

    @Override
    public AccountInterface getAccount() {
        return this.account;
    }

    @Override
    public void setLastUsed(Date lastUsed) {
        this.last_used = lastUsed;
    }

    @Override
    public Date getLastUsed() {
        return this.last_used;
    }

    @Override
    public void setPinCode(int pinCode) {
        this.pin_code = pinCode;
    }

    @Override
    public int getPinCode() {
        return this.pin_code;
    }

    @Override
    public void setWrongPinCodeAttempts(int wrongPinCodeAttempts) {
        this.wrong_pin_code_attempts = wrongPinCodeAttempts;
    }

    @Override
    public void addWrongPinCodeAttempt() {
        this.wrong_pin_code_attempts = 1;
    }

    @Override
    public int getWrongPinCodeAttempts() {
        return this.wrong_pin_code_attempts;
    }

    @Override
    public void resetWrongPinCodeAttempts() {
        this.wrong_pin_code_attempts = 0;
    }

    @Override
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    @Override
    public boolean isBlocked() {
        return this.blocked;
    }
}
