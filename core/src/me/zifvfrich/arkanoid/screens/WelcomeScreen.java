package me.zifvfrich.arkanoid.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import me.zifvfrich.arkanoid.Arkanoid;
import me.zifvfrich.arkanoid.Assets;
import me.zifvfrich.arkanoid.AbstractMenuScreen;

public class WelcomeScreen extends AbstractMenuScreen {
    int i;
    public WelcomeScreen(Arkanoid game) {
        super(game);
    }

    @Override
    public void update(float delta) {
        time += delta;

        if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY) && time > 1)
            game.setScreen(game.mainMenuScreen);

        moveBackground(delta);
    }
    @Override
    public void show() {
        game.audioManager.playMusic();
    }
    @Override
    public void render(float delta) {
        this.update(delta);

        game.logger.log();

        batch.begin();
        drawBackground();
        batch.draw(Assets.logo, 16, 447, 687, 141);
        batch.end();

        if ((time % 1) > 0.5f && time > 1) {
            batch.begin();
            Assets.font65.draw(batch, "press any button to start", 25, 100);
            batch.end();
        }
    }
}
