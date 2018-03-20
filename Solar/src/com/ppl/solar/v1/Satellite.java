package com.ppl.solar.v1;

import java.awt.Color;
import java.awt.Graphics;

public class Satellite extends Planet
{

	public Satellite(String path, double a, double b, double speed, Star center) 
	{
		super(path, a, b, speed, center);
	}

	@Override
	public void drawTrace(Graphics g) 
	{
//		Color oriColor = g.getColor();
//		int t_x = (int)(center.x0 - a);
//		int t_y = (int)(center.y0 - b);
//		int t_w = (int)(2*a);
//		int t_h = (int)(2*b);
//		g.setColor(Color.CYAN);
//		g.drawOval( t_x, t_y, t_w, t_h);
//		g.setColor(oriColor);
	}
	
	
}
