/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hallur
 */
public class Connector {
    public static Connection getConnection() throws SQLException{
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment_5", "root", "123");
    return con;
    }
}
