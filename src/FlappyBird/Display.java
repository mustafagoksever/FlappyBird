
package FlappyBird;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display {

    private JFrame jframe;
  
   private JPanel gameover;
    private String title;
    private int width,height;
    private Canvas canvas;
    
    
    Display(String title,int width,int height)
                   
    {
        
        this.title=title;
        this.width=width;
        this.height=height;
        createDisplay();
        
    }

private void createDisplay()
{
    jframe=new JFrame(title);
    	gameover= new JPanel();
        jframe.setSize(width, height);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.setVisible(true);
        
        canvas= new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setFocusable(false);
        
        jframe.add(canvas);
        jframe.pack();


    	
        
        
        
}
    
	public Canvas getCanvas(){
		return canvas;
	}
	
	public JFrame getFrame(){
		return jframe;
	}
	
	
	public JPanel getPanel()
	{
		
		
		return gameover;
	}


}
