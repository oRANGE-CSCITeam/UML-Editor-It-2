import gui.Manager;

public class UMLEditor {

	public static void main(String[] args) {
		// Set the look and feel (for Macs too).
		if (System.getProperty("mrj.version") != null) {
			System.setProperty("apple.laf.useScreenMenuBar", "true");
			System.setProperty(
					"com.apple.mrj.application.apple.menu.about.name",
					"Citrux UML Editor");
		}
		Manager.main(args);
	}
}
