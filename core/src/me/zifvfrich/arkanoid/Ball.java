package me.zifvfrich.arkanoid;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;

public class Ball {
    Circle collisionBox;
    TextureRegion texture;
    public int speedX;
    public int speedY;
    int boundX1;
    int boundX2;
    int boundY;
    public Ball(TextureRegion texture, int x, int y, int boundX1, int boundX2, int boundY, int speed) {
        this.texture = texture;
        collisionBox = new Circle(0, 0, texture.getRegionHeight()/2);

        this.boundX1 = boundX1;
        this.boundX2 = boundX2;
        this.boundY = boundY;

        speedY = speed;
        speedX = speed;
    }
    public void update(float delta) {
        collisionBox.y += (speedY * delta);
        collisionBox.x += (speedX * delta);

        if (collisionBox.contains(boundX1, collisionBox.y)) {
            speedX = -speedX;
            collisionBox.x = boundX1+collisionBox.radius;
        } else if (collisionBox.contains(boundX2, collisionBox.y)) {
            speedX = -speedX;
            collisionBox.x = boundX2-collisionBox.radius;
        }
        if (collisionBox.contains(collisionBox.x, boundY)) {
            speedY = -speedY;
            collisionBox.y = boundY-collisionBox.radius;
        }
    }
    public void draw(SpriteBatch batch) {
        batch.draw(texture, collisionBox.x-collisionBox.radius, collisionBox.y-collisionBox.radius);
    }
    public boolean checkCollision(Paddle paddle) {
        if (Intersector.overlaps(collisionBox, paddle.collisionBox))
            return true;
        return false;
    }
    public boolean checkCollision(Brick brick) {
        if (Intersector.overlaps(collisionBox, brick.collisonBox))
            return true;
        return false;
    }
}
