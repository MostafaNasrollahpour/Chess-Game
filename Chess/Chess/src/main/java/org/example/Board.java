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

        JLabel[] Cells = new JLabel[64];
        for (int i = 0; i < Cells.length; i++) {
            Cells[i] = new JLabel();
            if(colorIndex % 2 == 0){
                Cells[i].setBackground(WHITE);
            }else{
                Cells[i].setBackground(BLACK);
            }
            if((i + 1) % 8 != 0)
                colorIndex++;
            Cells[i].setOpaque(true);
            boardPanel.add(Cells[i]);
        }

        frame.add(boardPanel);
        frame.setVisible(true);
    }
}
