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
	int[][] boardHorizontal, boardVertical, captured;

	// Number of cells
	int width, height;

	public Grid(int width, int height){
		this.width = width;
		this.height = height;
		boardHorizontal = new int[width - 1][height - 1];
		boardVertical = new int[width -1][height -1];
		captured = new int[width - 1][height - 1];
		
//		boardHorizontal[0][0] = 1;
//		//boardVertical[0][0] = 1;
//		boardHorizontal[0][1] = 1;
//		boardVertical[1][0] = 1;
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
		if (x >= width - 1 || y >= height - 1)
			return;

		Dimension d = convertToPixels(x, y);

		paintCapturedSquares(x, y, g);

		if (boardHorizontal[x][y] == 1){
			g.setColor(Color.RED);
		}
		else if (boardHorizontal[x][y] == 2)
			g.setColor(Color.BLUE);
		
		if (boardHorizontal[x][y] != 0){
			//System.out.println("Drawing line from " + d);
			g.fillRect(d.width + 3, d.height + 3, Screen.WIDTH/width, 5);
		}
		
		if (boardVertical[x][y] == 0)
			return;

		if (boardVertical[x][y] == 1)
			g.setColor(Color.RED);
		else
			g.setColor(Color.BLUE);
		g.fillRect(d.width + 3, d.height + 3, 5, Screen.HEIGHT/height);

	}

	private void paintCapturedSquares(int i, int j, Graphics g){
		if (captured[i][j] == 0)
			return;
		Dimension d = convertToPixels(i, j);
		if (captured[i][j] == 1)
			g.setColor(Color.RED);
		else
			g.setColor(Color.BLUE);
		g.fillRect(d.width + 10, d.height + 10, Screen.WIDTH/width - 10, Screen.HEIGHT/height - 10);
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
			boardVertical[d1.width][d1.height] = player;
			System.out.println("Vertical");
		}
		else{
			boardHorizontal[d1.width][d1.height] = player;
		}

		System.out.println("Performed move at: "+d1);
		System.out.println("Check 1");
		// Check if all four lines have been captured.
		if (isBlockedHoriz(d1.width, d1.height + 1) && isBlockedVert(d1.width + 1, d1.height) 
				&& isBlockedHoriz(d1.width, d1.height) && isBlockedVert(d1.width, d1.height)){
			// If so, then square is captured.
			System.out.println("CAPTURED");
			captured[d1.width][d1.height] = player;
		}
		System.out.println("Check 1");
		if (isBlockedHoriz(d1.width, d1.height - 1) && isBlockedVert(d1.width + 1, d1.height - 1) 
				&& isBlockedHoriz(d1.width, d1.height) && isBlockedVert(d1.width, d1.height - 1)){
			// If so, then square is captured.
			System.out.println("CAPTURED");
			captured[d1.width][d1.height - 1] = player;
		}
		System.out.println("Check 1");
		if (isBlockedHoriz(d1.width - 1, d1.height) && isBlockedVert(d1.width - 1, d1.height) 
				&& isBlockedHoriz(d1.width - 1, d1.height + 1) && isBlockedVert(d1.width, d1.height)){
			// If so, then square is captured.
			System.out.println("CAPTURED");
			captured[d1.width - 1][d1.height] = player;
		}
//		System.out.println("Check 1");
//		if (isBlockedHoriz(d1.width, d1.height - 1) && isBlockedVert(d1.width - 1, d1.height) 
//				&& isBlockedHoriz(d1.width, d1.height) && isBlockedVert(d1.width, d1.height)){
//			// If so, then square is captured.
//			System.out.println("CAPTURED");
//			captured[d1.width - 1][d1.height - 1] = player;
//		}

		return true;
	}

	private boolean isBlockedHoriz(int i, int j){
		if (i < 0 || i >= width || j < 0 || j >= height)
			return false;
		System.out.println("Horizontal at " + i + ", "+j + ": " + boardHorizontal[i][j]);
		return boardHorizontal[i][j]!=0;
	}
	private boolean isBlockedVert(int i, int j){
		if (i < 0 || i >= width || j < 0 || j >= height)
			return false;
		System.out.println("Vertical at " + i + ", "+j + ": " + boardVertical[i][j]);
		return boardVertical[i][j]!=0;
	}


}
