public class Main {


    public static void main(String[] args) throws IllegalMoveException {
        ChessBoard board = new ChessBoard();
        board.toString();
        board.initialize();
        System.out.println(board);
        board.move("a2", "b7");
        System.out.println(board);
//        board.move("a8", "a2");
//        System.out.println(board);
//        board.move("a1", "a2");
//        System.out.println(board);
//        board.move("a2", "a7");
//        System.out.println(board);
    }
}
