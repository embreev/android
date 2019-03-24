package ru.breev.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

import ru.breev.base.Sprite;
import ru.breev.math.Rect;

public class Bullet extends Sprite {

    private Rect worldBounds;
    private Vector2 v;
    private int damage;
    private Object owner;

//    public Circle hitArea;

    public Bullet() {
        this.v = new Vector2();
        this.regions = new TextureRegion[1];
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        this.worldBounds = worldBounds;
    }

    public void set(
        Object owner,
        TextureRegion region,
        Vector2 pos0,
        Vector2 v0,
        float height,
        Rect worldBounds,
        int damage
    ) {
        this.owner = owner;
        this.regions[0] = region;
        this.pos.set(pos0);
        this.v.set(v0);
        setHeightProportion(height);
        this.worldBounds = worldBounds;
        this.damage = damage;
//        this.hitArea = new Circle(this.pos.x, this.pos.y, this.halfHeight);
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        if (isOutside(worldBounds)) {
            destroy();
        }
//        hitArea.x = pos.x;
//        hitArea.y = pos.y;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Object getOwner() {
        return owner;
    }

    public void setOwner(Object owner) {
        this.owner = owner;
    }
}
