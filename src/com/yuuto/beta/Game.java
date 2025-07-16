package com.yuuto.beta;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.yuuto.beta.entity.Player;
import com.yuuto.beta.graphics.Screen;
import com.yuuto.beta.input.Keyboard;
import com.yuuto.beta.input.Mouse;
import com.yuuto.beta.level.Level;
import com.yuuto.beta.level.SpawnLevel;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	// Resolution
	private static final int WIDTH = 300;
	private static final int HEIGHT = WIDTH / 16 * 9;
	private static final int SCALE = 3;
	private static final String TITLE = "Beta";

	private boolean running = false;
	
	private Thread thread;
	private JFrame frame;
	private Keyboard keyboard;
	private Mouse mouse;
	private Screen screen;
	private Level level;
	private Player player;

	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	public Game() {
		Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
		setPreferredSize(size);

		screen = new Screen(WIDTH, HEIGHT);

		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle(Game.TITLE);
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		keyboard = new Keyboard();
		addKeyListener(keyboard);
		
		mouse = new Mouse();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		
		level = new SpawnLevel("res/textures/level.png");
		player = new Player(700, 700, keyboard);
		level.add(player);
	}

	public static int getWindowWidth() {
		return WIDTH * SCALE;
	}

	public static int getWindowHeight() {
		return HEIGHT * SCALE;
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();

		final double nsPerTick = 1000000000.0 / 60.0;

		double delta = 0;
		int fps = 0;
		int ups = 0;

		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			while (delta >= 1) {
				update();
				ups++;
				delta--;
			}
			render();
			fps++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(TITLE + " | " + ups + " ups, " + fps + " fps");
				ups = 0;
				fps = 0;
			}
		}
		stop();
	}

	public void update() {
		keyboard.update();
		level.update();
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();

		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		screen.clear();
		level.render(player.x() - screen.width / 2, player.y() - screen.height / 2, screen);

		System.arraycopy(screen.pixels, 0, pixels, 0, pixels.length);

		Graphics g = bs.getDrawGraphics();
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
}