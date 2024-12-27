import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdoptionPanel extends JPanel implements ActionListener {
    private Mainframe frame;
    private JTextField nameField;

    public AdoptionPanel(Mainframe frame) {
        this.frame = frame;

        // Background color: Pastel purple
        setBackground(new Color(0xC3B1E1)); // Pastel purple

        // Set layout to null (absolute positioning)
        setLayout(null);

        // Title Label
        JLabel titleLabel = new JLabel("You've adopted a Ditto!");
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(100, 50, 400, 50);
        titleLabel.setForeground(new Color(139, 69, 19)); // Brown text
        add(titleLabel);

        // Ditto Image
        ImageIcon dittoImage = new ImageIcon("resources\\trans_ditto.png");
        Image dittoScaled = dittoImage.getImage().getScaledInstance(240, 240, Image.SCALE_SMOOTH); // Scaled properly
        JLabel dittoLabel = new JLabel(new ImageIcon(dittoScaled));
        dittoLabel.setBounds(180, 120, 240, 240);
        add(dittoLabel);

        // Name Field Label
        JLabel nameLabel = new JLabel("Enter your Ditto's name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        nameLabel.setBounds(180, 370, 240, 30);
        add(nameLabel);

        // Name Input Field
        nameField = new JTextField();
        nameField.setBounds(180, 400, 240, 40);
        add(nameField);

        // Adopt Button
        JButton adoptButton = new JButton("Adopt");
        adoptButton.setBounds(250, 460, 100, 50);
        adoptButton.setFont(new Font("Arial", Font.BOLD, 18));
        adoptButton.setBackground(new Color(255, 223, 186));
        adoptButton.addActionListener(this); // Action listener for the button
        add(adoptButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String petName = nameField.getText().trim();
        if (!petName.isEmpty()) {
            frame.setPetName(petName); // Set the pet name in Mainframe
            System.out.println("Pet name set to: " + petName);  // Debugging line to ensure the name is being set
            frame.switchToDittoHousePanel(); // Switch to DittoHouse Panel
        } else {
            JOptionPane.showMessageDialog(this, "Give your new ditto a name!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
