package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Handler implements MouseListener {

    private static Cell[][] cells;

    public Handler(){

    }


    public Handler(Piece piece){

        piece.addActionListener(actionEvent -> {
            System.out.println(piece.position);
        });

    }

    public static void setCells(Cell[][] x){
        cells = x;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        Cell cell = (Cell) mouseEvent.getSource();
        System.out.println(cell.position);
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
