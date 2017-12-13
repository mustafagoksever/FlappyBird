
package FlappyBird;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Pipe extends Image {
	
	
	private int rand,x;
	private BufferedImage image2;
	
	public Pipe()
	{
		image= ImageLoader.loadImage("/textures/toptube.png");
	
		image2= ImageLoader.loadImage("/textures/baslik.png");
		Random rnd = new Random();
     	rand= rnd.nextInt(300)+100;
	}
	
	
	

	public void setImage2(BufferedImage image2) {
		this.image2 = image2;
	}


	public BufferedImage getImage2()
	{
		return image2;
	}


	public int getRand() {
		return rand;
	}
	
	public void setRand(int rand)
	{
		this.rand=rand;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}



}
