package ru.breev.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.breev.base.BaseScreen;

public class MainScreen extends BaseScreen {
    private SpriteBatch batch;
    private Texture background;
    private Texture spaceship;
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
    private float v;
    private boolean isMoved;
    private float halfWidthSpaceship;
    private float halfHeightSpaceship;
    private float halfWidthScreen;
    private float halfHeightScreen;

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        background = new Texture("space.png");
        spaceship = new Texture("spaceship1_128.png");
        halfWidthSpaceship = spaceship.getWidth() / 2;
        halfHeightSpaceship = spaceship.getHeight() / 2;
        halfWidthScreen = Gdx.graphics.getWidth() / 2;
        halfHeightScreen = Gdx.graphics.getHeight() / 2;
        position = new Vector2(halfWidthScreen - halfWidthSpaceship,
                halfHeightScreen - halfHeightSpaceship);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        updateMotion();
        batch.draw(spaceship, position.x, position.y);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        super.dispose();
    }

    private void updateMotion() {
        if (moveUP && position.y + spaceship.getHeight() <= Gdx.graphics.getHeight())
            position.add(UP);
        if (moveDOWN && position.y >= 0) position.add(DOWN);
        if (moveLEFT && position.x >= 0) position.add(LEFT);
        if (moveRIGHT && position.x + spaceship.getWidth() <= Gdx.graphics.getWidth())
            position.add(RIGHT);
        if (isMoved) {
            position.add(direction.nor().scl(v));
            System.out.printf("SRC %s: %s\nDST %s: %s\n", position.x, position.y, nextPosition.x, nextPosition.y);
            if ((position.x <= 0) || (position.y <= 0) ||
                    (position.x + spaceship.getWidth() >= Gdx.graphics.getWidth()) ||
                    (position.y + spaceship.getHeight() >= Gdx.graphics.getHeight()) ||
                    (nextPosition.cpy().sub(position).len() <= v)) {
                direction.setZero();
            }
        }
    }

    private void setMoveUP(boolean b) {
        if (moveDOWN && b) moveDOWN = false;
        moveUP = b;
    }

    private void setMoveDOWN(boolean b) {
        if (moveUP && b) moveUP = false;
        moveDOWN = b;
    }

    private void setMoveLEFT(boolean b) {
        if (moveRIGHT && b) moveRIGHT = false;
        moveLEFT = b;
    }

    private void setMoveRIGHT(boolean b) {
        if (moveLEFT && b) moveLEFT = false;
        moveRIGHT = b;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.UP:
                setMoveUP(true);
                break;
            case Input.Keys.DOWN:
                setMoveDOWN(true);
                break;
            case Input.Keys.LEFT:
                setMoveLEFT(true);
                break;
            case Input.Keys.RIGHT:
                setMoveRIGHT(true);
                break;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.UP:
                setMoveUP(false);
                break;
            case Input.Keys.DOWN:
                setMoveDOWN(false);
                break;
            case Input.Keys.LEFT:
                setMoveLEFT(false);
                break;
            case Input.Keys.RIGHT:
                setMoveRIGHT(false);
                break;
        }
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        nextPosition = new Vector2(screenX - halfWidthSpaceship,
                Gdx.graphics.getHeight() - screenY - halfHeightSpaceship);
        direction = nextPosition.cpy().sub(position);
//        v = (float) Math.sqrt(speed.x * speed.x + speed.y * speed.y);
        v = speed.len();
//        System.out.printf("SRC %s: %s\nDST %s: %s\n", position.x, position.y, nextPosition.x, nextPosition.y);
        isMoved = true;
        return false;
    }

}
