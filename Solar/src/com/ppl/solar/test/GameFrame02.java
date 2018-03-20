package com.ppl.solar.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class GameFrame02 extends GameFrame
{
	private Image yellowMan = null;
	private double x = 100;
	private double y = 100;
	private double degree = Math.PI/3; //[0,2PI]
	private double speed = 20;
	private int IMG_WIDTH = 114;
	private int IMG_HIGHT = 114;
	
	@Override
	public void paint(Graphics g) 
	{
		g.drawImage(yellowMan, (int)x, (int)y, null);
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		if (y<0 || y+IMG_HIGHT>Constant.GAME_HIGHT)
		{
			degree = -degree;
		}
		if (x<0 || x+IMG_WIDTH>Constant.GAME_WIDTH)
		{
			degree = Math.PI-degree;
		}
	}
	
	@Override
	public void loadImage()
	{
		this.yellowMan = GameUtil.getImage("images/yellow.jpg");
	}
	
	public static void main(String[] args) 
	{
		GameFrame02 gf2 = new GameFrame02();
		gf2.loadImage();
		gf2.launchFrame();
	}
}
