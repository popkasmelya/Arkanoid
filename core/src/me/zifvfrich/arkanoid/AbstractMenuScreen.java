package me.zifvfrich.arkanoid;

import com.badlogic.gdx.utils.ScreenUtils;

public abstract class AbstractMenuScreen extends AbstractScreen<Arkanoid> {
    public AbstractMenuScreen(Arkanoid game) {
        super(game);
        this.batch = game.batch;
    }

    protected void moveBackground(float delta) {
        if (game.backgroundOffset != 0)
            game.backgroundOffset +=  9 * delta;
        else
            game.backgroundOffset = -32;
    }
    protected void drawBackground() {
        ScreenUtils.clear(Assets.backgroundColor);
        Assets.background1.draw(batch, game.backgroundOffset, 0, Constants.SCREEN_WIDTH-game.backgroundOffset, Constants.SCREEN_HEIGHT);
    }
}
