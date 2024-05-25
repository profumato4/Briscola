package briscola;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * A custom JLabel class representing a circular label with a number inside.
 * This label is designed to display a number inside a circular shape.
 */

public class CerchioLabel extends JLabel {

	private static final long serialVersionUID = 1L;
	private int numero;

    /**
     * Constructs a CerchioLabel object with default values.
     */

    public CerchioLabel() {
        super();
        this.numero = 0;
    }

    /**
     * Sets the number to be displayed inside the circular label.
     *
     * @param numero The number to be displayed
     */

    public void setNumero(int numero) {
        this.numero = numero;
        repaint();  // Repaint the label to update the displayed number
    }

    /**
     * Overrides the paintComponent method to customize the appearance of the circular label.
     *
     * @param g The Graphics object used for painting
     */

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Cast Graphics object to Graphics2D for advanced drawing operations
        Graphics2D g2d = (Graphics2D) g;


        int width = getWidth();
        int height = getHeight();

        // Create a circular shape

        Ellipse2D.Double cerchio = new Ellipse2D.Double(0, 0, width, height);
        g2d.setColor(Color.WHITE); // Set the fill color to white
        g2d.fill(cerchio); // Fill the circular shape with the chosen color

        g2d.setColor(Color.RED);  // Set the font color to red

        // Define font and size

        Font font = new Font("Arial", Font.BOLD, 30);
        g2d.setFont(font);

        // Get font metrics to calculate text position

        FontMetrics fm = g2d.getFontMetrics();
        String testo = Integer.toString(numero); // Convert the number to a string
        int testoWidth = fm.stringWidth(testo);
        int testoHeight = fm.getHeight();

        // Calculate the position to center the text inside the circular label

        int x = (width - testoWidth) / 2;
        int y = (height - testoHeight) / 2 + fm.getAscent();

        // Draw the text inside the circular label

        g2d.drawString(testo, x, y);
    }

    /**
     * Calculates the center position of a child JLabel relative to its parent JLabel.
     *
     * @param figlio The child JLabel to be centered
     * @param padre  The parent JLabel relative to which the child will be centered
     */

    public void calcolaCentro(JLabel figlio, JLabel padre) {
		int xPadre = padre.getX();
        int yPadre = padre.getY();
        int larghezzaPadre = padre.getWidth();
        int altezzaPadre = padre.getHeight();

        int larghezzaFiglio = figlio.getWidth();
        int altezzaFiglio = figlio.getHeight();

        // Calculate the center position of the child relative to its parent

        int xCentro = xPadre + (larghezzaPadre - larghezzaFiglio) / 2;
        int yCentro = yPadre + (altezzaPadre - altezzaFiglio) / 2;

        // Set the location of the child JLabel to its calculated center position

        figlio.setLocation(xCentro, yCentro);
	}
    
}
