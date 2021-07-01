/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab12;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.sun.jdi.connect.spi.Connection;
import java.beans.Statement;
import javax.xml.transform.Result;


/**
 *
 * @author Thuy Linh
 */
public class ConnectSQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        var server = "LAPTOP-H4F5GCM5\\SQLEXPRESS";
        var user = "sa";
        var pass = "sa";
        var db = "QLHH";
        var port = 1433;
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(user);
        ds.setPassword(pass);
        ds.setDatabaseName(db);
        ds.setServerName(server);
        ds.setPortNumber(port);
        try (java.sql.Connection conn = ds.getConnection()) {
            System.out.println("kết nối thành công");
            System.out.println(conn.getCatalog());
            java.sql.Statement stm =  conn.createStatement();
            String sql = "SELECT MAMH,TENMH,DONGIA FROM MATHANG ";
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
