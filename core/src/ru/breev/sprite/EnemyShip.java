package ru.breev.sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.breev.base.Sprite;
import ru.breev.math.Rect;

public class EnemyShip extends Sprite {

    private TextureAtlas atlas;
    private Rect worldBounds;

    private float health;
    private float damage;

    private Vector2 v = new Vector2();
    private Vector2 v0 = new Vector2(0.5f, 0);

    public EnemyShip(TextureAtlas atlas, float health, float damage) {
        super(atlas.findRegion("enemy0"), 1, 2, 2);
        this.atlas = atlas;
        setHeightProportion(0.15f);
        //setAngle(180); //не нужен, т.к. вражеские корабли уже перевернуты
        this.health = health;
        this.damage = damage;
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        setTop(worldBounds.getTop() - 0.05f);
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        if (getRight() < worldBounds.getRight() + this.getWidth() / 2) {
            moveRight();
        }
        if (getLeft() < worldBounds.getLeft() + this.getWidth() / 2) {
            moveLeft();
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    public void shoot() {

    }

    public float getHealth() {
        return this.health;
    }

    public float getDamage() {
        return this.damage;
    }

    private void moveRight() {
        v.set(v0);
    }

    private void moveLeft() {
        v.set(v0).rotate(180);
    }

    private void stop() {
        v.setZero();
    }
}
