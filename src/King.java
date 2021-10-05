public class King extends ChessPiece{

    public King(Color color){
        this.color = color;
    }

    public boolean canMove(String from, String to, ChessBoard board) throws IllegalPositionException {
        int stepX = Math.abs(board.index(to, 1) - board.index(from, 1));
        int stepY = Math.abs(board.index(to, 0) - board.index(from, 0));
        boolean stepIsShort = (stepX  <= 1) && (stepY  <= 1);
        return stepIsShort && super.canMove(from, to, board);
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
