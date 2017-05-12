package model;

import java.awt.Color;
import java.awt.Graphics;

import view.Screen;


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
	public void display(Graphics g) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < width; i++){
			for (int j = 0; j < height; j++){
				g.setColor(Color.GRAY);
				g.fillOval(i*Screen.WIDTH/(width) + 10, j*Screen.HEIGHT/(height) + 10, 10, 10);
			}
		}
		
	}

}
