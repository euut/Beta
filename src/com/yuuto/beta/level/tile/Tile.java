package com.yuuto.beta.level.tile;

import com.yuuto.beta.graphics.Screen;
import com.yuuto.beta.graphics.Sprite;

public class Tile {

	public int x, y;
	public Sprite sprite;
	private boolean solid;
	private boolean breakable;

	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile brick = new BrickTile(Sprite.brick);
	public static Tile wood = new WoodTile(Sprite.wood);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	public static Tile tree = new TreeTile(0, 0, null);

	public Tile(Sprite sprite, boolean solid) {
		this.sprite = sprite;
		this.solid = solid;
	}

	public void render(int x, int y, Screen screen) {
	}

	public boolean isSolid() {
		return solid;
	}
	
	public boolean isBreakable() {
		return breakable;
	}
}
