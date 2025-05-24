
import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {
    public Dashboard() {
        setTitle("Dashboard - Airline Management System");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JLabel header = new JLabel("Airline Management Dashboard", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(header, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        String[] buttons = {"Add Customer", "View Flights", "Book Flight", "Cancel Flight", "Payments", "Logout"};
        for (String btn : buttons) {
            JButton button = new JButton(btn);
            button.setFont(new Font("Arial", Font.PLAIN, 16));
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Dashboard().setVisible(true));
    }
}
