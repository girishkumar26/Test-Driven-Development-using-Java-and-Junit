public class Queen extends ChessPiece{

    public Queen(Color color){
        this.color = color;
    }


    public String toString(){
        if (this.color == Color.WHITE) {
            return "\u2655";
        }
        else {
            return "\u265B";
        }
    }
}
