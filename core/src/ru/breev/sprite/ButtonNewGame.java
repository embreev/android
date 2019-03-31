package ru.breev.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.breev.base.ScaledButton;
import ru.breev.screen.GameScreen;

public class ButtonNewGame extends ScaledButton {

    private GameScreen gameScreen;

    public ButtonNewGame(TextureAtlas atlas, GameScreen gameScreen) {
        super(atlas.findRegion("button_new_game"));
        setHeightProportion(0.05f);
        setTop(-0.012f);
        this.gameScreen = gameScreen;
    }

    @Override
    protected void action() {
        gameScreen.startNewGame();
    }
}
