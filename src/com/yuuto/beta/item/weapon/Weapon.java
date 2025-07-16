package com.yuuto.beta.item.weapon;

import com.yuuto.beta.item.Item;

public class Weapon extends Item {
	
	private int dmg;
	
	public Weapon(int dmg) {
		this.dmg = dmg;
	}
	
	public int getDmg() {
		return dmg;
	}
}
