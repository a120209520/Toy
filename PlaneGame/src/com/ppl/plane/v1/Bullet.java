package com.ppl.plane.v1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Bullet 
{
	Image img = GameUtil.getImage("images/bullet.jpg");
	double x,y;  //顶点
	double x0,y0; //中心点
	double speed;
	double degree;
	int width,height;
	
	public Bullet()
	{
		degree = Math.random()*Math.PI*2;
		speed = Math.random()*3;
		width = img.getWidth(null);
		height = img.getHeight(null);
		do
		{
			x0 = Math.random()*Constant.GAME_WIDTH;
			y0 = Math.random()*Constant.GAME_HEIGHT;
		}while(outofRange((int)x0, (int)y0));
		x = x0 - width/2;
		y = y0 - height/2;
	}
	
	public Rectangle getRect()
	{
		return new Rectangle((int)x, (int)y, width, height);
	}
	
	private boolean outofRange(int x, int y)
	{
		if (x>Constant.GAME_WIDTH/4 && x<Constant.GAME_WIDTH*3/4)
		{
			if (y>Constant.GAME_HEIGHT/4 && y<Constant.GAME_HEIGHT*3/4)
				return true;
		}
		return false;
	}
	
	public void move()
	{
		x0 += speed*Math.cos(degree);
		y0 += speed*Math.sin(degree);
		if(x0<0 || x0>Constant.GAME_WIDTH)
		{
			degree = Math.PI - degree;
		}
		if(y0<0 || y0>Constant.GAME_HEIGHT)
		{
			degree = -degree;
		}
		x = x0 - width/2;
		y = y0 - height/2;
		
		speed += 0.001;
	}
	
	public void draw(Graphics g)
	{
		move();
		g.drawImage(img, (int)x, (int)y, null);
	}
}
