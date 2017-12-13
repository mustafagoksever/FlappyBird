
package FlappyBird;
import java.awt.image.*;
import java.util.*;
import java.awt.*;


public class Game implements Runnable {

		
        private Display display;
        public int width,height;
        public String title;
        
        private Thread thread;
        private boolean running=false;
        
        private BufferStrategy bs;
        private Graphics g;
       

        private Pipe pipe1,pipe2;
        private highscore num;
        private Background background;
        private Bird bird;
        private Gameover gameover;
        private Foreground foreground;
       
        private KeyManager keyManager;
        private MouseManager mouseManager;
        public boolean dead;
        public boolean isstart;
        private Start start;
        private Medal medal;
        
        
        private int a=0; // animasyonlar icin
         
        public int lastscore=0;
        private int  bestScore=0;
        
        
   public Game(String title,int width,int height)
    {
        
        this.height=height;
        this.width=width;
        this.title=title;
        keyManager = new KeyManager();
        mouseManager= new MouseManager();
        bird= new Bird();
    	start= new Start();
    	gameover=  new Gameover();
    	num= new highscore();
    	pipe1= new Pipe();
    	pipe2= new Pipe();
    	foreground = new Foreground();    	
    	background = new Background();
    	medal = new Medal();
    	
    }

    private void init(){
    	
    	display=new Display(title,width,height);
    	display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
    	display.getFrame().addMouseMotionListener(mouseManager);
    	display.getCanvas().addMouseListener(mouseManager);
    	display.getCanvas().addMouseMotionListener(mouseManager);
    	pipe1.setX(800);
    	pipe2.setX(1250);
        dead= false;
        isstart=false;
        
    }
    private void collision()
   {
	   if(num.getNum()>bestScore)
   		bestScore=num.getNum();
   	
   	    Rectangle rectBird = new Rectangle(bird.getX(),bird.getY(),50,36);
   	    Rectangle rectPipe1up = new Rectangle(pipe1.getX(),width-pipe1.getRand(),100,pipe1.getRand());
   	    Rectangle rectPipe1down = new Rectangle(pipe1.getX(),0,100,width-pipe1.getRand()-150);
   	    Rectangle rectPipe2up = new Rectangle(pipe2.getX(),width-pipe2.getRand(),100,pipe2.getRand());
   	    Rectangle rectPipe2down = new Rectangle(pipe2.getX(),0,100,width-pipe2.getRand()-150);
   	    
   	    if (rectBird.intersects(rectPipe1up)||rectBird.intersects(rectPipe2up)||rectBird.intersects(rectPipe1down)||rectBird.intersects(rectPipe2down))
   	    {
   	    	//if(isstart)
   	    	//	isstart=false;
   	    	
   	    	dead=true; 
   	   //	bird.setY(bird.getY()+5);
   	    	
   	    }
   }
    private void levelup_control()
    {
    	if(pipe1.getX()==50 || pipe2.getX()==50 )
    	{
    		num.arttir();
    		lastscore++;
    	}
    	
    }
    private void create_new_pipe()
    {
    	if(pipe1.getX()==-100 )
    	{
    		
    		 Random rnd = new Random();
         	 pipe1.setRand(rnd.nextInt(300)+100);
         	 pipe1.setX(width);
    		
        }
    	if(pipe2.getX()==-100 )
    	{
    		 Random rnd = new Random();
         	 pipe2.setRand( rnd.nextInt(300)+100);
         	pipe2.setX(width);
        }
    }
    private void bird_jump()
    {
    	if( bird.getY()<= 0 )
    		return;  
    	else
    	{


    	

    		if(dead && isstart )
        		{
    			if(bird.getY()>= width-35)
    				;
    			else
    			bird.setY(bird.getY()+5);
    			//baslama=true;
        		}
        	else
        	{
    	if(getKeyManager().space)
    		{
    		if(!isstart)
    			isstart=true;
    		
    		if(bird.getY()<=6 )
    			{
    			dead=true;
    			return;
    			}
    		else
    			bird.setY(bird.getY()-6);
    		
    		
    		}
    	else if(getMouseManager().isLeft())
    	{
    		if(!isstart)
    			isstart=true;
    		
    		
    		if(bird.getY()<=6 )
    			return;
    		else
    		bird.setY(bird.getY()-6);
    		
    		
    		}
        	
    	else if(bird.getY()>= width-35  )
    	{
    		dead=true;
    	}
    	
    	else 
    		bird.setY(bird.getY()+5);
    	
    	}}
    }
    private void start_menu(){
    	g.drawImage(start.getImage(),50,50,700,width,null);
		
		
    
    		if(a==2 || a==3)
        		g.drawImage(bird.getImage(),370,300,null);
        	else if(a==4 || a==5)
            	g.drawImage(bird.getImage2(),370,300,null);
        	else if(a==6 || a==7 || a==8 )
            	g.drawImage(bird.getImage3(),370,300,null);
        	else if(a==0 || a==1 )
            	g.drawImage(bird.getImage4(),370,300,null);
        
    	
    		bird.setY(300);
    		
    }
    private void animation_bird()
    {
    	if(dead || bird.getY()>=745)
    		g.drawImage(bird.getImage(),bird.getX(),bird.getY(),null);
    	else if(a==2 || a==3)
    		g.drawImage(bird.getImage(),bird.getX(),bird.getY(),null);
    	else if(a==4 || a==5)
        	g.drawImage(bird.getImage2(),bird.getX(),bird.getY(),null);
    	else if(a==6 || a==7 )
        	g.drawImage(bird.getImage3(),bird.getX(),bird.getY(),null);
    	else if(a==0 || a==1 )
        	g.drawImage(bird.getImage4(),bird.getX(),bird.getY(),null);
    	
	
    }
    private void foreground()
    {
    		
    	int ax=3;
    	
    	if(dead)
    		g.drawImage(foreground.getImage(),0,width,null);
    	else if(a==1)
    	g.drawImage(foreground.getImage(),0,width,null);
    	else if(a==2 ) 
        	g.drawImage(foreground.getImage(),-1*ax,width,null);
    	else if(a==3 )
        	g.drawImage(foreground.getImage(),-2*ax,width,null);
    	else if(a==4 )
        	g.drawImage(foreground.getImage(),-3*ax,width,null);
    	else if(a==5 )
        	g.drawImage(foreground.getImage(),-4*ax,width,null);
    	else if(a==6 )
        	g.drawImage(foreground.getImage(),-5*ax,width,null);
    	else if(a==7 )
        	g.drawImage(foreground.getImage(),-6*ax,width,null);
    	else if(a==8 )
        	g.drawImage(foreground.getImage(),-7*ax,width,null);
    	else if(a==0 )
        	g.drawImage(foreground.getImage(),-8*ax,width,null);
    	
    }
    private void pipes()
    {
    	g.drawImage(pipe1.getImage(),pipe1.getX(),width-pipe1.getRand(),100,pipe1.getRand(),null);
    	g.drawImage(pipe1.getImage2(),pipe1.getX()-2,width-pipe1.getRand(),104,50,null);
    	
    	g.drawImage(pipe1.getImage(),pipe1.getX(),0,100,width-pipe1.getRand()-150,null);
    	g.drawImage(pipe1.getImage2(),pipe1.getX()-2,width-pipe1.getRand()-200,104,50,null);

    	g.drawImage(pipe2.getImage(),pipe2.getX(),width-pipe2.getRand(),100,pipe2.getRand(),null);
    	g.drawImage(pipe2.getImage2(),pipe2.getX()-2,width-pipe2.getRand(),104,50,null);
    	
    	g.drawImage(pipe2.getImage(),pipe2.getX(),0,100,width-pipe2.getRand()-150,null);
    	g.drawImage(pipe2.getImage2(),pipe2.getX()-2,width-pipe2.getRand()-200,104,50,null);
    	
    }
    private void highscore_up()
    {
    	
    	num.setElde(num.getNum()/10);
    	num.setKalan(num.getNum()%10);
    	
    	if(num.getElde()==0)
    		;//g.drawImage(num.getImage(), 360,10, 50, 60,null);
    	else if(num.getElde()==1)
    		g.drawImage(num.getImage1(), 360,10, 50, 60,null);
    	else if(num.getElde()==2)
    		g.drawImage(num.getImage2(), 360,10, 50, 60,null);
    	else if(num.getElde()==3)
    		g.drawImage(num.getImage3(), 360,10, 50, 60,null);
    	else if(num.getElde()==4)
    		g.drawImage(num.getImage4(), 360,10, 50, 60,null);
    	else if(num.getElde()==5)
    		g.drawImage(num.getImage5(), 360,10, 50, 60,null);
    	else if(num.getElde()==6)
    		g.drawImage(num.getImage6(), 360,10, 50, 60,null);
    	else if(num.getElde()==7)
    		g.drawImage(num.getImage7(), 360,10, 50, 60,null);
    	else if(num.getElde()==8)
    		g.drawImage(num.getImage8(), 360,10, 50, 60,null);
    	else if(num.getElde()==9)
    		g.drawImage(num.getImage9(), 360,10, 50, 60,null);
    	
    	if(num.getKalan()==0)
    		g.drawImage(num.getImage(), 400,10, 50, 60,null);
    	else if(num.getKalan()==1)
    		g.drawImage(num.getImage1(), 400,10, 50, 60,null);
    	else if(num.getKalan()==2)
    		g.drawImage(num.getImage2(), 400,10, 50, 60,null);
    	else if(num.getKalan()==3)
    		g.drawImage(num.getImage3(), 400,10, 50, 60,null);
    	else if(num.getKalan()==4)
    		g.drawImage(num.getImage4(), 400,10, 50, 60,null);
    	else if(num.getKalan()==5)
    		g.drawImage(num.getImage5(), 400,10, 50, 60,null);
    	else if(num.getKalan()==6)
    		g.drawImage(num.getImage6(), 400,10, 50, 60,null);
    	else if(num.getKalan()==7)
    		g.drawImage(num.getImage7(), 400,10, 50, 60,null);
    	else if(num.getKalan()==8)
    		g.drawImage(num.getImage8(), 400,10, 50, 60,null);
    	else if(num.getKalan()==9)
    		g.drawImage(num.getImage9(), 400,10, 50, 60,null);
    	
    }
    private void gameover_table(){

		g.drawImage(gameover.getImage(),120, 200, 600, 600, null);
		
		// madalyalar calismiyo 
		
		if(lastscore >= 0 && lastscore < 10)
			g.drawImage(medal.getImage(),205, 440,105,105 ,null);
		else if(lastscore >= 10 && lastscore < 20)
			g.drawImage(medal.getImage2(),205, 440,105,105 ,null);
		else if(lastscore >= 20)
			g.drawImage(medal.getImage3(),205, 440,105,105, null);
		

		// madalyalarin yanindaki score tablosu
    	num.setElde(num.getNum()/10);
    	num.setKalan(num.getNum()%10);
    		//if(num.getElde()==0)
    	//g.drawImage(num.getImage(), 550,420, 40, 50,null);
    	 if(num.getElde()==1)
    		g.drawImage(num.getImage1(), 550,420, 40, 50,null);
    	else if(num.getElde()==2)
    		g.drawImage(num.getImage2(), 550,420, 40, 50,null);
    	else if(num.getElde()==3)
    		g.drawImage(num.getImage3(), 550,420, 40, 50,null);
    	else if(num.getElde()==4)
    		g.drawImage(num.getImage4(), 550,420, 40, 50,null);
    	else if(num.getElde()==5)
    		g.drawImage(num.getImage5(), 550,420, 40, 50,null);
    	else if(num.getElde()==6)
    		g.drawImage(num.getImage6(), 550,420, 40, 50,null);
    	else if(num.getElde()==7)
    		g.drawImage(num.getImage7(), 550,420, 40, 50,null);
    	else if(num.getElde()==8)
    		g.drawImage(num.getImage8(), 550,420, 40, 50,null);
    	else if(num.getElde()==9)
    		g.drawImage(num.getImage9(), 550,420, 40, 50,null);
    	
    	if(num.getKalan()==0)
    		g.drawImage(num.getImage(), 590,420, 40, 50,null);
    	else if(num.getKalan()==1)
    		g.drawImage(num.getImage1(), 590,420, 40, 50,null);
    	else if(num.getKalan()==2)
    		g.drawImage(num.getImage2(), 590,420, 40, 50,null);
    	else if(num.getKalan()==3)
    		g.drawImage(num.getImage3(), 590,420, 40, 50,null);
    	else if(num.getKalan()==4)
    		g.drawImage(num.getImage4(), 590,420, 40, 50,null);
    	else if(num.getKalan()==5)
    		g.drawImage(num.getImage5(), 590,420, 40, 50,null);
    	else if(num.getKalan()==6)
    		g.drawImage(num.getImage6(), 590,420, 40, 50,null);
    	else if(num.getKalan()==7)
    		g.drawImage(num.getImage7(), 590,420, 40, 50,null);
    	else if(num.getKalan()==8)
    		g.drawImage(num.getImage8(), 590,420, 40, 50,null);
    	else if(num.getKalan()==9)
    		g.drawImage(num.getImage9(), 590,420, 40, 50,null);
    	
    	int elde=bestScore/10;
    	int kalan=bestScore%10;
    		//if(elde==0)
    	//g.drawImage(num.getImage(), 550,420, 40, 50,null);
    	 if(elde==1)
    		g.drawImage(num.getImage1(), 550,510, 40, 50,null);
    	else if(elde==2)
    		g.drawImage(num.getImage2(), 550,510, 40, 50,null);
    	else if(elde==3)
    		g.drawImage(num.getImage3(), 550,510, 40, 50,null);
    	else if(elde==4)
    		g.drawImage(num.getImage4(), 550,510, 40, 50,null);
    	else if(elde==5)
    		g.drawImage(num.getImage5(), 550,510, 40, 50,null);
    	else if(elde==6)
    		g.drawImage(num.getImage6(), 550,510, 40, 50,null);
    	else if(elde==7)
    		g.drawImage(num.getImage7(), 550,510, 40, 50,null);
    	else if(elde==8)
    		g.drawImage(num.getImage8(), 550,510, 40, 50,null);
    	else if(elde==9)
    		g.drawImage(num.getImage9(), 550,510, 40, 50,null);
    	
    	if(kalan==0)
    		g.drawImage(num.getImage(), 590,510, 40, 50,null);
    	else if(kalan==1)
    		g.drawImage(num.getImage1(), 590,510, 40, 50,null);
    	else if(kalan==2)
    		g.drawImage(num.getImage2(), 590,510, 40, 50,null);
    	else if(kalan==3)
    		g.drawImage(num.getImage3(), 590,510, 40, 50,null);
    	else if(kalan==4)
    		g.drawImage(num.getImage4(), 590,510, 40, 50,null);
    	else if(kalan==5)
    		g.drawImage(num.getImage5(), 590,510, 40, 50,null);
    	else if(kalan==6)
    		g.drawImage(num.getImage6(), 590,510, 40, 50,null);
    	else if(kalan==7)
    		g.drawImage(num.getImage7(), 590,510, 40, 50,null);
    	else if(kalan==8)
    		g.drawImage(num.getImage8(), 590,510, 40, 50,null);
    	else if(kalan==9)
    		g.drawImage(num.getImage9(), 590,510, 40, 50,null);
    	
    	
   
		if(getKeyManager().space)
    	{
			
			
    		  	isstart=false;
    		        		//render();
    		  	
    		  	//g.finalize();
    		  	
    		  	
    		  		//	start_menu();
    		        		bird.setY(300);
    		        		num.sifirla();
    		        		dead=false;
    		        		lastscore=0;
    		        		
    		        		pipe1= new Pipe();
    		        		pipe1.setX(800);
    		        		pipe2=new Pipe();
    		        		pipe2.setX(1250);
    		        		bird= new Bird();
    		   
    		    
    		
    		
    	}
		
		//run();
    	//start();
		
	//	init();
    		
    	if(dead)
    	 if(getMouseManager().isLeft())
    	{
    		
    		
        		            	isstart=false;
        		        		//render();
        		        		bird.setY(300);
        		        		num.sifirla();
        		        		dead=false;
        		        		lastscore=0;
        		        		pipe1= new Pipe();
        		        		pipe1.setX(800);
        		        		pipe2=new Pipe();
        		        		pipe2.setX(1250);
        		        		bird= new Bird();
        		     
    	}
    	
    	
    	
    }

    
    
    
    private void tick(){
    	
    	//if(dead && isstart)
    //	{
    		//getDisplay().getPanel().
    		
    	//	getDisplay().getFrame().setContentPane(getDisplay().getPanel());
    		
    // gameovera yeni panel yap graphic tanimla
    		
    		
    	//}
    	
    	keyManager.tick();
    	
    	collision();
    	levelup_control();
    	create_new_pipe();
    	bird_jump();
    	
    	
    	
    	if(a==7)
    		a=0;
    	else 
    		a++;
    	
    	if(dead && isstart )
    		;
    	else
    	{	
    		pipe1.setX(pipe1.getX()-2);
    		pipe2.setX(pipe2.getX()-2);
    		
    	}
    
    	
    
    	
    }

    
    private void render(){
    	
    	
    	
    		bs = display.getCanvas().getBufferStrategy();
    	
    	if ( bs== null){
    		display.getCanvas().createBufferStrategy(3);
    		return;
    	}
    	
    	
    	g = bs.getDrawGraphics();
    	
    
    	g.drawImage(background.getImage(),0,0,width,height,null);
         
    	
    	
    	if(isstart==false )
    	{
    		start_menu();
    		
    	}
    	else
    	{
    		
    	
    	
    	
 
    	foreground();
    	
    	pipes();

    	animation_bird();
    	
    	highscore_up();
    	
    
    
    	
    	if(dead && isstart && bird.getY() >= width-35 )	
    		{
    		
    		gameover_table();
    		
    		}
    	}
    	
    	 
    	bs.show();
    	g.dispose();
    }
    	
    
public void run()
{
	
	init();

	int fps = 60     ;
	double timePerTick = 1000000000/fps;
	double delta = 0 ;
	long now;
	long lastTime = System.nanoTime();

	              
	while(running){
		now = System.nanoTime();
		delta+= (now-lastTime)/timePerTick;
		lastTime = now;
		
		if(delta >= 1){
			tick();
			render();
			delta--;
		}


	}
	stop();

}
 public KeyManager getKeyManager(){
	 return keyManager;
 }
 public MouseManager getMouseManager(){
	 return mouseManager;
 }

public Display getDisplay() {
	return display;
}

public int getWidth() {
	return width;
}

public int getHeight() {
	return height;
}

public String getTitle() {
	return title;
}

public Thread getThread() {
	return thread;
}

public boolean isRunning() {
	return running;
}

public BufferStrategy getBs() {
	return bs;
}

public Graphics getG() {
	return g;
}





public synchronized void start(){
    
	if(running)
		return;
	running=true;
    thread = new Thread(this);
    thread.start();
    



}

public synchronized void stop(){
    if(!running)
    	return;
	running=false;
    try {
		thread.join();
	} catch (InterruptedException e) {

		e.printStackTrace();
	}
    



}

public boolean isDead() {
	return dead;
}

public void setDead(boolean dead) {
	this.dead = dead;
}

public boolean isIsstart() {
	return isstart;
}

public void setIsstart(boolean isstart) {
	this.isstart = isstart;
}

    
}
