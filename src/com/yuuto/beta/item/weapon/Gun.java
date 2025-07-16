package com.yuuto.beta.item.weapon;

import com.yuuto.beta.Game;
import com.yuuto.beta.entity.projectile.Bullet;
import com.yuuto.beta.entity.projectile.Projectile;
import com.yuuto.beta.input.Mouse;
import com.yuuto.beta.level.Level;

public class Gun extends Weapon {
	
	public int fireRate;
	private Projectile projectile;

	public Gun(int dmg, int fireRate) {
		super(dmg);
		this.fireRate = fireRate;
	}
	
	public int getFireRate() {
		return fireRate;
	}

	private double getDir() {
		double dx = Mouse.getX() - Game.getWindowWidth() / 2;
		double dy = Mouse.getY() - Game.getWindowHeight() / 2;
		return Math.atan2(dy, dx);
	}

	public void shoot(Level level, int x, int y) {
		projectile = new Bullet(x, y, getDir());
		level.add(projectile);
	}
}
