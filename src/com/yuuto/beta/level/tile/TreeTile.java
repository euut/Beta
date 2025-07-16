package com.yuuto.beta.level.tile;

import com.yuuto.beta.graphics.Screen;
import com.yuuto.beta.graphics.Sprite;

public class TreeTile extends Tile {

	public TreeTile(int x, int y, Sprite sprite) {
		super(sprite, true);
		this.x = x;
		this.y = y;
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(this.x << 4, (this.y + 1) << 4, Sprite.tree_3);
		screen.renderTile((this.x + 1) << 4, (this.y + 1) << 4, Sprite.tree_4);
	}
}
