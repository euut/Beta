package com.yuuto.beta.entity.particle;

import java.util.Random;

import com.yuuto.beta.entity.Entity;
import com.yuuto.beta.graphics.Screen;
import com.yuuto.beta.graphics.Sprite;

public class Particle extends Entity {

	private Sprite sprite;
	private int life;
	private int time = 0;

	protected double xx, yy, zz;
	protected double xa, ya, za;

	private final Random random = new Random();

	public Particle(double x, double y, int life) {
		this.xx = x;
		this.yy = y;
		this.life = life + random.nextInt(20) - 10;
		sprite = Sprite.bullet_particle;

		xa = random.nextGaussian() * 0.5;
		ya = random.nextGaussian() * 0.5;
		za = random.nextFloat() + 1.0;
	}

	public void update() {
		time++;
		if (time > life) {
			remove();
			time = 0;
			return;
		}
		za -= 0.2;
		if (zz < 0) {
			zz = 0;
			za *= -0.1;
			ya *= 0.25;
			xa *= 0.25;
		}

		xx += xa;
		yy += ya;
		zz += za;
	}
	
	public void render(Screen screen) {
		screen.renderSprite((int) xx, (int) yy - (int) zz, sprite, false);
	}
}
