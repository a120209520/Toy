package com.ppl.plane.v1;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends Frame
{
	Image offScreenImage = null;
	public void launchFrame()
	{
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
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
	
	
	
	@Override
	public void update(Graphics g) 
	{
		if(offScreenImage == null) 
		{
			offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
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
