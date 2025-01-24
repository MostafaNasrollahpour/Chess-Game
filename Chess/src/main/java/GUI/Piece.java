package GUI;

import javax.swing.*;
import java.awt.*;

public class Piece extends JButton {

    Position position;

    public Piece(Color color, String colorName, int id, int x, int y) {
        this.setBackground(color);

        ImageIcon icon = new ImageIcon("img/" + colorName + "/" + id + ".png");
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        this.setIcon(icon);
        this.setFocusable(false);
        this.setSize(100, 100);

        position = new Position(x, y);

    }

    private static class Position{
        int x;
        int y;
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString(){
            return "(" + this.x + ", " + this.y + ")";
        }
    }

}
