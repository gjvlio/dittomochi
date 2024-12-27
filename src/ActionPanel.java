import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionPanel extends JPanel {
    public ActionPanel(Mainframe frame, String actionType) {
        // Background color: Pastel purple
        setBackground(new Color(0xC3B1E1)); // Pastel purple

        // Set layout to null (absolute positioning)
        setLayout(null);

        // Action Description
        String actionMessage = "Ditto " + actionType.toLowerCase() + "!";
        JLabel actionLabel = new JLabel(actionMessage);
        actionLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
        actionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        actionLabel.setBounds(100, 50, 400, 50);
        actionLabel.setForeground(new Color(139, 69, 19)); // Brown text
        add(actionLabel);

        // Action Image (corresponding to the action)
        String imagePath = "resources\\ditto_" + actionType.toLowerCase() + ".png"; // e.g., ditto_eat.png
        ImageIcon actionImage = new ImageIcon(imagePath);
        Image actionImageScaled = actionImage.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH); // Scaled properly
        JLabel actionImageLabel = new JLabel(new ImageIcon(actionImageScaled));
        actionImageLabel.setBounds(150, 120, 300, 300); // Adjusted position and size
        add(actionImageLabel);

        // Go Back Button
        JButton goBackButton = new JButton("Back");
        goBackButton.setBounds(250, 450, 100, 50);
        goBackButton.setFont(new Font("Arial", Font.BOLD, 18));
        goBackButton.setBackground(new Color(144, 238, 144)); // Light green
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.switchToDittoHousePanel(); // Go back to DittoHouse Panel
            }
        });
        add(goBackButton);
    }
}
