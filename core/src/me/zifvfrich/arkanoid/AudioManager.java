package me.zifvfrich.arkanoid;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.Array;

import java.util.Iterator;

public class AudioManager implements Music.OnCompletionListener{
    Array<String> musicPaths;
    Iterator<String> musicPathsIter;
    Music music;
    Array<Sound> hitSounds;
    Sound selectSound;
    public AudioManager() {
        musicPaths = new Array<>(true, 4);
        musicPaths.addAll("music/mattis_bergsmtaren_lever.ogg",
                                "music/necros_point_of_departure.ogg",
                                "music/ogge_kuk.ogg",
                                "music/sanxion_hybrid_song.ogg");
        musicPaths.shuffle();
        musicPathsIter = musicPaths.iterator();
        music = Gdx.audio.newMusic(Gdx.files.internal(musicPathsIter.next()));
        music.setOnCompletionListener(this);
        music.setVolume(Settings.musicVolume);

        hitSounds = new Array<>(true, 3);
        hitSounds.addAll(Gdx.audio.newSound(Gdx.files.internal("sounds/hit1.ogg")),
                Gdx.audio.newSound(Gdx.files.internal("sounds/hit2.ogg")),
                Gdx.audio.newSound(Gdx.files.internal("sounds/hit3.ogg")));

        selectSound = Gdx.audio.newSound(Gdx.files.internal("sounds/menu_select.ogg"));
    }
    @Override
    public void onCompletion(Music music) {
        music.dispose();

        if (!musicPathsIter.hasNext())
            musicPathsIter = musicPaths.iterator();

        this.music = Gdx.audio.newMusic(Gdx.files.internal(musicPathsIter.next()));
        this.music.setOnCompletionListener(this);
        this.music.setVolume(Settings.musicVolume);
        playMusic();
    }
    public void playMusic() {
        music.play();
    }
    public void updateVolume() {
        music.setVolume(Settings.musicVolume);
    }
    public void playSelectSound() {
        selectSound.play(Settings.soundVolume);
    }
    public void playHitSound() {
        hitSounds.random().play(Settings.soundVolume);
    }
}
