package ru.breev;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class StarGame extends Game {
	SpriteBatch batch;
	Texture background;
	Texture spaceship;
	Vector2 position;
	Vector2 nextPosistion;
	Vector2 speed = new Vector2(2, 2);
	Vector2 UP = new Vector2(0, 2);
	Vector2 DOWN = new Vector2(0, -2);
	Vector2 LEFT = new Vector2(-2, 0);
	Vector2 RIGHT = new Vector2(2, 0);
	int mouseX;
	int mouseY;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("space.png");
		spaceship = new Texture("spaceship1_128.png");
		position = new Vector2((Gdx.graphics.getWidth() / 2) - (spaceship.getWidth() / 2),
				(Gdx.graphics.getHeight() / 2) - (spaceship.getHeight() / 2));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		if (Gdx.input.isKeyPressed(Input.Keys.UP) &&
				position.y + spaceship.getHeight() <= Gdx.graphics.getHeight()) {
			position.add(UP);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && position.y >= 0) {
			position.add(DOWN);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && position.x >= 0) {
			position.add(LEFT);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) &&
				position.x + spaceship.getWidth() <= Gdx.graphics.getWidth()) {
			position.add(RIGHT);
		}

		if (Gdx.input.isTouched()) {
			mouseX = Gdx.input.getX();
			mouseY = Gdx.input.getY();
			System.out.println("x: " + mouseX + "; " + "y: " + mouseY);
		}

		batch.draw(spaceship, position.x, position.y);
//		position.add(speed);
//		if ((position.x <= 0) ||
//				(position.y <= 0) ||
//				(position.x + spaceship.getWidth() >= Gdx.graphics.getWidth()) ||
//				(position.y + spaceship.getHeight() >= Gdx.graphics.getHeight())) {
//			speed.set(0, 0);
//		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
	}
}
