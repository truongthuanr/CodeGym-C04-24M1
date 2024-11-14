package configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/rental";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection=  DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("return connection");
            return connection;
        } catch (Exception e) {
            System.out.println("Exception in  getConnection()");
            System.out.println(e);
            e.printStackTrace();
            return null;

        }
    }

}
