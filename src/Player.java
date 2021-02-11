import javax.swing.*;

public class Player {
    private String name;
    private Piece[] pieces = new Piece[16];

    public Player(String name, int num) {
        this.name = name;
        if (num == 1) {
            pieces[0] = new Piece(8, 4, "King", 1, 0);
            pieces[1] = new Piece(8, 5, "Queen", 1, 1);
            pieces[2] = new Piece(8, 2, "Knight", 1, 2);
            pieces[3] = new Piece(8, 7, "Knight", 1, 3);
            pieces[4] = new Piece(8, 3, "Bishop", 1, 4);
            pieces[5] = new Piece(8, 6, "Bishop", 1, 5);
            pieces[6] = new Piece(8, 1, "Rook", 1, 6);
            pieces[7] = new Piece(8, 8, "Rook", 1, 7);
            pieces[8] = new Piece(7, 1, "Pawn", 1, 8);
            pieces[9] = new Piece(7, 2, "Pawn", 1, 9);
            pieces[10] = new Piece(7, 3, "Pawn", 1, 10);
            pieces[11] = new Piece(7, 4, "Pawn", 1, 11);
            pieces[12] = new Piece(7, 5, "Pawn", 1, 12);
            pieces[13] = new Piece(7, 6, "Pawn", 1, 13);
            pieces[14] = new Piece(7, 7, "Pawn", 1, 14);
            pieces[15] = new Piece(7, 8, "Pawn", 1, 15);
        } else {
            pieces[0] = new Piece(1, 4, "King", 2, 0);
            pieces[1] = new Piece(1, 5, "Queen", 2, 1);
            pieces[2] = new Piece(1, 2, "Knight", 2, 2);
            pieces[3] = new Piece(1, 7, "Knight", 2, 3);
            pieces[4] = new Piece(1, 3, "Bishop", 2, 4);
            pieces[5] = new Piece(1, 6, "Bishop", 2, 5);
            pieces[6] = new Piece(1, 1, "Rook", 2, 6);
            pieces[7] = new Piece(1, 8, "Rook", 2, 7);
            pieces[8] = new Piece(2, 1, "Pawn", 2, 8);
            pieces[9] = new Piece(2, 2, "Pawn", 2, 9);
            pieces[10] = new Piece(2, 3, "Pawn", 2, 10);
            pieces[11] = new Piece(2, 4, "Pawn", 2, 11);
            pieces[12] = new Piece(2, 5, "Pawn", 2, 12);
            pieces[13] = new Piece(2, 6, "Pawn", 2, 13);
            pieces[14] = new Piece(2, 7, "Pawn", 2, 14);
            pieces[15] = new Piece(2, 8, "Pawn", 2, 15);
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Piece[] getPieces() {
        return pieces;
    }

    public void setPieces(Piece[] pieces) {
        this.pieces = pieces;
    }


}
