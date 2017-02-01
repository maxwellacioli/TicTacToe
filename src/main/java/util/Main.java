package util;

public class Main {
	public static void main(String[] args) {
		Board board = new Board();
		board.initGame();
		board.printBoard();

		board.setPlay(Board.COMPUTER, 5);

		System.out.println();
		System.out.println("#############");
		System.out.println();

		board.printBoard();

		board.setPlay(Board.PLAYER, 9);

		System.out.println();
		System.out.println("#############");
		System.out.println();

		board.printBoard();
	}
}
