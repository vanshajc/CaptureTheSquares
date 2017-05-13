package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.IGrid;

public class MouseController implements MouseListener{

	IGrid g;
	int startX, startY;
	
	public MouseController(IGrid g){
		this.g = g;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse Pressed at: "+e.getX()+", "+e.getY());
		startX = e.getX();
		startY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse Released at: "+e.getX()+", "+e.getY());
		g.makeMove(startX, startY, e.getX(), e.getY(), 1);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
