package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
     
/**
 * The {@code UserLogin} class represents the graphical user interface (GUI)
 * for the staff login screen of the Forza Car Rental system.
 * <p>
 * It allows staff members to enter their Staff ID and Password, initiating
 * authentication handled by the Controller layer.
 * </p>
 * <p>
 * This class is part of the View layer (V in MVC). It focuses purely on
 * user interaction and delegates authentication logic to the controller.
 * </p>
 *
 * @author Galicia
 * @author Marcelino
 * @author Samarista
 * @author Sy
 * @version 1.0
 */
public class UserLogin extends JFrame {

    /** Logger instance for this class. */
    private static final Logger logger = Logger.getLogger(UserLogin.class.getName());

    /** Text field for entering staff ID. */
    private JTextField idField;

    /** Password field for entering password. */
    private JPasswordField passwordField;

    /** Button to trigger the login action. */
    private JButton loginButton;

    /**
     * Constructs a new {@code UserLogin} window and initializes components.
     */
    public UserLogin() {
        initComponents();
        centerFrame();
    }

    /**
     * Initializes and arranges all UI components for the login form.
     * <p>
     * Uses {@code GridBagLayout} for flexible layout management and applies
     * basic styling to labels, fields, and buttons.
     * </p>
     */
    private void initComponents() {

        // --- Frame Settings ---
        setTitle("Forza Rentals Staff Login");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridBagLayout());

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            logger.log(Level.WARNING, "Nimbus LookAndFeel not available, using default.", e);
        }

        // --- Component Initialization ---
        JLabel idLabel = new JLabel("Staff ID:");
        JLabel passwordLabel = new JLabel("Password:");
        idField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");

        // --- Styling ---
        Font labelFont = new Font("Segoe UI", Font.BOLD, 14);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 14);

        idLabel.setFont(labelFont);
        passwordLabel.setFont(labelFont);
        idField.setFont(fieldFont);
        passwordField.setFont(fieldFont);

        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        loginButton.setBackground(new Color(30, 144, 255)); // Dodger Blue
        loginButton.setForeground(Color.WHITE);

        // --- Layout Configuration ---
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Row 1: Staff ID
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        add(idLabel, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        add(idField, gbc);

        // Row 2: Password
        gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = GridBagConstraints.EAST;
        add(passwordLabel, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        add(passwordField, gbc);

        // Row 3: Login Button
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(loginButton, gbc);

        // Action Listener
        loginButton.addActionListener(this::loginActionPerformed);

        pack(); // Resize to fit components
    }

    /**
     * Centers the frame on the user's screen.
     */
    private void centerFrame() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(
                dim.width / 2 - this.getSize().width / 2,
                dim.height / 2 - this.getSize().height / 2
        );
    }

    /**
     * Handles the {@code Login} button action.
     * <p>
     * This method currently performs basic validation and contains a
     * placeholder for real authentication logic.
     * </p>
     *
     * @param evt the {@link ActionEvent} triggered when the login button is clicked.
     */
    private void loginActionPerformed(ActionEvent evt) {
        String staffId = idField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (staffId.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter both Staff ID and Password.",
                    "Input Error",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // --- Placeholder Logic (To be replaced with DB authentication) ---
        boolean isAuthenticated = staffId.startsWith("STF");

        if (isAuthenticated) {
            JOptionPane.showMessageDialog(
                    this,
                    "Login Successful! Welcome, Staff ID: " + staffId,
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );
            this.dispose();
            // TODO: Open dashboard (e.g., new Dashboard().setVisible(true))
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Authentication Failed. Invalid Staff ID or Password.",
                    "Access Denied",
                    JOptionPane.ERROR_MESSAGE
            );
            passwordField.setText("");
        }
    }
}