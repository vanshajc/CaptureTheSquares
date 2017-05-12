package app;
import javax.swing.JFrame;

import model.Grid;
import model.IGrid;
import view.Screen;


public class Main {

	public static void main(String args[]){
		
		System.out.println("Starting...");
		
		IGrid g = new Grid(10, 10);
		Screen s = new Screen(g);
		
		JFrame f = new JFrame();
		f.add(s);
		f.setSize(Screen.WIDTH, Screen.HEIGHT);
		f.setVisible(true);
		
	}
}
