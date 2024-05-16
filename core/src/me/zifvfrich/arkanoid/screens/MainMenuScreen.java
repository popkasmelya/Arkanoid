package me.zifvfrich.arkanoid.screens;

import me.zifvfrich.arkanoid.*;
import me.zifvfrich.arkanoid.menus.MainMenu;

public class MainMenuScreen extends AbstractMenuScreen {
    MainMenu menu;
    public MainMenuScreen(Arkanoid game) {
        super(game);
    }

    @Override
    public void update(float delta) {
        menu.update();
        moveBackground(delta);
    }

    @Override
    public void show() {
        if (menu == null)
            menu = new MainMenu(game);
    }

    @Override
    public void render(float delta) {
        update(delta);

        batch.begin();
        drawBackground();
        batch.draw(Assets.logo, 16, 800, 687, 141);
        menu.draw(batch);
        batch.end();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
