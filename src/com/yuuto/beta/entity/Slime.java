package com.yuuto.beta.entity;

import com.yuuto.beta.graphics.Screen;
import com.yuuto.beta.graphics.Sprite;

public class Slime extends Mob {
	
	private double xa, ya;
	private int anim;

	public Slime(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void update() {
		tickCount++;

		if (anim < 7500)
			anim++;
		else
			anim = 0;
		if (random.nextInt(40) == 0) {
			xa = (random.nextInt(3) - 1);
			ya = (random.nextInt(3) - 1);
		}
		
		move(xa, ya);
	}

	public void render(Screen screen) {
		int flip = 0;

		sprite = Sprite.slime;
		if (anim % 20 > 10) {
			sprite = Sprite.slime_1;
		}

		screen.renderMob(x, y, sprite, flip);
	}

	public boolean collision(double xa, double ya) {
		return tileCollision((int) (x + xa), (int) (y + ya), 7, -3, 11, 0);
	}
}
