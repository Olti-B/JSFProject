/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;



public class CRUDOperationsImpl implements CRUDOperations {

    private PreparedStatement pstmt = null;
    
    @Override
    public void delete(String userName, String email, String password) {

    }

    @Override
    public void create(String firstName, String lastName, String userName, String password, String email, String city, String found) {
        try {
            pstmt = DatabaseInstance.getConnection().prepareStatement("INSERT INTO loginCredentions(firstName, lastName, userName, password, email, city, found) VALUES(?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, userName);
            pstmt.setString(4, password);
            pstmt.setString(5, email);
            pstmt.setString(6, city);
            pstmt.setString(7, found);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger("Unable too insert values" + ex);
        }

    }

    @Override
    public void update(String firstName1, String lastName1, String userName1, String password1, String email, String city1, String found1) {}

    @Override
    public boolean existInDb(String userName, String password) {
        boolean hasResultInDB = false;
        try {
            String sql = "SELECT userName, password  FROM logincredentions WHERE  userName=? and password=?";
            pstmt =  DatabaseInstance.getConnection().prepareStatement(sql);
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                hasResultInDB = true;
            }
            pstmt.close();
        } catch (SQLException ex ) {
            org.jboss.logging.Logger.getLogger("User is not in the "+ ex);
       }
        // This is to be fix because we should shut down thee connection in some way
        
        //        finally {
        //            try {
        //                if ( db.getConnection() != null) db.getConnection().close();
        //            } catch (SQLException ex) {
        //                Logger.getLogger("Unable to find addres in database"+ ex);
        //            }
        //        }
        return hasResultInDB;
       
    }
    }



