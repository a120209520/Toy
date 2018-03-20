package com.ppl.solar.v1;

import java.awt.Color;
import java.awt.Graphics;

public class Planet extends Star
{
	double a;  //椭圆的长轴
	double b;  //椭圆的短轴
	double speed;  //飞行速度
	double degree; //角度
	Star center;   //恒星
	
	public Planet(String path, double a, double b, double speed, Star center) 
	{
		super(path);
		this.x0 = center.x0 + a;
		this.y0 = center.y0 + b;
		this.x = this.x0 - this.img.getWidth(null)/2;
		this.y = this.y0 - this.img.getWidth(null)/2;
		this.a = a;
		this.b = b;
		this.speed = speed;
		this.center = center;
	}

	@Override
	public void draw(Graphics g) 
	{
		move();
		super.draw(g);
		drawTrace(g);
	}
	
	public void drawTrace(Graphics g)
	{
		Color oriColor = g.getColor();
		int t_x = (int)(center.x0 - a);
		int t_y = (int)(center.y0 - b);
		int t_w = (int)(2*a);
		int t_h = (int)(2*b);
		g.setColor(Color.GRAY);
		g.drawOval( t_x, t_y, t_w, t_h);
		g.setColor(oriColor);
	}
	
	public void move()
	{
		x0 = center.x0 + a*Math.cos(degree);
		y0 = center.y0 + b*Math.sin(degree);
		x = x0 - this.img.getWidth(null)/2;
		y = y0 - this.img.getWidth(null)/2;
		degree += speed;
	}
}
