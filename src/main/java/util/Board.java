package util;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//TODO separar classe board e play(Criá-la)
public class Board {

	private int position;
	private int winner = -1; // FIXME verificar local correto
	private ArrayList<Integer> boardCells;
	public static final Integer EMPTY_CELL = -1;
	public static final Integer PLAYER = 1;
	public static final Integer COMPUTER = 0;

	private int cost;

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Board() {
		boardCells = new ArrayList<Integer>();
		createBoard();
	}

	public int getPosition() {
		return position;
	}

	public int getWinner() {
		return winner;
	}

	// Preenche as celulas do jogo
	private void createBoard() {
		for (int i = 0; i < 9; i++) {
			boardCells.add(EMPTY_CELL);
		}
	}

	// Seta um estado do jogo
	// onde as posições são:
	// 1 | 2 | 3
	// -- --- --
	// 4 | 5 | 6
	// -- --- --
	// 7 | 8 | 9
	public void setBoardState(int pos1, int pos2, int pos3, int pos4, int pos5, int pos6, int pos7, int pos8,
			int pos9) {
		boardCells.add(pos1);
		boardCells.add(pos2);
		boardCells.add(pos3);
		boardCells.add(pos4);
		boardCells.add(pos5);
		boardCells.add(pos6);
		boardCells.add(pos7);
		boardCells.add(pos8);
		boardCells.add(pos9);
	}

	// Imprime o tabuleiro
	public void printBoard() {
		int cell = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				if (boardCells.get(cell) == 1) {
					System.out.print("X |");
				} else if (boardCells.get(cell) == 0) {
					System.out.print("O |");
				} else {
					System.out.print("  |");
				}
				cell++;
			}
			if (boardCells.get(cell) == 1) {
				System.out.print("X");
			} else if (boardCells.get(cell) == 0) {
				System.out.print("O");
			}
			System.out.println();
			if (i < 2) {
				System.out.println("-- -- --");
			}
			cell++;
		}
	}

	// Seta a posição jogada pelo ultimo jogador
	public void setPlay(int player, int position) {
		// position - 1, por conta do index da celula
		if (boardCells.get(position - 1) >= 0) {
			System.out.println("Jogada invalida!");
		} else {
			boardCells.set(position - 1, player);
		}
	}

	// TODO melhorar implementação
	public boolean hasWinner() {

		// verificação linha 1
		if (verifyWinnerLine(boardCells.get(0), boardCells.get(1), boardCells.get(2))) {
			winner = boardCells.get(0);
		}
		// verificação linha 2
		else if (verifyWinnerLine(boardCells.get(3), boardCells.get(4), boardCells.get(5))) {
			winner = boardCells.get(3);
		}
		// verificação linha 3
		else if (verifyWinnerLine(boardCells.get(6), boardCells.get(7), boardCells.get(8))) {
			winner = boardCells.get(6);
		}
		// verificação coluna 1
		else if (verifyWinnerLine(boardCells.get(0), boardCells.get(3), boardCells.get(6))) {
			winner = boardCells.get(0);
		}
		// verificação coluna 2
		else if (verifyWinnerLine(boardCells.get(1), boardCells.get(4), boardCells.get(7))) {
			winner = boardCells.get(1);
		}
		// verificação coluna 3
		else if (verifyWinnerLine(boardCells.get(2), boardCells.get(5), boardCells.get(8))) {
			winner = boardCells.get(2);
		}
		// verificação diagonal 1
		else if (verifyWinnerLine(boardCells.get(0), boardCells.get(4), boardCells.get(8))) {
			winner = boardCells.get(0);
		}
		// verificação diagonal 2
		else if (verifyWinnerLine(boardCells.get(2), boardCells.get(4), boardCells.get(6))) {
			winner = boardCells.get(2);
		}

		if (winner >= 0) {
			return true;
		} else {
			return false;
		}
	}

	// Verifica se existe uma reta com os três números iguais
	private boolean verifyWinnerLine(int cell1, int cell2, int cell3) {
		if (cell1 == cell2 && cell2 == cell3) {
			if (cell1 != -1) {
				return true;
			} else {
				return false;
			}
		} else
			return false;
	}

	// TODO remover este método ou melhora-lo (mesmos parametros de setplay)
	public void play(int player, int position) {
		setPlay(player, position);

		System.out.println();
		System.out.println("#############");
		System.out.println();

		printBoard();
	}

	public ArrayList<Integer> getCurrentBoard() {
		return boardCells;
	}
}
