package com.ppl.plane.v1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Plane 
{
	Image img;
	double x,y;  //顶点
	double x0,y0; //中心点
	double speed = 4;
	boolean left,right,up,down;
	int width,height;
	boolean isAlive = true;

	public Plane(String path, double x0, double y0)
	{
		this.img = GameUtil.getImage(path);
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		this.x = x0 - this.width/2;
		this.y = y0 - this.height/2;
		this.x0 = x0;
		this.y0 = y0;
	}
	
	public Rectangle getRect()
	{
		return new Rectangle((int)x+20, (int)y+20, width-40, height-40);
	}
	
	public void actKey(KeyEvent key, boolean pressed)
	{
		switch(key.getKeyCode())
		{
			case KeyEvent.VK_LEFT:  left  = pressed; break;
			case KeyEvent.VK_RIGHT: right = pressed; break;
			case KeyEvent.VK_UP:    up    = pressed; break;
			case KeyEvent.VK_DOWN:  down  = pressed; break;
		}
	}
	
	public void move()
	{	
		if (left)  x -= speed;
		if (right) x += speed;
		if (up)    y -= speed;
		if (down)  y += speed;
	}
	
	public void draw(Graphics g)
	{
		if (isAlive)
		{
			move();	
			g.drawImage(img, (int)x, (int)y, null);
		}
		else
		{
			GameAct.GameOver(g);
		}
	}
	
	public boolean isAlive() 
	{
		return isAlive;
	}

	public void setAlive(boolean isAlive) 
	{
		this.isAlive = isAlive;
	}
}
