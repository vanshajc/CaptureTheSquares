package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

import model.IGrid;
import controller.MouseController;


public class Screen extends JPanel implements Runnable{

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 400, HEIGHT = 500;

	public IGrid grid;

	private Thread thread;
	private boolean running = false;

	public Screen(IGrid grid){
		//this.setTitle("Capture the Squares");
		this.setLayout(null);
		this.setSize(new Dimension(WIDTH, HEIGHT));
		this.setFocusable(true);
		//this.setBackground(new Color(10, 150, 250));
		this.setBackground(Color.WHITE);
		this.grid = grid;

		this.addMouseListener(new MouseController(grid));
		
		this.setVisible(true);

		this.start();
	}

	@Override
	public void run()
	{
		while (running){
			tick();
			repaint();
		}

	}
	private void start(){
		running = true;
		thread = new Thread(this,"Game Loop");
		thread.start();

	}
	public void stop(){
		try
		{
			running = false;
			thread.join();
		} catch (InterruptedException ex)
		{
			Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void tick(){
		// Do nothing.
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g){
		this.grid.display(g);
	}
	

}
