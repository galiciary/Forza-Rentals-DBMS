/**
 * Supposed to be login form for DB app but idk if I should be putting this
 * 
 * 
*/

/**
 * 
 * 
package View;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class UserLogin extends javax.swing.JFrame{
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(UserLogin.class.getName());
    // Variables //
    private javax.swing.JLabel labelAppName;
    private javax.swing.JPanel panelAppName;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JPasswordField password;
    private javax.swing.JPanel passwordPanel;
    private javax.swing.JPanel usernamePanel;
    private javax.swing.JTextField usernameText;
    
    // Creates a new form LoginFrame //

    public UserLogin(){
        initComponents();
    }

    private void initComponents() {
        Font customFont = null;
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("\\Formula1-Display-Bold-Bold\\Formula1-Bold_web_0.ttf\"")).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(customFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        panelAppName = new javax.swing.JPanel();
        labelAppName = new javax.swing.JLabel();
        usernamePanel = new javax.swing.JPanel();
        label1 = new javax.swing.JLabel();
        usernameText = new javax.swing.JTextField();
        passwordPanel = new javax.swing.JPanel();
        label2 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        buttonPanel = new javax.swing.JPanel();
        buttonLogin = new javax.swing.JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Forza Rentals");
        getContentPane().setLayout(new java.awt.GridLayout(4, 1));

        panelAppName.setLayout(new java.awt.BorderLayout());

        labelAppName.setFont(customFont);
    }
}

