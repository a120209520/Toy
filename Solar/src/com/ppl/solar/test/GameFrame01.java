package com.ppl.solar.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GameFrame01 extends GameFrame
{
	@Override
	public void paint(Graphics g) 
	{
		g.drawLine(50, 50, 150, 150);
		g.drawRect(50, 50, 100, 100);
		g.drawOval(50, 50, 100, 100);
		
		g.setFont(new Font("微软雅黑", Font.BOLD, 20));
		g.drawString("PPL", 100, 100);
		
		Color oriColor = g.getColor();
		g.setColor(Color.red);
		g.fillOval(125, 125, 25, 25);
		g.fillRect(50, 50, 25, 25);
		g.setColor(oriColor);
	}
	
	public static void main(String[] args) 
	{
		GameFrame01 gf1 = new GameFrame01();
		gf1.launchFrame();
	}

}
