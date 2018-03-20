package com.ppl.plane.v1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Date;

public class GameAct 
{
	static Date startTime;
	static Date endTime;
	static long tempTimer;
	static boolean isGameOver = false;
	
	public static void actCrash(Rectangle a, Rectangle b, Plane pl)
	{
		if (a.intersects(b))
		{
			pl.setAlive(false);
		}
	}
	
	public static void GameStart()
	{
		startTime = new Date();
	}
	
	public static void GameOver(Graphics g)
	{
		if (!isGameOver)
		{
			endTime = new Date();
		}
		long gameTime = endTime.getTime() - startTime.getTime();
		int x = Constant.GAME_WIDTH/2 - 155;
		int y = Constant.GAME_HEIGHT/2;
		PrintString(g, Color.BLACK, "Game Over!", 50, x, y);
		PrintString(g, Color.RED,"Score:"+gameTime+"ms", 20, x+80, y+50);
		PrintString(g, Color.BLACK, "Made by Lz", 20, 20,550);
		isGameOver = true;
	}
	
	public static void PrintTime(Graphics g)
	{
		if (!isGameOver)
		{
			tempTimer += Constant.INTERVAL; 
			PrintString(g, Color.BLACK,"Time:"+tempTimer+"ms", 20, 450, 60);
		}
	}
	
	public static void PrintString(Graphics g, Color color, String str, int size, int x, int y)
	{
		Color ori = g.getColor();
		g.setColor(color);
		Font font = new Font("微软雅黑", Font.BOLD, size);
		g.setFont(font);
		g.drawString(str, x, y);
		g.setColor(ori);
	}
}





