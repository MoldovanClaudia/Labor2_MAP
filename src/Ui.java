import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ui {
    private JFrame frame;

    public Ui() {
        frame = new JFrame("Laborator2_MAP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel panel = new JPanel();
        JButton CustomerButton = new JButton("Customers");
        JButton EmployeeButton = new JButton("Employee");
        JButton JobButton = new JButton("Job");
        JButton OrderButton = new JButton("Order");
        JButton ProductButton = new JButton("Product");

        CustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessageDialog("Hello, World!");
            }
        });

        panel.add(CustomerButton);
        panel.add(EmployeeButton);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
    }

    public void display() {
        frame.setVisible(true);
    }

    private void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(frame, message, "Message", JOptionPane.INFORMATION_MESSAGE);
    }
}
