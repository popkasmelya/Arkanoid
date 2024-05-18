package me.zifvfrich.arkanoid.levels;

import com.badlogic.gdx.utils.Array;
import me.zifvfrich.arkanoid.Assets;
import me.zifvfrich.arkanoid.Brick;
import me.zifvfrich.arkanoid.Level;
import me.zifvfrich.arkanoid.screens.GameScreen;

public class Level2 extends Level {
    public Level2() {
        ballSpeed = 500;
        paddleSpeed = 300;
        scorePerBrick = 40;
        lifes = 4;

        bricks = new Array<>(false, 14*4);
        background = Assets.background1;

        for (int y = GameScreen.boundY- Brick.height*3; y > GameScreen.boundY-Brick.height*8-1; y -= Brick.height) {
            for (int x = GameScreen.boundX1+1; x < GameScreen.boundX2; x += Brick.width*2) {
                bricks.add(new Brick(Assets.bricks.random(), x, y));
            }
        }

    }
}
