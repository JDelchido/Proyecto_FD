package ConexionBaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexionBaseDatos {
    private static final String URL = "jdbc:mysql://localhost:3306/Proyecto";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection connection;

    private ConexionBaseDatos() {
    }

    public static synchronized Connection getConexion() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
}