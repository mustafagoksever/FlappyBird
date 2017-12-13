package FlappyBird;

import java.awt.image.BufferedImage;

public class highscore extends Image{
	private int num,elde,kalan;
	private BufferedImage image1,image2,image3,image4,image5,image6,image7,image8,image9;
	
	public highscore()
	{
		elde=0;
		kalan=0;
		num=0;
		image=ImageLoader.loadImage("/textures/font_big_0.png");

		image1=ImageLoader.loadImage("/textures/font_big_1.png");

		image2=ImageLoader.loadImage("/textures/font_big_2.png");

		image3=ImageLoader.loadImage("/textures/font_big_3.png");

		image4=ImageLoader.loadImage("/textures/font_big_4.png");

		image5=ImageLoader.loadImage("/textures/font_big_5.png");

		image6=ImageLoader.loadImage("/textures/font_big_6.png");

		image7=ImageLoader.loadImage("/textures/font_big_7.png");

		image8=ImageLoader.loadImage("/textures/font_big_8.png");

		image9=ImageLoader.loadImage("/textures/font_big_9.png");
	}
	
	public int getNum(){
		
		return num;
		
	}
	
	

	public BufferedImage getImage1() {
		return image1;
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

	public BufferedImage getImage5() {
		return image5;
	}

	public BufferedImage getImage6() {
		return image6;
	}

	public BufferedImage getImage7() {
		return image7;
	}

	public BufferedImage getImage8() {
		return image8;
	}

	public BufferedImage getImage9() {
		return image9;
	}

	public void arttir()
	{
		
		num++;
	}
	public void sifirla()
	{
		num=0;
	}
	public int getElde()
	{
		return elde;
	}
	public int  getKalan()
	{
		return kalan;
	}
	public void setElde(int elde)
	{
		this.elde=elde;
	}
	public void setKalan(int kalan)
	{
		this.kalan=kalan;
	
	}
}
