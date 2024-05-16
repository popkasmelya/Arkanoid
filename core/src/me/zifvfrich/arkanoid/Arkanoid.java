package me.zifvfrich.arkanoid;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.zifvfrich.arkanoid.screens.*;

public class Arkanoid extends Game {
	public SpriteBatch batch;
	public WelcomeScreen welcomeScreen;
	public Screen mainMenuScreen;
	public Screen settingsScreen;
	public Screen creditsScreen;
	public Screen levelSelectScreen;
	public Screen exitScreen;
	public FPSLogger logger;
	public int backgroundOffset = 0;
	public AudioManager audioManager;

	public void create () {
		Assets.load();
		Settings.load();
		audioManager = new AudioManager();
		batch = new SpriteBatch();
		logger = new FPSLogger();
		welcomeScreen = new WelcomeScreen(this);
		mainMenuScreen = new MainMenuScreen(this);
		settingsScreen = new SettingsScreen(this);
		creditsScreen = new CreditsScreen(this);
		levelSelectScreen = new LevelSelectScreen(this);
		exitScreen = new ExitScreen(this);

		setScreen(welcomeScreen);
	}

	public void dispose () {
		Settings.save();
	}
}
