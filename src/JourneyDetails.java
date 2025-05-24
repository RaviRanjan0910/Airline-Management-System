
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class JourneyDetails extends JFrame {
    public JourneyDetails() {
        setTitle("Journey Details");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel custIdLabel = new JLabel("Customer ID:");
        custIdLabel.setBounds(20, 30, 100, 25);
        add(custIdLabel);

        JTextField custIdField = new JTextField();
        custIdField.setBounds(130, 30, 200, 25);
        add(custIdField);

        JLabel flightIdLabel = new JLabel("Flight ID:");
        flightIdLabel.setBounds(20, 70, 100, 25);
        add(flightIdLabel);

        JTextField flightIdField = new JTextField();
        flightIdField.setBounds(130, 70, 200, 25);
        add(flightIdField);

        JButton bookButton = new JButton("Book");
        bookButton.setBounds(130, 110, 80, 25);
        add(bookButton);

        bookButton.addActionListener(e -> {
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/AirlineDB", "root", "");
                PreparedStatement pst = con.prepareStatement("INSERT INTO booking (customer_id, flight_id, seat_number) VALUES (?, ?, ?)");
                pst.setInt(1, Integer.parseInt(custIdField.getText()));
                pst.setInt(2, Integer.parseInt(flightIdField.getText()));
                pst.setString(3, "A1");
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Flight booked successfully");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        new JourneyDetails().setVisible(true);
    }
}
