package intbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection1 {
     public static Connection getConnectToInternetBanking() throws SQLException, ClassNotFoundException
    {
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=null;
         String url="jdbc:mysql://localhost:3306/";
         String dbName="internetbanking";
         String userName="root";
         String password="Lava";
         con=DriverManager.getConnection(url+dbName,userName, password);
         return con;
    }    
}
