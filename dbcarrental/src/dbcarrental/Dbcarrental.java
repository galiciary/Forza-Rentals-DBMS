package dbcarrental;

import view.UserLogin;

/**
 * The {@code Dbcarrental} class serves as the main entry point of the Forza Car Rental system.
 * <p>
 * It initializes the application and launches the {@code UserLogin} interface.
 * </p>
 *
 * @author Galicia
 * @author Marcelino
 * @author Samarista
 * @author Sy
 * @version 1.0
 */
public class Dbcarrental {

    /**
     * The main method that starts the Car Rental System.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new UserLogin().setVisible(true));
    }
}
