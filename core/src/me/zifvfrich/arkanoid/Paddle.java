package me.zifvfrich.arkanoid;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Paddle {
    TextureRegion texture;
    Rectangle collisionBox;
    int bound1;
    int bound2;
    int speedX;
    public Paddle(TextureRegion texture, int y, int bound1, int bound2, int speed) {
        this.texture = texture;

        collisionBox = new Rectangle(0, y, texture.getRegionWidth(), texture.getRegionHeight());
        collisionBox.x =  Constants.X_CENTER - collisionBox.width/2;

        this.bound1 = bound1;
        this.bound2 = bound2;

        speedX = speed;

    }
    public void update(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            collisionBox.x -= (int) (delta * speedX);
            if (collisionBox.contains(bound1, collisionBox.y))
                collisionBox.x = bound1 + 1;
        }  else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            collisionBox.x += (int) (delta * speedX);
            if (collisionBox.contains(bound2, collisionBox.y))
                collisionBox.x = bound2-collisionBox.width;
        }
    }
    public void draw(SpriteBatch batch) {
        batch.draw(texture, collisionBox.x, collisionBox.y);
    }
}
