class ChessBoard{
    private ChessPiece[][] board = new ChessPiece[8][8];
    public ChessBoard(){
        initialize();
    }

    public void initialize(){
        board[0][0] = new Rook(ChessPiece.Color.WHITE);
        board[0][1] = new Knight(ChessPiece.Color.WHITE);
        board[0][2] = new Bishop(ChessPiece.Color.WHITE);
        board[0][3] = new Queen(ChessPiece.Color.WHITE);
        board[0][4] = new King(ChessPiece.Color.WHITE);
        board[0][5] = new Bishop(ChessPiece.Color.WHITE);
        board[0][6] = new Knight(ChessPiece.Color.WHITE);
        board[0][7] = new Rook(ChessPiece.Color.WHITE);
        board[1][0] = new Pawn(ChessPiece.Color.WHITE);
        board[1][1] = new Pawn(ChessPiece.Color.WHITE);
        board[1][2] = new Pawn(ChessPiece.Color.WHITE);
        board[1][3] = new Pawn(ChessPiece.Color.WHITE);
        board[1][4] = new Pawn(ChessPiece.Color.WHITE);
        board[1][5] = new Pawn(ChessPiece.Color.WHITE);
        board[1][6] = new Pawn(ChessPiece.Color.WHITE);
        board[1][7] = new Pawn(ChessPiece.Color.WHITE);

        board[7][0] = new Rook(ChessPiece.Color.BLACK);
        board[7][1] = new Knight(ChessPiece.Color.BLACK);
        board[7][2] = new Bishop(ChessPiece.Color.BLACK);
        board[7][3] = new Queen(ChessPiece.Color.BLACK);
        board[7][4] = new King(ChessPiece.Color.BLACK);
        board[7][5] = new Bishop(ChessPiece.Color.BLACK);
        board[7][6] = new Knight(ChessPiece.Color.BLACK);
        board[7][7] = new Rook(ChessPiece.Color.BLACK);
        board[6][0] = new Pawn(ChessPiece.Color.BLACK);
        board[6][1] = new Pawn(ChessPiece.Color.BLACK);
        board[6][2] = new Pawn(ChessPiece.Color.BLACK);
        board[6][3] = new Pawn(ChessPiece.Color.BLACK);
        board[6][4] = new Pawn(ChessPiece.Color.BLACK);
        board[6][5] = new Pawn(ChessPiece.Color.BLACK);
        board[6][6] = new Pawn(ChessPiece.Color.BLACK);
        board[6][7] = new Pawn(ChessPiece.Color.BLACK);
    }

    public ChessPiece getPiece(String position)throws IllegalPositionException{
        int x = index(position, 1);
        int y = index(position, 0);
//        System.out.println("+++++++++++++++++++++");
//        System.out.println(board[y][x]);
        return ( isOccupied(position) ) ? board[y][x] : null;
    }

    public boolean placePiece(ChessPiece piece, String position){return true;}

    public void move(String fromPosition, String toPosition) throws IllegalMoveException, IllegalPositionException {
        int index0 = fromPosition.charAt(0);
        int index1 = fromPosition.charAt(1);

        if(isLegalMove(getPiece(fromPosition).getColor(), fromPosition, toPosition)) {
            board[toPosition.charAt(1) - 49][toPosition.charAt(0) - 97] = board[index1 - 49][index0 - 97];
            board[index1 - 49][index0 - 97] = null;
        }else {
            throw new IllegalMoveException();
        }
    }

    public void move1(String fromPosition, String toPosition) throws IllegalMoveException, IllegalPositionException {
        int index0 = fromPosition.charAt(0);
        int index1 = fromPosition.charAt(1);
        int toindex = toPosition.charAt(1) - 49;
        int toindex1 = toPosition.charAt(0) - 97;
        System.out.println("");

//        if(board[toPosition.charAt(1) - 49][toPosition.charAt(0) - 97].getColor() == board[index1 - 49][index0 - 97].getColor()) {
            board[toPosition.charAt(1) - 49][toPosition.charAt(0) - 97] = board[index1 - 49][index0 - 97];
            board[index1 - 49][index0 - 97] = null;
//        }else {
//            throw new IllegalMoveException();
//        }
    }

     int index(String position, int i) throws IllegalPositionException {
        if ( position.length() != 2 )
            throw new IllegalPositionException(position);

        int r = (i == 1) ? position.charAt(0) - 'a' : (position.charAt(1) - 49);

        		System.out.println(position + " => " + i + "->" + r);

        if ( r < 0 || r > 7 )
            throw new IllegalPositionException(position);
        else
            return r;
    }

    boolean isStraight(String from, String to) throws IllegalPositionException{
        return ( ( index(from, 0) == index(to, 0) ) || ( index(from, 1) == index(to, 1) ) );
    }

    boolean isDiagonal(String from, String to) throws IllegalPositionException{
        return ( Math.abs( index(from, 0) - index(to, 0) ) == Math.abs( index(from, 1) - index(to, 1) ) );
    }

    private boolean isOccupied(int x, int y) {
//        System.out.println("------------------------");
//        System.out.println(x + " " + y);
//        System.out.println(board[x][y]);
        return ( board[y][x] != null );
    }

    boolean isOccupiedBetween(String from, String to) throws IllegalPositionException{
        int fromX = index(from, 1);
        int fromY = index(from, 0);

        int toX = index(to, 1);
        int toY = index(to, 0);

        int diffX = toX - fromX;
        int diffY = toY - fromY;

        int stepX = (diffX == 0) ? 0 : diffX/Math.abs(diffX);
        int stepY = (diffY == 0) ? 0 : diffY/Math.abs(diffY);

        int x = fromX + stepX;
        int y = fromY + stepY;
        while ( ( isStraight(from, to) || isDiagonal(from, to) ) && !(x == toX && y == toY) ) {
            if ( isOccupied(x, y) ) return true;
            x += stepX;
            y += stepY;
        }
        return false;
    }

    boolean isOccupied(String pos) throws IllegalPositionException {
        return isOccupied( index(pos, 1), index(pos, 0) );
    }

    boolean isLegalMove(ChessPiece.Color color, String from, String to) throws IllegalPositionException{
        if ( !isOccupied(from) )
            return false;
        System.out.println("Pass1");


        if ( !isOccupied(to) )
            return getPiece(from).canMove(from, to, this);

        System.out.println("Pass2");
        if (getPiece(to) == null){
            return true;
        }
        System.out.println("Pass3");


        if ((getPiece(from).getColor() == getPiece(to).getColor())) {
            return false;
        }

        System.out.println("Pass4");
        return getPiece(from).canTake(from, to, this);
    }

    @Override
    public String toString(){
        String chess="";
        String upperLeft = "\u250C";
        String upperRight = "\u2510";
        String horizontalLine = "\u2500";
        String horizontal3 = horizontalLine + "\u3000" + horizontalLine;
        String verticalLine = "\u2502";
        String upperT = "\u252C";
        String bottomLeft = "\u2514";
        String bottomRight = "\u2518";
        String bottomT = "\u2534";
        String plus = "\u253C";
        String leftT = "\u251C";
        String rightT = "\u2524";

        String topLine = upperLeft;
        for (int i = 0; i<7; i++){
            topLine += horizontal3 + upperT;
        }
        topLine += horizontal3 + upperRight;

        String bottomLine = bottomLeft;
        for (int i = 0; i<7; i++){
            bottomLine += horizontal3 + bottomT;
        }
        bottomLine += horizontal3 + bottomRight;
        chess+=topLine + "\n";

        for (int row = 7; row >=0; row--){
            String midLine = "";
            for (int col = 0; col < 8; col++){
                if(board[row][col]==null) {
                    midLine += verticalLine + " \u3000 ";
                } else {midLine += verticalLine + " "+board[row][col]+"\u3000";}
            }
            midLine += verticalLine;
            String midLine2 = leftT;
            for (int i = 0; i<7; i++){
                midLine2 += horizontal3 + plus;
            }
            midLine2 += horizontal3 + rightT;
            chess+=midLine+ "\n";
            if(row>=1)
                chess+=midLine2+ "\n";
        }

        chess+=bottomLine;
        return chess;
    }


}
