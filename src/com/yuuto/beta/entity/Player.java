package com.yuuto.beta.entity;

import com.yuuto.beta.graphics.Screen;
import com.yuuto.beta.graphics.Sprite;
import com.yuuto.beta.input.Keyboard;
import com.yuuto.beta.item.weapon.Gun;

public class Player extends Mob {
	
	private Keyboard input;
	private int anim;
	private Gun weapon = new Gun(20, 15);

	public Player(Keyboard input) {
		this.input = input;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}
	
	public void update() {
		tickCount++;

		int xa = 0, ya = 0;

		if (anim < 7500)
			anim++;
		else
			anim = 0;

		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;

		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		
		if (weapon.use() && tickCount >= weapon.fireRate) {
			shoot(x, y);
			tickCount = 0;
		}
	}
	
	public void render(Screen screen) {
		int flip = 0;
		
		if (dir == 0) {
			sprite = Sprite.player_back;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_back_1;
				} else {
					sprite = Sprite.player_back_2;
				}
			}
		}
		else if (dir == 1) {
			sprite = Sprite.player_side;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_side_1;
				} else {
					sprite = Sprite.player_side_2;
				}
			}
		}
		else if (dir == 2) {
			sprite = Sprite.player_front;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_front_1;
				} else {
					sprite = Sprite.player_front_2;
				}
			}
		}
		else if (dir == 3) {
			sprite = Sprite.player_side;
			flip = 1;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_side_1;
				} else {
					sprite = Sprite.player_side_2;
				}
			}
		}
		else {
			sprite = Sprite.player_front;
		}

		screen.renderMob(x - 16 / 2, y - 16 / 2, sprite, flip);
	}

	public boolean collision(double xa, double ya) {
		return tileCollision((int) (x + xa), (int) (y + ya), 7, -3, 3, 0);
	}

	private void shoot(int x, int y) {
		weapon.shoot(level, x, y);
	}
}
