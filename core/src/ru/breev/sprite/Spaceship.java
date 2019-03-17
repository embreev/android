package ru.breev.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.breev.base.Sprite;
import ru.breev.math.Rect;
import ru.breev.math.Rnd;

public class Spaceship extends Sprite {
    private Vector2 position;
    private Vector2 nextPosition;
    private Vector2 speed = new Vector2(2, 2);
    private Vector2 direction;
    private Vector2 UP = new Vector2(0, 2);
    private Vector2 DOWN = new Vector2(0, -2);
    private Vector2 LEFT = new Vector2(-2, 0);
    private Vector2 RIGHT = new Vector2(2, 0);
    private boolean moveUP;
    private boolean moveDOWN;
    private boolean moveLEFT;
    private boolean moveRIGHT;

    public Spaceship(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship"));
        setHeightProportion(0.3f);
    }

    @Override
    public void resize(Rect worldBounds) {
        setBottom(worldBounds.getBottom() + 0.02f);
    }

}
