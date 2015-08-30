package in.teamkrishna.tilegame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class TileGame extends ApplicationAdapter /*implements InputProcessor {
    SpriteBatch batch;
	Texture img, cover;
	TextureRegion textureRegion[][];
	TextureRegion trTemp;
	Sprite spriteCover;
	Sprite spriteRegion[][];
	OrthographicCamera camera;
//Sprite spritae;
	boolean bSpriteState[][];

	int iViewPortWidth, iViewPortHeight;
	int iTileWidth, iTileHeight;
	int iRow, iCol;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("tile.png");
		cover = new Texture("cover.png");
		spriteCover = new Sprite(cover);



		iViewPortWidth = img.getWidth();//Gdx.graphics.getWidth();
		iViewPortHeight = img.getHeight(); //Gdx.graphics.getHeight();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, iViewPortWidth, iViewPortHeight);
		//camera.setToOrtho(false, iViewPortWidth, iViewPortHeight);

		iRow=2;
		iCol=2;
		iTileWidth = iViewPortWidth/iCol;
		iTileHeight = iViewPortHeight/iRow;
		textureRegion = new TextureRegion[iRow][iCol];
		bSpriteState = new boolean[iRow][iCol];
		spriteRegion = new Sprite[iRow][iCol];

		System.out.println("width: " + Gdx.graphics.getWidth());
		System.out.println("height:" + Gdx.graphics.getHeight());

		for(int row=0;row<iRow;row++)
		{
			for(int col=0;col<iCol;col++)
			{
				//textureRegion[row][col] = new TextureRegion(img,col*iTileWidth,row*iTileHeight,iTileWidth,iTileHeight);
				trTemp = new TextureRegion(img,col*iTileWidth,row*iTileHeight,iTileWidth,iTileHeight);
				spriteRegion[row][col] = new Sprite(trTemp);
				bSpriteState[row][col]=false;

				System.out.println(row + "," + col + "," + trTemp.getRegionWidth() + "," + trTemp.getRegionHeight());
			}
		}

		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render() {
		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		for(int row=0;row<iRow;row++)
		{
			for(int col=0;col<iCol;col++)
			{
				//batch.draw(textureRegion[row][col], col * iTileWidth, (iRow - 1 - row) * iTileHeight);
				spriteRegion[row][col].setPosition(col * iTileWidth, (iRow - 1 - row) * iTileHeight);
				spriteRegion[row][col].draw(batch);

				spriteCover.setPosition(col * iTileWidth, (iRow - 1 - row) * iTileHeight);

				if(bSpriteState[row][col])
					spriteCover.setAlpha(0.0f);
				else
					spriteCover.setAlpha(1.0f);

				spriteCover.draw(batch);
			}
		}
		batch.end();
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
		System.out.println("x: " + screenX);
		System.out.println("y: " + screenY);

		for(int row=0; row<iRow; row++)
		{
			for(int col=0; col<iCol; col++)
			{
				if(spriteRegion[row][col].getBoundingRectangle().contains(screenX,screenY))
				{
					System.out.println("yeah: " + row +","+col);
					bSpriteState[iRow-1-row][col]=true;
				}
			}
		}
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}*/

{
    Stage stage;

    @Override
    public void create() {
        ScreenViewport viewport = new ScreenViewport();
        //initialising the stage while passing the viewport as parameter hence it will know it's area or range
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);

        MyActor actor = new MyActor();

        //setting the actor class to the stage
        stage.addActor(actor);
        stage.setKeyboardFocus(actor);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }
}

