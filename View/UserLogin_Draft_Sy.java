/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author JUSTIN
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserLogin_Draft_Sy extends JFrame {

    private static final Logger logger = Logger.getLogger(UserLogin_Draft_Sy.class.getName());

    private JTextField idField;
    private JPasswordField passwordField;
    private JButton loginButton;
    
    /**
     * Creates new form UserLogin
     */
    public UserLogin_Draft_Sy() {
        initComponents();
        centerFrame();
    }

    // Method to initialize and layout components
    private void initComponents() {
        
        // --- Frame Settings ---
        setTitle("Forza Rentals Staff Login");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridBagLayout()); 
        
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
             logger.log(Level.WARNING, "Nimbus L&F not available, using default.", e);
        }
        
        //Components Initialization
        JLabel idLabel = new JLabel("Staff ID:");
        JLabel passwordLabel = new JLabel("Password:");
        idField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");

        //Styling
        Font labelFont = new Font("Segoe UI", Font.BOLD, 14);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 14);
        
        idLabel.setFont(labelFont);
        passwordLabel.setFont(labelFont);
        idField.setFont(fieldFont);
        passwordField.setFont(fieldFont);
        
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        loginButton.setBackground(new Color(30, 144, 255)); // Dodger Blue
        loginButton.setForeground(Color.WHITE);
        
        //Layout using GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 

        //Row 1: Staff ID Label and Field
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        add(idLabel, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        add(idField, gbc);

        //Row 2: Password Label and Field
        gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = GridBagConstraints.EAST;
        add(passwordLabel, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        add(passwordField, gbc);

        //Row 3: Login Button
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; 
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL; 
        add(loginButton, gbc);
        
        //Action Listener
        loginButton.addActionListener(this::loginActionPerformed);
        
        pack(); //Resize the frame to fit components
    }
    
    private void centerFrame() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2);
    }

    /**
     * Handles the login button click event.
     * NOTE: This method contains the placeholder for the authentication logic.
     */
    private void loginActionPerformed(ActionEvent evt) {
        String staffId = idField.getText().trim();
        String password = new String(passwordField.getPassword());
        
        // TODO: This is where we will add the call to your DAO (e.g., StaffRecord.java) 
        // to authenticate the staffId and password against the database.
        
        if (staffId.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both Staff ID and Password.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // --- START Placeholder for Logic ---
        boolean isAuthenticated = false; // Assume failure until authentication is performed

        // For testing only
        if (staffId.startsWith("STF")) { 
            isAuthenticated = true; // Temporary success for UI test
        }
        // --- END Placeholder for Logic ---

        if (isAuthenticated) {
            JOptionPane.showMessageDialog(this, "Login Successful! Welcome, Staff ID: " + staffId, "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose(); 
            // TODO: Open main application Dashboard here (e.g., new Dashboard().setVisible(true);)
        } else {
            JOptionPane.showMessageDialog(this, "Authentication Failed. Invalid Staff ID or Password.", "Access Denied", JOptionPane.ERROR_MESSAGE);
            passwordField.setText("");
        }
    }

   
    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new UserLogin_Draft_Sy().setVisible(true));
    }
}
