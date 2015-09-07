package in.teamkrishna.tilegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by Avi on 07/09/15.
 */
public class SplashScreens implements Screen {
    MainGamePage mainGamePage;
    private Texture logo;
    private SpriteBatch spriteBatch;
    private BitmapFont font, devName;

    public SplashScreens(MainGamePage mainGamePage) {
        this.mainGamePage = mainGamePage;
    }

    @Override
    public void show() {
        logo = new Texture(Gdx.files.internal("silverfox.png"));
        spriteBatch = new SpriteBatch();
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font/robot.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 70;
        font = generator.generateFont(parameter); // font size 12 pixels
        font.setColor(Color.WHITE);
        FreeTypeFontGenerator.FreeTypeFontParameter parameters = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameters.size = 50;
        devName = generator.generateFont(parameters); // font size 12 pixels
        devName.setColor(Color.WHITE);
        generator.dispose(); // don't forget to dispose to avoid memory leaks!
    }

    @Override
    public void render(float delta) {
        handleInput();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.begin();
        spriteBatch.draw(logo, Constants.WIDTH / 2 - logo.getWidth() / 4, Constants.HEIGHT / 2 - logo.getHeight() / 4, 256, 256);
//        Timer.schedule(new Timer.Task() {
//            @Override
//            public void run() {
//                font.draw(spriteBatch, "Touch screen to start", 500, 100);
//            }
//        },0);
        devName.draw(spriteBatch,"silverFoxA",Constants.WIDTH/2-logo.getWidth()/6,Constants.HEIGHT/2-logo.getHeight()/4-30);
        font.draw(spriteBatch, "Touch screen to start", Constants.WIDTH / 3 + 50, 110);
        spriteBatch.end();

    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            mainGamePage.setScreen(new MainMenuScreen(mainGamePage));
        }
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
