package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Board implements MouseListener, ActionListener {

    final Color BLACK = new Color(16, 134, 45);
    final Color WHITE = new Color(214, 206, 185);
    final Image MAIN_ICON = new ImageIcon("img/icon.png").getImage();

    JPanel boardPanel;
    JLabel[][] cells; // this is the white and black cells in board
    JButton[][] blackPieces;
    JButton[][] whitePieces;

    boolean pressed_piece = false;

    public Board(){
        JFrame frame = new JFrame("Chess");
        frame.setIconImage(MAIN_ICON);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400, 150, 800, 800);

        boardPanel = new JPanel();
        boardPanel.setBounds(0,0,500,500);
        boardPanel.setLayout(new GridLayout(8,8));

        setCells();
        setPieces();

        frame.add(boardPanel);
        frame.setVisible(true);
    }

    private void setCells(){
        int colorIndex = 0;

        cells = new JLabel[8][8];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new JLabel();
                if (colorIndex % 2 == 0)
                    cells[i][j].setBackground(WHITE);
                else
                    cells[i][j].setBackground(BLACK);

                cells[i][j].setOpaque(true);

                cells[i][j].addMouseListener(this);

                boardPanel.add(cells[i][j]);
                colorIndex++;
            }
            colorIndex++;
        }
    }

    private void setPieces(){
        blackPieces = new JButton[2][8];
        whitePieces = new JButton[2][8];

        for (int i = 0; i < blackPieces.length; i++) {
            for (int j = 0; j < blackPieces[i].length; j++) {
                blackPieces[i][j] = new JButton();
                whitePieces[i][j] = new JButton();

                blackPieces[i][j].setFocusable(false);
                whitePieces[i][j].setFocusable(false);

                blackPieces[i][j].setSize(100, 100);
                whitePieces[i][j].setSize(100, 100);

                blackPieces[i][j].setBackground(cells[i][j].getBackground());
                whitePieces[i][j].setBackground(cells[7 - i][j].getBackground());

                blackPieces[i][j].addActionListener(this);
                whitePieces[i][j].addActionListener(this);

                cells[i][j].add(blackPieces[i][j]);
                cells[7 - i][j].add(whitePieces[i][j]);
            }
        }

        ImageIcon blackIcon = null;
        Image blackTemp = null;

        ImageIcon whiteIcon = null;
        Image whiteTemp = null;

        for (int i = 0; i < 16; i++) {
            if(i < 8){
                blackIcon = new ImageIcon("img/black/" + (i + 1) + ".png");
                whiteIcon = new ImageIcon("img/white/" + (i + 1) + ".png");
            }else{
                blackIcon = new ImageIcon("img/black/10.png");
                whiteIcon = new ImageIcon("img/white/10.png");
            }
            blackTemp = blackIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            whiteTemp = whiteIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

            blackIcon = new ImageIcon(blackTemp);
            whiteIcon = new ImageIcon(whiteTemp);

            blackPieces[i / 8][i % 8].setIcon(blackIcon);
            whitePieces[i / 8][i % 8].setIcon(whiteIcon);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(pressed_piece){
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {

                    if(e.getSource() == cells[i][j]){
                        pressed_piece = !pressed_piece;
                        cells[i][j].setBackground(new Color(138, 21, 21));
                    }

                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!pressed_piece){
            for (int i = 0; i < blackPieces.length; i++) {
                for (int j = 0; j < blackPieces[i].length; j++) {

                    if(e.getSource() == blackPieces[i][j] || e.getSource() == whitePieces[i][j]){
                        pressed_piece = !pressed_piece;
                    }

                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
