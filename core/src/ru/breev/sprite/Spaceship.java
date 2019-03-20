package ru.breev.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import ru.breev.base.MotionSpaceship;
import ru.breev.math.Rect;

public class Spaceship extends MotionSpaceship {
    public Spaceship(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship"));
        setHeightProportion(0.3f);
    }

    @Override
    public void resize(Rect worldBounds) {
        setBottom(worldBounds.getBottom() + 0.02f);
    }

    @Override
    public void update(float delta) {
        updateMotion();
    }
}
