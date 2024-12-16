package org.example;

import javax.swing.*;
import java.awt.*;

public class Board {

    final Color BLACK = new Color(16, 134, 45);
    final Color WHITE = new Color(214, 206, 185);

    public Board(){
        JFrame frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);

        JPanel boardPanel = new JPanel();
        boardPanel.setBounds(0,0,500,500);
        boardPanel.setLayout(new GridLayout(8,8));
        
        int colorIndex = 0;

        JLabel[][] cells = new JLabel[8][8];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new JLabel();
                if (colorIndex % 2 == 0)
                    cells[i][j].setBackground(WHITE);
                else
                    cells[i][j].setBackground(BLACK);

                colorIndex++;
                cells[i][j].setOpaque(true);
                boardPanel.add(cells[i][j]);
            }
            colorIndex++;
        }

        frame.add(boardPanel);
        frame.setVisible(true);
    }
}
