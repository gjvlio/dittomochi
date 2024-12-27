import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGamePanel extends JPanel implements ActionListener {
    private Mainframe frame;

    public StartGamePanel(Mainframe frame) {
        this.frame = frame;

        // Background color: Pastel purple
        setBackground(new Color(0xC3B1E1)); // Pastel purple

        // Set layout to null (absolute positioning)
        setLayout(null);

        // Dittomochi Title Image
        ImageIcon titleImage = new ImageIcon("resources\\dittomochi_title.png");
        JLabel titleLabel = new JLabel(titleImage);
        titleLabel.setBounds(0, 100, 600, 300); // Adjust as needed
        add(titleLabel);

        // Start Game Button
        JButton startButton = new JButton(new ImageIcon("resources\\start_button.png"));
        startButton.setBounds(200, 300, 200, 50);
        startButton.setBorder(null); // Remove border
        startButton.setContentAreaFilled(false); // Transparent background
        startButton.addActionListener(this); // Action listener for the button
        add(startButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.switchToAdoptionPanel(); // Switch to Adoption Panel
    }
}
