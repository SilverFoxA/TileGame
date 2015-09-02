package in.teamkrishna.tilegame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class TileGame extends ApplicationAdapter {
    Stage stage;
    SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        Texture img = new Texture("elephant.png");
        //imgcomplete = new Texture("badlogic.png");
        int iViewPortWidth = img.getWidth();
        int iViewPortHeight = img.getHeight();
        OrthographicCamera camera = new OrthographicCamera(iViewPortWidth, iViewPortHeight);
        camera.setToOrtho(false, iViewPortWidth, iViewPortHeight);
        ScreenViewport viewport = new ScreenViewport();
        //initialising the stage while passing the viewport as parameter hence it will know it's area or range
        stage = new Stage(viewport);
        int iRow = 2;
        int iCol = 2;
        int iTileWidth = iViewPortWidth / iCol;
        int iTileHeight = iViewPortHeight / iRow;
        Sprite[][] spriteRegion = new Sprite[iRow][iCol];
        int X, Y;
        for (int row = 0; row < iRow; row++) {
            for (int col = 0; col < iCol; col++) {
                X = col * iTileWidth;
                Y = (iRow - 1 - row) * iTileHeight;
                TextureRegion trTemp = new TextureRegion(img, col * iTileWidth, row * iTileHeight, iTileWidth, iTileHeight);
                spriteRegion[row][col] = new Sprite(trTemp);
                MyActor actor = new MyActor(spriteRegion[row][col], X, Y);
                //setting the actor class to the stage
                stage.addActor(actor);
                stage.setKeyboardFocus(actor);
            }
        }
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }
}

