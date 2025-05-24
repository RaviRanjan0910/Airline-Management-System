
import javax.swing.*;
import java.sql.*;

public class Payment extends JFrame {
    public Payment() {
        setTitle("Payment Info");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTextArea area = new JTextArea();
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(20, 20, 350, 230);
        add(scroll);
        setLayout(null);

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/AirlineDB", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT booking.id, customer.name, flight.flight_number FROM booking " +
                                           "JOIN customer ON booking.customer_id = customer.id " +
                                           "JOIN flight ON booking.flight_id = flight.id");
            while (rs.next()) {
                area.append("Booking ID: " + rs.getInt("id") +
                            ", Customer: " + rs.getString("name") +
                            ", Flight: " + rs.getString("flight_number") + "\n");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Payment().setVisible(true);
    }
}
