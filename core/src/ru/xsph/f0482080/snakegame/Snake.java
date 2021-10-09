package ru.xsph.f0482080.snakegame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Snake extends ApplicationAdapter {
	OrthographicCamera camera;
	SpriteBatch batch;
	Texture snakehead;
	Texture snakeback;
	Texture normalfood;
	Texture badfood;
	#tttthj

	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 480, 800);
		
		int width = 480;
		int height = 800;
		
		int box = 10;
		
		int map_w = 48;
		int map_h = 80;
		
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		
		snakehead = new Texture("snake-hat.png");
		snakeback = new Texture("snake-back.png");
		normalfood = new Texture("food.png");
		badfood = new Texture("bad-food.png");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0.56f, 1);
		batch.begin();
		//batch.draw(img, 1, 3);
		batch.draw(snakehead, 1, 3);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
