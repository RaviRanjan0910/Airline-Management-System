
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AddCustomer extends JFrame {
    public AddCustomer() {
        setTitle("Add Customer");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 30, 80, 25);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(100, 30, 200, 25);
        add(nameField);

        JLabel passportLabel = new JLabel("Passport No:");
        passportLabel.setBounds(20, 60, 80, 25);
        add(passportLabel);

        JTextField passportField = new JTextField();
        passportField.setBounds(100, 60, 200, 25);
        add(passportField);

        JLabel nationalityLabel = new JLabel("Nationality:");
        nationalityLabel.setBounds(20, 90, 80, 25);
        add(nationalityLabel);

        JTextField nationalityField = new JTextField();
        nationalityField.setBounds(100, 90, 200, 25);
        add(nationalityField);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(100, 130, 80, 25);
        add(saveButton);

        saveButton.addActionListener(e -> {
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/AirlineDB", "root", "");
                PreparedStatement pst = con.prepareStatement("INSERT INTO customer (name, passport_number, nationality) VALUES (?, ?, ?)");
                pst.setString(1, nameField.getText());
                pst.setString(2, passportField.getText());
                pst.setString(3, nationalityField.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Customer added successfully");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        new AddCustomer().setVisible(true);
    }
}
