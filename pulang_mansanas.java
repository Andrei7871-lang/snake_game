package snakeGame;

import java.awt.Color;
import java.awt.Graphics;

public class pulang_mansanas {
	private int x,y,width,height;
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
public pulang_mansanas(int x,int y,int tileSize){
	this.x=x;
	this.y=y;
	width=tileSize;
	height=tileSize;
}
public void tck() {
}
public void draw(Graphics g){
	g.setColor(Color.red);
	g.fillRect(x*width, y*height, width, height);
}
}