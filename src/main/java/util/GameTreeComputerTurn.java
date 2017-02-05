package util;

//O computador é o primeiro a jogar!
public class GameTreeComputerTurn {
	private TreeNode root;
	private TreeNode nodeAux;
	private Game game;
	private Board boardAux;

	public GameTreeComputerTurn() {
		boardAux = new Board();
		nodeAux = new TreeNode(null, null);
		root = new TreeNode(1, boardAux);
		game = new Game();
	}

	private void createTree() {
		boardAux.setBoardState(Board.EMPTY_CELL, Board.EMPTY_CELL, Board.EMPTY_CELL, Board.EMPTY_CELL, Board.COMPUTER,
				Board.EMPTY_CELL, Board.EMPTY_CELL, Board.EMPTY_CELL, Board.EMPTY_CELL);

		nodeAux = new TreeNode(1, boardAux);
		root.addChild(nodeAux);

		boardAux.setBoardState(Board.PLAYER, Board.EMPTY_CELL, Board.EMPTY_CELL, Board.EMPTY_CELL, Board.COMPUTER,
				Board.EMPTY_CELL, Board.EMPTY_CELL, Board.EMPTY_CELL, Board.EMPTY_CELL);
		
		nodeAux.setCost(0);
		nodeAux.setNodeBoardState(boardAux);
		
		root.getChilds().get(0).addChild(nodeAux);
		
		boardAux.setBoardState(Board.PLAYER, Board.EMPTY_CELL, Board.EMPTY_CELL, Board.EMPTY_CELL, Board.COMPUTER,
				Board.EMPTY_CELL, Board.EMPTY_CELL, Board.EMPTY_CELL, Board.EMPTY_CELL);
		
		nodeAux.setCost(0);
		nodeAux.setNodeBoardState(boardAux);
		
		boardAux.setBoardState(Board.EMPTY_CELL, Board.PLAYER, Board.EMPTY_CELL, Board.EMPTY_CELL, Board.COMPUTER,
				Board.EMPTY_CELL, Board.EMPTY_CELL, Board.EMPTY_CELL, Board.EMPTY_CELL);
		
		nodeAux.setCost(0);
		nodeAux.setNodeBoardState(boardAux);
	}

	public TreeNode getGameTreeComputerTurn() {
		return root;
	}

}
