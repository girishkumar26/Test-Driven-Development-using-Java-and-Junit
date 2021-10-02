public class Knight extends ChessPiece{

    public Knight(Color color){
        this.color = color;
    }


    public String toString(){
        if (this.color == color.WHITE) {
            return "\u2658";
        }
        else {
            return "\u265E";
        }
    }
}
