package com.yuuto.beta.entity;

import com.yuuto.beta.graphics.Sprite;

public class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 2;
	protected int health = 100;
	protected boolean walking = false;
	protected boolean hurt = false;
	
	public void move(double xa, double ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}

		if (xa > 0) dir = 1;
		if (xa < 0) dir = 3;
		if (ya > 0) dir = 2;
		if (ya < 0) dir = 0;

		if (!collision((int) xa, (int) ya)) {
			x += xa;
			y += ya;
		}
	}
	
	protected boolean collision(double xa, double ya) {
		return false;
	}

	public void update() {
	}
	
	public boolean contact(Entity e) {
		return this.x >= e.x;
	}
	
	public void hurt(int dmg) {
		this.health -= dmg;
		if (this.health < 0) {
			this.health = 0;
		}
	}
}
