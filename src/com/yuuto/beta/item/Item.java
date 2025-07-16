package com.yuuto.beta.item;

import com.yuuto.beta.input.Mouse;

public class Item {

	public Item() {
	}

	public void update() {
	}
	
	public boolean use() {
		return Mouse.getButton() == 1;
	}
}
