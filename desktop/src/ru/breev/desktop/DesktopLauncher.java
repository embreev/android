package ru.breev.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.breev.Star2DGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		float aspect = 3f/4f;
		config.width = 400;
		config.height = (int) (config.width / aspect);
		config.resizable = false;
		new LwjglApplication(new Star2DGame(), config);
	}
}
