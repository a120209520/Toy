package com.ppl.solar.test;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends Frame
{
	public void launchFrame()
	{
		setSize(Constant.GAME_WIDTH,Constant.GAME_HIGHT);
		setLocation(Constant.GAME_X, Constant.GAME_Y);
		setVisible(true);	
		new PaintThread().start();
		addWindowListener(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			}
		);
	}
	
	public void loadImage()
	{
		
	}
	
	class PaintThread extends Thread
	{
		public void run()
		{
			while (true)
			{
				repaint();
				try 
				{
					Thread.sleep(Constant.INTERVAL);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
}
