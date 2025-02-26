package GUI;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Handler implements MouseListener {

    private static Cell[][] cells;
    private static ArrayList<Cell> emptyCells;
    private static boolean pressed = false;
    private static Piece piecePressed;
    private static JFrame frame;
    private static boolean isWhiteTurn = true;

    public Handler(){

    }
    public Handler(Piece piece){

        piece.addActionListener(actionEvent -> {
            if (!pressed){
                if(isWhiteTurn && piece.isWhite){
                    piecePressed = piece;
                    pressed = true;
                    isWhiteTurn = false;
                }else if(!isWhiteTurn && !piece.isWhite){
                    piecePressed = piece;
                    pressed = true;
                    isWhiteTurn = true;
                }
            }
        });

    }

    public static void setComponents(Cell[][] x,ArrayList<Cell> y, JFrame z){
        cells = x;
        emptyCells = y;
        frame = z;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (pressed){
            pressed = false;
            Cell cell = (Cell) mouseEvent.getSource();

            int x = piecePressed.position.getX();
            int y = piecePressed.position.getY();
            cells[x][y].remove(piecePressed);
            emptyCells.add(cells[y][x]);

            x = cell.position.getX();
            y = cell.position.getY();

            piecePressed.setBackground(cells[y][x].getBackground());
            piecePressed.updatePosition(x, y);
            cells[y][x].add(piecePressed);
            emptyCells.remove(cells[y][x]);

            frame.repaint();
            for(var dklj: emptyCells){
                System.out.println(dklj.position);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
