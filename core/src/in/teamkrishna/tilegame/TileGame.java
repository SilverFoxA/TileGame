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

public class TileGame extends ApplicationAdapter {
    Stage stage;
    SpriteBatch batch;
    private OrthographicCamera camera;
    private int iViewPortWidth;
    private int iViewPortHeight;
    private Texture img;

    ///note: as the image is getting scaled the cutting factor is not changing
    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("elephant.png");
        //imgcomplete = new Texture("badlogic.png");
        iViewPortWidth = img.getWidth();
        iViewPortHeight = img.getHeight();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, iViewPortWidth, iViewPortHeight);
        stage = new Stage();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        iViewPortWidth = width;
        iViewPortHeight = height;
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
                TextureRegion trTemp = new TextureRegion(img, X, Y, iTileWidth, iTileHeight);
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
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }
}

