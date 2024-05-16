package me.zifvfrich.arkanoid;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;


public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.useVsync(true);
		config.setWindowIcon(Files.FileType.Internal, "icons/icon128.png", "icons/icon64.png", "icons/icon32.png");
		config.setTitle("Zim's Arkanoid");
		config.setResizable(false);
		Arkanoid game = new Arkanoid();
		config.setWindowedMode(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		new Lwjgl3Application(game, config);
	}
}
