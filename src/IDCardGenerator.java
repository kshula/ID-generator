import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IDCardGenerator extends JFrame {
    private JTextField nameField;
    private JTextField departmentField;
    private JTextField idNumberField;
    private JLabel cardDisplay;

    public IDCardGenerator() {
        // Setting up the frame
        setTitle("ID Card Generator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creating the main panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        // Adding components to the panel
        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Department:"));
        departmentField = new JTextField();
        panel.add(departmentField);

        panel.add(new JLabel("ID Number:"));
        idNumberField = new JTextField();
        panel.add(idNumberField);

        JButton generateButton = new JButton("Generate ID Card");
        panel.add(generateButton);

        cardDisplay = new JLabel();
        cardDisplay.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(cardDisplay);

        // Add action listener to the button
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateIDCard();
            }
        });

        // Adding the panel to the frame
        add(panel);

        // Making the frame visible
        setVisible(true);
    }

    private void generateIDCard() {
        String name = nameField.getText();
        String department = departmentField.getText();
        String idNumber = idNumberField.getText();

        String idCardInfo = "<html><body style='text-align: center;'>" +
                            "<h1>ID Card</h1>" +
                            "<p><strong>Name:</strong> " + name + "</p>" +
                            "<p><strong>Department:</strong> " + department + "</p>" +
                            "<p><strong>ID Number:</strong> " + idNumber + "</p>" +
                            "</body></html>";

        cardDisplay.setText(idCardInfo);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new IDCardGenerator();
            }
        });
    }
}
