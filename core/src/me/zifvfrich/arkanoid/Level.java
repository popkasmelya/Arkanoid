package me.zifvfrich.arkanoid;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable;
import com.badlogic.gdx.utils.Array;

public abstract class Level {
    public int ballSpeed;
    public int paddleSpeed;
    public int lifes;
    public int scorePerBrick;
    public TiledDrawable background;
    public Array<Brick> bricks;
    public void draw(SpriteBatch batch) {
        for (Brick brick : bricks) {
            brick.draw(batch);
        }
    }
}
