package splashScreen;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.JPanel;

/**
 * A JPanel with a gradient background.
 *
 * This panel provides a background with a gradient that transitions from one color to ano  ther.
 *
 */

public class GradientPanel extends JPanel {

    private static final long serialVersionUID = 1L;
	private final Color gradientStart;
    private final Color gradientEnd;

    /**
     * Constructs a GradientPanel with the specified gradient colors.
     * @param gradientStart The starting color of the gradient.
     * @param gradientEnd The ending color of the gradient.
     */

    public GradientPanel(Color gradientStart, Color gradientEnd) {
        this.gradientStart = gradientStart;
        this.gradientEnd = gradientEnd;
    }

    /**
     * Paints the component.
     *
     * This method paints the gradient background of the panel.
     *
     * @param g The Graphics object used for painting.
     */

    @Override
    public void paintComponent(Graphics g) {
        int height = getHeight();
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint painter = new GradientPaint(0, 0, gradientStart,
                0, height, gradientEnd);
        Paint oldPainter = g2.getPaint();
        g2.setPaint(painter);
        g2.fill(g2.getClip());
        painter = new GradientPaint(0, 0, gradientEnd,
                0, (float) height / 2, gradientStart);
        g2.setPaint(painter);
        g2.fill(g2.getClip());

        painter = new GradientPaint(0, (float) height / 2, gradientStart,
                0, height, gradientEnd);
        g2.setPaint(painter);
        g2.fill(g2.getClip());

        g2.setPaint(oldPainter);
    }
}
