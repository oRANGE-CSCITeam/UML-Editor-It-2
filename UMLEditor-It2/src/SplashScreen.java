import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class SplashScreen extends JWindow {
  private int duration;
  public SplashScreen(int d) {
    duration = d;
  }

  public void showSplash() {
    JPanel content = (JPanel)getContentPane();
    //Set center of screen
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (screen.width)/3;
    int y = (screen.height)/3;
    setLocation(x,y);

    // Build the splash screen
    JLabel label = new JLabel(new ImageIcon(getClass().getResource("Splash.png")));
    
    content.add(label);
    pack();
    // Display it
    setVisible(true);

    // Wait a little while, maybe while loading resources
    try { Thread.sleep(duration); } catch (Exception e) {}

    setVisible(false);
  }

  public void showSplashAndExit() {
    showSplash();
    System.exit(0);
  }
}