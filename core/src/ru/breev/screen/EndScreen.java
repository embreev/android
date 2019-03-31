package ru.breev.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.breev.base.Base2DScreen;
import ru.breev.math.Rect;
import ru.breev.sprite.Background;
import ru.breev.sprite.ButtonGameOver;
import ru.breev.sprite.ButtonNewGame;
import ru.breev.sprite.Star;

public class EndScreen extends Base2DScreen {

    private static final int STAR_COUNT = 128;

    private Game game;

    private Background background;
    private Texture backgroundTexture;
    private TextureAtlas atlas;

    private Star starList[];
    private ButtonGameOver buttonGameOver;
    private ButtonNewGame buttonNewGame;

    private Music music;

    public EndScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        super.show();
        music = Gdx.audio.newMusic(Gdx.files.internal("data/starwars.mp3"));
        music.setLooping(true);
        music.setVolume(0.7f);
        music.play();
        backgroundTexture = new Texture("textures/bg.png");
        background = new Background(new TextureRegion(backgroundTexture));
        atlas = new TextureAtlas("textures/mainAtlas.tpack");
        starList = new Star[STAR_COUNT];
        for (int i = 0; i < starList.length; i++) {
            starList[i] = new Star(atlas);
        }
        buttonGameOver = new ButtonGameOver(atlas);
        buttonNewGame = new ButtonNewGame(atlas, game);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (Star star : starList) {
            star.resize(worldBounds);
        }
        buttonGameOver.resize(worldBounds);
        buttonNewGame.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    private void update(float delta) {
        for (Star star : starList) {
            star.update(delta);
        }
    }

    private void draw() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        for (Star star : starList) {
            star.draw(batch);
        }
        buttonGameOver.draw(batch);
        buttonNewGame.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        backgroundTexture.dispose();
        atlas.dispose();
        music.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        buttonGameOver.touchDown(touch, pointer);
        buttonNewGame.touchDown(touch, pointer);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        buttonGameOver.touchUp(touch, pointer);
        buttonNewGame.touchUp(touch, pointer);
        return false;
    }

}
