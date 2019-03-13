package ru.breev;

import com.badlogic.gdx.Game;
import ru.breev.screen.MainScreen;

public class StarGame extends Game {
	@Override
	public void create() {
		setScreen(new MainScreen());
	}
}
