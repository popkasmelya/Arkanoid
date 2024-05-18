package me.zifvfrich.arkanoid.levels;

import com.badlogic.gdx.utils.Array;
import me.zifvfrich.arkanoid.Assets;
import me.zifvfrich.arkanoid.Brick;
import me.zifvfrich.arkanoid.Level;
import me.zifvfrich.arkanoid.screens.GameScreen;

public class Level3 extends Level {
    public Level3() {
        ballSpeed = 600;
        paddleSpeed = 400;
        lifes = 4;
        scorePerBrick = 60;

        bricks = new Array<>(false, 14*4);
        background = Assets.background2;

        for (int y = GameScreen.boundY- Brick.height*6; y > GameScreen.boundY-Brick.height*14-1; y -= Brick.height*2) {
            for (int x = GameScreen.boundX1+1; x < GameScreen.boundX2; x += Brick.width) {
                bricks.add(new Brick(Assets.bricks.random(), x, y));
            }
        }

    }
}
