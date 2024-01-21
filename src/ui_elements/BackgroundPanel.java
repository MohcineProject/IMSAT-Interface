package ui_elements ; 

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel() {
        // Load the background image
        try {
            
			URL imageUrl =getClass().getClassLoader().getResource("Images/Space.png.png") ; // Replace with the URL or file path of your image
            backgroundImage = ImageIO.read(imageUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
