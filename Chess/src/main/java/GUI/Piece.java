package GUI;

import javax.swing.*;
import java.awt.*;

public class Piece extends JButton {

    public Piece(Color color, String colorName, int id) {
        this.setBackground(color);

        ImageIcon icon = new ImageIcon("img/" + colorName + "/" + id + ".png");
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        this.setIcon(icon);
        this.setFocusable(false);
        this.setSize(100, 100);

    }

}
