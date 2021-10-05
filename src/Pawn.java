public class Pawn extends ChessPiece{

    public Pawn(Color color){
        this.color = color;
    }

    @Override
    public boolean canTake(String from, String to, ChessBoard board) throws IllegalPositionException {
        int fromX = board.index(from, 1);
        int fromY = board.index(from, 0);

        int toX = board.index(to, 1);
        int toY = board.index(to, 0);

        int diffX = toX - fromX;
        int diffY = toY - fromY;

        if ( this.getColor() == Color.BLACK )
            return diffY == 1 && Math.abs(diffX) == 1;
        else
            return diffY == -1 && Math.abs(diffX) == 1;
    }

    @Override
    public boolean canMove(String from, String to, ChessBoard board) throws IllegalPositionException {
        int fromX = board.index(from, 1);
        int fromY = board.index(from, 0);

        int toX = board.index(to, 1);
        int toY = board.index(to, 0);

        int diffX = toX - fromX;
        int diffY = toY - fromY;

        boolean legalMove = false;
        if ( diffX <= 0 ) {
            if ( this.getColor() == Color.BLACK ){
                if ( fromY == 1 && diffY == 2 )
                    legalMove = true;
                else if ( diffY == 1)
                    legalMove = true;
            } else if ( this.getColor() == Color.WHITE ) {
                if ( fromY == 6 && diffY == -2 )
                    legalMove = true;
                else if ( diffY == -1)
                    legalMove = true;
            }
        }

        return legalMove && !board.isOccupied(to) && !board.isOccupiedBetween(from, to);

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
