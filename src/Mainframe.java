import javax.swing.*;
import java.awt.*;

public class Mainframe extends JFrame {
    private CardLayout cardLayout;
    private JPanel panelContainer;
    private String petName;

    public Mainframe() {
        setTitle("Dittomochi");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set icon and background color (your original colors and icon)
        ImageIcon icon = new ImageIcon("resources\\trans_ditto.png"); // Adjust the path to your logo
        this.setIconImage(icon.getImage());

        // Set up the CardLayout and panel container
        cardLayout = new CardLayout();
        panelContainer = new JPanel(cardLayout);
        add(panelContainer);

        // Create and add panels
        StartGamePanel startGamePanel = new StartGamePanel(this);
        AdoptionPanel adoptionPanel = new AdoptionPanel(this);
        DittoHousePanel dittoHousePanel = new DittoHousePanel(this);

        panelContainer.add(startGamePanel, "StartGame");
        panelContainer.add(adoptionPanel, "Adoption");
        panelContainer.add(dittoHousePanel, "DittoHouse");

        // Display Start Game panel initially
        cardLayout.show(panelContainer, "StartGame");
    }

    public void switchToAdoptionPanel() {
        cardLayout.show(panelContainer, "Adoption");
    }

    public void switchToDittoHousePanel() {
        // Ensure that pet name is set before switching to DittoHousePanel
        if (petName != null && !petName.isEmpty()) {
            cardLayout.show(panelContainer, "DittoHouse");
        } else {
            // Handle case where petName is null or empty
            JOptionPane.showMessageDialog(this, "Please give your Ditto a name first!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }    

    public void switchToActionPanel(String actionType) {
        ActionPanel actionPanel = new ActionPanel(this, actionType);
        panelContainer.add(actionPanel, actionType);
        cardLayout.show(panelContainer, actionType);
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetName() {
        return petName;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Mainframe frame = new Mainframe();
            frame.setVisible(true);
        });
    }
}
