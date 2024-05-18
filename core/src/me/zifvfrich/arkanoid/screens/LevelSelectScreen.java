package me.zifvfrich.arkanoid.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import me.zifvfrich.arkanoid.AbstractMenuScreen;
import me.zifvfrich.arkanoid.Arkanoid;
import me.zifvfrich.arkanoid.menus.LevelSelectMenu;

public class LevelSelectScreen extends AbstractMenuScreen {
    LevelSelectMenu menu;

    public LevelSelectScreen(Arkanoid game) {
        super(game);
    }
    @Override
    public void update(float delta) {
        moveBackground(delta);
        menu.update();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
            game.setScreen(game.mainMenuScreen);
    }
    @Override
    public void show() {
        menu = new LevelSelectMenu(game);
    }
    @Override
    public void render(float delta) {
        update(delta);

        batch.begin();
        drawBackground();
        menu.draw(batch);
        batch.end();
    }
}
