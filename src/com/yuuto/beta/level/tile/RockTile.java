package com.yuuto.beta.level.tile;

import com.yuuto.beta.graphics.Screen;
import com.yuuto.beta.graphics.Sprite;

public class RockTile extends Tile {

	public RockTile(Sprite sprite) {
		super(sprite, true);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, sprite);
	}
}
