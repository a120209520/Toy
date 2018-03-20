package com.ppl.plane.v1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PlaneGameFrame extends GameFrame
{
	Image backGround = GameUtil.getImage("images/bg.jpg");
	Plane pl = new Plane("images/plane.jpg", Constant.GAME_WIDTH/2, Constant.GAME_HEIGHT/2);
	ArrayList bulletList = new ArrayList();
	
	@Override
	public void paint(Graphics g) 
	{
		g.drawImage(backGround, 0, 0, null);
		pl.draw(g);
		for (int i=0; i<bulletList.size(); i++)
		{
			Bullet b = (Bullet)bulletList.get(i);
			b.draw(g);
			GameAct.actCrash(b.getRect(), pl.getRect(), pl);
		}
		GameAct.PrintTime(g);
	}
	
	@Override
	public void launchFrame() 
	{
		super.launchFrame();
		addKeyListener(new KeyControler());
		for (int i=0; i<15; i++)
		{
			Bullet b = new Bullet();
			bulletList.add(b);
		}
		GameAct.GameStart();
	}

	class KeyControler extends KeyAdapter
	{
		@Override
		public void keyPressed(KeyEvent key) 
		{
			pl.actKey(key, true);
		}

		@Override
		public void keyReleased(KeyEvent key) 
		{
			pl.actKey(key, false);
		}	
	}

	public static void main(String[] args) 
	{
		PlaneGameFrame pgf = new PlaneGameFrame();
		pgf.launchFrame();
	}
}
