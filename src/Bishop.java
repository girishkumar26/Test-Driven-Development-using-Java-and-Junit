public class Bishop extends ChessPiece{

    public Bishop(Color color){
        this.color = color;
    }


    public boolean canMove(String from, String to, ChessBoard board) throws IllegalPositionException {
        return board.isDiagonal(from, to) && super.canMove(from, to, board);
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
