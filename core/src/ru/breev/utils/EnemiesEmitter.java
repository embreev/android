package ru.breev.utils;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.breev.math.Rect;
import ru.breev.math.Rnd;
import ru.breev.pool.EnemyPool;
import ru.breev.sprite.Enemy;

public class EnemiesEmitter {

    private static final float ENEMY_SMALL_HEIGHT = 0.1f;
    private static final float ENEMY_SMALL_BULLET_HEIGHT = 0.01f;
    private static final float ENEMY_SMALL_BULLET_VY = -0.3f;
    private static final int ENEMY_SMALL_DAMAGE = 1;
    private static final float ENEMY_SMALL_RELOAD_INTERVAL = 3f;
    private static final int ENEMY_SMALL_HP = 1;

    private static final float ENEMY_MIDDLE_HEIGHT = 0.13f;
    private static final float ENEMY_MIDDLE_BULLET_HEIGHT = 0.02f;
    private static final float ENEMY_MIDDLE_BULLET_VY = -0.3f;
    private static final int ENEMY_MIDDLE_DAMAGE = 2;
    private static final float ENEMY_MIDDLE_RELOAD_INTERVAL = 9f;
    private static final int ENEMY_MIDDLE_HP = 2;

    private static final float ENEMY_BIG_HEIGHT = 0.16f;
    private static final float ENEMY_BIG_BULLET_HEIGHT = 0.03f;
    private static final float ENEMY_BIG_BULLET_VY = -0.3f;
    private static final int ENEMY_BIG_DAMAGE = 3;
    private static final float ENEMY_BIG_RELOAD_INTERVAL = 27f;
    private static final int ENEMY_BIG_HP = 3;

    private Rect worldBounds;

    private float generateInterval = 4f;
    private float generateTimer0;
    private float generateTimer1;
    private float generateTimer2;

    private TextureRegion[] enemySmallRegion;
    private Vector2 enemySmallV = new Vector2(0f, -0.2f);

    private TextureRegion[] enemyMiddleRegion;
    private Vector2 enemyMiddleV = new Vector2(0f, -0.2f);

    private TextureRegion[] enemyBigRegion;
    private Vector2 enemyBigV = new Vector2(0f, -0.2f);

    private TextureRegion bulletRegion;

    private EnemyPool enemyPool;

    public EnemiesEmitter(TextureAtlas atlas, Rect worldBounds, EnemyPool enemyPool) {
        this.worldBounds = worldBounds;
        this.enemyPool = enemyPool;
        TextureRegion textureRegion0 = atlas.findRegion("enemy0");
        this.enemySmallRegion = Regions.split(textureRegion0, 1, 2, 2);
        TextureRegion textureRegion1 = atlas.findRegion("enemy1");
        this.enemyMiddleRegion = Regions.split(textureRegion1, 1, 2, 2);
        TextureRegion textureRegion2 = atlas.findRegion("enemy2");
        this.enemyBigRegion = Regions.split(textureRegion2, 1, 2, 2);
        this.bulletRegion = atlas.findRegion("bulletEnemy");
    }

    public void generateSmall(float delta) {
        generateTimer0 += delta;
        if (generateTimer0 >= ENEMY_SMALL_RELOAD_INTERVAL) {
            generateTimer0 = 0f;
            Enemy enemy = enemyPool.obtain();
            enemy.set(
                    enemySmallRegion,
                    enemySmallV,
                    bulletRegion,
                    ENEMY_SMALL_BULLET_HEIGHT,
                    ENEMY_SMALL_BULLET_VY,
                    ENEMY_SMALL_DAMAGE,
                    ENEMY_SMALL_RELOAD_INTERVAL,
                    ENEMY_SMALL_HEIGHT,
                    ENEMY_SMALL_HP
            );
            enemy.pos.x = Rnd.nextFloat(worldBounds.getLeft() + enemy.getHalfWidth(), worldBounds.getRight() - enemy.getHalfWidth());
            enemy.setBottom(worldBounds.getTop());
        }
    }

    public void generateMiddle(float delta) {
        generateTimer1 += delta;
        if (generateTimer1 >= ENEMY_MIDDLE_RELOAD_INTERVAL) {
            generateTimer1 = 0f;
            Enemy enemy = enemyPool.obtain();
            enemy.set(
                    enemyMiddleRegion,
                    enemyMiddleV,
                    bulletRegion,
                    ENEMY_MIDDLE_BULLET_HEIGHT,
                    ENEMY_MIDDLE_BULLET_VY,
                    ENEMY_MIDDLE_DAMAGE,
                    ENEMY_MIDDLE_RELOAD_INTERVAL,
                    ENEMY_MIDDLE_HEIGHT,
                    ENEMY_MIDDLE_HP
            );
            enemy.pos.x = Rnd.nextFloat(worldBounds.getLeft() + enemy.getHalfWidth(), worldBounds.getRight() - enemy.getHalfWidth());
            enemy.setBottom(worldBounds.getTop());
        }
    }

    public void generateBig(float delta) {
        generateTimer2 += delta;
        if (generateTimer2 >= ENEMY_BIG_RELOAD_INTERVAL) {
            generateTimer2 = 0f;
            Enemy enemy = enemyPool.obtain();
            enemy.set(
                    enemyBigRegion,
                    enemyBigV,
                    bulletRegion,
                    ENEMY_BIG_BULLET_HEIGHT,
                    ENEMY_BIG_BULLET_VY,
                    ENEMY_BIG_DAMAGE,
                    ENEMY_BIG_RELOAD_INTERVAL,
                    ENEMY_BIG_HEIGHT,
                    ENEMY_BIG_HP
            );
            enemy.pos.x = Rnd.nextFloat(worldBounds.getLeft() + enemy.getHalfWidth(), worldBounds.getRight() - enemy.getHalfWidth());
            enemy.setBottom(worldBounds.getTop());
        }
    }
}
