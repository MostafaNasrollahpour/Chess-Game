package GUI;

import javax.swing.*;
import java.awt.*;

public class Cell extends JLabel {

    Position position;

    public Cell(Color color, int x, int y){
        this.setBackground(color);
        this.setOpaque(true);
        position = new Position(x, y);
    }

}
