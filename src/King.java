public class King extends ChessPiece{

    public King(Color color){
        this.color = color;
    }


    public String toString(){
        if (this.color == color.WHITE) {
            return "\u2654";
        }
        else {
            return "\u265A";
        }
    }
}
