package in.teamkrishna.tilegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Avi on 07/09/15.
 */
public class ButtonActor extends Actor {
    Sprite sprites;
    MainGamePage mainGamePage;

    public ButtonActor(Sprite sprite1, final String levels, final MainGamePage mainGamePage) {
        this.mainGamePage = mainGamePage;
        this.sprites = sprite1;
        setBounds(sprites.getX(), sprites.getY(), sprites.getWidth(), sprites.getHeight());
        setTouchable(Touchable.enabled);
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Clicked");
                if (levels.equals("levels")) {
                    System.out.println("working");
                    mainGamePage.setScreen(new LevelOne(mainGamePage));
                } else if (levels.equals("exit")){
                    Gdx.app.exit();
                } else if (levels.equals("back")){
                    mainGamePage.setScreen(new MainMenuScreen(mainGamePage));
                } else if (levels.equals("puzzle")){
                    mainGamePage.setScreen(new TileGame(mainGamePage));
                } else if (levels.equals("puzzleback")){
                    mainGamePage.setScreen(new LevelOne(mainGamePage));
                } else if (levels.equals("draw")){
                    mainGamePage.setScreen(new JoinDots(mainGamePage));
                }
                super.clicked(event, x, y);
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprites.draw(batch);
    }

    @Override
    protected void positionChanged() {
        //incase the position changes this method is called
        sprites.setPosition(getX(), getY());
        super.positionChanged();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
