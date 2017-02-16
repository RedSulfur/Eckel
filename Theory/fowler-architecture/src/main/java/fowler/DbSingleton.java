package fowler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSingleton {

    private static final String URL = "jdbc:postgresql://localhost:5432/edudb";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private static DbSingleton instance;

    private Connection conn;

    private DbSingleton() {}

    public static DbSingleton getInstance() {
        if(instance == null) instance = new DbSingleton();
        return instance;
    }

    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
