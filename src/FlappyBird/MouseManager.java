package FlappyBird;


import java.awt.event.*;

public class MouseManager implements MouseListener,MouseMotionListener{

	private boolean left,right;
	
	
	public MouseManager()
	{
	
		
		
	}
	
	
	
	public boolean isLeft() {
		return left;
	}



	public void setLeft(boolean left) {
		this.left = left;
	}



	public boolean isRight() {
		return right;
	}



	public void setRight(boolean right) {
		this.right = right;
	}



	




	public void mouseClicked(MouseEvent e) {
		
		
		
	}


	public void mouseEntered(MouseEvent e) {
		
		
	}


	public void mouseExited(MouseEvent e) {
		
		
	}


	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			left=true;
		else if(e.getButton() == MouseEvent.BUTTON3)
			right=true;
		
	}


	public void mouseReleased(MouseEvent e) {
		
		if(e.getButton() == MouseEvent.BUTTON1)
			left=false;
		else if(e.getButton() == MouseEvent.BUTTON3)
			right=false;
		
	}


	public void mouseDragged(MouseEvent e) {
		
		
	}

	
	public void mouseMoved(MouseEvent e) {
		
		
	}
	

}
