package in.teamkrishna.tilegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

public class JoinDots implements InputProcessor, Screen {
    SpriteBatch batch;
    ShapeRenderer shapeRenderer;
    Pixmap pixmap;
    Texture texture,back;
    Sprite backsprite;
    MainGamePage mainGamePage;

    boolean status = false;

    ArrayList<Integer> xValues = new ArrayList<Integer>();
    ArrayList<Integer> yValues = new ArrayList<Integer>();

    public JoinDots(MainGamePage mainGamePage) {
        this.mainGamePage = mainGamePage;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        status = true;
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        status = false;
        xValues.clear();
        yValues.clear();
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {

        xValues.add(screenX);
        yValues.add(screenY);
        int size = xValues.size();
        if (status) {
            pixmap.setColor(Color.RED);
//            if (xValues.size()>2){
//                //pixmap.drawLine(xValues.get(size - 2), yValues.get(size - 2), xValues.get(size - 1), yValues.get(size - 1));
//                pixmap.fillCircle((xValues.get(size - 2)+xValues.get(size - 1))/2,(yValues.get(size - 2)+yValues.get(size - 1))/2,10);
//               // pixmap.fillCircle(screenX, screenY, 10);
//            }
            for (int i = 0; i < size; i++) {
                pixmap.fillCircle(xValues.get(i), yValues.get(i), 10);
            }
            texture.draw(pixmap, 0, 0);
        }

        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        pixmap = new Pixmap(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), Pixmap.Format.RGBA8888);
        texture = new Texture(pixmap);
        back= new Texture("back.png");
        backsprite= new Sprite(back);
        backsprite.setSize(Constants.WIDTH / 10, Constants.HEIGHT / 9);
        backsprite.setPosition(5, 10);
        System.out.println(backsprite.getBoundingRectangle());
        Gdx.input.setInputProcessor(this);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(texture, 0, 0);
        batch.draw(back,0,Constants.HEIGHT-80);
        batch.end();
        if (Gdx.input.isTouched()) {
            if (backsprite.getBoundingRectangle().contains(Gdx.input.getX(), Gdx.input.getY())) {
                mainGamePage.setScreen(new LevelOne(mainGamePage));
            }
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
