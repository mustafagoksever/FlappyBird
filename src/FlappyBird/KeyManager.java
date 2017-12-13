package FlappyBird;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keys;
	public boolean space;
	
	
	
	public KeyManager() {
		keys = new boolean[256];
	}


	public void tick(){
		space  = keys[KeyEvent.VK_SPACE];
		
	}
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		
	}

	
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	
	public void keyTyped(KeyEvent e) {
		
	}
 
	
}
