package in.teamkrishna.tilegame.android;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

import in.teamkrishna.tilegame.MainGamePage;

public class AndroidLauncher extends AndroidApplication {
	private View decorView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		//initialize(new TileGame(), config);
		//initialize(new JoinDots(),config);
		initialize(new MainGamePage(),config);
		decorView = getWindow().getDecorView();
		hideSystemUi(decorView);
	}

	public void hideSystemUi(View decorView) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
					decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                                    | View.SYSTEM_UI_FLAG_IMMERSIVE
                    );
				}
			}
		}

	}
}