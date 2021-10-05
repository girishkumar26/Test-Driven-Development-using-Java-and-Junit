abstract class ChessPiece {
    protected ChessBoard board;
    public enum Color {WHITE, BLACK}
    protected int row;
    protected int column;
    protected Color color;
    public ChessPiece(){

    }

    public ChessPiece(ChessBoard board, Color color){
    }

    public ChessPiece getPiece(String position) {
        return null;
    }

    public boolean canTake(String from, String to, ChessBoard board) throws IllegalPositionException {
        return this.canMove(from, to, board);
    }

    public String getPosition(){return null;}


    public Color getColor(){ return  this.color;}

    public boolean canMove(String from, String to, ChessBoard board) throws IllegalPositionException{
        return this.canMove(from, to, board);
    }

    public void setPosition(String position){}

    abstract public String toString();

}
