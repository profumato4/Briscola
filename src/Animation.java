import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Animation {

    private Timer timerDistribuisci;
    private Timer timerDistribuisciBack;
    private Timer timerPresa;
    private Timer timerPresaBack;
    private Timer timerPescata;
    private Timer timerPescataBack;
    private JLabel label = new JLabel(new ImageIcon("res/Cards/Rotate/back.png"));
    private JLabel label2 = new JLabel(new ImageIcon("res/Cards/Rotate/back.png"));

    public Animation(){
        label.setBounds(950, 430, 168, 89);
        label2.setBounds(950, 215, 168, 89);
    }

    public void distribuisciAnimation(JButton card, ImageIcon img, int x1) {
        timerDistribuisci = new Timer(5, new ActionListener() {
            private int y = 90;
            private int x = 158;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (x == x1 && y == 600) {
                    card.setIcon(img);
                    ((Timer) e.getSource()).stop();
                }


                if (y < 600) {
                    y = Math.min(y + 20, 600);
                    card.setBounds(x, y, 89, 168);
                    card.repaint();
                    if (card.getLocation().x < x1) {
                        x = Math.min(x + 20, x1);
                        card.setBounds(x, y, 89, 168);
                        card.repaint();
                    }
                }

            }
        });

        timerDistribuisci.start();

    }

    public void distribuisciAnimationBack(JButton card, int x1) {
        timerDistribuisciBack = new Timer(5, new ActionListener() {
            private int y = 90;
            private int x = 158;

            @Override
            public void actionPerformed(ActionEvent e) {


                if (card.getLocation().x < x1) {
                    x = Math.min(x + 20, x1);
                    card.setBounds(x, y, 89, 168);
                    card.repaint();
                }

                if (y > 0) {
                    y = Math.min(y - 20, 0);
                    card.setBounds(x, y, 89, 168);
                    card.repaint();
                }

                if (y == 0 && x == x1) {
                    ((Timer) e.getSource()).stop();
                }

            }
        });

        timerDistribuisciBack.start();

    }

    public void presaAnimationBack(JButton card, JButton card2, ImageIcon img, JPanel panel) {


        timerPresaBack = new Timer(10, new ActionListener() {
            private int y1 = card.getLocation().y;
            private int x1 = card.getLocation().x;
            private int y2 = card2.getLocation().y;
            private int x2 = card2.getLocation().x;
            private int i = 0;
            private int j = 0;
            private int k = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (x1 == 950 && y1 == 215) {
                    if (i == 0) {
                        i = 1;
                        card.setBounds(x2, y2, 168, 89);
                        card.setIcon(img);
                        card.repaint();
                    }

                    if (k == 0) {
                        k = 1;
                        label2.setBounds(950, 215, 168, 89);
                        panel.add(label2);
                        panel.setComponentZOrder(label2, 1);
                    }

                }

                if (y1 > 215) {
                    y1 = Math.min(y1 - 25, 215);
                    card.setBounds(x1, y1, 89, 168);
                    card.repaint();
                }
                if (x1 < 950) {
                    x1 = Math.min(x1 + 25, 950);
                    card.setBounds(x1, y1, 89, 168);
                    card.repaint();
                }

                if (x2 == 950 && y2 == 215) {
                    if (j == 0) {
                        j = 1;
                        card2.setBounds(x2, y2, 168, 89);
                        card2.setIcon(img);
                        card2.repaint();
                    }

                }
                if (y2 < 215) {
                    y2 = Math.min(y2 + 25, 215);
                    card2.setBounds(x2, y2, 89, 168);
                    card2.repaint();
                }
                if (x2 < 950) {
                    x2 = Math.min(x2 + 25, 950);
                    card2.setBounds(x2, y2, 89, 168);
                    card2.repaint();
                }


                if(x1 == 950 && y1 == 215 && x2 == 950 && y2 == 215 && j == 1 && i == 1){
                    ((Timer) e.getSource()).stop();
                }

            }

        });

        timerPresaBack.start();
    }

    public void presaAnimation(JButton card, JButton card2, ImageIcon img, JPanel panel) {
        timerPresa = new Timer(10, new ActionListener() {
            private int y1 = card.getLocation().y;
            private int x1 = card.getLocation().x;
            private int y2 = card2.getLocation().y;
            private int x2 = card2.getLocation().x;
            private int l = 0;
            private int m = 0;
            private int n = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (x1 == 950 && y1 == 430) {
                    if (l == 0) {
                        l = 1;
                        card.setBounds(x2, y2, 168, 89);
                        card.setIcon(img);
                        card.repaint();
                    }

                    if (n == 0) {
                        n = 1;
                        label.setBounds(950, 430, 168, 89);
                        panel.add(label);
                        panel.setComponentZOrder(label, 1);
                    }

                }

                if (y1 < 430) {
                    y1 = Math.min(y1 + 25, 430);
                    card.setBounds(x1, y1, 89, 168);
                    card.repaint();
                }
                if (x1 < 950) {
                    x1 = Math.min(x1 + 25, 950);
                    card.setBounds(x1, y1, 89, 168);
                    card.repaint();
                }

                if (x2 == 950 && y2 == 430) {
                    if (m == 0) {
                        m = 1;
                        card2.setBounds(x2, y2, 168, 89);
                        card2.setIcon(img);
                        card2.repaint();
                    }

                }
                if (y2 < 430) {
                    y2 = Math.min(y2 + 25, 430);
                    card2.setBounds(x2, y2, 89, 168);
                    card2.repaint();
                }
                if (x2 < 950) {
                    x2 = Math.min(x2 + 25, 950);
                    card2.setBounds(x2, y2, 89, 168);
                    card2.repaint();
                }


                if (x1 == 950 && y1 == 430 && x2 == 950 && y2 == 430 && m == 1 && n == 1){
                    ((Timer) e.getSource()).stop();
                }

            }
        });

        timerPresa.start();
    }

    public void pescataAnimation(JButton card, Carta carta, int x1) {
        timerPescata = new Timer(10, new ActionListener() {
            private int y = 90;
            private int x = 158;

            @Override
            public void actionPerformed(ActionEvent e) {

                if (y == 90 && x == 158) {
                    card.setIcon(new ImageIcon("res/Cards/back.png"));
                    card.setBounds(x, y, 89, 168);
                    card.repaint();
                }

                if (x == x1 && y == 600) {
                    card.setIcon(carta.getImg());
                    ((Timer) e.getSource()).stop();
                }

                if (y < 600) {
                    y = Math.min(y + 25, 600);
                    card.setBounds(x, y, 89, 168);
                    card.repaint();
                }

                if (card.getLocation().x < x1) {
                    x = Math.min(x + 25, x1);
                    card.setBounds(x, y, 89, 168);
                    card.repaint();
                }

            }
        });

        timerPescata.start();
    }

    public void pescataAnimationBack(JButton card, Carta carta, int x1) {
        timerPescataBack = new Timer(10, new ActionListener() {
            private int y = 90;
            private int x = 158;

            @Override
            public void actionPerformed(ActionEvent e) {

                if (y == 90 && x == 158) {
                    card.setIcon(new ImageIcon("res/Cards/back.png"));
                    card.setBounds(x, y, 89, 168);
                    card.repaint();
                }


                if (y > 0) {
                    y = Math.min(y - 25, 0);
                    card.setBounds(x, y, 89, 168);
                    card.repaint();
                }

                if (card.getLocation().x < x1) {
                    x = Math.min(x + 25, x1);
                    card.setBounds(x, y, 89, 168);
                    card.repaint();
                }

                if( y == 0 && x == x1){
                    ((Timer) e.getSource()).stop();
                }

            }
        });

        timerPescataBack.start();
    }

    public JLabel getLabel(){
        return  label;
    }

    public JLabel getLabel2(){
        return label2;
    }

}