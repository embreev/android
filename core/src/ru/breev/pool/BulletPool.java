package ru.breev.pool;

import ru.breev.base.SpritesPool;
import ru.breev.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {
    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
