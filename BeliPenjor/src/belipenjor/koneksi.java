package belipenjor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ekanesa
 */
public class koneksi {
        public static Connection buatkoneks(){
        Connection cnn = null;
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/belipenjor","root","");
            
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Koneksi ke DBMS MySQL gagal");
        }
        return cnn;
    }
}
    