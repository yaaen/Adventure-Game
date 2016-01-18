package GameState;

import java.awt.Color;
import java.awt.Graphics2D;

import com.sun.glass.events.KeyEvent;

import Entity.*;
import TileMap.*;
import Main.GamePanel;

public class Stage1State extends GameState
{
	private TileMap tileMap;
	private Background background;
	
	private Player player;
	
	public Stage1State(GameStateManager gsmanager)
	{
		this.gsmanager = gsmanager;
		init();
	}
	
	@Override
	public void init() 
	{
		tileMap = new TileMap(30);
		tileMap.loadTiles("/Tileset/maplesheet.png");
		tileMap.loadMap("/MapFiles/level1-1.map");
		tileMap.setPosition(0, 0);
		tileMap.setTween(1);
		background = new Background("/Backgrounds/grassbg1.gif", 0.1);
		
		player = new Player(tileMap);
		player.setPosition(100, 100);
	}

	@Override
	public void update() 
	{
		player.update();
		tileMap.setPosition(GamePanel.WIDTH/2-player.getx(), GamePanel.HEIGHT/2 - player.gety());
	}

	@Override
	public void draw(Graphics2D g) 
	{
		// Draw background
		background.draw(g);
		// Draw the tile map
		tileMap.draw(g);
		// Draw player
		player.draw(g);
	}

	@SuppressWarnings("restriction")
	@Override
	public void keyPressed(int k) 
	{
		if(k == KeyEvent.VK_LEFT) player.setIsMovingLeft(true);
		if(k == KeyEvent.VK_RIGHT) player.setIsMovingRight(true);
		if(k == KeyEvent.VK_UP) player.setIsMovingUp(true);
		if(k == KeyEvent.VK_DOWN) player.setIsMovingDown(true);
		if(k == KeyEvent.VK_SHIFT) player.setIsJumping(true);
		if(k == KeyEvent.VK_Z) player.setMeleeAttacking(true);
		
	}
	
	@SuppressWarnings("restriction")
	@Override
	public void keyReleased(int k) 
	{
		if(k == KeyEvent.VK_LEFT) player.setIsMovingLeft(false);
		if(k == KeyEvent.VK_RIGHT) player.setIsMovingRight(false);
		if(k == KeyEvent.VK_UP) player.setIsMovingUp(false);
		if(k == KeyEvent.VK_DOWN) player.setIsMovingDown(false);
		if(k == KeyEvent.VK_SHIFT) player.setIsJumping(false);
		if(k == KeyEvent.VK_Z) player.setMeleeAttacking(false);
	}
	
}
