package in.teamkrishna.tilegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;


/**
 * Created by Avi on 07/09/15.
 */
public class MainMenuScreen implements Screen {
    private MainGamePage mainGamePage;
    private Texture background, levelButton, exitButton;
    SpriteBatch batch;
    Stage stage;
    private Sprite sprite, sprite1, sprite2;
    private Sound sound;


    public MainMenuScreen(MainGamePage mainGamePage) {
        this.mainGamePage = mainGamePage;
    }

    @Override
    public void show() {
        background = new Texture("junglebackground.png");
        levelButton = new Texture("levels.png");
        exitButton = new Texture("exit.png");
        sprite = new Sprite(background);
        sprite1 = new Sprite(levelButton);
        sprite2 = new Sprite(exitButton);
        //sound = Gdx.audio.newSound(Gdx.files.internal("tropical_birds.mp3"));
        sprite1.setSize(Constants.WIDTH / 5, Constants.HEIGHT / 9);
        sprite1.setPosition(Constants.WIDTH / 2 - sprite1.getWidth() / 2, Constants.HEIGHT / 2 + 100);
        sprite2.setSize(Constants.WIDTH / 5, Constants.HEIGHT / 9);
        sprite2.setPosition(Constants.WIDTH / 2 - sprite1.getWidth() / 2, Constants.HEIGHT / 2 - 100);
        sprite.setSize(Constants.WIDTH, Constants.HEIGHT);
        batch = new SpriteBatch();
        stage = new Stage();
        stage.addActor(new ButtonActor(sprite1, "levels", mainGamePage));
        stage.addActor(new ButtonActor(sprite2, "exit", mainGamePage));
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
//        if (Gdx.input.justTouched()) {
//            mainGamePage.setScreen(new LevelOne(mainGamePage));
//        }
        Gdx.gl.glClearColor(0, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        //batch.draw(background, 0, 0);
        sprite.draw(batch);
        sprite1.draw(batch);
        sprite2.draw(batch);
        batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
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
        sound.stop();
    }
}
