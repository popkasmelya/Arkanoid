package me.zifvfrich.arkanoid.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import me.zifvfrich.arkanoid.Arkanoid;
import me.zifvfrich.arkanoid.Assets;
import me.zifvfrich.arkanoid.Settings;

public class SettingsMenu extends AbstractMenu {
    public SettingsMenu(Arkanoid game) {
        super(game);
        elements = new Array<>(true, 4);
        elements.addAll(new Text("music volume...........", Assets.font80, 16, 799, Settings.getMusicVolume()),
                        new Text("sound volume...........", Assets.font80, 16, 703, Settings.getSoundVolume()));
    }
    @Override
    public void update() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.S) && (currentIndex < 1)) {
            game.audioManager.playSelectSound();
            currentIndex++;
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.W) && (currentIndex > 0)) {
            game.audioManager.playSelectSound();
            currentIndex--;
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.D) && elements.get(currentIndex).value < 100) {
            game.audioManager.playSelectSound();
            elements.get(currentIndex).value += 5;
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.A) && elements.get(currentIndex).value > 0) {
            game.audioManager.playSelectSound();
            elements.get(currentIndex).value -= 5;
        }

        if (currentIndex == 0)
            Settings.setMusicVolume(elements.get(currentIndex).value);
        else
            Settings.setSoundVolume(elements.get(currentIndex).value);

        game.audioManager.updateVolume();
    }
}
