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
//import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.input.GestureDetector;


import java.util.Iterator;


public class StanGame implements Screen {
    final Snake game;
    OrthographicCamera camera;
    int length = 1;
    int width = 800;
    int height = 480;
    int score = 0;
    int state = 0;
    Texture food;
   //Texture badfood;
    Texture snakeh;
    Texture snakeb;
    Rectangle foodr;
    //Rectangle foodbr;
    Rectangle snakehr;
    long lastStepTime;
    Array<Rectangle> backs;
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
        //badfood = new Texture("bad-food.png");
        snakeh  = new Texture("snake-hat.png");
        snakeb  = new Texture("snake-back.png");

        foodr = new Rectangle();
        //foodbr = new Rectangle();
        foodr.width = 10;
    	foodr.height = 10;

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

        snakehr = new Rectangle();
        snakehr.x = (800 / 2) - 10;
        snakehr.y = (480 / 2) - 10;
        snakehr.width = 10;
        snakehr.height = 10;

        Gdx.input.setInputProcessor(new SimpleDirectionGestureDetector(new SimpleDirectionGestureDetector.DirectionListener() {

            @Override
            public void onUp() {
                System.out.println(0);
                if (state != 3)
                    state = 0;
                //bucket.y += 30;
            }

            @Override
            public void onRight() {
                System.out.println(1);
                if (state != 2)
                    state = 1;
                //bucket.x += 30;
            }

            @Override
            public void onLeft() {
                System.out.println(2);
                if (state != 1)
                    state = 2;
                //bucket.x -= 30;
            }

            @Override
            public void onDown() {
                System.out.println(3);
                if (state != 0)
                    state = 3;
                //bucket.y -= 30;
            }
        }));

        //raindrops = new Array<Rectangle>();
        //spawnRaindrop();
        backs = new Array<Rectangle>();
        Rectangle back = new Rectangle();
        backs.add(back);
        spawnFood();
        //spawnFoodb();
        step();

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
    private void eatFood () {
        score += 10;
        length++;
        spawnFood();
        addLen();
    }
    /*private void spawnFoodb () {
        foodbr.x = MathUtils.random(0, width - 10);
        foodbr.y = MathUtils.random(0, height - 10);
    }*/
    /*private void eatFoodb () {
        score -= 10;
        //if (length  != 0)
            //length --;
        spawnFoodb();
    }*/
    private void step () {
        /*backs.reverse();
        Iterator<Rectangle> iter = backs.iterator();
        int u = backs.size;
        System.out.println(u);
        while (iter.hasNext()){
            Rectangle back = iter.next();
            u--;
            if (u == 0){
                back.x = snakehr.x;
                back.y = snakehr.y;
            }
            else {
            Rectangle bc = backs.get(u-1);
            back.x = bc.x;
            back.y = bc.y;}





        }*/
        backs.pop();
        backs.reverse();
        Rectangle back = new Rectangle();
        back.x = snakehr.x;
        back.y = snakehr.y;
        backs.add(back);
        backs.reverse();
        if (state == 0)
            snakehr.y += 10;
        else if (state == 1)
            snakehr.x += 10;
        else if (state == 2)
            snakehr.x -= 10;
        else if (state == 3)
            snakehr.y -= 10;
        if (snakehr.x > 790) snakehr.x = 0;
        if (snakehr.x < 0) snakehr.x = 800;
        if (snakehr.y > 470) snakehr.y = 0;
        if (snakehr.y < 0) snakehr.y = 480;
        //snakehr.x += 10;
        lastStepTime = TimeUtils.nanoTime();

    }
    private void addLen () {
        Rectangle back = new Rectangle();
        Rectangle bc = backs.get(backs.size-1);
        back.x = bc.x;
        back.y = bc.y;
        backs.add(back);
    }


    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(food, foodr.x, foodr.y);
        game.batch.draw(snakeh, snakehr.x, snakehr.y);
        //game.batch.draw(badfood, foodbr.x, foodbr.y);
        game.font.draw(game.batch, "Score: "+score, 0, 480);
        for (Rectangle back: backs){
            game.batch.draw(snakeb,back.x, back.y);

        }
        //game.batch.draw(bucketImage, bucket.x, bucket.y);
        //for (Rectangle raindrop: raindrops){
        //    game.batch.draw(dropImage, raindrop.x, raindrop.y);
        //}
        game.batch.end();

        if(Gdx.input.isKeyPressed(Input.Keys.UP)){if (state != 3) state = 0;}
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){if (state != 2) state = 1;}
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){if (state != 1) state = 2;}
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){if (state != 0) state = 3;}

        if (TimeUtils.nanoTime() - lastStepTime > 100000000) step();
        //if (snakehr.overlaps(foodbr)){eatFoodb();}
        if (snakehr.overlaps(foodr)){eatFood(); }

        //snakehr.y -= 200 * Gdx.graphics.getDeltaTime();



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
        //raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
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
        //Iterator<Rectangle>
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
       // badfood.dispose();
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
