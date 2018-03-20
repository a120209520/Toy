package com.ppl.solar.test;

import java.awt.Graphics;
import java.awt.Image;

public class GameFrame03 extends GameFrame
{
	private Image yellowMan = null;
	private double x = 100;
	private double y = 100;
	private double degree = Math.PI/3; //[0,2PI]
	private double speed = 0.3;
	private int IMG_WIDTH = 114;
	private int IMG_HIGHT = 114;
	
	@Override
	public void paint(Graphics g) 
	{
		g.drawImage(yellowMan, (int)x, (int)y, null);
		x = 200 + 100*Math.cos(degree);
		y = 200 + 50*Math.sin(degree);
		degree += speed;
	}
	
	@Override
	public void loadImage()
	{
		this.yellowMan = GameUtil.getImage("images/yellow.jpg");
	}
	public static void main(String[] args) 
	{
		GameFrame03 gf3 = new GameFrame03();
		gf3.loadImage();
		gf3.launchFrame();
	}

}
