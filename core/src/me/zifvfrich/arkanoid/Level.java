package me.zifvfrich.arkanoid;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable;
import com.badlogic.gdx.utils.Array;

public abstract class Level {
    public int ballSpeed;
    public int paddleSpeed;
    public TiledDrawable background;
    public Array<Brick> bricks;
    public abstract void draw(SpriteBatch batch);
    public abstract void update();



}
