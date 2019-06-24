import java.awt.*;
public class wall {
	Graphics g;Occupied oc;
	wall(Graphics g,Occupied oc){this.g=g;this.oc=oc;
	g.drawRect(901,58,80,30);}
	public void dwall(int x,int y,int len,char dir){
		int x2=0,y2=0;
		if(dir=='d'){x2=len;y2=25;
		oc.line(x,y,len,25);}
		else if(dir=='s'){x2=25;y2=len;
		oc.line(x,y,25,len);

		}

	g.setColor(Color.blue);

	g.fillRoundRect(x,y,x2,y2,15,15);


	}
}
