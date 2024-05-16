package me.zifvfrich.arkanoid.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import me.zifvfrich.arkanoid.AbstractMenuScreen;
import me.zifvfrich.arkanoid.Arkanoid;
import me.zifvfrich.arkanoid.Assets;
import me.zifvfrich.arkanoid.Settings;
import me.zifvfrich.arkanoid.menus.SettingsMenu;

public class SettingsScreen extends AbstractMenuScreen {
    private SettingsMenu menu;
    public SettingsScreen(Arkanoid game) {
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
        if (menu == null)
            menu = new SettingsMenu(game);
    }

    @Override
    public void render(float delta) {
        update(delta);
        batch.begin();
        drawBackground();
        Assets.font80.draw(batch, "settings", 208, 911);
        menu.draw(batch);
        batch.end();
    }

    public void hide() {
        System.out.println(Settings.musicVolume);
    }

}
