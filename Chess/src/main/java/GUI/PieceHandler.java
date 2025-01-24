package GUI;

public class PieceHandler {

    private static Cell[][] cells;

    public PieceHandler(Piece piece){

        piece.addActionListener(actionEvent -> {
            System.out.println(piece.position);
        });

    }

    public static void setCells(Cell[][] x){
        cells = x;
    }

}
