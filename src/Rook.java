public class Rook extends ChessPiece{

    public Rook(Color color){
        this.color = color;
        this.board = board;
    }

    public boolean isValidMove(){
        this.getPosition();
        return true;
    }

    public String toString(){
        if (this.color == Color.WHITE) {
            return "\u2656";
        }
        else {
            return "\u265C";
        }
    }
}
