package GUI;

import javax.swing.*;
import java.awt.*;

public class Board {

    JFrame frame;
    JPanel boardPanel;
    JLabel[][] cells; // all white & black cells in board

    private final Color BLACK = new Color(16, 134, 45);
    private final Color WHITE = new Color(214, 206, 185);

    Piece[] whitePawn;
    Piece[] blackPawn;

    Piece[] whiteChessMan;
    Piece[] blackChessMan;

    public Board(){
        initFrame();
        initBoard();
        initPawns();
        initChessMan();

        frame.repaint();
    }

    public void initFrame(){
        frame = new JFrame("Chess");
        frame.setBounds(100, 100, 800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var icon = new ImageIcon("img/icon.png").getImage();
        frame.setIconImage(icon);

        frame.setVisible(true);
    }

    public void initBoard(){
        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(8, 8));
        cells = new JLabel[8][8];

        int colorIndex = 0;

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new JLabel();

                if (colorIndex % 2 == 0)
                    cells[i][j].setBackground(WHITE);
                else
                    cells[i][j].setBackground(BLACK);

                cells[i][j].setOpaque(true);
                boardPanel.add(cells[i][j]);
                colorIndex++;
            }
            colorIndex++;
        }
        frame.add(boardPanel);
    }

    public void initPawns(){
        whitePawn = new Piece[8];
        blackPawn = new Piece[8];

        for (int i = 0; i < whitePawn.length; i+=2) {
            whitePawn[i] = new Piece(WHITE, "white", 10);
            whitePawn[i + 1] = new Piece(BLACK, "white", 10);

            blackPawn[i] = new Piece(BLACK, "black", 10);
            blackPawn[i + 1] = new Piece(WHITE, "black", 10);

            cells[1][i].add(blackPawn[i]);
            cells[1][i + 1].add(blackPawn[i + 1]);

            cells[6][i].add(whitePawn[i]);
            cells[6][i + 1].add(whitePawn[i + 1]);
        }

    }

    public void initChessMan(){
        whiteChessMan = new Piece[8];
        blackChessMan = new Piece[8];

        for (int i = 0; i < whiteChessMan.length; i+=2) {
            whiteChessMan[i] = new Piece(BLACK, "white", i + 1);
            whiteChessMan[i + 1] = new Piece(WHITE, "white", i + 2);

            blackChessMan[i] = new Piece(WHITE, "black", i + 1);
            blackChessMan[i + 1] = new Piece(BLACK, "black", i + 2);

            cells[0][i].add(blackChessMan[i]);
            cells[0][i + 1].add(blackChessMan[i + 1]);

            cells[7][i].add(whiteChessMan[i]);
            cells[7][i + 1].add(whiteChessMan[i + 1]);

        }

    }

    public static void main(String[] args) {
        new Board();
    }
}
