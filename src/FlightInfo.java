
import javax.swing.*;
import java.sql.*;

public class FlightInfo extends JFrame {
    public FlightInfo() {
        setTitle("Flight Info");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTextArea area = new JTextArea();
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(20, 20, 450, 230);
        add(scroll);
        setLayout(null);

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/AirlineDB", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM flight");
            while (rs.next()) {
                area.append("Flight: " + rs.getString("flight_number") +
                            ", From: " + rs.getString("origin") +
                            ", To: " + rs.getString("destination") +
                            ", Date: " + rs.getDate("date") + "\n");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FlightInfo().setVisible(true);
    }
}
