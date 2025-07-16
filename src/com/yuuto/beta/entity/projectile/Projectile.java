package com.yuuto.beta.entity.projectile;

import java.util.Random;

import com.yuuto.beta.entity.Entity;
import com.yuuto.beta.graphics.Screen;
import com.yuuto.beta.graphics.Sprite;

public class Projectile extends Entity {

	protected double x, y;
	protected final int xo, yo;
	protected double angle;
	protected double nx, ny;
	protected double speed, damage, range;
	protected Sprite sprite;

	protected final Random random = new Random();

	public Projectile(int x, int y, double dir) {
		this.x = x;
		this.y = y;
		xo = x;
		yo = y;
		angle = dir;
	}

	public void update() {
	}

	public void render(Screen screen) {
	}
}
