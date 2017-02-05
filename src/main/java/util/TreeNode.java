package util;

import java.util.ArrayList;

public class TreeNode {
	private ArrayList<Board> childs;
	private int cost;
	
	public TreeNode(int cost) {
		this.cost = cost;
		childs = new ArrayList<Board>();
	}
	
	public int getCost() {
		return cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public ArrayList<Board> getChilds() {
		return childs;
	}

	public boolean isLeaf() {
		return childs.isEmpty();
	}
	//TODO Percorrer arvore
}
