package me.zifvfrich.arkanoid.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import me.zifvfrich.arkanoid.AbstractMenuScreen;
import me.zifvfrich.arkanoid.Arkanoid;
import me.zifvfrich.arkanoid.Assets;

public class CreditsScreen extends AbstractMenuScreen {
    public CreditsScreen(Arkanoid game) {
        super(game);
    }

    @Override
    public void update(float delta) {
        moveBackground(delta);
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
            game.setScreen(game.mainMenuScreen);
    }
    @Override
    public void render(float delta) {
        update(delta);

        batch.begin();
        drawBackground();
        Assets.font80.draw(batch, "programmer", 176, 851);
        Assets.font80.draw(batch, "zimich artem", 151, 771);
        Assets.font80.draw(batch, "used music authors", 50, 659);
        Assets.font80.draw(batch, "mattis", 251, 579);
        Assets.font80.draw(batch, "necros", 250, 499);
        Assets.font80.draw(batch, "ogge", 288, 419);
        Assets.font80.draw(batch, "sanxion", 232, 339);
        Assets.font80.draw(batch, "used sounds authors", 31, 227);
        Assets.font80.draw(batch, "dneproman", 195, 147);
        batch.end();
    }
}
