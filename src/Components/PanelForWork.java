package Components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PanelForWork extends JPanel {
    private Image backgroundImage;

    public PanelForWork() {
        setBounds(0,100,1360,768);
        setBackground(Color.RED);
        setLayout(null);
        try {
            backgroundImage = ImageIO.read(new File("Image/ГУПС итог.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, null);
    }
}
