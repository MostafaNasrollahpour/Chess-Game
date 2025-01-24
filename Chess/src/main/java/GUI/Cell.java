package GUI;

import javax.swing.*;
import java.awt.*;

public class Cell extends JLabel {

    public Cell(Color color){
        this.setBackground(color);
        this.setOpaque(true);
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
