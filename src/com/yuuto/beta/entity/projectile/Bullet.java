package com.yuuto.beta.entity.projectile;

import com.yuuto.beta.entity.particle.Particle;
import com.yuuto.beta.graphics.Screen;
import com.yuuto.beta.graphics.Sprite;

public class Bullet extends Projectile {

	public static final int FIRE_RATE = 20;

	public Bullet(int x, int y, double dir) {
		super(x, y, dir);
		sprite = Sprite.bullet;
		speed = 3;
		damage = 20;
		range = random.nextInt(100) + 300;

		nx = speed * Math.cos(dir);
		ny = speed * Math.sin(dir);
	}

	public void render(Screen screen) {
		screen.renderProjectile((int) x, (int) y, sprite);
	}

	public void update() {
		if (distance() >= range) {
			remove();
			return;
		}
		if (tileCollision((int) (x + nx), (int) (y + ny), 1, 1, 4, 2)) {
			remove();
			spawnParticles(x, y, 10, 30);
			return;
		}
		move();
	}

	private void move() {
		x += nx;
		y += ny;
	}

	private double distance() {
		return Math.sqrt((xo - x) * (xo - x) + (yo - y) * (yo - y));
	}

	private void spawnParticles(double x, double y, int amount, int life) {
		for (int i = 0; i < amount; i++) {
			level.add(new Particle(x, y, life));
		}
	}
}
