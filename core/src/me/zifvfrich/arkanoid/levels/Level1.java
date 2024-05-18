package me.zifvfrich.arkanoid.levels;

import com.badlogic.gdx.utils.Array;
import me.zifvfrich.arkanoid.Assets;
import me.zifvfrich.arkanoid.Brick;
import me.zifvfrich.arkanoid.Level;
import me.zifvfrich.arkanoid.screens.GameScreen;

public class Level1 extends Level {
    public Level1() {
        ballSpeed = 400;
        paddleSpeed = 250;
        scorePerBrick = 20;
        lifes = 3;

        bricks = new Array<>(false, 14*4);
        background = Assets.background2;

        for (int y = GameScreen.boundY-Brick.height; y > GameScreen.boundY-Brick.height*3-1; y -= Brick.height) {
            for (int x = GameScreen.boundX1+1; x < GameScreen.boundX2; x += Brick.width) {
                bricks.add(new Brick(Assets.bricks.random(), x, y));
            }
        }
    }
}
