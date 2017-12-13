package FlappyBird;

import java.awt.image.BufferedImage;

public class Bird extends Image{

	
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;
	
	private int x,y;
	
	
	public Bird()
	{
		super();
		image=ImageLoader.loadImage("/textures/bird-0.png");
		image2=ImageLoader.loadImage("/textures/bird-1.PNG");
		image3=ImageLoader.loadImage("/textures/bird-2.PNG");
		image4=ImageLoader.loadImage("/textures/bird-3.PNG");
		
		y=300;
		
		x=100;
		
	}




	public BufferedImage getImage2() {
		return image2;
	}




	public BufferedImage getImage3() {
		return image3;
	}




	public BufferedImage getImage4() {
		return image4;
	}




	public int getX() {
		return x;
	}




	public void setX(int x) {
		this.x = x;
	}




	public int getY() {
		return y;
	}




	public void setY(int y) {
		this.y = y;
	}




	public void setImage2(BufferedImage image2) {
		this.image2 = image2;
	}




	public void setImage3(BufferedImage image3) {
		this.image3 = image3;
	}




	public void setImage4(BufferedImage image4) {
		this.image4 = image4;
	}
	
	
	
	
	
}
