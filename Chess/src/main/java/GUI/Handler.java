package GUI;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Handler implements MouseListener {

    private static Cell[][] cells;
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

    public static void setComponents(Cell[][] x, JFrame y){
        cells = x;
        frame = y;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (pressed){
            pressed = false;
            Cell cell = (Cell) mouseEvent.getSource();

            int x = piecePressed.position.getX();
            int y = piecePressed.position.getY();
            cells[x][y].remove(piecePressed);


            x = cell.position.getX();
            y = cell.position.getY();

            piecePressed.setBackground(cells[y][x].getBackground());
            cells[y][x].add(piecePressed);


            frame.repaint();
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
