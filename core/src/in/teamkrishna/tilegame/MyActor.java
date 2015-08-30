package in.teamkrishna.tilegame;

/**
 * Created by Avi on 30/08/15.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MyActor extends Actor {
    Sprite sprite = new Sprite(new Texture(Gdx.files.internal("badlogic.jpg")));
    Sprite sprite1 = new Sprite(new Texture("cover.png"));
    boolean switchbool = false;

    public MyActor() {
        //Scaled the image and changed the position
        sprite.scale(1);
        sprite.setPosition(100, 0);
        sprite1.scale(2);
        sprite1.setPosition(100, 0);

        //touchable field for the sprite i.e. for our image
        setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
        setTouchable(Touchable.enabled);

        //make sure to use the "ClickListener()" and within it the "Clicled()"
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Clickeed");

                //Simple boolean operation
                if (!switchbool)
                    switchbool = true;
                else
                    switchbool = false;
                super.clicked(event, x, y);
            }
        });
    }

    @Override
    protected void positionChanged() {
        //incase the position changes this method is called
        sprite.setPosition(getX(), getY());
        super.positionChanged();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);

        //By default the badlogic image is set if boolean is true use the cover
        if (switchbool)
            sprite1.draw(batch);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}