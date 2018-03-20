package com.ppl.solar.v1;

import java.awt.Graphics;
import java.awt.Image;

public class SolarFrame extends GameFrame
{
	Image backGround = GameUtil.getImage("images/bg2.jpg");
	Star sun = new Star("images/Sun.jpg", Constant.GAME_WIDTH/2, Constant.GAME_HEIGHT/2);
	Planet mercury = new Planet("images/Mercury.jpg", 80, 40, 0.1, sun);
	Planet venus = new Planet("images/Venus.jpg", 120, 60, 0.04, sun);
	Planet earth = new Planet("images/Earth.jpg", 160, 80, 0.025, sun);
	Planet mars = new Planet("images/Mars.jpg", 200, 100, 0.01, sun);
	Planet jupiter = new Planet("images/Jupiter.jpg", 240, 120, 0.01, sun);
	Planet saturn = new Planet("images/Saturn.jpg", 280, 140, 0.005, sun);
	Planet uranus = new Planet("images/Uranus.jpg", 320, 160, 0.002, sun);
	Planet neptune = new Planet("images/Neptune.jpg", 360, 180, 0.001, sun);
	Satellite moon = new Satellite("images/Moon.jpg", 10, 10, 0.2, earth);
	@Override
	public void paint(Graphics g) 
	{
		g.drawImage(backGround, 0, 0, null);	
		sun.draw(g);
		mercury.draw(g);
		venus.draw(g);
		earth.draw(g);
		mars.draw(g);
		jupiter.draw(g);
		saturn.draw(g);
		uranus.draw(g);
		neptune.draw(g);
		moon.draw(g);
	}

	public static void main(String[] args) 
	{
		SolarFrame sf = new SolarFrame();
		sf.launchFrame();
	}
}
