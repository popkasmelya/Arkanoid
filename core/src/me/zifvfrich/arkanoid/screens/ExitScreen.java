package me.zifvfrich.arkanoid.screens;

import com.badlogic.gdx.Gdx;
import me.zifvfrich.arkanoid.AbstractScreen;
import me.zifvfrich.arkanoid.Arkanoid;

public class ExitScreen extends AbstractScreen<Arkanoid> {
    public ExitScreen(Arkanoid game) {
        super(game);
    }

    @Override
    public void update(float delta) {

    }

    public void show() {
        System.out.println(game);
        game.dispose();
        Gdx.app.exit();
    }
}
