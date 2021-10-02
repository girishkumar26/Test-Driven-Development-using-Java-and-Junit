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

    public String getPosition(){return null;}


    public Color getColor(){ return  this.color;}

    public void setPosition(String position){}

    abstract public String toString();

}
