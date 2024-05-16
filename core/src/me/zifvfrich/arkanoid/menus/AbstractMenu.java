package me.zifvfrich.arkanoid.menus;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import me.zifvfrich.arkanoid.Arkanoid;

import java.util.Objects;

public abstract class AbstractMenu {
    protected Arkanoid game;
    protected int currentIndex;
    protected Array<Text> elements;
    protected Color currentColor;

    public AbstractMenu(Arkanoid game) {
        this.game = game;
    }
    public void draw(SpriteBatch batch) {
        for (int i = 0; i < elements.size; i++) {
            if (i == currentIndex)
                currentColor = Color.GRAY;
            else
                currentColor = Color.WHITE;
            elements.get(i).draw(batch, currentColor);
        }
    }
    public abstract void update();
    protected class Text {
        String text;
        BitmapFont font;
        float x, y;
        public Screen screen;
        public Integer value;
        private final Color defualtColor = Color.WHITE;
        public Text(String text, BitmapFont font, float x, float y) {
            this.text = text;
            this.font = font;
            this.x = x;
            this.y = y;
        }
        public Text(String text, BitmapFont font, float x, float y, Screen screen) {
            this(text, font, x, y);
            this.screen = screen;
        }
        public Text(String text, BitmapFont font, float x, float y, int value) {
            this(text, font, x, y);
            this.value = value;
        }
        public void draw(SpriteBatch batch, Color color) {
            font.setColor(color);
            font.draw(batch, text + Objects.toString(value, ""), x, y);
            font.setColor(defualtColor);
        }
    }
}
