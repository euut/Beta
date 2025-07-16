package com.yuuto.beta.entity;

import java.util.Random;

import com.yuuto.beta.graphics.Screen;
import com.yuuto.beta.level.Level;

public abstract class Entity {

	protected int x, y;
	protected Level level;
	protected int tickCount = 0;
	private boolean removed = false;
	
	protected final Random random = new Random();
	
	public void update() {
	}
	
	public void render(Screen screen) {
	}
	
	public void remove() {
		removed = true;
		level.remove(this);
	}
	
	public boolean isRemoved() {
		return removed;
	}
	
	public void init(Level level) {
		this.level = level;
	}
	
	public boolean tileCollision(int x, int y, int w, int h, int xo, int yo) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = (x - c % 2 * w + xo) >> 4;
			int yt = (y - c / 2 * h + xo) >> 4;
			if (level.getTile(xt, yt).isSolid()) {
				solid = true;
				break;
			}
		}
		return solid;
	}
	
	public int x() {
		return x;
	}
	
	public int y() {
		return y;
	}
}
