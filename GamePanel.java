package snakeGame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
public class GamePanel extends JPanel implements Runnable,KeyListener{
	private static final int Width=500,Height=500;
	private Thread thread;
	private boolean running;
	private boolean right=true,left=false,up=false,down=false;
	private Body_Part body;
	private ArrayList<Body_Part> snake;
	private pulang_mansanas apple;
	private ArrayList<pulang_mansanas> apples;
	private Random r;
	private int x=10,y=10,size=15;
	private int ticks=0;
	public GamePanel(){
		setFocusable(true);
		setPreferredSize(new Dimension(Width,Height));
		addKeyListener(this);
		snake=new ArrayList<Body_Part>();
		apples=new ArrayList<pulang_mansanas>();
		r=new Random();
		start();
	}
	public void start(){
		running=true;
		thread =new Thread(this);
		thread.start();
	}
	public void stop(){
		running =false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void tck() {
		if(snake.size()==0){
			body=new Body_Part(x,y,10);
			snake.add(body);
		}
		ticks++;
		if(ticks>250000) {
			if(right)
				x++;
			if(left)
				x--;
			if(down)
				y--;
			if(up)
				y++;
			
			ticks=0;
			body=new Body_Part(x,y,10);
			snake.add(body);
			
			if(snake.size()>size)
				snake.remove(0);
			
		}
		if(apples.size()==0) {
			int xcoor=r.nextInt(49);
			int ycoor=r.nextInt(49);
			apple=new pulang_mansanas(xcoor,ycoor,10);
			apples.add(apple);
		}
		for(int i=0;i<apples.size();i++){
			if(x==apples.get(i).getX() && y==apples.get(i).getY()) {
				size++;
				apples.remove(i);
				i++;
			}
		}
		for(int i=0;i<snake.size();i++){
			if(x==snake.get(i).getX() && y==snake.get(i).getY()) {
				if(i!=snake.size()-1){
					System.out.println("Game Over :D");
					stop();
				}
			}
		}
		if(x<0||x>49||y<0||y>49) {
			System.out.println("Game Over :D");
			stop();
		}
	}
	public void paintComponent(Graphics g){
		g.clearRect(0, 0, Width, Height);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 0,0);
		for(int i=0;i<Width/10;i++)
			g.drawLine(i*10,0,i*10, Height);
		for(int i=0;i<Height/10;i++)
			g.drawLine(0,i*10,Height,i*10);
		for(int i=0;i<snake.size();i++)
			snake.get(i).draw(g);
		for(int i=0;i<apples.size();i++)
			apples.get(i).draw(g);
		
	}
	@Override
	public void run() {
		while(running){
			tck();
			repaint();
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		if(key==KeyEvent.VK_RIGHT && !left){
			right=true;
			up=false;
			down=false;
		}
		if(key==KeyEvent.VK_LEFT && !right){
			left=true;
			up=false;
			down=false;
		}
		if(key==KeyEvent.VK_DOWN && !down){
			up=true;
			left=false;
			right=false;
		}
		if(key==KeyEvent.VK_UP && !up){
			down=true;
			left=false;
			right=false;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
