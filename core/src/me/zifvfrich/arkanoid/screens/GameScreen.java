package me.zifvfrich.arkanoid.screens;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;
import me.zifvfrich.arkanoid.*;

import java.util.Iterator;

public class GameScreen extends AbstractScreen<Arkanoid> {
    private Paddle paddle;
    private Ball ball;
    private int score;
    private Level level;
    private ShapeRenderer boundsDrawer;
    private Color boundsColor;
    public static final int boundX1 = 23;
    public static final int boundX2 = 696;
    public static final int boundY = 864;
    public GameScreen(Arkanoid game, Level level) {
        super(game);
        this.batch = game.batch;
        this.level = level;
        boundsDrawer = new ShapeRenderer();
        boundsColor = new Color(132/255f, 126/255f, 135/255f, 1);
        paddle = new Paddle(Assets.paddle, 34, boundX1, boundX2);
        ball = new Ball(Assets.ball, 100, 100, boundX1, boundX2, boundY);
    }
    @Override
    public void update(float delta) {
        paddle.update(delta);
        ball.update(delta);

        if (ball.checkCollision(paddle)) {
            ball.speedY = -ball.speedY;
            ball.speedX = ball.speedX;
        }

        Brick brick;
        for (Iterator<Brick> iter = level.bricks.iterator(); iter.hasNext();) {
            brick = iter.next();
            if(ball.checkCollision(brick)) {
                game.audioManager.playHitSound();
                iter.remove();
                ball.speedY = -ball.speedY;
                ball.speedX = -ball.speedX;
            }
        }
    }
    @Override
    public void render(float delta) {
        update(delta);

        ScreenUtils.clear(Assets.backgroundColor);

        drawBounds();

        batch.begin();
        level.background.draw(batch, 24, 0, 672, 864);
        batch.draw(Assets.logo, 457, 900);
        paddle.draw(batch);
        level.draw(batch);
        ball.draw(batch);
        batch.end();
    }
    private void drawBounds() {
        boundsDrawer.setColor(boundsColor);
        boundsDrawer.begin(ShapeType.Filled);
        boundsDrawer.rect(8, 0, 16, 864);
        boundsDrawer.rect(8, 864, 704, 16);
        boundsDrawer.rect(696, 0, 16, 864);
        boundsDrawer.end();
    }
}
