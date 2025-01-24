package GUI;

import javax.swing.*;
import java.awt.*;

public class Piece extends JButton {

    Position position;
    boolean isWhite;

    public Piece(Color color, String colorName, int id, int x, int y) {
        this.setBackground(color);

        isWhite = colorName.equals("white");

        ImageIcon icon = new ImageIcon("img/" + colorName + "/" + id + ".png");
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        this.setIcon(icon);
        this.setFocusable(false);
        this.setSize(100, 100);

        position = new Position(x, y);

    }

}
