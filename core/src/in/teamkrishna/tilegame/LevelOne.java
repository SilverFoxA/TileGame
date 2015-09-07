package in.teamkrishna.tilegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by Avi on 07/09/15.
 */
public class LevelOne implements Screen {
    MainGamePage mainGamePage;
    Texture levelback, level1, level2, backbutton;
    private Sprite sprite;
    private Stage stage;
    private Sprite background, puzzle;
    SpriteBatch batch;
    private Sprite draw;

    public LevelOne(MainGamePage mainGamePage) {
        this.mainGamePage = mainGamePage;
    }

    @Override
    public void show() {
        //   level1 = new Texture();
        levelback = new Texture("levelbackground.png");
        background = new Sprite(levelback);
        batch = new SpriteBatch();
        background.setSize(Constants.WIDTH, Constants.HEIGHT);
        background.setPosition(0, 0);
        backbutton = new Texture("back.png");
        sprite = new Sprite(backbutton);
        sprite.setPosition(5, 10);
        sprite.setSize(Constants.WIDTH / 8, Constants.HEIGHT / 9);
        stage = new Stage();
        stage.addActor(new ButtonActor(sprite, "back", mainGamePage));

        level1 = new Texture("puzzle.png");
        puzzle = new Sprite(level1);
        puzzle.setSize(Constants.WIDTH / 5, Constants.HEIGHT / 9);
        puzzle.setPosition(Constants.WIDTH / 2 - puzzle.getWidth() / 2, Constants.HEIGHT / 2 + 100);

        stage.addActor(new ButtonActor(puzzle, "puzzle", mainGamePage));

        level2 = new Texture("drawing.png");
        draw = new Sprite(level2);
        draw.setSize(Constants.WIDTH / 5, Constants.HEIGHT / 9);
        draw.setPosition(Constants.WIDTH / 2 - draw.getWidth() / 2, Constants.HEIGHT / 2 - 100);

        stage.addActor(new ButtonActor(draw, "draw", mainGamePage));


        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        puzzle.draw(batch);
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

    }
}
