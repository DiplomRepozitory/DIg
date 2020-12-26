package Components;

import javax.swing.*;
import java.awt.*;

public class LabelForGreenText extends JLabel {

    public LabelForGreenText(int x,int y) {
        setFont(new Font("Monospaced", Font.PLAIN, 24));
        setForeground(Color.GREEN);
        setBounds(x,y,58,20);
    }
}
