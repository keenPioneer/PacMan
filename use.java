import java.awt.event.*;
import java.awt.*;
public class use extends Frame implements MouseListener,MouseMotionListener,KeyListener{
	
	public void mouseClicked(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseDragged(MouseEvent me){}
	public void mouseMoved(MouseEvent me){}
	public void keyPressed(KeyEvent ke){}
	public void keyReleased(KeyEvent ke){}
	public void keyTyped(KeyEvent ke){}
	use(){						//Constructor No arguments
		addKeyListener(this);				
		  addMouseMotionListener(this);
		  addMouseListener(this);
		  setLayout(null);
		  setVisible(true);
		  setSize(1000,700);}
	use(int x,int y){			//Constructor with args size x,y;
		addKeyListener(this);	
		  addMouseMotionListener(this);
		  addMouseListener(this);
		  setLayout(null);
		  setVisible(true);
		  setSize(x*100,y*100);}

		  
		  }