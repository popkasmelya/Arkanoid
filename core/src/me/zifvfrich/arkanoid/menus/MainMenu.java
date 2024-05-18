package me.zifvfrich.arkanoid.menus;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import me.zifvfrich.arkanoid.Arkanoid;
import me.zifvfrich.arkanoid.Assets;

public class MainMenu extends AbstractMenu {
    public MainMenu(Arkanoid game) {
        super(game);
        elements = new Array<>(true, 4);
        elements.addAll(new Text("play", Assets.font80, 288, 559, game.levelSelectScreen),
                        new Text("settings", Assets.font80, 213, 463, game.settingsScreen),
                        new Text("credits", Assets.font80, 232, 367, game.creditsScreen),
                        new Text("exit", Assets.font80, 288, 271, game.exitScreen));

        currentIndex = 0;
        currentColor = Color.WHITE;
    }
    public void update() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.S) && (currentIndex < 3)) {
            game.audioManager.playSelectSound();
            currentIndex++;
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.W) && (currentIndex > 0)) {
            game.audioManager.playSelectSound();
            currentIndex--;
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.D) || Gdx.input.isKeyJustPressed(Input.Keys.A)) {
            game.audioManager.playSelectSound();
            game.setScreen(elements.get(currentIndex).screen);
        }
    }
}
