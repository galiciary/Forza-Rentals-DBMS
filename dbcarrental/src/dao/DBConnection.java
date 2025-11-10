package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The {@code DBConnection} class provides methods for establishing and managing
 * a connection to a MySQL database using JDBC.
 * <p>
 * This class uses the Singleton pattern to ensure that only one instance
 * of a database connection is created and reused throughout the application.
 * </p>
 *
 * <p><b>Example usage:</b></p>
 * <pre>
 * Connection conn = DBConnection.getConnection();
 * // use the connection
 * DBConnection.closeConnection();
 * </pre>
 *
 * @author Galicia
 * @author Marcelino
 * @author Samarista
 * @author Sy
 * @version 1.0
 */
public class DBConnection {
    /** The JDBC URL for connecting to the MySQL database. */
    private static final String URL = "jdbc:mysql://localhost:3306/dbcarrentals";

    /** The MySQL username used for authentication. */
    private static final String USER = "root";

    /** The MySQL password used for authentication. */
    private static final String PASSWORD = "Angcutenijen0leejang__";

    /** A static {@link Connection} instance to ensure a single active connection. */
    private static Connection connection = null;

    /**
     * Establishes a connection to the database if one does not already exist.
     * <p>
     * If the connection has already been established, the existing connection
     * is returned. Otherwise, a new connection is created using the defined
     * JDBC URL, username, and password.
     * </p>
     *
     * @return a {@link Connection} object to the MySQL database,
     *         or {@code null} if the connection attempt fails.
     */
    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Database connected successfully!");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Database connection failed: " + e.getMessage());
            }
        }
        return connection;
    }

    /**
     * Closes the active database connection if it exists and is open.
     * <p>
     * This method ensures that system resources are properly released.
     * </p>
     */
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}
