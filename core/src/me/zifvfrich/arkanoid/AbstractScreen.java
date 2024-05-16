package me.zifvfrich.arkanoid;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class AbstractScreen<T> implements Screen {
    protected T game;
    protected float time;
    protected SpriteBatch batch;

    public AbstractScreen(T game){
        this.game = game;
    }
    abstract public void update(float delta);
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
