package com.yuuto.beta.level;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.yuuto.beta.entity.Slime;

public class SpawnLevel extends Level {
	
	public SpawnLevel(String path) {
		super(path);
	}

	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(new File(path));
			int w = width = image.getWidth();
			int h = height = image.getHeight();
			tilesCol = new int[w * h];
			image.getRGB(0, 0, w, h, tilesCol, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < 10; i++) {
			add(new Slime(700, 700));
		}
	}
}
