package in.teamkrishna.tilegame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;

/**
 * Created by Avi on 07/09/15.
 */
public class MainGamePage extends Game implements ApplicationListener {


    @Override
    public void create() {

        //Texture.setEnforcePotImages(false);
        setScreen(new SplashScreens(this));
    }
}
