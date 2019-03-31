package ru.breev.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.breev.base.ScaledButton;
import ru.breev.math.Rect;
import ru.breev.screen.GameScreen;

public class ButtonNewGame extends ScaledButton {

    private Game game;

    public ButtonNewGame(TextureAtlas atlas, Game game) {
        super(atlas.findRegion("button_new_game"));
        this.game = game;
        setHeightProportion(0.1f);
    }

    @Override
    public void resize(Rect worldBounds) {
        setBottom(worldBounds.getBottom() + 0.1f);
    }

    @Override
    protected void action() {
        game.setScreen(new GameScreen(game));
    }
}
