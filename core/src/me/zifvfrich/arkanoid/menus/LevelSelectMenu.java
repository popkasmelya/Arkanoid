package me.zifvfrich.arkanoid.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import me.zifvfrich.arkanoid.Arkanoid;
import me.zifvfrich.arkanoid.Assets;
import me.zifvfrich.arkanoid.Level;
import me.zifvfrich.arkanoid.levels.Level1;
import me.zifvfrich.arkanoid.levels.Level2;
import me.zifvfrich.arkanoid.levels.Level3;
import me.zifvfrich.arkanoid.screens.GameScreen;

public class LevelSelectMenu extends AbstractMenu{
    private final Level[] levels = new Level[] {new Level1(), new Level2(), new Level3()};

    public LevelSelectMenu(Arkanoid game) {
        super(game);

        elements = new Array<>(true, 3);
        elements.addAll(new Text("level 1", Assets.font80, 244, 723, new GameScreen(this.game, levels, 0, 0)),
                new Text("level 2", Assets.font80, 244, 499, new GameScreen(this.game, levels, 1, 0)),
                new Text("level 3", Assets.font80, 244, 275, new GameScreen(this.game, levels, 2, 0)));

        currentIndex = 0;
        currentColor = Color.WHITE;
    }

    @Override
    public void update() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.S) && (currentIndex < 2)) {
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
