/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.sql.DataSource;

/**
 *
 * @author hallur
 */
public interface DataMapperInterface {
public void setDataSource(DataSource dataSource);
public void setCreditCard(CreditCardInterface creditCard);
public CreditCardInterface getCreditCard(int id);
public void setAccount(AccountInterface account);
public AccountInterface getAccount(int id);
}
