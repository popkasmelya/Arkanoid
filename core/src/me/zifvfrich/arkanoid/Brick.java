package me.zifvfrich.arkanoid;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Brick {
    public static final int width = 48;
    public static final int height = 32;
    Rectangle collisonBox;
    TextureRegion texture;
    public Brick(TextureRegion texture, int x, int y) {
        this.texture = texture;
        collisonBox = new Rectangle(x, y, width, height);
    }
    public void draw(SpriteBatch batch) {
        batch.draw(texture, collisonBox.x, collisonBox.y);
    }
}
