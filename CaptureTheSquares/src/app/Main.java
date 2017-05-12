package app;
import view.Screen;
import model.Grid;
import model.IGrid;


public class Main {

	public static void main(String args[]){
		
		System.out.println("Starting...");
		
		IGrid g = new Grid(10, 10);
		Screen s = new Screen(g);
		
	}
}