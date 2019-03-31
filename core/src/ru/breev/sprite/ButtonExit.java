package ru.breev.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.breev.base.ScaledButton;
import ru.breev.math.Rect;
import ru.breev.screen.EndScreen;

public class ButtonExit extends ScaledButton {

    private Game game;

    public ButtonExit(TextureAtlas atlas) {
        super(atlas.findRegion("btExit"));
        setHeightProportion(0.2f);
    }

    @Override
    public void resize(Rect worldBounds) {
        setBottom(worldBounds.getBottom() + 0.02f);
        setLeft(worldBounds.getLeft() + 0.02f);
    }

    @Override
    protected void action() {
        Gdx.app.exit();
    }
}
