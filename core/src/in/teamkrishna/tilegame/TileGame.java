package in.teamkrishna.tilegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class TileGame implements Screen {
    Stage stage,stage2;
    SpriteBatch batch;
    private OrthographicCamera camera;
    private int iViewPortWidth;
    private int iViewPortHeight;
    private Texture img, backbutton;
    private Sprite back;
    MainGamePage mainGamePage;

    public TileGame(MainGamePage mainGamePage) {
        this.mainGamePage= mainGamePage;
    }

    ///note: as the image is getting scaled the cutting factor is not changing

    @Override
    public void show() {
        batch = new SpriteBatch();
        img = new Texture("elephant.png");
        //imgcomplete = new Texture("badlogic.png");
        iViewPortWidth = img.getWidth();
        iViewPortHeight = img.getHeight();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, iViewPortWidth, iViewPortHeight);
        stage = new Stage();
//        backbutton = new Texture("back.png");
//        back= new Sprite(backbutton);
//        back.setPosition(5, 10);
//        back.setSize(Constants.WIDTH /10, Constants.HEIGHT / 7);
//        stage2= new Stage();
//        stage2.addActor(new ButtonActor(back,"puzzleback",mainGamePage));
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        iViewPortWidth = width;
        iViewPortHeight = height;
        int iRow = 2;
        int iCol = 3;
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
                MyActor actor = new MyActor(spriteRegion[row][col], X, Y,mainGamePage);
                //setting the actor class to the stage
                stage.addActor(actor);
                stage.setKeyboardFocus(actor);
            }
        }
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

