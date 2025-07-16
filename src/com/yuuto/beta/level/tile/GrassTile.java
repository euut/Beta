package com.yuuto.beta.level.tile;

import com.yuuto.beta.graphics.Screen;
import com.yuuto.beta.graphics.Sprite;

public class GrassTile extends Tile {

	public GrassTile(Sprite sprite) {
		super(sprite, false);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, sprite);
	}
}
