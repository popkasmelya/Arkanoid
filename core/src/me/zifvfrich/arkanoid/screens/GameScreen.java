package me.zifvfrich.arkanoid.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.ScreenUtils;
import me.zifvfrich.arkanoid.*;

import java.util.Iterator;

public class GameScreen extends AbstractScreen<Arkanoid> {
    private final Paddle paddle;
    private final Ball ball;
    private final int levelIndex;
    private int score;
    private int lifeCount;
    private final Level level;
    private final ShapeRenderer boundsDrawer;
    private final Color boundsColor;
    private float timer;
    private boolean lose = false;
    private boolean win = false;
    private final Level[] levels;
    public static final int boundX1 = 23;
    public static final int boundX2 = 696;
    public static final int boundY = 864;
    public GameScreen(Arkanoid game, Level[] levels, int levelIndex, int score) {
        super(game);
        this.batch = game.batch;
        this.level = levels[levelIndex];
        this.levels = levels;
        this.levelIndex = levelIndex;
        boundsDrawer = new ShapeRenderer();
        boundsColor = new Color(132/255f, 126/255f, 135/255f, 1);
        paddle = new Paddle(Assets.paddle, 34, boundX1, boundX2, level.paddleSpeed);
        ball = new Ball(Assets.ball, Constants.X_CENTER, 200, boundX1, boundX2, boundY, level.ballSpeed);
        this.score = score;
        lifeCount = level.lifes;
    }
    @Override
    public void update(float delta) {
        paddle.update(delta);
        ball.update(delta);

        if (ball.collisionBox.y < -level.ballSpeed*3) {
            if (lifeCount != 0) {
                lifeCount -= 1;
                ball.collisionBox.y = 200;
                ball.collisionBox.x = Constants.X_CENTER;
                ball.speedY = -ball.speedY;
            } else {
                lose = true;
                timer += delta;
            }
        }

        if (ball.checkCollision(paddle)) {
            ball.speedY = -ball.speedY;
            if (Gdx.input.isKeyPressed(Input.Keys.A) && (ball.speedX > 0))
                ball.speedX = -ball.speedX;
            else if ((Gdx.input.isKeyPressed(Input.Keys.D) && (ball.speedX < 0)))
                ball.speedX = -ball.speedX;

            ball.collisionBox.setPosition(ball.collisionBox.x, ball.collisionBox.y+ball.collisionBox.radius/2);
        }

        Brick brick;
        for (Iterator<Brick> iter = level.bricks.iterator(); iter.hasNext();) {
            brick = iter.next();
            if (ball.checkCollision(brick)) {
                game.audioManager.playHitSound();
                iter.remove();
                score += level.scorePerBrick;
                ball.speedY = -ball.speedY;
                ball.speedX = -ball.speedX;
            }
        }

        if (level.bricks.isEmpty()) {
            win = true;
            timer += delta;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
            game.setScreen(game.mainMenuScreen);
    }
    @Override
    public void render(float delta) {
        time += delta;
        update(delta);

        ScreenUtils.clear(Assets.backgroundColor);

        drawBounds();

        batch.begin();
        level.background.draw(batch, 24, 0, 672, 864);
        batch.draw(Assets.logo, 457, 900);
        Assets.font65.draw(batch, "score: "+score, 8, Constants.SCREEN_HEIGHT-16);
        Assets.font65.draw(batch, "lifes: "+lifeCount, 8, Constants.SCREEN_HEIGHT-16-45);
        paddle.draw(batch);
        level.draw(batch);
        ball.draw(batch);
        if (lose) {
            Assets.font80.draw(batch, "game over", Constants.X_CENTER-150, Constants.Y_CENTER);
            if (timer > 3)
                game.setScreen(game.mainMenuScreen);
        } else if (win) {
            Assets.font80.draw(batch, "you win", Constants.X_CENTER-150, Constants.Y_CENTER);
            if (timer > 3)
                getNextLevel();
        }
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
    private void getNextLevel() {
        if (levelIndex+1 > levels.length-1)
            game.setScreen(game.mainMenuScreen);
        else
            game.setScreen(new GameScreen(game, levels, levelIndex+1, score));

    }
}
