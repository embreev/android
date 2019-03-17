package ru.breev;

import com.badlogic.gdx.Game;

import ru.breev.screen.MenuScreen;

public class Star2DGame extends Game {
    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }
}
