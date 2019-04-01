package ru.breev.pool;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.breev.base.SpritesPool;
import ru.breev.math.Rect;
import ru.breev.sprite.Bonus;

public class BonusPool extends SpritesPool<Bonus> {

    private TextureAtlas atlas;
    private Rect worldBounds;
    private Sound sound;

    public BonusPool(TextureAtlas atlas, Rect worldBounds, Sound sound) {
        this.atlas = atlas;
        this.worldBounds = worldBounds;
        this.sound = sound;
    }

    @Override
    protected Bonus newObject() {
        return new Bonus(atlas, sound, worldBounds);
    }
}
