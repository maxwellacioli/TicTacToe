package util;

import java.util.ArrayList;
import java.util.Random;

public class Board {

	private ArrayList<Integer> boardCells;
	private static final Integer EMPTY_CELL = -1;
	private static final Integer PLAYER = 1;
	private static final Integer COMPUTER = 0;

	public void createBoard() {
		boardCells = new ArrayList<Integer>();

		for (int i = 0; i < 9; i++) {
			boardCells.add(EMPTY_CELL);
		}
	}

	// TODO Remover a impressao do valor vazio (-1)
	public void printBoard() {
		int cell = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				if (boardCells.get(cell) >= 0) {
					System.out.print(boardCells.get(cell) + " |");
				} else {
					System.out.print("  |");
				}
				cell++;
			}
			if (boardCells.get(cell) >= 0) {
				System.out.print(boardCells.get(cell));
			}
			System.out.println();
			if (i < 2) {
				System.out.println("-- -- --");
			}
		}
	}

	public int getStarterPlayer() {
		Random rnd = new Random();

		int rndNumber = rnd.nextInt(2);
		return rndNumber;
	}
}
