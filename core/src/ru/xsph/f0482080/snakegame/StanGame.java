package ru.xsph.f0482080.snakegame;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.input.GestureDetector;
import java.util.Iterator;


public class StanGame implements Screen {
    final Snake game;
    OrthographicCamera camera;
    int length = 1;
    int block = 10;
    int width = 800;
    int height = 480;
    Texture food;
    Texture badfood;
    Texture snakeh;
    Texture snakeb;
    Rectangle foodr;
    //Texture dropImage;
    //Texture bucketImage;
    //Sound dropSound;
    //Music rainMusic;
    //Rectangle bucket;
    //Vector3 touchPos;
    //Array<Rectangle> raindrops;
    //long lastDropTime;
    //int dropsGatchered;
    //String dropString;

/*Home.png
3 months ago
IMG_20210430_145209.jpg
3 months ago
IMG_20210907_152556_508.jpg
3 months ago
bad-food.png
3 months ago
badlogic.jpg
3 months ago
food.png
3 months ago
snake-back.png
3 months ago
snake-hat.png*/


    public StanGame (final Snake gam) {
        //GestureDetector input = new GestureDetector(this);
        this.game = gam;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);

        //touchPos = new Vector3();

        food    = new Texture("food.png");
        badfood = new Texture("bad-food.png");
        snakeh  = new Texture("snake-hat.png");
        snakeb  = new Texture("snake-back.png");

        foodr = new Rectangle();
        foodr.width = block;
    	foodr.height = block;

        //dropImage = new Texture("kaplya.png");
        //bucketImage = new Texture("bucket.png");

        //dropSound = Gdx.audio.newSound(Gdx.files.internal("kaplya.mp3"));
        //rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));

        //rainMusic.setLooping(true);
        //rainMusic.play();

        //bucket = new Rectangle();
        //bucket.x = 800 / 2 - 64 / 2;
        //bucket.y = 20;
        //bucket.width = 64;
        //bucket.height = 64;

        Gdx.input.setInputProcessor(new SimpleDirectionGestureDetector(new SimpleDirectionGestureDetector.DirectionListener() {

            @Override
            public void onUp() {
                System.out.println(1);
                //bucket.y += 30;
            }

            @Override
            public void onRight() {
                System.out.println(2);
                //bucket.x += 30;
            }

            @Override
            public void onLeft() {
                System.out.println(3);
                //bucket.x -= 30;
            }

            @Override
            public void onDown() {
                System.out.println(4);
                //bucket.y -= 30;
            }
        }));

        //raindrops = new Array<Rectangle>();
        //spawnRaindrop();
        spawnFood();

    }

    /*private void spawnRaindrop(){
        Rectangle raindrop = new Rectangle();
        raindrop.x = MathUtils.random(0, 800-64);
        raindrop.y = 480;
        raindrop.width = 64;
        raindrop.height = 64;
        raindrops.add(raindrop);
        lastDropTime = TimeUtils.nanoTime();
    }*/
    private void spawnFood (){
    	//foodr = new Rectangle();
    	foodr.x = MathUtils.random(0, width - 10);
    	foodr.y = MathUtils.random(0, height - 10);


    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(food, foodr.x, foodr.y);
        //game.font.draw(game.batch, "Score: ", 0, 480);
        //game.batch.draw(bucketImage, bucket.x, bucket.y);
        //for (Rectangle raindrop: raindrops){
        //    game.batch.draw(dropImage, raindrop.x, raindrop.y);
        //}
        game.batch.end();

        /*if(Gdx.input.isTouched()){
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            bucket.x = (int) (touchPos.x -64 / 2);
            //System.out.println(bucket.x);


        }*/

        //if(Gdx.input.isTouched()&&Gdx.input.getDeltaY()>0)
        // System.out.println(1);

        //if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) bucket.x -= 200 * Gdx.graphics.getDeltaTime();
        //if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) bucket.x += 200 * Gdx.graphics.getDeltaTime();

        //if (bucket.x < 0) bucket.x = 0;
        //if (bucket.x > 800 - 64) bucket.x = 800 - 64;

        //if (TimeUtils.nanoTime() - lastDropTime > 1000000000) spawnRaindrop();

        //Iterator<Rectangle> iter = raindrops.iterator();
        //while (iter.hasNext()){
            //Rectangle raindrop = iter.next();
            //raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
            //if (raindrop.y + 64 < 0) iter.remove();
            //if (raindrop.overlaps(bucket)){
                //dropsGatchered++;
                //dropSound.play();
                //iter.remove();
            //}
        //}
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        food.dispose();
        badfood.dispose();
        snakeh.dispose();
        snakeb.dispose();
        //dropImage.dispose();
        //bucketImage.dispose();
        //dropSound.dispose();
        //rainMusic.dispose();
    }

    @Override
    public void show() {
        //rainMusic.play();
    }
}
