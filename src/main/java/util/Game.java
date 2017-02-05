package util;

import java.util.Random;
import java.util.Scanner;

public class Game {

	private Board currentBoardState;
	private Integer starter;
	private int turnPlayer = -1;
	public Scanner scanner; // input position

	// Inicia os parâmetros do jogo
	public void initGame() {
		currentBoardState = new Board();
		starter = getStarterPlayer();

		// Tutorial do jogo
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
	}

	// Loop jogo
	// while (hasWinner() == false) {
	// if (turnPlayer == 0) {
	// if (playeds == 0) {
	// play(Board.COMPUTER, 5);
	// }
	//
	// turnPlayer = 1;
	// } else {
	// System.out.println("Digite a posição que deseja jogar:");
	// position = scanner.nextInt();
	// play(Board.PLAYER, position);
	//
	// turnPlayer = 0;
	// }
	//
	// playeds++;
	// }
	//
	// if (winner == 1)
	//
	// {
	// System.out.println("Você venceu!");
	// } else {
	// System.out.println("Você perdeu");
	// }
	// }

	// Define o jogador que irá começar a partida
	private int getStarterPlayer() {
		Random rnd = new Random();

		int rndNumber = rnd.nextInt(2);
		return rndNumber;
	}

	public Integer getStarter() {
		return starter;
	}
	
	public Board getCurrentBoardState() {
		return currentBoardState;
	}
}
