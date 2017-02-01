package util;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//TODO separar classe board e play(Criá-la)
public class Board {

	private Integer starter;
	private int position;
	private int winner = -1;
	private int turnPlayer = -1;
	private int playeds = 0; //FIXME remover
	private ArrayList<Integer> boardCells;
	private static final Integer EMPTY_CELL = -1;
	public static final Integer PLAYER = 1;
	public static final Integer COMPUTER = 0;
	public Scanner scanner;
	
	public Board() {
		boardCells = new ArrayList<Integer>();
		//FIXME fechar variavel scanner
		scanner = new Scanner(System.in);

		//FIXME verificar necessidade
		createBoard();
	}

	public int getPosition() {
		return position;
	}
	
	// Preenche as celulas do jogo
	private void createBoard() {
		for (int i = 0; i < 9; i++) {
			boardCells.add(EMPTY_CELL);
		}
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

	// Define o jogador que irá começar a partida
	private int getStarterPlayer() {
		Random rnd = new Random();

		int rndNumber = rnd.nextInt(2);
		return rndNumber;
	}

	// Seta a posição jogada pelo ultimo jogador
	public void setPlay(int player, int position) {
		boardCells.set(position - 1, player);
	}

	public Integer getStarter() {
		return starter;
	}

	// Inicia os parâmetros do jogo
	public void initGame() {
		createBoard();

		starter = getStarterPlayer();

		//Tutorial do jogo
		System.out.println("Você deve escolher a posição (1 à 9) do tabuleiro a ser jogada.\n");
		int count = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(count++ + " |");
			}
			System.out.println(count++);
			if (i < 2) {
				System.out.println("-- -- --");
			}
		}
		System.out.println("\n##############\n");
		
		turnPlayer = starter;
		
		//TODO ... Implementar IA
		
		//loop jogo
		while(hasWinner() == false) {
			if(turnPlayer == 0) {
				if(playeds == 0) {
					play(Board.COMPUTER, 5);
				}
				
				
				turnPlayer = 1;
			} else {
				System.out.println("Digite a posição que deseja jogar:");
				position = scanner.nextInt();
				play(Board.PLAYER, position);
				
				turnPlayer = 0;
			}
			
			playeds++;
		}
		
		System.out.println("O jogador " + winner + " venceu!");
	}

	// TODO IA
	public void computerDefense() {

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
			if(cell1 != -1) { 
				return true;
			} else {
				return false;
			}
		}
		else
			return false;
	}

	public int getWinner() {
		return winner;
	}

	// TODO remover este método ou melhora-lo (mesmos parametros de setplay)
	public void play(int player, int position) {
		setPlay(player, position);

		System.out.println();
		System.out.println("#############");
		System.out.println();

		printBoard();
	}

}
