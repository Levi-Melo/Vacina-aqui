package data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/PROJETO_COVID?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "Azxs1230";

        Connection connection = DriverManager.getConnection(url,user,password);
        return connection;
    }
}
