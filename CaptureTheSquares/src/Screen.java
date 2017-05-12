import java.awt.Dimension;

import javax.swing.JFrame;


public class Screen extends JFrame{

	Screen(){
		this.setTitle("Capture the Squares");
		this.setLayout(null);
		this.setSize(new Dimension(400, 400));
		this.setFocusable(true);
		
		this.setVisible(true);
	}
	
}
