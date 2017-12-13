package FlappyBird;

import java.awt.image.BufferedImage;

public class Medal extends Image {

	private BufferedImage image2,image3;
	
	public Medal()
	{
		image=ImageLoader.loadImage("/textures/medal_bronze.png");

		image2=ImageLoader.loadImage("/textures/medal_silver.png");

		image3=ImageLoader.loadImage("/textures/medal_gold.png");
		
		
	}
	public BufferedImage getImage() {
		return image;
	}

	public BufferedImage getImage2() {
		return image2;
	}

	public BufferedImage getImage3() {
		return image3;
	}
	
	
}
