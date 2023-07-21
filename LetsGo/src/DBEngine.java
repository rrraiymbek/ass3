import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBEngine {
    public static final String url = "jdbc:postgresql://localhost:5432/shoping";
    public static final String user = "postgres";
    public static final String password = "1234";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
