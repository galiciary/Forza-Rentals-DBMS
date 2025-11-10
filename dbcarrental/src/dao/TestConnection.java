package dao;

/**
 * The {@code TestConnection} class is a simple utility for verifying
 * that the application's database connection works properly.
 * <p>
 * It attempts to establish a connection to the database using
 * {@link DBConnection#getConnection()} and then immediately closes it
 * with {@link DBConnection#closeConnection()}.
 * </p>
 *
 * <p><b>Usage:</b></p>
 * <pre>
 * // Run this class to test database connection
 * java dao.TestConnection
 * </pre>
 *
 * Expected console output:
 * <pre>
 * Database connected successfully!
 * Connection closed.
 * </pre>
 *
 * @author Galicia
 * @author Marcelino
 * @author Samarista
 * @author Sy
 * @version 1.0
 */
public class TestConnection {

    /**
     * The entry point of the program.
     * <p>
     * This method tests the database connection by calling the
     * {@code getConnection()} and {@code closeConnection()} methods
     * from the {@link DBConnection} class.
     * </p>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        DBConnection.getConnection();    // Try to connect
        DBConnection.closeConnection();  // Then close the connection
    }
}
