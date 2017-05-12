package view;
import java.awt.Dimension;

import javax.swing.JFrame;

import model.IGrid;


public class Screen extends JFrame{

	private static final long serialVersionUID = 1L;
	
	IGrid grid;
	
	public Screen(IGrid grid){
		this.setTitle("Capture the Squares");
		this.setLayout(null);
		this.setSize(new Dimension(400, 400));
		this.setFocusable(true);
		
		this.grid = grid;
		
		this.grid.display();
		this.setVisible(true);
	}
	
}
