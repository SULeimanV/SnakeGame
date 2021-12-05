package ru.xsph.f0482080.snakegame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Snake extends Game {
	SpriteBatch batch;
	BitmapFont font;
	/*OrthographicCamera camera;
	SpriteBatch batch;
	Texture snakehead;
	Texture snakeback;
	Texture normalfood;
	Texture badfood;
	Rectangle bucket;
	int x = 0;
	int y = 0;
	//Sound eatn;
	//Sound eatb;
	//tttthj*/

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		this.setScreen(new StartMenu(this));
		/*Gdx.input.setInputProcessor(new SimpleDirectionGestureDetector(new SimpleDirectionGestureDetector.DirectionListener() {

		@Override
		public void onUp() {
		//System.out.println("f");
			y+=10;
		}

		@Override
		public void onRight() {
			x+=10;
		}

		@Override
		public void onLeft() {
			x-=10;
		}

		@Override
		public void onDown() {
			y-=10;
		}
		}));


		//swipelistener new
		//Gdx.input.setInputProcessor(new swipelistener());

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 480, 800);
		
		int width = 480;
		int height = 800;
		
		int box = 10;
		
		int map_w = 48;
		int map_h = 80;
		
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		
		//eatn = Gdx.audio.newSound(Gdx.files.internal("eatn.wav"));
		//eatb = Gdx.audio.newSound(Gdx.files.internal("eatb.wav"));
		snakehead = new Texture("snake-hat.png");
		snakeback = new Texture("snake-back.png");
		normalfood = new Texture("food.png");
		badfood = new Texture("bad-food.png");
		
		/*
		bucket = new Rectangle();
      		bucket.x = 800 / 2 - 64 / 2;
      		bucket.y = 20;
     		bucket.width = 64;
      		bucket.height = 64;
		*/
	}

	@Override
	public void render () {
		super.render();
		/*ScreenUtils.clear(1, 0, 0.56f, 1);
		batch.begin();
		//batch.draw(img, 1, 3);
		batch.draw(snakehead, x, y);
		batch.draw(snakehead, 10, 0);

		batch.end();*/
	}
	
	@Override
	public void dispose () {
		super.dispose();
		batch.dispose();
		font.dispose();
		/*batch.dispose();*/
		//img.dispose();
	}
}
