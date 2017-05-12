package model;


public class Grid implements IGrid{

	/** 
	 * Represents the lines between adjacent positions
	 * 0 = unoccupied, 1 = player 1, 2 = player 2 
	 */
	int[][] board;
	
	// Number of cells
	int width, height;
	
	public Grid(int width, int height){
		this.width = width;
		this.height = height;
		board = new int[width][height];
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
