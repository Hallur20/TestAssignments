/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import entities.Account;
import interfaces.AccountInterface;
import interfaces.CreditCardInterface;
import interfaces.DataMapperInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author hallur
 */
public class DataMapper implements DataMapperInterface {



    @Override
    public void setDataSource(DataSource dataSource) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCreditCard(CreditCardInterface creditCard) {
        try {
            Connection con = Connector.getConnection();
            PreparedStatement ps = con.prepareStatement("update 'creditcard' set "
                    + "last_used = ?, "
                    + "pin_code = ?, "
                    + "wrong_pin_code_attempts = ?"
                    + "blocked = ?"
                    + "where id = ?");
            ps.setDate(1, creditCard.getLastUsed());
            ps.setString(2, creditCard.getPinCode() + "");
            ps.setInt(3, creditCard.getWrongPinCodeAttempts());
            ps.setBoolean(4, creditCard.isBlocked());
            ps.setInt(5, creditCard.getId());
            int rs = ps.executeUpdate();
            if(rs == 0){
                System.out.println("it not found, creditcard doesnt exist?");
            } else {
                System.out.println("creditcard changed.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public CreditCardInterface getCreditCard(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAccount(AccountInterface account) {
        try {
            Connection con = Connector.getConnection();
            PreparedStatement ps = con.prepareStatement("update account set "
                    + "balance = ?"
                    + "where id = ?");
            ps.setDouble(1, account.getBalance());
            ps.setInt(2, account.getId());
            int rs = ps.executeUpdate();
            if (rs == 0) {
                System.out.println("nothing was added, id does not exist?");
            } else {
                System.out.println("account changed.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public AccountInterface getAccount(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
