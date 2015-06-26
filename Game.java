package game;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends Thread implements MouseListener{
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
		Boolean stopper=false;
		Boolean isGame=false;
		Boolean SELECTED=false;
		long sec;
		long min;
		long t;
		Boolean move;
		short heroselected=12;
		int line1=200;
		int line2=400;
		int line3=300;
		int line4=500;
		short sense=16;
		String secs;
		String mins;
		int bgnm=((int)screensize.getWidth()/2)-256;
		int[] ln={bgnm+30,bgnm+150,bgnm+270,bgnm+390};
		Boolean[] line={false,false,false,false};
		int cspeed=13;
		String name="tani";
		int highscore=0;	
		Boolean cc1=true,cc2=true,cc3=true,cc4=true,cc5=true,cc6=true,cc7=true,cc8=true,cc9=true,cc10=true,cc11=true;
		URL carhorn1;
		URL carhorn2;
		URL carpass;
		URL crash2;
		URL cardrive1;
		String user=System.getProperty("user.name");
		AudioClip CarHorn1;
		AudioClip CarHorn2;
		AudioClip CarPass;
		AudioClip Crash2;
		AudioClip CarDrive1;
		URL buttonaudio;
		AudioClip ButtonAudio;
		URL userdir;		
		public class makeapplets extends JApplet{
		public makeapplets(){
			try{
				carhorn1=new URL("file:/c:/game/src/sounds/carhorn1.wav");
				carhorn2=new URL("file:/c:/game/src/sounds/carhorn2.wav");
				carpass=new URL("file:/c:/game/src/sounds/carpass.wav");
				cardrive1=new URL("file:/c:/game/src/sounds/cardrive1.wav");
				buttonaudio=new URL("file:/c:/game/src/sounds/button.wav");
				crash2=new URL("file:/c:/game/src/sounds/crash2.wav");
				CarHorn1=Applet.newAudioClip(carhorn1);
				CarHorn2=Applet.newAudioClip(carhorn2);
				Crash2=Applet.newAudioClip(crash2);
				CarDrive1=Applet.newAudioClip(cardrive1);
				CarPass=Applet.newAudioClip(carpass);
				ButtonAudio=Applet.newAudioClip(buttonaudio);						
				CarDrive1.loop();
				while(stopper){
						try{
							Thread.sleep(100);
						}
						catch(Exception ea){}
					}					
				Crash2.play();
				CarDrive1.stop();
				CarPass.stop();
			}
			catch(Exception ea){JOptionPane.showMessageDialog(f,ea);}
		}
		}
		
		
		public class Audio extends Thread{
			public void run(){
				new makeapplets();				
			}
				
			}

		
		public class moreCars extends Thread{
			public void run(){
				while(isGame){
					try{
						Thread.sleep(Speedo);
						if(Score==200)
							TrackSpeed=9;
						else if(Score==600)
							TrackSpeed=8;
						else if(Score==1000){
							callcar();
							TrackSpeed=7;
							cspeed=10;
						}
						else if(Score==3000){
							TrackSpeed=6;
						}
						else if(Score==4000){
							TrackSpeed=5;
							cspeed=9;
							callcar();

						}
					}
					catch(Exception ea){}
				}
			}
		}
		

		
		public class T21 extends Thread{
			public void run(){
				String[] ss={"3","2","1","GO"};
				for(int ij=0;ij<=3;ij++){
					getready.setText(ss[ij]);
					try{
						Thread.sleep(1000);
					}
					catch(Exception ea){}
				}
				getready.setVisible(false);

			}
		}
		
		public class crash extends Thread{
			public void run(){
				while(stopper){
					try{
						Thread.sleep(100);
					}
					catch(Exception ea){}
				Rectangle r1=hero.getBounds();
				r1.setBounds(hero.getX()+10,hero.getY()+10,hero.getWidth()-20,hero.getHeight()-20);
				Rectangle c1=car1.getBounds();
				Rectangle c2=car2.getBounds();
				Rectangle c3=car3.getBounds();
				Rectangle c4=car4.getBounds();
				Rectangle c5=car5.getBounds();
				Rectangle c6=car6.getBounds();
				Rectangle c7=car7.getBounds();
				Rectangle c8=car8.getBounds();
				Rectangle c9=car9.getBounds();
				Rectangle c10=car10.getBounds();
				Rectangle c11=car11.getBounds();

				if(r1.intersects(c1)||r1.intersects(c2)||r1.intersects(c3)||r1.intersects(c4)||r1.intersects(c5)||r1.intersects(c6)||r1.intersects(c7)||r1.intersects(c8)||r1.intersects(c9)||r1.intersects(c10)||r1.intersects(c11)){
					stopper=false;
					gameover();
					
				}
				}				
			}
		}
		
		public class moveright extends Thread{
			public void run(){
				while(isGame&&xx<=((bgnm+492)-hero.getWidth())&&move){
					try{
						Thread.sleep(sense);
					}
					catch(Exception ea){}
					hero.setLocation(xx+=4,530);
				}
			}
		}
		public class moveleft extends Thread{
			public void run(){
				while(isGame&&xx>bgnm+20&&move){
					try{
						Thread.sleep(sense);
					}
					catch(Exception ea){}
					hero.setLocation(xx-=4,530);
				}
			}
		}

		public class base extends Thread{
			public void run(){
				long currenttime=System.currentTimeMillis();	
				while(stopper){
					try{
						Thread.sleep(1000);
					}
					catch(Exception ea){}
					t=System.currentTimeMillis()-currenttime;
					sec=t/1000;
					min=t/1000/60;
					sec=sec%60;
					min=min%60;
					secs=String.valueOf(sec);
					mins=String.valueOf(min);
					if(sec<10)
						secs="0"+secs;
					if(min<10)
						mins="0"+mins;
					watch.setText(mins+":"+secs);
					}
				}		
			}
		
		int Score=0;
		int Speedo=100;
		public class score extends Thread{
			public void run(){
				Score=0;
				
				while(stopper){
					try{
						Thread.sleep(Speedo);
					}
					catch(Exception ea){}
					Score+=2;
					String ss=String.valueOf(Score);
					if(Score<10)
						ss="000"+ss;
					else if(Score>=10&&Score<100)
						ss="00"+ss;
					else if(Score>=100&&Score<1000)
						ss="0"+ss;
					else if(Score>=1000)
						ss=""+ss;
					scorecounter.setText(ss);
				}
				
			}	
			}
		int TrackSpeed;
		public class track extends Thread{
			public void run(){
				while(stopper){
					try{
						Thread.sleep(TrackSpeed);
					}
					catch(Exception ea){}
					background1.setLocation(0,y1+=5);
					background2.setLocation(0,y2+=5);
					background3.setLocation(0,y3+=5);
					bg1.setLocation(bgnm,y1+=5);
					bg2.setLocation(bgnm,y2+=5);
					bg3.setLocation(bgnm,y3+=5);
					if(y1>=770)
						y1=-1536;
					if(y2>=770)
						y2=-1536;
					if(y3>=770)
						y3=-1536;
					if(Score==2000)
					{
						background1.setIcon(new ImageIcon("src/images/bg2.jpg"));
						background2.setIcon(new ImageIcon("src/images/bg2.jpg"));
						background3.setIcon(new ImageIcon("src/images/bg2.jpg"));

					}
					else if(Score==4000){
						background1.setIcon(new ImageIcon("src/images/bg3.jpg"));
						background2.setIcon(new ImageIcon("src/images/bg3.jpg"));
						background3.setIcon(new ImageIcon("src/images/bg3.jpg"));
					}

			}
		}
		}
	
	public class Car1 extends Thread{
		Random rand=new Random();
		int i=rand.nextInt(11)+cspeed;
		int j=rand.nextInt(4);
		int yy1=rand.nextInt(400)-600;
		public void run(){
			while(line[j])
				j=rand.nextInt(4);
			line[j]=true;
			car1.setLocation(ln[j],yy1);
			while(yy1<=770&&stopper){
				try{
					Thread.sleep(i);
				}
				catch(Exception ea){}
				car1.setLocation(ln[j],yy1+=5);
			}
			car1.setLocation(350,-300);
			line[j]=false;
		callcar();
		cc1=true;
		}
	}
	
	JFrame f=new JFrame("My Game");
	JPanel f2=new JPanel();
	JLabel background1=new JLabel(new ImageIcon("src/images/bg.jpg"));
	JLabel background2=new JLabel(new ImageIcon("src/images/bg.jpg"));
	JLabel background3=new JLabel(new ImageIcon("src/images/bg.jpg"));
	JLabel bg1=new JLabel(new ImageIcon("src/images/track.jpg"));
	JLabel bg2=new JLabel(new ImageIcon("src/images/track.jpg"));
	JLabel bg3=new JLabel(new ImageIcon("src/images/track.jpg"));
	JLabel fire=new JLabel(new ImageIcon("src/images/fire2.gif"));
	JLabel CHorn1=new JLabel();
	JLabel CHorn2=new JLabel();
	JButton about=new JButton("About");
	JButton exit=new JButton("Exit");
	JButton help=new JButton("Help");
	JLabel watch=new JLabel("00:00");
	JLabel scorecounter=new JLabel("00");
	JLabel left=new JLabel();
	JLabel right=new JLabel();
	JLabel hero=new JLabel();
	JLabel NAME=new JLabel();
	JLabel HIGHSCORE=new JLabel();
	JLabel welcome=new JLabel("Welcome");
	JLabel hssc=new JLabel("High-Score");
	JLabel BYHIGHSCORE=new JLabel("");
	JButton changename=new JButton("change name");
	JButton changesensor=new JButton("modify sensor");
	JLabel car1=new JLabel(new ImageIcon("src/images/car1.gif"));
	JLabel car2=new JLabel(new ImageIcon("src/images/car2.gif"));
	JLabel car3=new JLabel(new ImageIcon("src/images/car3.gif"));
	JLabel car4=new JLabel(new ImageIcon("src/images/car4.gif"));
	JLabel car5=new JLabel(new ImageIcon("src/images/car5.gif"));
	JLabel car6=new JLabel(new ImageIcon("src/images/car6.gif"));
	JLabel car7=new JLabel(new ImageIcon("src/images/car7.gif"));
	JLabel car8=new JLabel(new ImageIcon("src/images/car8.gif"));
	JLabel car9=new JLabel(new ImageIcon("src/images/car9.gif"));
	JLabel car10=new JLabel(new ImageIcon("src/images/car10.gif"));
	JLabel car11=new JLabel(new ImageIcon("src/images/car11.gif"));
	JLabel bike=new JLabel(new ImageIcon("src/images/bike.gif"));
	JLabel getready=new JLabel("");
	JButton s1=new JButton(new ImageIcon("src/images/car1.gif"));
	JButton s2=new JButton(new ImageIcon("src/images/car2.gif"));
	JButton s3=new JButton(new ImageIcon("src/images/car3.gif"));
	JButton s4=new JButton(new ImageIcon("src/images/car4.gif"));
	JButton s5=new JButton(new ImageIcon("src/images/car5.gif"));
	JButton s6=new JButton(new ImageIcon("src/images/car6.gif"));
	JButton s7=new JButton(new ImageIcon("src/images/car7.gif"));
	JButton s8=new JButton(new ImageIcon("src/images/car8.gif"));
	JButton s9=new JButton(new ImageIcon("src/images/car9.gif"));
	JButton s10=new JButton(new ImageIcon("src/images/car10.gif"));
	JButton s11=new JButton(new ImageIcon("src/images/car11.gif"));
	JButton cs=new JButton("Select Car");
	JLabel s12=new JLabel("No Car Selected");
	JButton test=new JButton("Play");
	int y1=0;
	int y2=-768;
	int y3=-1536;
	int xx;
	int bgnum;
	
	
        @SuppressWarnings("LeakingThisInConstructor")
	Game(){
//		JOptionPane.showMessageDialog(f,CarGame.class.getResource("tani"));

		ArrayList<Image> icos=new ArrayList<Image>();
		icos.add((new ImageIcon("src/images/24.ico")).getImage());
		icos.add((new ImageIcon("src/images/32.ico")).getImage());
		icos.add((new ImageIcon("src/images/64.ico")).getImage());
		icos.add((new ImageIcon("src/images/128.ico")).getImage());
		icos.add((new ImageIcon("src/images/256.ico")).getImage());
		f.setIconImages(icos);
		f2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		f.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		f.setExtendedState(Frame.MAXIMIZED_BOTH);
		f.setUndecorated(true);
		try{
		getNameScore();}
		catch(Exception ea){}
		background1.setBounds(0,y1,1920,771);
		background2.setBounds(0,y2,1920,771);
		background3.setBounds(0,y3,1920,771);
		f.add(about);
		f.add(exit);
		f.add(help);
		CHorn1.setBounds(0,0,bgnm-50,384);
		CHorn2.setBounds(0,384,bgnm-50,384);
		about.addMouseListener(this);
		help.addMouseListener(this);
		help.setBounds(bgnm+550,470,200,30);
		about.setBounds(bgnm+550,520,200,30);
		exit.setBounds(bgnm+550,570,200,30);
		exit.addMouseListener(this);
		test.setEnabled(false);
		scorecounter.setFont(new Font("arial",Font.BOLD,90));
		scorecounter.setForeground(Color.WHITE);
		watch.setFont(new Font("arial",Font.BOLD,16));
		watch.setForeground(Color.WHITE);
		welcome.setForeground(Color.WHITE);
		welcome.setBounds(bgnm+550,0,70,30);
		NAME.setBounds(bgnm+630,0,130,30);
		NAME.setForeground(Color.WHITE);
		HIGHSCORE.setBounds(bgnm+630,30,130,30);
		HIGHSCORE.setForeground(Color.WHITE);
		hssc.setBounds(bgnm+550,30,130,30);
		hssc.setForeground(Color.WHITE);
		BYHIGHSCORE.setForeground(Color.WHITE);
		BYHIGHSCORE.setBounds(bgnm+550,60,200,30);
		changename.setBounds(bgnm+550,100,200,30);
		changesensor.addMouseListener(this);
		f.add(NAME);
		f.add(HIGHSCORE);
		f.add(welcome);
		f.add(hssc);
		f.add(changename);
		f.add(BYHIGHSCORE);
		f.add(changesensor);
		changename.addMouseListener(this);
		s12.setFont(new Font("arial",Font.BOLD,12));
		fire.setSize(new ImageIcon("src/images/fire2.gif").getIconWidth(),(new ImageIcon("src/images/fire2.gif")).getIconHeight());
		car1.setSize(new ImageIcon("src/images/car1.gif").getIconWidth(),(new ImageIcon("src/images/car1.gif")).getIconHeight());
		car2.setSize(new ImageIcon("src/images/car2.gif").getIconWidth(),(new ImageIcon("src/images/car2.gif")).getIconHeight());
		car3.setSize(new ImageIcon("src/images/car3.gif").getIconWidth(),(new ImageIcon("src/images/car3.gif")).getIconHeight());
		car4.setSize(new ImageIcon("src/images/car4.gif").getIconWidth(),(new ImageIcon("src/images/car4.gif")).getIconHeight());
		car5.setSize(new ImageIcon("src/images/car5.gif").getIconWidth(),(new ImageIcon("src/images/car5.gif")).getIconHeight());
		car6.setSize(new ImageIcon("src/images/car6.gif").getIconWidth(),(new ImageIcon("src/images/car6.gif")).getIconHeight());
		car7.setSize(new ImageIcon("src/images/car7.gif").getIconWidth(),(new ImageIcon("src/images/car7.gif")).getIconHeight());
		car8.setSize(new ImageIcon("src/images/car8.gif").getIconWidth(),(new ImageIcon("src/images/car8.gif")).getIconHeight());
		car9.setSize(new ImageIcon("src/images/car9.gif").getIconWidth(),(new ImageIcon("src/images/car9.gif")).getIconHeight());
		car10.setSize(new ImageIcon("src/images/car10.gif").getIconWidth(),(new ImageIcon("src/images/car10.gif")).getIconHeight());
		car11.setSize(new ImageIcon("src/images/car11.gif").getIconWidth(),(new ImageIcon("src/images/car11.gif")).getIconHeight());
		s1.setSize(new ImageIcon("src/images/car1.gif").getIconWidth(),(new ImageIcon("src/images/car1.gif")).getIconHeight());
		s2.setSize(new ImageIcon("src/images/car2.gif").getIconWidth(),(new ImageIcon("src/images/car2.gif")).getIconHeight());
		s3.setSize(new ImageIcon("src/images/car3.gif").getIconWidth(),(new ImageIcon("src/images/car3.gif")).getIconHeight());
		s4.setSize(new ImageIcon("src/images/car4.gif").getIconWidth(),(new ImageIcon("src/images/car4.gif")).getIconHeight());
		s5.setSize(new ImageIcon("src/images/car5.gif").getIconWidth(),(new ImageIcon("src/images/car5.gif")).getIconHeight());
		s6.setSize(new ImageIcon("src/images/car6.gif").getIconWidth(),(new ImageIcon("src/images/car6.gif")).getIconHeight());
		s7.setSize(new ImageIcon("src/images/car7.gif").getIconWidth(),(new ImageIcon("src/images/car7.gif")).getIconHeight());
		s8.setSize(new ImageIcon("src/images/car8.gif").getIconWidth(),(new ImageIcon("src/images/car8.gif")).getIconHeight());
		s9.setSize(new ImageIcon("src/images/car9.gif").getIconWidth(),(new ImageIcon("src/images/car9.gif")).getIconHeight());
		s10.setSize(new ImageIcon("src/images/car10.gif").getIconWidth(),(new ImageIcon("src/images/car10.gif")).getIconHeight());
		s11.setSize(new ImageIcon("src/images/car11.gif").getIconWidth(),(new ImageIcon("src/images/car11.gif")).getIconHeight());
		
		bike.setSize(new ImageIcon("src/images/bike.gif").getIconWidth(),(new ImageIcon("src/images/bike.gif")).getIconHeight());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		left.addMouseListener(this);
		right.addMouseListener(this);
		CHorn1.addMouseListener(this);
		CHorn2.addMouseListener(this);
		left.setBounds(bgnm,0,200,768);
		right.setBounds(bgnm+312,0,200,768);
		test.addMouseListener(this);
		f.setBounds(0,0,1024,724);
		bg1.setBounds(bgnm,y1,512,770);
		bg2.setBounds(bgnm,y2,512,770);
		bg3.setBounds(bgnm,y3,512,770);
		Random rand=new Random();
		xx=rand.nextInt(4);
		xx=ln[xx];
		hero.setLocation(xx,530);
		watch.setBounds(bgnm+235,0,50,50);
		scorecounter.setBounds(bgnm+550,320,200,150);
		scorecounter.setText("0000");
		cs.setBounds(bgnm+550,200,200,50);
		changesensor.setBounds(bgnm+550,150,200,30);
		test.setBounds(bgnm+550,260,200,50);
		f.add(test);
		getready.setBounds(400,200,100,100);
		getready.setFont(new Font("arial black",Font.BOLD,50));
		getready.setForeground(Color.RED);
		f.setVisible(true);
		f2.setBounds(730,0,150,600);
		f2.setLayout(new GridLayout(2,6));
		f.add(cs);
		f2.add(s1);
		f2.add(s2);
		f2.add(s3);
		f2.add(s4);
		f2.add(s5);
		f2.add(s6);
		f2.add(s7);
		f2.add(s8);
		f2.add(s9);
		f2.add(s10);
		f2.add(s11);
		f2.add(s12);
		f.add(bg1);
		f.add(bg2);
		f.add(bg3);
		f.add(background1);
		f.add(background2);
		f.add(background3);
		fire.setLocation(400,-400);
		cs.addMouseListener(this);
		s1.addMouseListener(this);
		s2.addMouseListener(this);
		s3.addMouseListener(this);
		s4.addMouseListener(this);
		s5.addMouseListener(this);
		s6.addMouseListener(this);
		s7.addMouseListener(this);
		s8.addMouseListener(this);
		s9.addMouseListener(this);
		s10.addMouseListener(this);
		s11.addMouseListener(this);

		f.setResizable(false);

	}

	public void gamestart(){
		if(!isGame&&SELECTED){
			f.remove(background1);
			f.remove(background2);
			f.remove(background3);
			f.remove(bg1);
			f.remove(bg2);
			f.remove(bg3);
			test.setEnabled(false);
			background1.setIcon(new ImageIcon("src/images/bg.jpg"));
			background2.setIcon(new ImageIcon("src/images/bg.jpg"));
			background3.setIcon(new ImageIcon("src/images/bg.jpg"));	
		cs.setEnabled(false);
		stopper=true;
		isGame=true;
		f2.setVisible(true);
		Random rand=new Random();
		xx=rand.nextInt(4);
		hero.setLocation(ln[xx],530);
		xx=ln[xx];
		fire.setLocation(400,-400);
		car1.setLocation(200,-1000);
		car2.setLocation(200,-1000);
		car3.setLocation(200,-1000);
		car4.setLocation(200,-1000);
		car5.setLocation(200,-1000);
		car6.setLocation(200,-1000);
		car7.setLocation(200,-1000);
		car8.setLocation(200,-1000);
		car9.setLocation(200,-1000);
		car10.setLocation(200,-1000);
		car11.setLocation(200,-1000);
		TrackSpeed=11;
		Thread MORE=new Thread(new moreCars());
		Thread Crash=new Thread(new crash());
		Thread watchstop=new Thread(new base());
		Thread score=new Thread(new score());
		Thread tracker=new Thread(new track());
		Thread audio=new Thread(new Audio());
		f.add(fire);		
		f.add(hero);
		f.add(car1);
		f.add(car2);
		f.add(car3);
		f.add(car4);
		f.add(car5);
		f.add(car6);
		f.add(car7);
		f.add(car8);
		f.add(car9);
		f.add(car10);
		f.add(car11);
		f.add(watch);
		f.add(left);
		f.add(right);
		f.add(CHorn1);
		f.add(CHorn2);
		f.add(scorecounter);
		f.add(getready);
		f.add(fire);
		f.add(bg1);
		f.add(bg2);
		f.add(bg3);
		f.add(background1);
		f.add(background2);
		f.add(background3);		
	//	new makeapplets();
		audio.start();
		watchstop.start();
		score.start();
		tracker.start();
		Crash.start();
		MORE.start();
		callcar();
		callcar();
		}
		else{
			if(isGame){
				JOptionPane.showMessageDialog(f,"This action cannot be performed during game, sorry :')");
			}
			if(!SELECTED){
				JOptionPane.showMessageDialog(f,"Please select a car you'd like to drive :')");
			}
		}

	}
	
	public void gameover(){
		stopper=false;
		test.setEnabled(true);
		cs.setEnabled(true);
		isGame=false;
		fire.setLocation(hero.getX(),hero.getY()-20);
		hero.setLocation(400,-400);
		JOptionPane.showMessageDialog(f,"You played for "+mins+":"+secs+" & Your Score is "+Score);
		try{
		savescore();
		}
		catch(Exception e){}
	}
	
	public static void main(String[] args){
		new Game();
		}
	@Override
	public void mouseClicked(MouseEvent e) {		
		if(e.getSource()==help)
			JOptionPane.showMessageDialog(f,"1. Select a car by clicking on \"Select Car\" button.\n2. Click \"Play\" to start the game.\n3. Move your cursor left or right for driving directions.\n4. Or let the cursor be on Play button & right click to turn\n     right & left click to turn left.\n					5. If it's too slow or too fast click on \"modify sensor\" button.\n6. Move cursor top-left/botton-left for Horns.","Help Topics",JOptionPane.INFORMATION_MESSAGE);
		if(e.getSource()==about)
			JOptionPane.showMessageDialog(f,"My name is Tanweer Ahmad, I'm the coder of this game.\nThis is one of my few creations I can be proud of.\nI'm sharing this game as open source, can be downloaded\nfrom my github account github.com/Tani02\n14TL02@Student.muet.edu.pk  PrinceTanweer02@gmail.com","About Coder",JOptionPane.INFORMATION_MESSAGE);
		if(e.getSource()==exit)
			System.exit(0);
		if(e.getSource()==changesensor){
			String xy=JOptionPane.showInputDialog("If you think mouse-motion-sensor is too high or low\nGive your speed here, 22=Slowest, 8=Fastest.\n(By default everytime you open this game it'll become 16)","any number between 8 & 22");
			int tmp=0;
			if(xy!=null)
			tmp=Integer.parseInt(xy);
			if(tmp>=8&&tmp<=22)
                            sense=(short) tmp;
			else
			JOptionPane.showMessageDialog(f,"Aahan, I told you 8 is for Fastest & 22 is for Slowest, Give values between 8 & 22 only :')");
		}
		if(e.getSource()==changename){
				try{
					savename();
			}
		
				catch(Exception ea){}
		}
		if(e.getSource()==test&&test.isEnabled())
			gamestart();
		if(e.getSource()==cs&&cs.isEnabled())
			JOptionPane.showMessageDialog(f,f2,"Select the car of your choice",JOptionPane.INFORMATION_MESSAGE);
		if(e.getSource()==s1)
			{
			selecthero(1);
			test.setEnabled(true);
			s12.setText("White Car Selected");
			s12.setForeground(Color.WHITE);
			cs.setText("White Car");
			Speedo=75;
			}
		if(e.getSource()==s2)
			{
			selecthero(2);
			test.setEnabled(true);
			s12.setText("Black Car Selected");
			s12.setForeground(Color.BLACK);
			cs.setText("Black Car");
			Speedo=75;
			}
		if(e.getSource()==s3)
			{
			selecthero(3);
			test.setEnabled(true);
			s12.setText("Pajero Selected");
			s12.setForeground(Color.BLACK);
			cs.setText("Black Pajero");
			Speedo=50;
			}
		if(e.getSource()==s4)
			{
			selecthero(4);
			test.setEnabled(true);
			s12.setText("Mini Truck Selected");
			s12.setForeground(Color.GRAY);
			cs.setText("Mini Truck");
			Speedo=50;
			}
		if(e.getSource()==s5)
			{
			selecthero(5);
			test.setEnabled(true);
			s12.setText("Red Car Selected");
			s12.setForeground(Color.RED);
			cs.setText("Red Car");
			Speedo=80;
			}
		if(e.getSource()==s6)
			{
			selecthero(6);
			test.setEnabled(true);
			s12.setText("Yellow Car Selected");
			s12.setForeground(Color.YELLOW);
			cs.setText("Yellow Car");
			Speedo=50;
			}
		if(e.getSource()==s7)
			{
			selecthero(7);
			test.setEnabled(true);
			s12.setText("Mini Pink Selected");
			s12.setForeground(Color.MAGENTA);
			cs.setText("Mini Pink");
			Speedo=110;
			}
		if(e.getSource()==s8)
			{
			selecthero(8);
			test.setEnabled(true);
			s12.setText("SkyBlue Car Selected");
			s12.setForeground(Color.BLUE);
			cs.setText("SkyBlue Car");
			Speedo=60;
			}
		if(e.getSource()==s9)
			{
			selecthero(9);
			String ij=HIGHSCORE.getText();
			int ab=Integer.parseInt(ij);
			if(ab>=4000)
			{
			test.setEnabled(true);
			s12.setText("Blue Car Selected");
			s12.setForeground(Color.BLUE);
			cs.setText("Blue Car");
			Speedo=75;}
			}
		if(e.getSource()==s10)
			{
			selecthero(10);
			String ij=HIGHSCORE.getText();
			int ab=Integer.parseInt(ij);
			if(ab>=4000)
			{
			test.setEnabled(true);
			s12.setText("Brown Car Selected");
			s12.setForeground(Color.RED);
			cs.setText("Brown Car");
			Speedo=75;}
			}
		if(e.getSource()==s11)
			{
			selecthero(11);
			String ij=HIGHSCORE.getText();
			int ab=Integer.parseInt(ij);
			if(ab>=4000)
			{
			test.setEnabled(true);
			s12.setText("Green Car Selected");
			s12.setForeground(Color.GREEN);
			cs.setText("Green Car");
			Speedo=75;}
			}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		move=true;
		if(e.getSource()==right){
			
			Thread rightmove=new Thread(new moveright());
			rightmove.start();
		}
		if(e.getSource()==left){
			Thread leftmove=new Thread(new moveleft());
			leftmove.start();
		
		}
		if(e.getSource()==CHorn1&&stopper)
			CarHorn1.play();
		if(e.getSource()==CHorn2&&stopper)
			CarHorn2.play();
		

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==left)
			move=false;
		if(e.getSource()==right)
			move=false;

	}

	@Override
	public void mousePressed(MouseEvent e) {	
				move=true;
		if(e.getButton()==MouseEvent.BUTTON3){
			
			Thread rightmove=new Thread(new moveright());
			rightmove.start();
		}
		if(e.getButton()==MouseEvent.BUTTON1){
			Thread leftmove=new Thread(new moveleft());
			leftmove.start();

		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1)
			move=false;
		if(e.getButton()==MouseEvent.BUTTON3)
			move=false;

			
	}
	public void selecthero(int ijk){
		switch(ijk){
		case 1:
			hero.setIcon(new ImageIcon("src/images/car1.gif"));
			hero.setSize(new ImageIcon("src/images/car1.gif").getIconWidth(),(new ImageIcon("src/images/car1.gif")).getIconHeight());
			SELECTED=true;
			break;
		case 2:
			hero.setIcon(new ImageIcon("src/images/car2.gif"));
			hero.setSize(new ImageIcon("src/images/car2.gif").getIconWidth(),(new ImageIcon("src/images/car2.gif")).getIconHeight());
			SELECTED=true;
			break;
		case 3:
			hero.setIcon(new ImageIcon("src/images/car3.gif"));
			hero.setSize(new ImageIcon("src/images/car3.gif").getIconWidth(),(new ImageIcon("src/images/car3.gif")).getIconHeight());
			SELECTED=true;
			break;
		case 4:
			hero.setIcon(new ImageIcon("src/images/car4.gif"));
			hero.setSize(new ImageIcon("src/images/car4.gif").getIconWidth(),(new ImageIcon("src/images/car4.gif")).getIconHeight());
			SELECTED=true;
			break;	
		case 5:
			hero.setIcon(new ImageIcon("src/images/car5.gif"));
			hero.setSize(new ImageIcon("src/images/car5.gif").getIconWidth(),(new ImageIcon("src/images/car5.gif")).getIconHeight());
			SELECTED=true;
			break;
		case 6:
			hero.setIcon(new ImageIcon("src/images/car6.gif"));
			hero.setSize(new ImageIcon("src/images/car6.gif").getIconWidth(),(new ImageIcon("src/images/car6.gif")).getIconHeight());
			SELECTED=true;
			break;
		case 7:
			hero.setIcon(new ImageIcon("src/images/car7.gif"));
			hero.setSize(new ImageIcon("src/images/car7.gif").getIconWidth(),(new ImageIcon("src/images/car7.gif")).getIconHeight());
			SELECTED=true;
			break;
		case 8:
			hero.setIcon(new ImageIcon("src/images/car8.gif"));
			hero.setSize(new ImageIcon("src/images/car8.gif").getIconWidth(),(new ImageIcon("src/images/car8.gif")).getIconHeight());
			SELECTED=true;
			break;
		case 9:
			String ij=HIGHSCORE.getText();
			int ab=Integer.parseInt(ij);
		if(ab>=4000){
			hero.setIcon(new ImageIcon("src/images/car9.gif"));
			hero.setSize(new ImageIcon("src/images/car9.gif").getIconWidth(),(new ImageIcon("src/images/car9.gif")).getIconHeight());
			SELECTED=true;
		}
		else
			JOptionPane.showMessageDialog(f2,"To Drive this beautiful car your highscore should be >= 4000.");
		break;
		case 10:
			String ij2=HIGHSCORE.getText();
			int ab2=Integer.parseInt(ij2);
		if(ab2>=4000){
			hero.setIcon(new ImageIcon("src/images/car10.gif"));
			hero.setSize(new ImageIcon("src/images/car10.gif").getIconWidth(),(new ImageIcon("src/images/car10.gif")).getIconHeight());
			SELECTED=true;			
		}
		else
			JOptionPane.showMessageDialog(f2,"To Drive this beautiful car your highscore should be >= 4000.");

			break;

		case 11:
			String ij3=HIGHSCORE.getText();
			int ab3=Integer.parseInt(ij3);
		if(ab3>=4000){

			hero.setIcon(new ImageIcon("src/images/car11.gif"));
			hero.setSize(new ImageIcon("src/images/car11.gif").getIconWidth(),(new ImageIcon("src/images/car11.gif")).getIconHeight());
			SELECTED=true;
		}
		else
			JOptionPane.showMessageDialog(f2,"To Drive this beautiful car your highscore should be >= 4000.");
		break;

		
//		case 12:
	//		hero.setIcon(new ImageIcon("src/images/bike.gif"));
		//	hero.setSize(new ImageIcon("src/images/bike.gif").getIconWidth(),(new ImageIcon("src/images/bike.gif")).getIconHeight());
			//SELECTED=true;
		//	break;
		default:
			hero.setIcon(new ImageIcon("src/images/car7.gif"));
			hero.setSize(new ImageIcon("src/images/car7.gif").getIconWidth(),(new ImageIcon("src/images/car7.gif")).getIconHeight());
			SELECTED=true;
			break;
		}

	}

	public class Car2 extends Thread{
		Random rand=new Random();
		int i=rand.nextInt(11)+cspeed;
		int j=rand.nextInt(4);
		int yy1=rand.nextInt(400)-600;
		public void run(){
			while(line[j])
				j=rand.nextInt(4);
				line[j]=true;
			car2.setLocation(ln[j],yy1);
			while(yy1<=770&&stopper){
				try{
					Thread.sleep(i);
				}
				catch(Exception ea){}
				car2.setLocation(ln[j],yy1+=5);
			}
			car2.setLocation(350,-300);
			line[j]=false;
			callcar();
			cc2=true;		
		}
	}
	
	public class Car3 extends Thread{
		Random rand=new Random();
		int i=rand.nextInt(11)+cspeed;
		int j=rand.nextInt(4);
		int yy1=rand.nextInt(400)-600;
		public void run(){
			while(line[j])
				j=rand.nextInt(4);
			line[j]=true;
			car3.setLocation(ln[j],yy1);
			while(yy1<=770&&stopper){
				try{
					Thread.sleep(i);
				}
				catch(Exception ea){}
				car3.setLocation(ln[j],yy1+=5);
			}
			car3.setLocation(350,-300);
			line[j]=false;
			callcar();
			cc3=true;
		}
	}

	public class Car4 extends Thread{
		Random rand=new Random();
		int i=rand.nextInt(11)+cspeed;
		int j=rand.nextInt(4);
		int yy1=rand.nextInt(400)-600;
		public void run(){
			while(line[j])
				j=rand.nextInt(4);
			line[j]=true;
			car4.setLocation(ln[j],yy1);
			while(yy1<=770&&stopper){
				try{
					Thread.sleep(i);
				}
				catch(Exception ea){}
				car4.setLocation(ln[j],yy1+=5);
			}
			car4.setLocation(350,-300);
			line[j]=false;
			callcar();
			cc4=true;
		}
	}

	public class Car5 extends Thread{
		Random rand=new Random();
		int i=rand.nextInt(11)+cspeed;
		int j=rand.nextInt(4);
		int yy1=rand.nextInt(400)-600;
		public void run(){
			while(line[j])
				j=rand.nextInt(4);
			line[j]=true;
			car5.setLocation(ln[j],yy1);
			while(yy1<=770&&stopper){
				try{
					Thread.sleep(i);
				}
				catch(Exception ea){}
				car5.setLocation(ln[j],yy1+=5);
			}
			car5.setLocation(350,-300);
			line[j]=false;
			callcar();
			cc5=true;
		}
	}
	
	public class Car6 extends Thread{
		Random rand=new Random();
		int i=rand.nextInt(11)+cspeed;
		int j=rand.nextInt(4);
		int yy1=rand.nextInt(400)-600;
		public void run(){
			while(line[j])
				j=rand.nextInt(4);
			line[j]=true;
			car6.setLocation(ln[j],yy1);
			while(yy1<=770&&stopper){
				try{
					Thread.sleep(i);
				}
				catch(Exception ea){}
				car6.setLocation(ln[j],yy1+=5);
				}
			car6.setLocation(350,-300);
			line[j]=false;
			callcar();
			cc6=true;
		}
	}

	public class Car7 extends Thread{
		Random rand=new Random();
		int i=rand.nextInt(11)+cspeed;
		int j=rand.nextInt(4);
		int yy1=rand.nextInt(400)-600;
		public void run(){
			while(line[j])
				j=rand.nextInt(4);
			line[j]=true;		
			car7.setLocation(ln[j],yy1);
			while(yy1<=770&&stopper){
				try{
					Thread.sleep(i);
				}
				catch(Exception ea){}
				car7.setLocation(ln[j],yy1+=5);
			}
			car7.setLocation(350,-300);
			line[j]=false;
			callcar();
			cc7=true;
		}
	}

	
	public class Car8 extends Thread{
		Random rand=new Random();
		int i=rand.nextInt(11)+cspeed;
		int j=rand.nextInt(4);
		int yy1=rand.nextInt(400)-600;
		public void run(){
			while(line[j])
				j=rand.nextInt(4);
			line[j]=true;
			car8.setLocation(ln[j],yy1);
			while(yy1<=770&&stopper){
				try{
					Thread.sleep(i);
				}
				catch(Exception ea){}
				car8.setLocation(ln[j],yy1+=5);
			}
			car8.setLocation(350,-300);
			line[j]=false;
			callcar();
			cc8=true;
		}
	}
	
	public class Car9 extends Thread{
		Random rand=new Random();
		int i=rand.nextInt(11)+cspeed;
		int j=rand.nextInt(4);
		int yy1=rand.nextInt(400)-600;
		public void run(){
			while(line[j])
				j=rand.nextInt(4);
			line[j]=true;
			car9.setLocation(ln[j],yy1);
			while(yy1<=770&&stopper){
				try{
					Thread.sleep(i);
				}
				catch(Exception ea){}
				car9.setLocation(ln[j],yy1+=5);
				}
			car9.setLocation(350,-300);
			line[j]=false;
			callcar();
			cc9=true;
		}
	}

	
	public class Car10 extends Thread{
		Random rand=new Random();
		int j=rand.nextInt(4);
		int i=rand.nextInt(11)+cspeed;
		int yy1=rand.nextInt(400)-600;
		public void run(){
			while(line[j])
				j=rand.nextInt(4);
			line[j]=true;
			car10.setLocation(ln[j],yy1);
			while(yy1<=770&&stopper){
				try{
					Thread.sleep(i);
				}
				catch(Exception ea){}
				car10.setLocation(ln[j],yy1+=5);
			}
			car10.setLocation(350,-300);
			line[j]=false;
			callcar();
			cc10=true;
		}
	}

	public class Car11 extends Thread{
		Random rand=new Random();
		int i=rand.nextInt(11)+cspeed;
		int j=rand.nextInt(4);
		int yy1=rand.nextInt(400)-600;
		public void run(){
			while(line[j])
				j=rand.nextInt(4);
			line[j]=true;
			car11.setLocation(ln[j],yy1);
			while(yy1<=770&&stopper){
				try{
					Thread.sleep(i);
				}
				catch(Exception ea){}
				car11.setLocation(ln[j],yy1+=5);
						}
			car11.setLocation(350,-300);
			line[j]=false;
			callcar();
			cc11=true;
		}
	}
	
	public void callcar(){
		if(isGame){
			Random rand=new Random();
			int abc=rand.nextInt(11)+1;
			switch(abc){
			case 1:
				Thread CCar1=new Thread(new Car1());
				if(cc1){
					CCar1.start();
					cc1=false;
				}
				else
					callcar();
				break;
			case 2:
				Thread CCar2=new Thread(new Car2());
				if(cc2){
					CCar2.start();
					cc2=false;
				}
				else
					callcar();
				break;
			case 3:
				Thread CCar3=new Thread(new Car3());
				if(cc3){
					CCar3.start();
					cc3=false;
				}
				else
					callcar();
				break;
			case 4:
				Thread CCar4=new Thread(new Car4());
				if(cc4){
					CCar4.start();
					cc4=false;
				}
				else
					callcar();
				break;
			case 5:
				Thread CCar5=new Thread(new Car5());
				if(cc5){
					CCar5.start();
					cc5=false;
				}
				else
					callcar();
				break;
			case 6:
				Thread CCar6=new Thread(new Car6());
				if(cc6){
					CCar6.start();
					cc6=false;
				}
				else
					callcar();				
				break;
			case 7:
				Thread CCar7=new Thread(new Car7());
				if(cc7){
					CCar7.start();
					cc7=false;
				}
				else
					callcar();				
				break;
			case 8:
				Thread CCar8=new Thread(new Car8());
				if(cc8){
					CCar8.start();
					cc8=false;
				}
				else
					callcar();
				break;
			case 9:
				Thread CCar9=new Thread(new Car9());
				if(cc9){
					CCar9.start();
					cc9=false;
				}
				else
					callcar();
				break;
			case 10:
				Thread CCar10=new Thread(new Car10());
				if(cc10){
					cc10=false;
					CCar10.start();
				}
				else
					callcar();
				break;
			case 11:
				Thread CCar11=new Thread(new Car11());
				if(cc11){
					cc11=false;
					CCar11.start();
				}			
				else
					callcar();
				break;
	
			}
		}
		}
	
	public void getNameScore(){
		try{
			FileInputStream in_name=new FileInputStream(new File("tani"));
                        String name;
                    try (InputStreamReader reader = new InputStreamReader(in_name)) {
                        int m;
                        name = "";
                        while(!((m=reader.read())==-1)){
                            char nme=(char)m;
                            name=name+nme;
			}
                    }
			NAME.setText(name);

		}
		catch(Exception e){
			try{savename();
			}
			catch(Exception ea){}
		}
	
		try{
			FileInputStream hi_score=new FileInputStream(new File("hs.tani"));
                        String s;
                    try (InputStreamReader reader = new InputStreamReader(hi_score)) {
                        int h;
                        s = "";
                        while((h=reader.read())!=-1){
                            char c=(char) h;
				s=s+c;
			}
                    }
			String onlyscore=s.substring(0,s.indexOf(':'));
			highscore=Integer.parseInt(onlyscore);
			HIGHSCORE.setText(""+highscore);
			BYHIGHSCORE.setText("Scored by:    "+s.substring(s.indexOf(':')+1));
		}
		catch(Exception e){
			try{
			savescore();
			
		}
			catch(Exception t){}
			
		}
	}
	
	public void savename() throws Exception{
		String nm=JOptionPane.showInputDialog("What is your name? I guess, Ummm, "+InetAddress.getLocalHost().getHostName()+"!");
		FileOutputStream out=new FileOutputStream("tani");
		out.write(nm.getBytes());
		out.close();
		NAME.setText(nm);
	}
	public void savescore() throws IOException{
		if(Score>=highscore){
			highscore=Score;
			String byname=NAME.getText();
			String hsc=String.valueOf(highscore)+":"+byname;
			File file=new File("hs.tani");
			FileOutputStream out=new FileOutputStream(file);
			out.write(hsc.getBytes());
			out.close();	
			HIGHSCORE.setText(""+highscore);
			BYHIGHSCORE.setText("Score by: "+byname);
		}
		
	}	
	
}
//Game by Tanweer Ahmad.
//www.TLians.com
//PrinceTanweer02@gmail.com
