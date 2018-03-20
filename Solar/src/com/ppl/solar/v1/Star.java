package com.ppl.solar.v1;

import java.awt.Graphics;
import java.awt.Image;

public class Star 
{
	Image img;
	double x,y;  //顶点
	double x0,y0; //中心点
	
	public void draw(Graphics g)
	{
		g.drawImage(img, (int)x, (int)y, null); //画中心点
	}

	public Star(String path)
	{
		this.img = GameUtil.getImage(path);
	}
	
	public Star(String path, double x0, double y0)
	{
		this.img = GameUtil.getImage(path);
		this.x = x0 - this.img.getWidth(null)/2;
		this.y = y0 - this.img.getHeight(null)/2;
		this.x0 = x0;
		this.y0 = y0;
	}
	
}
