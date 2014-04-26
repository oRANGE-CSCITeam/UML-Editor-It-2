import java.awt.Frame;

import javax.swing.JFrame;

import gui.Manager;

public class CitruxUMLEditor {

	public static void main(String[] args) {
		// Set the look and feel (for Macs too).
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		SplashScreen splash = new SplashScreen(2500);
		splash.showSplash();
		Manager.main(args);
	}
}
