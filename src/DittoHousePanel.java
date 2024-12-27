import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DittoHousePanel extends JPanel {
    public DittoHousePanel(Mainframe frame) {
        // Background color: Pastel purple
        setBackground(new Color(0xC3B1E1)); // Pastel purple

        // Set layout to null (absolute positioning)
        setLayout(null);

        // Ditto Image at the center
        ImageIcon dittoImage = new ImageIcon("resources\\trans_ditto.png");
        Image dittoScaled = dittoImage.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH); // Scaled properly
        JLabel dittoLabel = new JLabel(new ImageIcon(dittoScaled));
        dittoLabel.setBounds(150, 100, 300, 300); // Adjusted position and size
        add(dittoLabel);

        // Display pet name at the top
        String petName = frame.getPetName(); // Get the pet name from Mainframe
        if (petName != null && !petName.isEmpty()) {
            JLabel actionLabel = new JLabel("What should " + petName + " do?");
            actionLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
            actionLabel.setHorizontalAlignment(SwingConstants.CENTER);
            actionLabel.setBounds(100, 50, 400, 50);
            actionLabel.setForeground(new Color(139, 69, 19)); // Brown text
            add(actionLabel);
        } else {
            // Handle error or show a default message if name is missing
            JLabel actionLabel = new JLabel("What should your Ditto do?");
            actionLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
            actionLabel.setHorizontalAlignment(SwingConstants.CENTER);
            actionLabel.setBounds(100, 50, 400, 50);
            actionLabel.setForeground(new Color(139, 69, 19)); // Brown text
            add(actionLabel);
        }

        // Eat Button with custom icon
        JButton eatButton = new JButton();
        ImageIcon eatIcon = new ImageIcon("resources\\eat.png");
        Image eatScaled = eatIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Scale to 50x50 pixels
        eatButton.setIcon(new ImageIcon(eatScaled)); // Set the scaled image as the button's icon
        eatButton.setBounds(50, 400, 150, 150); 
        eatButton.setBorder(null); // Remove border
        eatButton.setContentAreaFilled(false); // Transparent background
        eatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.switchToActionPanel("Eat"); // Switch to Eat Panel
            }
        });
        add(eatButton);

        // Bath Button with custom icon
        JButton bathButton = new JButton();
        ImageIcon bathIcon = new ImageIcon("resources\\bath.png");
        Image bathScaled = bathIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Scale to 50x50 pixels
        bathButton.setIcon(new ImageIcon(bathScaled)); // Set the scaled image as the button's icon
        bathButton.setBounds(225, 400, 150, 150); 
        bathButton.setBorder(null); // Remove border
        bathButton.setContentAreaFilled(false); // Transparent background
        bathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.switchToActionPanel("Bath"); // Switch to Bath Panel
            }
        });
        add(bathButton);

        // Sleep Button with custom icon
        JButton sleepButton = new JButton();
        ImageIcon sleepIcon = new ImageIcon("resources\\sleep.png");
        Image sleepScaled = sleepIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Scale to 50x50 pixels
        sleepButton.setIcon(new ImageIcon(sleepScaled)); // Set the scaled image as the button's icon
        sleepButton.setBounds(400, 400, 150, 150); 
        sleepButton.setBorder(null); // Remove border
        sleepButton.setContentAreaFilled(false); // Transparent background
        sleepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.switchToActionPanel("Sleep"); // Switch to Sleep Panel
            }
        });
        add(sleepButton);
    }
}
