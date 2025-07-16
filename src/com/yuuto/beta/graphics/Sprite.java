package com.yuuto.beta.graphics;

public class Sprite {

	private int x, y;
	public final int SIZE;
	public int[] pixels;

	private static SpriteSheet sheet = new SpriteSheet("res/textures/spritesheet.png");

	public static Sprite grass = new Sprite(16, 0, 0);
	public static Sprite rock = new Sprite(16, 1, 0);
	public static Sprite flower = new Sprite(16, 2, 0);
	public static Sprite brick = new Sprite(16, 3, 0);
	public static Sprite wood = new Sprite(16, 4, 0);
	public static Sprite voidSprite = new Sprite(16, 0);

	public static Sprite tree_1 = new Sprite(16, 0, 1);
	public static Sprite tree_2 = new Sprite(16, 1, 1);
	public static Sprite tree_3 = new Sprite(16, 0, 2);
	public static Sprite tree_4 = new Sprite(16, 1, 2);

	public static Sprite player_front = new Sprite(16, 0, 4);
	public static Sprite player_front_1 = new Sprite(16, 0, 5);
	public static Sprite player_front_2 = new Sprite(16, 0, 6);

	public static Sprite player_side = new Sprite(16, 1, 4);
	public static Sprite player_side_1 = new Sprite(16, 1, 5);
	public static Sprite player_side_2 = new Sprite(16, 1, 6);
	
	public static Sprite player_back = new Sprite(16, 2, 4);
	public static Sprite player_back_1 = new Sprite(16, 2, 5);
	public static Sprite player_back_2 = new Sprite(16, 2, 6);
	
	public static Sprite slime = new Sprite(16, 3, 4);
	public static Sprite slime_1 = new Sprite(16, 3, 5);

	public static Sprite bullet = new Sprite(8, 0, 16);

	public static Sprite bullet_particle = new Sprite(3, 0xff774825);

	public Sprite(int size, int x, int y) {
		SIZE = size;
		pixels = new int[size * size];
		this.x = x * size;
		this.y = y * size;
		loadSprite();
	}

	public Sprite(int size, int col) {
		SIZE = size;
		pixels = new int[size * size];
		createSprite(col);
	}

	private void loadSprite() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}

	private void createSprite(int col) {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = col;
		}
	}
}
