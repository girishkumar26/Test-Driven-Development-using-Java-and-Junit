public class Main {


    public static void main(String[] args) throws IllegalMoveException, IllegalPositionException {
        ChessBoard board = new ChessBoard();
        board.toString();
        board.initialize();
        System.out.println(board);
        board.move("a2", "a3");
        System.out.println(board);
        board.move("a1", "a8");
        System.out.println(board);
//        board.move("a1", "a2");
//        System.out.println(board);
//        board.move("a2", "a7");
//        System.out.println(board);
    }
}
