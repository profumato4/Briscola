package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CerchioLabel extends JLabel {
    private int numero;

    public CerchioLabel() {
        super();
        this.numero = 0;
    }

    public void setNumero(int numero) {
        this.numero = numero;
        repaint(); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        
        Graphics2D g2d = (Graphics2D) g;


        int width = getWidth();
        int height = getHeight();

        Ellipse2D.Double cerchio = new Ellipse2D.Double(0, 0, width, height);
        g2d.setColor(Color.WHITE);
        g2d.fill(cerchio);

        g2d.setColor(Color.RED);

        Font font = new Font("Arial", Font.BOLD, 30);
        g2d.setFont(font);

        FontMetrics fm = g2d.getFontMetrics();
        String testo = Integer.toString(numero);
        int testoWidth = fm.stringWidth(testo);
        int testoHeight = fm.getHeight();

        int x = (width - testoWidth) / 2;
        int y = (height - testoHeight) / 2 + fm.getAscent();

        g2d.drawString(testo, x, y);
    }
    
    public void calcolaCentro(JLabel figlio, JLabel padre) {
		int xPadre = padre.getX();
        int yPadre = padre.getY();
        int larghezzaPadre = padre.getWidth();
        int altezzaPadre = padre.getHeight();

        int larghezzaFiglio = figlio.getWidth();
        int altezzaFiglio = figlio.getHeight();

        int xCentro = xPadre + (larghezzaPadre - larghezzaFiglio) / 2;
        int yCentro = yPadre + (altezzaPadre - altezzaFiglio) / 2;
        System.out.println(xCentro + " x" + yCentro);

        figlio.setLocation(xCentro, yCentro);
	}
    
}
