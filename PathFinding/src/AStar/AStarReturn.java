package AStar;

import java.util.ArrayList;
import java.util.PriorityQueue;

import Components.Block;
import Components.BlockComparator;

public class AStarReturn {
	ArrayList<Block> selected ;
	PriorityQueue<Block> explored ;
	public ArrayList<Block> getSelected() {
		return selected;
	}
	public void setSelected(ArrayList<Block> selected) {
		this.selected = selected;
	}
	public PriorityQueue<Block> getExplored() {
		return explored;
	}
	public void setExplored(PriorityQueue<Block> explored) {
		this.explored = explored;
	}
	
	public AStarReturn(ArrayList<Block> selected, PriorityQueue<Block> explored) {
		super();
		this.selected = selected;
		this.explored = explored;
	}
}
