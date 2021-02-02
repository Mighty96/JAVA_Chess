import Piece.*;

public class Player {
    private String name;
    private King k1;
    private Queen q1;
    private Knight n1;
    private Knight n2;
    private Bishop b1;
    private Bishop b2;
    private Rook r1;
    private Rook r2;
    private Pawn p1;
    private Pawn p2;
    private Pawn p3;
    private Pawn p4;
    private Pawn p5;
    private Pawn p6;
    private Pawn p7;
    private Pawn p8;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
