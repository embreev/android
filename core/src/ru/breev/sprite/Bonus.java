package ru.breev.sprite;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.breev.base.Sprite;
import ru.breev.math.Rect;

public class Bonus extends Sprite {

    public final Vector2 pos = new Vector2();
    private Vector2 v;
    private Sound sound;
    private Rect worldBounds;
    private int hp;
    private int damage;
    private float reloadInterval = 5f;
    private float reloadTimer;

    public Bonus(TextureAtlas atlas, Sound sound, Rect worldBounds) {
        super(atlas.findRegion("bonus-damage"));
        setHeightProportion(0.07f);
        this.sound = sound;
        this.worldBounds = worldBounds;
        this.hp = 0;
        this.damage = 50;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        reloadTimer += delta;
        pos.mulAdd(v, delta);
        if (reloadTimer >= reloadInterval) {
            reloadTimer = 0f;
        }
        if (getBottom() <= worldBounds.getBottom()) {
            this.destroy();
        }
    }

    public int getHp() {
        return hp;
    }

    public int getDamage() {
        return damage;
    }
}