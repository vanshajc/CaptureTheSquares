package model;

import java.awt.Graphics;

public interface IGrid {

	/**
	 * Displays the grid to the given screen.
	 * TODO: Need to figure out what the paramter is.
	 */
	public void display(Graphics g);
	
	/**
	 * Makes a move on the grid.
	 * @return if the move was valid
	 */
	public boolean makeMove(int x1, int y1, int x2, int y2, int player);
}
