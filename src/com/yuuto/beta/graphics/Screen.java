package com.yuuto.beta.graphics;

public class Screen {

	public int width, height;
	public int[] pixels;

	private int xOffset, yOffset;

	private static final int ALPHA_COL = 0xffff00ff; 

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void renderSprite(int xp, int yp, Sprite sprite, boolean fixed) {
		if (!fixed) {
			xp -= xOffset;
			yp -= yOffset;
		}
		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			if (ya < 0 || ya >= height) continue;
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < 0 || xa >= width) continue;
				pixels[xa + ya * width] = sprite.pixels[x + y * sprite.SIZE];
			}
		}
	}

	public void renderTile(int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			if (ya < 0 || ya >= height) continue;
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < 0 || xa >= width) continue;
				pixels[xa + ya * width] = sprite.pixels[x + y * sprite.SIZE];
			}
		}
	}

	public void renderMob(int xp, int yp, Sprite sprite, int flip) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < 16; y++) {
			int ya = y + yp;
			int ys = y;
			if (ya < 0 || ya >= height) continue;
			if (flip == 2 || flip == 3) ys = 15 - y;
			for (int x = 0; x < 16; x++) {
				int xa = x + xp;
				int xs = x;
				if (flip == 1 || flip == 3) xs = 15 - x;
				if (xa < 0 || xa >= width) continue;
				int col = sprite.pixels[xs + ys * 16];
				if (col != ALPHA_COL) pixels[xa + ya * width] = col;
			}
		}
	}

	public void renderProjectile(int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			if (ya < 0 || ya >= height) continue;
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < 0 || xa >= width) continue;
				int col = sprite.pixels[x + y * sprite.SIZE];
				if (col != ALPHA_COL) pixels[xa + ya * width] = col;
			}
		}
	}

	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
