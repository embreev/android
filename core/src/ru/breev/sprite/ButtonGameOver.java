package ru.breev.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.breev.base.ScaledButton;
import ru.breev.math.Rect;

public class ButtonGameOver extends ScaledButton {

    public ButtonGameOver(TextureAtlas atlas) {
        super(atlas.findRegion("message_game_over"));
        setHeightProportion(0.1f);
    }

    @Override
    public void resize(Rect worldBounds) {
        setTop(worldBounds.getTop() - 0.1f);
    }

    @Override
    protected void action() {
        Gdx.app.exit();
    }
}
