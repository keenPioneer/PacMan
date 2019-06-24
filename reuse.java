import java.awt.*;
import java.awt.event.*;
public class reuse implements KeyListener{
	Occupied oc=new Occupied();
	int round;
	boolean gameState=true;
	int X=900,Y=571;
	int Point=0;

	int speed=5;
	int xv=940;
	int yv=100;
	int earr[][]=new int[701][1002];
	static	int pacMouth=1;
	char dir='a';
	Frame frame;
	Button b;
	Button b2;
		reuse(int round){
			this.round=round;
		 b=new Button("Reset");
		 b2=new Button("Exit");
			frame=new Frame(){
				public void paint(Graphics g)
							{	g.setColor(Color.white);
								g.fillOval(xv,yv,25,25);
									g.setColor(Color.green);
								g.fillOval(xv2,yv2,25,25);
									g.setColor(Color.black);
								g.fillOval(xv3,yv3,25,25);
							//	g.fillOval(xv4,yv4,25,25);
								if(pacMouth==1)pacMouth=0;
								else if(pacMouth==0)pacMouth=1;//bitting system
								g.setColor(Color.yellow);
								if(pacMouth==0)//bite
								switch (dir){
									case 'd':g.fillArc(X,Y,25,25,35,317);break;
									case 'a':g.fillArc(X,Y,25,25,219,317);break;
									case 'w':g.fillArc(X,Y,25,25,129,325);break;
									case 's':g.fillArc(X,Y,25,25,309,325);break;
									default :g.fillArc(X,Y,25,25,35,325);
								}
								else if(pacMouth==1)
								switch (dir){
									case 'd':g.fillArc(X,Y,25,25,15,337);break;
									case 'a':g.fillArc(X,Y,25,25,219,337);break;
									case 'w':g.fillArc(X,Y,25,25,109,337);break;
									case 's':g.fillArc(X,Y,25,25,287,337);break;
									default :g.fillArc(X,Y,25,25,15,337);
								}
								int odd=0;
							wall walls=new wall(g,oc);
				if(round==1){
						for(int let1=70;let1<800;let1+=220)
							for(int let2=120;let2<650;let2+=60)
								walls.dwall(let1,let2,170,'d');
}				else if(round==2){
	for(int let1=170;let1<1000;let1+=220)
		for(int let2=120;let2<400;let2+=60)
			walls.dwall(let1,let2,170,'s');

}
							g.setColor(Color.BLACK);
							for(int j=0;j<=1000;j++)
							for(int k=0;k<=700;k++)
							if(oc.ck(j,k)==2){g.fillOval(j,k,3,3);}



						//border
								walls.dwall(0,0,700,'s');
								walls.dwall(0,30,1000,'d');
								walls.dwall(970,0,700,'s');
								walls.dwall(0,30,1000,'d');
								walls.dwall(0,670,980,'d');
								//border end

						g.setColor(Color.yellow);

						g.drawString("Points =>"+Point,900,70);
						g.drawString("Speed =>"+speed,900,85);

							}
			};
				b.setBounds(450,300,100,100);
				b2.setBounds(450,400,100,40);
				b2.addActionListener(
				new ActionListener(){
				public	void actionPerformed(ActionEvent ae){System.exit(0);}
				}
				);
				b.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae)
					{frame.setVisible(false);
					new reuse(round);}
				});
				frame.setSize(1000,700);
				b.setVisible(false);
				b2.setVisible(false);
				frame.setBackground(Color.GRAY);
				for(int i=30;i<1000;i+=40)
				for(int j=45;j<700;j+=60)
				{			oc.dot(i,j);				}
				frame.addKeyListener(this);


				frame.add(b);
				frame.add(b2);
				frame.setVisible(true);
				pc pac=new pc();
			//	pac.setPriority(7);
				pac.start();
				t1 t11=new t1();
				t11.start();
				t2 t22=new t2();
				t22.start();
				t3 t33=new t3();
				t33.start();
				Re r=new Re();

				r.start();
				Marks mar=new Marks();
				mar.start();
			}

		public void keyPressed(KeyEvent ke){}
		public void keyTyped(KeyEvent ke){
				if(gameState)
					dir=ke.getKeyChar();



					}

			public void keyReleased(KeyEvent ke){
				if(Point==240){
					frame.setVisible(false);
				new	reuse(2);
				}
						if(27==ke.getKeyCode()){
						System.exit(0);
						}}
	char dirv='s';
	char dirv3='s';
	/*
	public boolean ckCollision(int X,int Y){
		if(oc.ck(X,Y)==1)return true;
		else return false;
	}*/
int xv3=50;
int yv3=600;
	class pc extends Thread{
				public void run(){
				while(gameState){
					try {
						Thread.sleep(7);
					} catch(Exception e) {

			}
				if(dir=='d'){X+=1;
						{if(oc.ck(X+25,Y+12)==1||oc.ck(X+25,Y)==1||oc.ck(X+25,Y+25)==1)
							{X-=1;}
						}
				}// problem is'nt here //checked "for sure"
				else if(dir=='a')
				{X-=1;
					{if(oc.ck(X,Y+12)==1||oc.ck(X,Y)==1||oc.ck(X,Y+25)==1)
						{X+=1;}
					}
				}
				else if(dir=='s')
				{Y+=1;
					{if(oc.ck(X+25,Y+25)==1||oc.ck(X,Y+25)==1||oc.ck(X+12,Y+25)==1)
						{Y-=1;}
					}
				}
				else if(dir=='w')
				{Y-=1;
					{if(oc.ck(X,Y)==1||oc.ck(X+12,Y)==1||oc.ck(X+25,Y)==1)
						{Y+=1;}
					}
				}
				for(int i=0;i<25;i++)//running a loop around the pac
				for(int j=0;j<25;j++){
					int locX=X;	int locY=Y;
					if(oc.ck(locX+i,locY+j)==2){
						Point++;
					//	System.out.println("Points=>> "+Point);
						oc.eatenDot(locX+i,locY+j);
					}
				}
			}
			}}

			public boolean ck(int x,int y){
				if(oc.ck(x,y)==1)return true;
				else return false;
				}
	public void dirSwap(){
		if(dirv=='a')dirv='d';
		else if(dirv=='d')dirv='a';
		else if(dirv=='w')dirv='s';
		else if(dirv=='s')dirv='w';
		}
	public void move (){
		if(dirv=='d'){xv++;
		if(ck(xv+25,yv)||ck(xv+25,yv+12)||ck(xv+25,yv+25)){xv--;dirSwap();}
		}
		else if(dirv=='a'){xv--;
		if(ck(xv,yv)||ck(xv,yv+12)||ck(xv,yv+25)){xv++;dirSwap();}
		}
		else if(dirv=='s'){yv++;
		if(ck(xv,yv+25)||ck(xv+12,yv+25)||ck(xv+25,yv+25)){yv--;dirSwap();}
		}
		else if(dirv=='w'){yv--;}
		if(ck(xv,yv)||ck(xv,yv+25)||ck(xv,yv+12)){yv++;dirSwap();}
		}
	public void move2(){
		if(dirv2=='d'){xv2++;
		if(ck(xv2+25,yv2)||ck(xv2+25,yv2+12)||ck(xv2+25,yv2+25)){xv2--;dirSwap2();}
		}
		else if(dirv2=='a'){xv2--;
		if(ck(xv2,yv2)||ck(xv2,yv2+12)||ck(xv2,yv2+25)){xv2++;dirSwap2();}
		}
		else if(dirv2=='s'){yv2++;
		if(ck(xv2,yv2+25)||ck(xv2+12,yv2+25)||ck(xv2+25,yv2+25)){yv2--;dirSwap2();}
		}
		else if(dirv2=='w'){yv2--;}
		if(ck(xv2,yv2)||ck(xv2,yv2+25)||ck(xv2,yv2+12)){yv2++;dirSwap2();}
		}
	public void dirSwap2(){
		if(dirv2=='a')dirv2='d';
		else if(dirv2=='d')dirv2='a';
		else if(dirv2=='w')dirv2='s';
		else if(dirv2=='s')dirv2='w';
		}
	public void colCk(){

		for(int i=xv;i<xv+25;i++)
		for(int j=yv;j<yv+25;j++){
			for(int k=X;k<X+25;k++)
			for(int l=Y;l<Y+25;l++){
				if(i==k&&j==l){gameState=false;
				b.setVisible(true);
				b2.setVisible(true);
				break;}
			}
		}
	}
	public void colCk2(){
		for(int i=xv2;i<xv2+25;i++)
		for(int j=yv2;j<yv2+25;j++){
			for(int k=X;k<X+25;k++)
			for(int l=Y;l<Y+25;l++){
				if(i==k&&j==l){gameState=false;
							b.setVisible(true);
							b2.setVisible(true);
	break;}
			}
		}
	}
	public void move3(){
		if(dirv3=='d'){xv3++;
		if(ck(xv3+25,yv3)||ck(xv3+25,yv3+12)||ck(xv3+25,yv3+25)){xv3--;dirSwap3();}
		}
		else if(dirv3=='a'){xv3--;
		if(ck(xv3,yv3)||ck(xv3,yv3+12)||ck(xv3,yv3+25)){xv3++;dirSwap3();}
		}
		else if(dirv3=='s'){yv3++;
		if(ck(xv3,yv3+25)||ck(xv3+12,yv3+25)||ck(xv3+25,yv3+25)){yv3--;dirSwap3();}
		}
		else if(dirv3=='w'){yv3--;}
		if(ck(xv3,yv3)||ck(xv3,yv3+25)||ck(xv3,yv3+12)){yv3++;dirSwap3();}
		}
	public void dirSwap3(){
		if(dirv3=='a')dirv3='d';
		else if(dirv3=='d')dirv3='a';
		else if(dirv3=='w')dirv3='s';
		else if(dirv3=='s')dirv3='w';
		}
	public void colCk3(){
		for(int i=xv3;i<xv3+25;i++)
		for(int j=yv3;j<yv3+25;j++){
			for(int k=X;k<X+25;k++)
			for(int l=Y;l<Y+25;l++){
				if(i==k&&j==l){gameState=false;
							b.setVisible(true);
							b2.setVisible(true);
	break;}
			}
		}
	}
	int no=0;
	class t1 extends Thread{
		public void run(){int difX;int difY;
			while(gameState){if(no%2==0){
				no=0;}
					move();
						if(oc.ck(xv,yv)==1){
						if(dirv=='d')dirv='a';
						else if(dirv=='a')dirv='d';
						else if(dirv=='w')dirv='s';
						else if(dirv=='s')dirv='w';
					}//Collision with a wall for the ghost
				try {
						Thread.sleep(8);
				} catch(Exception e) {}//sleep for 10 ms
			difX=X-xv;//xv and yv are the CordOfVil
			difY=Y-yv;
			if(X==xv){
					if(difY<0){dirv='w';}
					else if(difY>0){dirv='s';}
				}//searching for pac and following
			else if(Y==yv)
				 	{
					if(difX<0){dirv='a';}
					else if(difX>0){dirv='d';}
				}//searching for pac and following

			if(difX<50&&difY<50)//if ghost and pac are near by start looping around them
			{
				colCk();
			}
			no++;
	}}}
	int noo=0;
	int xv2=100;
	int yv2=80;
	char dirv2='d';
	class t2 extends Thread{
		public void run(){
			while (gameState) {if(noo%2==0){

				noo=0;}
				move2();
					if(oc.ck(xv2,yv2)==1){
					if(dirv2=='d')dirv2='a';
					else if(dirv2=='a')dirv2='d';
					else if(dirv2=='w')dirv2='s';
					else if(dirv2=='s')dirv2='w';
				}//Collision with a wall for the ghost
			try {
					Thread.sleep(9);
			} catch(Exception e) {}//sleep for 10 ms
		int difX=X-xv2;//xv2 and yv2 are the CordOfVil
		int difY=Y-yv2;
		if(X==xv2){
				if(difY<0){dirv2='w';}
				else if(difY>0){dirv2='s';}
			}//searching for pac and following
		else if(Y==yv2)
				{
				if(difX<0){dirv2='a';}
				else if(difX>0){dirv2='d';}
			}//searching for pac and following

		if(difX<50&&difY<50)//if ghost and pac are near by start looping around them
		{
			colCk2();
		}
		noo++;
				}}}
				class t3 extends Thread{
					public void run(){
						while (gameState) {if(noo%2==0){

							noo=0;}
							move3();
								if(oc.ck(xv3,yv3)==1){
								if(dirv3=='d')dirv3='a';
								else if(dirv3=='a')dirv3='d';
								else if(dirv3=='w')dirv3='s';
								else if(dirv3=='s')dirv3='w';
							}//Collision with a wall for the ghost
						try {
								Thread.sleep(9);
						} catch(Exception e) {}//sleep for 10 ms
					int difX=X-xv3;//xv3 and yv3 are the CordOfVil
					int difY=Y-yv3;
					if(X==xv3){
							if(difY<0){dirv3='w';}
							else if(difY>0){dirv3='s';}
						}//searching for pac and following
					else if(Y==yv3)
							{
							if(difX<0){dirv3='a';}
							else if(difX>0){dirv3='d';}
						}//searching for pac and following

					if(difX<50&&difY<50)//if ghost and pac are near by start looping around them
					{
						colCk3();
					}
					noo++;
							}}}
				int re=0;
	class Re extends Thread{
		public void run(){
			while(gameState){re++;
				try {
						Thread.sleep(10);
				} catch(Exception e) {}
				if(re==1){
						frame.repaint(X-7,Y-7,43,43);

				}
				else if(re==2){
						frame.repaint(xv-6,yv-6,41,41);
				}

					else if(re==3){
						frame.repaint(xv2-6,yv2-6,41,41);

				}
				else if(re==4){
					frame.repaint(xv3-6,yv3-6,41,41);
					re=0;
			}

			}
		}
	}
	class Marks extends Thread{
		public void run(){
setPriority(3);

			while(gameState){
		try {
			Thread.sleep(1000);
		} catch(Exception e) {
		}

			frame.repaint(890,50,85,50);
		}}
	}
	}
