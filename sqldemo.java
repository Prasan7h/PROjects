package sql;




import java.sql.*;
public class sqldemo {
public static void main(String[] args)throws ClassNotFoundException,SQLException {
    try
    {
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    Connection con=DriverManager.getConnection("jdbc:sqlserver://192.168.134.164:1433;databaseName=db177;encrypt=true;trustServerCertificate=true","user177","db177");
    System.out.println("Connected successfully....");
    }
    
    catch(SQLException sql)
    {
        System.out.println(sql);
    }
}
}


