package ru.breev.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class MotionSpaceship extends Sprite {
    private boolean moveUP;
    private boolean moveDOWN;
    private boolean moveLEFT;
    private boolean moveRIGHT;
    private float v;
    private boolean isMoved;
    private Vector2 position;
    private Vector2 nextPosition;
    private Vector2 speed = new Vector2(2, 2);
    private Vector2 direction;
    private Vector2 UP = new Vector2(0, 2);
    private Vector2 DOWN = new Vector2(0, -2);
    private Vector2 LEFT = new Vector2(-2, 0);
    private Vector2 RIGHT = new Vector2(2, 0);

    public MotionSpaceship(TextureRegion region) {
        super(region);
    }
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

    protected void updateMotion() {
        if (moveUP && position.y + this.getHeight() <= Gdx.graphics.getHeight())
            position.add(UP);
        if (moveDOWN && position.y >= 0) position.add(DOWN);
        if (moveLEFT && position.x >= 0) position.add(LEFT);
        if (moveRIGHT && position.x + this.getWidth() <= Gdx.graphics.getWidth())
            position.add(RIGHT);
        if (isMoved) {
            position.add(direction.nor().scl(v));
//            System.out.printf("SRC %s: %s\nDST %s: %s\n", position.x, position.y, nextPosition.x, nextPosition.y);
            if ((position.x <= 0) || (position.y <= 0) ||
                    (position.x + this.getWidth() >= Gdx.graphics.getWidth()) ||
                    (position.y + this.getHeight() >= Gdx.graphics.getHeight()) ||
                    (nextPosition.cpy().sub(position).len() <= v)) {
                direction.setZero();
            }
        }
    }

    private boolean touchDown(Vector2 touch) {
        nextPosition = new Vector2(touch);
        direction = nextPosition.cpy().sub(position);
//        v = (float) Math.sqrt(speed.x * speed.x + speed.y * speed.y);
        v = speed.len();
//        System.out.printf("SRC %s: %s\nDST %s: %s\n", position.x, position.y, nextPosition.x, nextPosition.y);
        isMoved = true;
        return false;
    }
}
