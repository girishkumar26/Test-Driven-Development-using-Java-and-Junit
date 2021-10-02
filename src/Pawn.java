public class Pawn extends ChessPiece{

    public Pawn(Color color){
        this.color = color;
    }


    public String toString(){
        if (this.color == color.WHITE) {
            return "\u2659";
        }
        else {
            return "\u265F";
        }
    }
}
