package org.example;

import javax.swing.*;
import java.awt.*;

public class Board {

    final Color BLACK = new Color(16, 134, 45);
    final Color WHITE = new Color(214, 206, 185);
    final Color INVISIBLE = new Color(0,0,0,0);

    public Board(){
        JFrame frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400, 150, 800, 800);

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

        ImageIcon blackIcon = new ImageIcon("img/black/BLACK KING .png");
        Image blackTemp = blackIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        blackIcon = new ImageIcon(blackTemp);

        ImageIcon whiteIcon = new ImageIcon("img/white/WHITE KING .png");
        Image whiteTemp = whiteIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        whiteIcon = new ImageIcon(whiteTemp);

        JButton[][] blackPieces = new JButton[2][8];
        JButton[][] whitePieces = new JButton[2][8];
        for (int i = 0; i < blackPieces.length; i++) {
            for (int j = 0; j < blackPieces[i].length; j++) {
                blackPieces[i][j] = new JButton(blackIcon);
                whitePieces[i][j] = new JButton(whiteIcon);

                blackPieces[i][j].setFocusable(false);
                blackPieces[i][j].setFocusable(false);

                blackPieces[i][j].setSize(100,100);
                whitePieces[i][j].setSize(100,100);

                blackPieces[i][j].setBackground(cells[i][j].getBackground());
                whitePieces[i][j].setBackground(cells[7 - i][j].getBackground());

                cells[i][j].add(blackPieces[i][j]);
                cells[7 - i][j].add(whitePieces[i][j]);
            }
        }

        frame.add(boardPanel);
        frame.setVisible(true);
    }
}
