package util;

import java.util.ArrayList;

public class TreeNode {
	private ArrayList<TreeNode> childs;
	private Integer cost;
	private Board nodeBoardState;
	
	public TreeNode(Integer cost, Board nodeBoardState) {
		this.cost = cost;
		this.nodeBoardState = nodeBoardState;
		childs = new ArrayList<TreeNode>();
	}
	
	public Board getNodeBoardState() {
		return nodeBoardState;
	}
	
	public void setNodeBoardState(Board nodeBoardState) {
		this.nodeBoardState = nodeBoardState;
	}
	
	public Integer getCost() {
		return cost;
	}
	
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
	public ArrayList<TreeNode> getChilds() {
		return childs;
	}

	public boolean isLeaf() {
		return childs.isEmpty();
	}
	
	public void addChild(TreeNode child) {
		childs.add(child);
	}
	
	//TODO Percorrer arvore
}
