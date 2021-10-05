public class Rook extends ChessPiece{

    public Rook(Color color){
        this.color = color;
    }

    @Override
    public boolean canMove(String from, String to, ChessBoard board) throws IllegalPositionException {
        return board.isStraight(from, to) && !board.isOccupiedBetween(from, to);
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
