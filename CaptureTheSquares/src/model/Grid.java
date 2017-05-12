package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import view.Screen;


public class Grid implements IGrid{

	/** 
	 * Represents the lines between adjacent positions
	 * 0 = unoccupied, 1 = player 1, 2 = player 2 
	 */
	int[][] boardHorizontal, boardVertical;
	
	// Number of cells
	int width, height;
	
	public Grid(int width, int height){
		this.width = width;
		this.height = height;
		boardHorizontal = new int[width - 1][height - 1];
		boardVertical = new int[width -1][height -1];
		
	}
	
	@Override
	public void display(Graphics g) {
		// TODO Auto-generated method stub
		for (int i = 0; i < width; i++){
			for (int j = 0; j < height; j++){
				g.setColor(Color.GRAY);
				Dimension d = convertToPixels(i, j);
				g.fillOval(d.width, d.height, 10, 10);
				
				paintBoard(i, j, g);
				
			}
		}
		
	}
	
	private void paintBoard(int x, int y, Graphics g){
		if (x >= width - 1 || y >= height - 1 || boardHorizontal[x][y] == 0)
			return;
		Dimension d = convertToPixels(x, y);
		
		if (boardHorizontal[x][y] == 1){
			g.setColor(Color.RED);
		}
		else
			g.setColor(Color.BLUE);
		System.out.println("Drawing line from " + d);
		g.drawLine(d.width + 5, d.height + 5, d.width + 5 + Screen.WIDTH/width, d.height + 5);
		
		if (boardVertical[x][y] == 0)
			return;
		
		if (boardVertical[x][y] == 1)
			g.setColor(Color.RED);
		else
			g.setColor(Color.BLUE);
		g.drawLine(d.width, d.height, d.width, d.height + Screen.HEIGHT/height);
	}

	private Dimension convertToPixels(int i, int j){
		return new Dimension(i*Screen.WIDTH/(width) + 10, j*Screen.HEIGHT/(height) + 10);
	}
	
	private Dimension convertToGrid(int x, int y){
		return new Dimension((int)((x - 10)*width/Screen.WIDTH), (int)((y - 10)*height/Screen.HEIGHT));
	}
	
	public boolean makeMove(int x1, int y1, int x2, int y2, int player){
		Dimension d1 = convertToGrid(x1, y1);
		Dimension d2 = convertToGrid(x2, y2);
		
		if (d1.width != d2.width && d1.height != d2.height)
			return false; // Invalid move
		
		if (d1.width == d2.width){
			System.out.println("Vertical move");
			boardVertical[d1.width][d1.height] = player;
		}
		else{
			System.out.println("Horizontal move at " + d1);
			boardHorizontal[d1.width][d1.height] = player;
		}
		
		return true;
	}
	
}
