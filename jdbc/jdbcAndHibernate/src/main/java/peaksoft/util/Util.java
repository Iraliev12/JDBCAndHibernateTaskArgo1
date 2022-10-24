package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String user = "java7";
    private static final String password = "1234";
    private static  final String url ="jdbc:postgresql://localhost:5432/java7";
    public static Connection connect() {
        Connection conn=null;
        try {
            conn = DriverManager. getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully." );
        } catch (SQLException e) {
            System. out.println(e.getMessage()) ;
        }
        return conn;
    }

}
