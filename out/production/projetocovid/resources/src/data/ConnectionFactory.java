package data;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static infrastructure.GetProperties.getPropertie;

public class ConnectionFactory {
    public Connection getConection() throws SQLException, IOException {
        String url = getPropertie("db.url");
        String user =  getPropertie("db.user");
        String password =  getPropertie("db.password");

        return DriverManager.getConnection(url,user,password);
    }
}
