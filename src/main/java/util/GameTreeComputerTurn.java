package util;

import java.util.ArrayList;

//O computador é o primeiro a jogar!
public class GameTreeComputerTurn {
	private TreeNode root;
	private Game game;
	private Board boardAux;
	
	public GameTreeComputerTurn() {
		root = new TreeNode(1);
		game = new Game();
		boardAux = new Board();
	}
	
	private void createTree() {
		root.getChilds().add(boardAux);
	}
	
	public TreeNode getGameTreeComputerTurn() {
		return root;
	}
	
}
