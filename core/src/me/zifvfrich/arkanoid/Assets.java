package me.zifvfrich.arkanoid;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable;
import com.badlogic.gdx.utils.Array;

public class Assets {
    private static Texture atlas;
    public static TextureRegion logo;
    public static TiledDrawable background1;
    public static TiledDrawable background2;
    public static TiledDrawable background3;
    public static TiledDrawable background4;
    public static Array<TextureRegion> bricks;
    public static TextureRegion paddle;
    public static TextureRegion ball;
    public static BitmapFont font65;
    public static BitmapFont font80;
    public static Color backgroundColor;
    public static Array<TiledDrawable> backgrounds;
    private static Preferences preferences;
    public static void load(){

        preferences = Gdx.app.getPreferences("me.zifvfrich.arkanoid.settings");
        atlas = new Texture(Gdx.files.internal("atlases/atlas1.png"));

        logo = new TextureRegion(atlas, 0,32, 253,52);

        background1 = new TiledDrawable(new TextureRegion(Assets.atlas, 0, 0, 32, 32));
        background2 = new TiledDrawable(new TextureRegion(Assets.atlas, 32, 0, 32, 32));
        background3 = new TiledDrawable(new TextureRegion(Assets.atlas, 64, 0, 32, 32));
        background4 = new TiledDrawable(new TextureRegion(Assets.atlas, 96, 0, 32, 32));

        backgrounds = new Array<TiledDrawable>(false, 4);
        backgrounds.add(background1, background2, background3, background4);

        bricks = new Array<>(true, 6);
        for (int y = 84; y < 84+32+1; y+=32) {
            for (int x = 0; x < 48*3; x+=48) {
                bricks.add(new TextureRegion(Assets.atlas, x, y, 48, 32));
            }
        }

        backgroundColor = new Color(34/255f, 32/255f, 52/255f, 1);

        ball = new TextureRegion(atlas, 224, 0, 26, 26);
        paddle = new TextureRegion(atlas, 128, 0, 96, 30);

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/pixeboy.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 65;
        font65 = generator.generateFont(parameter);
        parameter.size = 80;
        font80 = generator.generateFont(parameter);
        generator.dispose();
    }
    public static void dispose() {
        atlas.dispose();
        font80.dispose();
        font65.dispose();
    }
}
