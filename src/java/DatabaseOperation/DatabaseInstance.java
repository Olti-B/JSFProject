/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author Olti
 */

public class DatabaseInstance {

    private static Connection getConnection = null;

    public static Connection getConnection() {
        if (getConnection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                getConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/transportsystem", "root", "");
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger("connection not succes " + ex);
            }
        }
       return getConnection;
    }
    
    
}
