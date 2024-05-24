package splashScreen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicProgressBarUI;

/**
 * A custom progress bar with the ability to set a custom color for the progress string.
 */

public class ProgressBarCustom extends JProgressBar {
    
    private static final long serialVersionUID = 1L;

    /**
     * Get the color of the progress string.
     * @return The color of the progress string.
     */

	public Color getColorString() {
        return colorString;
    }

    /**
     * Set the color of the progress string.
     * @param colorString The color to set for the progress string.
     */

    private Color colorString = new Color(0, 0, 0);

    /**
     * Constructs a new ProgressBarCustom with default settings.
     *
     * The default size is set to 100x5 pixels, and the background color is set to dark gray.
     *
     */

    public ProgressBarCustom() {
        setPreferredSize(new Dimension(100, 5));
        setBackground(new Color(77, 77, 77));
        setForeground(new Color(190, 190, 190));
        setUI(new BasicProgressBarUI() {
            
            @Override
            protected void paintString(Graphics grphcs, int i, int i1, int i2, int i3, int i4, Insets insets) {
                grphcs.setColor(getColorString());
                super.paintString(grphcs, i, i1, i2, i3, i4, insets);
            }
        });
    }
}
