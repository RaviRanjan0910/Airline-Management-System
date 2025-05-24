
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame {
    public Login() {
        setTitle("Airline Management System - Login");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        
        JLabel title = new JLabel("Login", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(100, 20, 200, 30);
        add(title);
        
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 70, 80, 25);
        add(userLabel);
        
        JTextField userText = new JTextField();
        userText.setBounds(150, 70, 180, 25);
        add(userText);
        
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 110, 80, 25);
        add(passLabel);
        
        JPasswordField passText = new JPasswordField();
        passText.setBounds(150, 110, 180, 25);
        add(passText);
        
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 160, 100, 30);
        add(loginButton);

        loginButton.addActionListener(e -> {
            String user = userText.getText();
            String pass = new String(passText.getPassword());
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/AirlineDB", "root", "");
                PreparedStatement pst = con.prepareStatement("SELECT * FROM user WHERE username=? AND password=?");
                pst.setString(1, user);
                pst.setString(2, pass);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    new Dashboard().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Credentials", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }
}
