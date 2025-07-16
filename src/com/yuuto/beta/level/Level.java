package com.yuuto.beta.level;

import java.util.ArrayList;
import java.util.List;

import com.yuuto.beta.entity.Entity;
import com.yuuto.beta.entity.Player;
import com.yuuto.beta.graphics.Screen;
import com.yuuto.beta.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tilesCol;
	protected Player player;
	private List<Entity> entities = new ArrayList<>();

	public Level(String path) {
		loadLevel(path);
	}

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		generateLevel();
	}

	protected void loadLevel(String path) {
	}

	protected void generateLevel() {
	}

	public void update() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);

		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 15) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 15) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}

		renderEntity(screen);
	}
	
	public void renderEntity(Screen screen) {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);;
		}
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.tree;
		}

		if (tilesCol[x + y * width] == 0xff00ff00) return Tile.grass;
		if (tilesCol[x + y * width] == 0xff7f7f00) return Tile.rock;
		if (tilesCol[x + y * width] == 0xffffff00) return Tile.flower;
		if (tilesCol[x + y * width] == 0xff96391b) return Tile.brick;
		if (tilesCol[x + y * width] == 0xffffcf68) return Tile.wood;

		return Tile.voidTile;
	}
	
	public List<Entity> getEntities() {
		return entities;
	}
	
	public void add(Entity e) {
		if (e instanceof Player) {
			player = (Player) e;
		}
		entities.add(e);
		e.init(this);
	}
	
	public void remove(Entity e) {
		entities.remove(e);
	}
}
