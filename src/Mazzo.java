import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Mazzo {

    private final MyArrayList<Carta> mazzo = new MyArrayList<Carta>();
    private JLabel carta;
    private JPanel panel;
    private int indice = 1; // indice carte da pescare
    private ArrayList<JButton> backs = new ArrayList<JButton>(); // carte avversario
    private String briscola;
    private CerchioLabel carteRimanenti;
    private Animation animation = new Animation();

    public Mazzo(JPanel panel, String cartaType, CerchioLabel carteRimanenti) {
        this.panel = panel;
        this.carteRimanenti = carteRimanenti;
        addCarte(cartaType);
        mescola();
        briscola(panel, cartaType);
        System.out.println(mazzo);
    }

    private void addCarte(String str) {

        if (str.equals("Piacentine")) {
            // spade
            mazzo.add(new Carta("Spade", "Asso", 11, new ImageIcon("res/Cards/31.png")));
            mazzo.add(new Carta("Spade", "2", 0, new ImageIcon("res/Cards/32.png")));
            mazzo.add(new Carta("Spade", "3", 10, new ImageIcon("res/Cards/33.png")));
            mazzo.add(new Carta("Spade", "4", 0, new ImageIcon("res/Cards/34.png")));
            mazzo.add(new Carta("Spade", "5", 0, new ImageIcon("res/Cards/35.png")));
            mazzo.add(new Carta("Spade", "6", 0, new ImageIcon("res/Cards/36.png")));
            mazzo.add(new Carta("Spade", "7", 0, new ImageIcon("res/Cards/37.png")));
            mazzo.add(new Carta("Spade", "Fante", 2, new ImageIcon("res/Cards/38.png")));
            mazzo.add(new Carta("Spade", "Cavallo", 3, new ImageIcon("res/Cards/39.png")));
            mazzo.add(new Carta("Spade", "Re", 4, new ImageIcon("res/Cards/40.png")));
            // coppe
            mazzo.add(new Carta("Coppe", "Asso", 11, new ImageIcon("res/Cards/21.png")));
            mazzo.add(new Carta("Coppe", "2", 0, new ImageIcon("res/Cards/22.png")));
            mazzo.add(new Carta("Coppe", "3", 10, new ImageIcon("res/Cards/23.png")));
            mazzo.add(new Carta("Coppe", "4", 0, new ImageIcon("res/Cards/24.png")));
            mazzo.add(new Carta("Coppe", "5", 0, new ImageIcon("res/Cards/25.png")));
            mazzo.add(new Carta("Coppe", "6", 0, new ImageIcon("res/Cards/26.png")));
            mazzo.add(new Carta("Coppe", "7", 0, new ImageIcon("res/Cards/27.png")));
            mazzo.add(new Carta("Coppe", "Fante", 2, new ImageIcon("res/Cards/28.png")));
            mazzo.add(new Carta("Coppe", "Cavallo", 3, new ImageIcon("res/Cards/29.png")));
            mazzo.add(new Carta("Coppe", "Re", 4, new ImageIcon("res/Cards/30.png")));
            // denara
            mazzo.add(new Carta("Denara", "Asso", 11, new ImageIcon("res/Cards/11.png")));
            mazzo.add(new Carta("Denara", "2", 0, new ImageIcon("res/Cards/12.png")));
            mazzo.add(new Carta("Denara", "3", 10, new ImageIcon("res/Cards/13.png")));
            mazzo.add(new Carta("Denara", "4", 0, new ImageIcon("res/Cards/14.png")));
            mazzo.add(new Carta("Denara", "5", 0, new ImageIcon("res/Cards/15.png")));
            mazzo.add(new Carta("Denara", "6", 0, new ImageIcon("res/Cards/16.png")));
            mazzo.add(new Carta("Denara", "7", 0, new ImageIcon("res/Cards/17.png")));
            mazzo.add(new Carta("Denara", "Fante", 2, new ImageIcon("res/Cards/18.png")));
            mazzo.add(new Carta("Denara", "Cavallo", 3, new ImageIcon("res/Cards/19.png")));
            mazzo.add(new Carta("Denara", "Re", 4, new ImageIcon("res/Cards/20.png")));
            // bastoni
            mazzo.add(new Carta("Bastoni", "Asso", 11, new ImageIcon("res/Cards/1.png")));
            mazzo.add(new Carta("Bastoni", "2", 0, new ImageIcon("res/Cards/2.png")));
            mazzo.add(new Carta("Bastoni", "3", 10, new ImageIcon("res/Cards/3.png")));
            mazzo.add(new Carta("Bastoni", "4", 0, new ImageIcon("res/Cards/4.png")));
            mazzo.add(new Carta("Bastoni", "5", 0, new ImageIcon("res/Cards/5.png")));
            mazzo.add(new Carta("Bastoni", "6", 0, new ImageIcon("res/Cards/6.png")));
            mazzo.add(new Carta("Bastoni", "7", 0, new ImageIcon("res/Cards/7.png")));
            mazzo.add(new Carta("Bastoni", "Fante", 2, new ImageIcon("res/Cards/8.png")));
            mazzo.add(new Carta("Bastoni", "Cavallo", 3, new ImageIcon("res/Cards/9.png")));
            mazzo.add(new Carta("Bastoni", "Re", 4, new ImageIcon("res/Cards/10.png")));
        } else if (str.equals("Napoletane")) {
            // spade
            mazzo.add(new Carta("Spade", "Asso", 11, new ImageIcon("res/Cards/Napoletane/2/00.png")));
            mazzo.add(new Carta("Spade", "2", 0, new ImageIcon("res/Cards/Napoletane/2/10.png")));
            mazzo.add(new Carta("Spade", "3", 10, new ImageIcon("res/Cards/Napoletane/2/20.png")));
            mazzo.add(new Carta("Spade", "4", 0, new ImageIcon("res/Cards/Napoletane/2/30.png")));
            mazzo.add(new Carta("Spade", "5", 0, new ImageIcon("res/Cards/Napoletane/2/40.png")));
            mazzo.add(new Carta("Spade", "6", 0, new ImageIcon("res/Cards/Napoletane/2/50.png")));
            mazzo.add(new Carta("Spade", "7", 0, new ImageIcon("res/Cards/Napoletane/2/60.png")));
            mazzo.add(new Carta("Spade", "Fante", 2, new ImageIcon("res/Cards/Napoletane/2/100.png")));
            mazzo.add(new Carta("Spade", "Cavallo", 3, new ImageIcon("res/Cards/Napoletane/2/110.png")));
            mazzo.add(new Carta("Spade", "Re", 4, new ImageIcon("res/Cards/Napoletane/2/120.png")));
            // coppe
            mazzo.add(new Carta("Coppe", "Asso", 11, new ImageIcon("res/Cards/Napoletane/2/02.png")));
            mazzo.add(new Carta("Coppe", "2", 0, new ImageIcon("res/Cards/Napoletane/2/12.png")));
            mazzo.add(new Carta("Coppe", "3", 10, new ImageIcon("res/Cards/Napoletane/2/22.png")));
            mazzo.add(new Carta("Coppe", "4", 0, new ImageIcon("res/Cards/Napoletane/2/32.png")));
            mazzo.add(new Carta("Coppe", "5", 0, new ImageIcon("res/Cards/Napoletane/2/42.png")));
            mazzo.add(new Carta("Coppe", "6", 0, new ImageIcon("res/Cards/Napoletane/2/52.png")));
            mazzo.add(new Carta("Coppe", "7", 0, new ImageIcon("res/Cards/Napoletane/2/62.png")));
            mazzo.add(new Carta("Coppe", "Fante", 2, new ImageIcon("res/Cards/Napoletane/2/102.png")));
            mazzo.add(new Carta("Coppe", "Cavallo", 3, new ImageIcon("res/Cards/Napoletane/2/112.png")));
            mazzo.add(new Carta("Coppe", "Re", 4, new ImageIcon("res/Cards/Napoletane/2/122.png")));
            // denara
            mazzo.add(new Carta("Denara", "Asso", 11, new ImageIcon("res/Cards/Napoletane/2/01.png")));
            mazzo.add(new Carta("Denara", "2", 0, new ImageIcon("res/Cards/Napoletane/2/11.png")));
            mazzo.add(new Carta("Denara", "3", 10, new ImageIcon("res/Cards/Napoletane/2/21.png")));
            mazzo.add(new Carta("Denara", "4", 0, new ImageIcon("res/Cards/Napoletane/2/31.png")));
            mazzo.add(new Carta("Denara", "5", 0, new ImageIcon("res/Cards/Napoletane/2/41.png")));
            mazzo.add(new Carta("Denara", "6", 0, new ImageIcon("res/Cards/Napoletane/2/51.png")));
            mazzo.add(new Carta("Denara", "7", 0, new ImageIcon("res/Cards/Napoletane/2/61.png")));
            mazzo.add(new Carta("Denara", "Fante", 2, new ImageIcon("res/Cards/Napoletane/2/101.png")));
            mazzo.add(new Carta("Denara", "Cavallo", 3, new ImageIcon("res/Cards/Napoletane/2/111.png")));
            mazzo.add(new Carta("Denara", "Re", 4, new ImageIcon("res/Cards/Napoletane/2/121.png")));
            // bastoni
            mazzo.add(new Carta("Bastoni", "Asso", 11, new ImageIcon("res/Cards/Napoletane/2/03.png")));
            mazzo.add(new Carta("Bastoni", "2", 0, new ImageIcon("res/Cards/Napoletane/2/13.png")));
            mazzo.add(new Carta("Bastoni", "3", 10, new ImageIcon("res/Cards/Napoletane/2/23.png")));
            mazzo.add(new Carta("Bastoni", "4", 0, new ImageIcon("res/Cards/Napoletane/2/33.png")));
            mazzo.add(new Carta("Bastoni", "5", 0, new ImageIcon("res/Cards/Napoletane/2/43.png")));
            mazzo.add(new Carta("Bastoni", "6", 0, new ImageIcon("res/Cards/Napoletane/2/53.png")));
            mazzo.add(new Carta("Bastoni", "7", 0, new ImageIcon("res/Cards/Napoletane/2/63.png")));
            mazzo.add(new Carta("Bastoni", "Fante", 2, new ImageIcon("res/Cards/Napoletane/2/103.png")));
            mazzo.add(new Carta("Bastoni", "Cavallo", 3, new ImageIcon("res/Cards/Napoletane/2/113.png")));
            mazzo.add(new Carta("Bastoni", "Re", 4, new ImageIcon("res/Cards/Napoletane/2/123.png")));
        }

    }

    public void mescola() {
        Collections.shuffle(this.mazzo);
    }

    public Carta briscola(JPanel panel, String cartaType) {
        Collections.swap(mazzo, 0, 39);
        carta = new JLabel(rotateCarta(this.mazzo.get(0), cartaType).getImg());
        carta.setBounds(105, 155, 200, 168);
        panel.add(carta);
        panel.setComponentZOrder(carta, 2);
        this.briscola = this.mazzo.get(0).getSeme();
        return this.mazzo.get(0);
    }

    public Carta rotateCarta(Carta carta, String cartaType) {

        if (cartaType.equals("Piacentine")) {
            // spade

            if (carta.getNome().equals("Asso") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/31.png"));
            } else if (carta.getNome().equals("2") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/32.png"));
            } else if (carta.getNome().equals("3") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/33.png"));
            } else if (carta.getNome().equals("4") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/34.png"));
            } else if (carta.getNome().equals("5") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/35.png"));
            } else if (carta.getNome().equals("6") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/36.png"));
            } else if (carta.getNome().equals("7") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/37.png"));
            } else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/38.png"));
            } else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/39.png"));
            } else if (carta.getNome().equals("Re") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/40.png"));
            }

            // coppe

            else if (carta.getNome().equals("Asso") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/21.png"));
            } else if (carta.getNome().equals("2") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/22.png"));
            } else if (carta.getNome().equals("3") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/23.png"));
            } else if (carta.getNome().equals("4") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/24.png"));
            } else if (carta.getNome().equals("5") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/25.png"));
            } else if (carta.getNome().equals("6") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/26.png"));
            } else if (carta.getNome().equals("7") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/27.png"));
            } else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/28.png"));
            } else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/29.png"));
            } else if (carta.getNome().equals("Re") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/30.png"));
            }

            // denara

            else if (carta.getNome().equals("Asso") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/11.png"));
            } else if (carta.getNome().equals("2") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/12.png"));
            } else if (carta.getNome().equals("3") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/13.png"));
            } else if (carta.getNome().equals("4") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/14.png"));
            } else if (carta.getNome().equals("5") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/15.png"));
            } else if (carta.getNome().equals("6") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/16.png"));
            } else if (carta.getNome().equals("7") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/17.png"));
            } else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/18.png"));
            } else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/19.png"));
            } else if (carta.getNome().equals("Re") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/20.png"));
            }

            // bastoni

            else if (carta.getNome().equals("Asso") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/1.png"));
            } else if (carta.getNome().equals("2") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/2.png"));
            } else if (carta.getNome().equals("3") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/3.png"));
            } else if (carta.getNome().equals("4") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/4.png"));
            } else if (carta.getNome().equals("5") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/5.png"));
            } else if (carta.getNome().equals("6") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/6.png"));
            } else if (carta.getNome().equals("7") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/7.png"));
            } else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/8.png"));
            } else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/9.png"));
            } else if (carta.getNome().equals("Re") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Rotate/10.png"));
            }
        } else if (cartaType.equals("Napoletane")) {
            // spade

            if (carta.getNome().equals("Asso") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/00.png"));
            } else if (carta.getNome().equals("2") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/10.png"));
            } else if (carta.getNome().equals("3") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/20.png"));
            } else if (carta.getNome().equals("4") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/30.png"));
            } else if (carta.getNome().equals("5") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/40.png"));
            } else if (carta.getNome().equals("6") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/50.png"));
            } else if (carta.getNome().equals("7") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/60.png"));
            } else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/100.png"));
            } else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/110.png"));
            } else if (carta.getNome().equals("Re") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/120.png"));
            }

            // coppe

            else if (carta.getNome().equals("Asso") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/02.png"));
            } else if (carta.getNome().equals("2") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/12.png"));
            } else if (carta.getNome().equals("3") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/22.png"));
            } else if (carta.getNome().equals("4") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/32.png"));
            } else if (carta.getNome().equals("5") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/42.png"));
            } else if (carta.getNome().equals("6") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/52.png"));
            } else if (carta.getNome().equals("7") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/62.png"));
            } else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/102.png"));
            } else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/112.png"));
            } else if (carta.getNome().equals("Re") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/122.png"));
            }

            // denara

            else if (carta.getNome().equals("Asso") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/01.png"));
            } else if (carta.getNome().equals("2") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/11.png"));
            } else if (carta.getNome().equals("3") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/21.png"));
            } else if (carta.getNome().equals("4") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/31.png"));
            } else if (carta.getNome().equals("5") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/41.png"));
            } else if (carta.getNome().equals("6") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/51.png"));
            } else if (carta.getNome().equals("7") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/61.png"));
            } else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/101.png"));
            } else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/111.png"));
            } else if (carta.getNome().equals("Re") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/121.png"));
            }

            // bastoni

            else if (carta.getNome().equals("Asso") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/03.png"));
            } else if (carta.getNome().equals("2") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/13.png"));
            } else if (carta.getNome().equals("3") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/23.png"));
            } else if (carta.getNome().equals("4") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/33.png"));
            } else if (carta.getNome().equals("5") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/43.png"));
            } else if (carta.getNome().equals("6") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/53.png"));
            } else if (carta.getNome().equals("7") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/63.png"));
            } else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/103.png"));
            } else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/113.png"));
            } else if (carta.getNome().equals("Re") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/rotate/123.png"));
            }
        }

        return carta;
    }

    public void distribuisci(Giocatore g1, Giocatore g2) {

        for (int i = 0; i < 3; i++) {
            g1.getMano().add(this.mazzo.get(this.indice++));
            g2.getMano().add(this.mazzo.get(this.indice++));
        }

        JButton card0 = new JButton(new ImageIcon("res/Cards/back.png"));
        JButton card1 = new JButton(new ImageIcon("res/Cards/back.png"));
        JButton card2 = new JButton(new ImageIcon("res/Cards/back.png"));

        JButton back0 = new JButton(new ImageIcon("res/Cards/back.png"));
        JButton back1 = new JButton(new ImageIcon("res/Cards/back.png"));
        JButton back2 = new JButton(new ImageIcon("res/Cards/back.png"));

        animation.distribuisciAnimation(card0, g1.getMano().get(0).getImg(), 418);
        animation.distribuisciAnimation(card1, g1.getMano().get(1).getImg(), 548);
        animation.distribuisciAnimation(card2, g1.getMano().get(2).getImg(), 678);

        animation.distribuisciAnimationBack(back0, 418);
        animation.distribuisciAnimationBack(back1, 548);
        animation.distribuisciAnimationBack(back2, 678);

        setUpButton(card0);
        setUpButton(card1);
        setUpButton(card2);

        setUpButton(back0);
        setUpButton(back1);
        setUpButton(back2);

        backs.add(back0);
        backs.add(back1);
        backs.add(back2);

        card0.addActionListener(e -> {
            g1.lancia(card0, g1, g1.getMano().get(0).getCarta());
            int r = selectCard();
            g2.lancia(backs.get(r), g2, g2.getMano().get(r).getCarta());
            System.out.println(briscola);
            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if (g1.getMano().get(0).getCarta().comparaCarte(g1.getMano().get(0).getCarta(),
                            g2.getMano().get(r).getCarta(), briscola)) {


                        animation.presaAnimation(card0, backs.get(r), new ImageIcon("res/Cards/Rotate/back.png"), panel);
                        pescata(card0, g1, r, g2, 0);
                        g1.getMano().remove(0);
                        g2.getMano().remove(r);


                    } else {

                        animation.presaAnimationBack(card0, backs.get(r), new ImageIcon("res/Cards/Rotate/back.png"), panel);

                        pescataBack(card0, g1, r, g2, 0);

                        g1.getMano().remove(0);
                        g2.getMano().remove(r);


                    }
                }
            });

            timer.setRepeats(false);
            timer.start();

        });

        card1.addActionListener(e -> {

            g1.lancia(card1, g1, g1.getMano().get(1).getCarta());
            int r = selectCard();
            g2.lancia(backs.get(r), g2, g2.getMano().get(r).getCarta());
            Timer timer = new Timer(500, e12 -> {
                if (g1.getMano().get(1).getCarta().comparaCarte(g1.getMano().get(1).getCarta(),
                        g2.getMano().get(r).getCarta(), briscola)) {

                    animation.presaAnimation(card1, backs.get(r), new ImageIcon("res/Cards/Rotate/back.png"), panel);

                    pescata(card1, g1, r, g2, 1);

                    g1.getMano().remove(1);
                    g2.getMano().remove(r);

                } else {
                    animation.presaAnimationBack(card1, backs.get(r), new ImageIcon("res/Cards/Rotate/back.png"), panel);

                    pescataBack(card1, g1, r, g2, 1);

                    g1.getMano().remove(1);
                    g2.getMano().remove(r);

                }
            });
            timer.setRepeats(false);
            timer.start();
        });

        card2.addActionListener(e -> {

            g1.lancia(card2, g1, g1.getMano().get(2).getCarta());
            int r = selectCard();
            g2.lancia(backs.get(r), g2, g2.getMano().get(r).getCarta());
            Timer timer = new Timer(500, e13 -> {
                if (g1.getMano().get(2).getCarta().comparaCarte(g1.getMano().get(2).getCarta(),
                        g2.getMano().get(r).getCarta(), briscola)) {

                    animation.presaAnimation(card2, backs.get(r), new ImageIcon("res/Cards/Rotate/back.png"), panel);

                    pescata(card2, g1, r, g2, 2);

                    g1.getMano().remove(2);
                    g2.getMano().remove(r);

                } else {
                    animation.presaAnimationBack(card2, backs.get(r), new ImageIcon("res/Cards/Rotate/back.png"), panel);

                    pescataBack(card2, g1, r, g2, 0);

                    g1.getMano().remove(2);
                    g2.getMano().remove(r);

                }
            });
            timer.setRepeats(false);
            timer.start();

        });

        /*
         * for (int i = 0; i < 3; i++) {
         * g1.getMano().add(this.mazzo.get(this.indice++));
         * g2.getMano().add(this.mazzo.get(this.indice++)); JButton button = new
         * JButton(g1.getMano().get(i).getImg()); JButton button2 = new JButton(new
         * ImageIcon("res/Cards/back.png")); button.setBounds(x, y, 89, 168);
         * button.setBorderPainted(false); button.setContentAreaFilled(false);
         * button.setFocusPainted(false); button.addActionListener(new ActionListener()
         * {
         *
         * @Override public void actionPerformed(ActionEvent e) {
         *
         * g1.lancia(button, g1); g2.lancia(button2, g2); }
         *
         * }); x += 130; button2.setBorderPainted(false);
         * button2.setContentAreaFilled(false); button2.setFocusPainted(false);
         * button2.setBounds(x2, y2, 89, 168); x2 += 130; panel.add(button);
         * panel.add(button2); panel.setComponentZOrder(button, 0);
         * panel.setComponentZOrder(button2, 0); }
         */
    }

    private void pescata(JButton card, Giocatore g1, int r, Giocatore g2, int n) {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controllo(card, n, g1);
                controllo2(r, g2);
            }
        });
        timer.setRepeats(false);
        timer.start();

    }

    private void pescataBack(JButton card, Giocatore g1, int r, Giocatore g2, int n) {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controllo2(r, g2);
                controllo(card, n, g1);
            }
        });


    }

    private void controllo(JButton card, int n, Giocatore g1){
        if (n == 0) {
            animation.pescataAnimation(card, distribuisci(g1), 418);
        } else if (n == 1) {
            animation.pescataAnimation(card, distribuisci(g1), 548);
        } else if (n == 2) {
            animation.pescataAnimation(card, distribuisci(g1), 678);
        }
    }

    private void controllo2(int r, Giocatore g2) {
        if (r == 0) {
            animation.pescataAnimationBack(backs.get(r), distribuisci(g2), 418);
        } else if (r == 1) {
            animation.pescataAnimationBack(backs.get(r), distribuisci(g2), 548);
        } else if (r == 2) {
            animation.pescataAnimationBack(backs.get(r), distribuisci(g2), 678);
        }
    }

    public Carta distribuisci(Giocatore g) {
        g.getMano().add(this.mazzo.get(this.indice++));
        carteRimanenti.setNumero(40 - (indice - 1));
        return g.getMano().get(2);
    }

    private void setUpButton(JButton button) {
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        panel.add(button);
        panel.setComponentZOrder(button, 0);
    }

    private int selectCard() {
        return new Random().nextInt(3);
    }



    public int getIndice() {
        return indice;
    }

}
