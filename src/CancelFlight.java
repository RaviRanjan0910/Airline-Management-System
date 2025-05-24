
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class CancelFlight extends JFrame {
    public CancelFlight() {
        setTitle("Cancel Flight");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel idLabel = new JLabel("Booking ID:");
        idLabel.setBounds(20, 30, 80, 25);
        add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(100, 30, 150, 25);
        add(idField);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(100, 70, 100, 25);
        add(cancelButton);

        cancelButton.addActionListener(e -> {
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/AirlineDB", "root", "");
                PreparedStatement pst = con.prepareStatement("DELETE FROM booking WHERE id = ?");
                pst.setInt(1, Integer.parseInt(idField.getText()));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Booking cancelled");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        new CancelFlight().setVisible(true);
    }
}
