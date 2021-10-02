public class Bishop extends ChessPiece{

    public Bishop(Color color){
        this.color = color;
    }


    public String toString(){
        if (this.color == color.WHITE) {
            return "\u2657";
        }
        else {
            return "\u265D";
        }
    }
}
