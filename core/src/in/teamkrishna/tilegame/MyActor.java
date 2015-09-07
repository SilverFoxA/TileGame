package in.teamkrishna.tilegame;

/**
 * Created by Avi on 30/08/15.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MyActor extends Actor {
    private final BitmapFont font;
    Sprite sprites;
    Sprite sprite1 = new Sprite(new Texture("cover.png"));
    boolean switchbool = false;
    MainGamePage mainGamePage;
    static int x1=0;


    public MyActor(Sprite sprite, int x, int y, final MainGamePage mainGamePage) {
        this.sprites = sprite;
        sprites.setPosition(x, y);
        this.mainGamePage= mainGamePage;
        //touchable field for the sprite i.e. for our image
        setBounds(sprites.getX(), sprites.getY(), sprites.getWidth(), sprites.getHeight());
        setTouchable(Touchable.enabled);
        sprite1.setPosition(sprites.getX(), sprites.getY());
        sprite1.setSize(sprites.getWidth(), sprites.getHeight());
        //make sure to use the "ClickListener()" and within it the "Clicled()"
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font/robot.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 70;
        font = generator.generateFont(parameter); // font size 12 pixels
        font.setColor(Color.WHITE);
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Clickeed");
                //Simple boolean operation
                if (x1>6){
                    mainGamePage.setScreen(new LevelOne(mainGamePage));
                    x1=0;
                }
                if (!switchbool) {
                    switchbool = true;
                    System.out.println(x1+"");
                }
                x1++;
                 /*else
                    switchbool = false;*/
                super.clicked(event, x, y);
            }
        });
    }

    @Override
    protected void positionChanged() {
        //incase the position changes this method is called
        sprites.setPosition(getX(), getY());
        super.positionChanged();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
       // sprites.draw(batch);
        if (!switchbool) {
            sprite1.draw(batch);
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}