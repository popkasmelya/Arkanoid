package me.zifvfrich.arkanoid;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
public class Settings {
    public static float soundVolume = 1f;
    public static float musicVolume = 1f;
    public static int[] highscores = new int[] {0, 0, 0, 0, 0};
    private final static String file = "me.zifvfrich.arkanoid.settings";
    public static void load () {
        try {
            FileHandle filehandle = Gdx.files.external(file);

            String[] strings = filehandle.readString().split("\n");

            soundVolume = Float.parseFloat(strings[0]);
            musicVolume = Float.parseFloat(strings[1]);
            for (int i = 0; i < 5; i++) {
                highscores[i] = Integer.parseInt(strings[i+2]);
            }
        } catch (Throwable e) {
        }
    }
    public static void save () {
        try {
            FileHandle filehandle = Gdx.files.external(file);

            filehandle.writeString(Float.toString(soundVolume)+"\n", false);
            filehandle.writeString(Float.toString(musicVolume)+"\n", true);
            for (int i = 0; i < 5; i++) {
                filehandle.writeString(Integer.toString(highscores[i])+"\n", true);
            }
        } catch (Throwable e) {
        }
    }
    public static void addScore (int score) {
        for (int i = 0; i < 5; i++) {
            if (highscores[i] < score) {
                for (int j = 4; j > i; j--)
                    highscores[j] = highscores[j - 1];
                highscores[i] = score;
                break;
            }
        }
    }
    public static void setMusicVolume(int v) {
        musicVolume = v / 100f;
    }
    public static int getMusicVolume() {
        return (int) (musicVolume*100);
    }
    public static void setSoundVolume(int v) {
        soundVolume = v / 100f;
    }
    public static int getSoundVolume() {
        return (int) (soundVolume*100);
    }
}