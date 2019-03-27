package ru.breev.pool;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.breev.base.SpritesPool;
import ru.breev.sprite.Explosion;

public class ExplosionPool extends SpritesPool<Explosion> {

    private TextureAtlas atlas;
    private Sound sound;

    public ExplosionPool(TextureAtlas atlas, Sound sound) {
        this.atlas = atlas;
        this.sound = sound;
    }

    @Override
    protected Explosion newObject() {
        return new Explosion(atlas, sound);
    }
}
