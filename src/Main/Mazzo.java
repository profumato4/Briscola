package Main;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Mazzo {

    private final MyArrayList<Carta> mazzo = new MyArrayList<>();
    private JLabel carta;
    private JPanel panel;
    private int indice = 1; // indice carte da pescare
    private ArrayList<JButton> backs = new ArrayList<>(); // carte avversario
    private String briscola;
    private CerchioLabel carteRimanenti;
    private Animation animation = new Animation();

    private AtomicInteger punteggio = new AtomicInteger(0);
    private AtomicInteger punteggio2 = new AtomicInteger(0);
    private CerchioLabel punti1 = new CerchioLabel();
    private CerchioLabel punti2 = new CerchioLabel();
    private boolean flags[] = new boolean[3];
    private int r;
    private String cartaType;

    public Mazzo(JPanel panel, String cartaType, CerchioLabel carteRimanenti) {
        this.panel = panel;
        this.carteRimanenti = carteRimanenti;
        this.cartaType = cartaType;
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

    private Carta rotateBriscola(Carta carta, String cartaType) {
        if (cartaType.equals("Piacentine")) {
            // spade

            if (carta.getNome().equals("Asso") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/31.png"));
            } else if (carta.getNome().equals("2") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/32.png"));
            } else if (carta.getNome().equals("3") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/33.png"));
            } else if (carta.getNome().equals("4") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/34.png"));
            } else if (carta.getNome().equals("5") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/35.png"));
            } else if (carta.getNome().equals("6") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/36.png"));
            } else if (carta.getNome().equals("7") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/37.png"));
            } else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/38.png"));
            } else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/39.png"));
            } else if (carta.getNome().equals("Re") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/40.png"));
            }

            // coppe

            else if (carta.getNome().equals("Asso") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/21.png"));
            } else if (carta.getNome().equals("2") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/22.png"));
            } else if (carta.getNome().equals("3") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/23.png"));
            } else if (carta.getNome().equals("4") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/24.png"));
            } else if (carta.getNome().equals("5") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/25.png"));
            } else if (carta.getNome().equals("6") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/26.png"));
            } else if (carta.getNome().equals("7") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/27.png"));
            } else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/28.png"));
            } else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/29.png"));
            } else if (carta.getNome().equals("Re") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/30.png"));
            }

            // denara

            else if (carta.getNome().equals("Asso") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/11.png"));
            } else if (carta.getNome().equals("2") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/12.png"));
            } else if (carta.getNome().equals("3") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/13.png"));
            } else if (carta.getNome().equals("4") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/14.png"));
            } else if (carta.getNome().equals("5") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/15.png"));
            } else if (carta.getNome().equals("6") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/16.png"));
            } else if (carta.getNome().equals("7") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/17.png"));
            } else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/18.png"));
            } else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/19.png"));
            } else if (carta.getNome().equals("Re") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/20.png"));
            }

            // bastoni

            else if (carta.getNome().equals("Asso") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/1.png"));
            } else if (carta.getNome().equals("2") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/2.png"));
            } else if (carta.getNome().equals("3") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/3.png"));
            } else if (carta.getNome().equals("4") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/4.png"));
            } else if (carta.getNome().equals("5") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/5.png"));
            } else if (carta.getNome().equals("6") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/6.png"));
            } else if (carta.getNome().equals("7") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/7.png"));
            } else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/8.png"));
            } else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/9.png"));
            } else if (carta.getNome().equals("Re") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/10.png"));
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


        cardActionListner(card0, g1, g2, 0);
        cardActionListner(card1, g1, g2, 1);
        cardActionListner(card2, g1, g2, 2);

    }

    private void pescata(JButton card, Giocatore g1, int r, Giocatore g2, int n) {
        Timer timer = new Timer(1000, actionEvent -> {
            controllo(card, n, g1);
            controllo2(r, g2);
        });
        timer.setRepeats(false);
        timer.start();

    }

    private void pescataBack(JButton card, Giocatore g1, int r, Giocatore g2, int n) {
        Timer timer = new Timer(1000, actionEvent -> {
            controllo2(r, g2);
            controllo(card, n, g1);
        });
        timer.setRepeats(false);
        timer.start();

    }

    private void controllo(JButton card, int n, Giocatore g1) {
        if (n == 0) {
            animation.pescataAnimation(card, distribuisci(g1, n), 418);
        } else if (n == 1) {
            animation.pescataAnimation(card, distribuisci(g1, n), 548);
        } else if (n == 2) {
            animation.pescataAnimation(card, distribuisci(g1, n), 678);
        }
    }

    private void controllo2(int r, Giocatore g2) {
        if (r == 0) {
            animation.pescataAnimationBack(backs.get(r), distribuiscir(g2, r), 418);
        } else if (r == 1) {
            animation.pescataAnimationBack(backs.get(r), distribuiscir(g2, r), 548);
        } else if (r == 2) {
            animation.pescataAnimationBack(backs.get(r), distribuiscir(g2, r), 678);
        }
    }

    public Carta distribuisci(Giocatore g, int n) {

        pescaUltimaCarta(g, n);

        return g.getMano().get(n);
    }

    public Carta distribuiscir(Giocatore g, int r) {
        pescaUltimaCarta(g, r);
        return g.getMano().get(r);
    }

    private void pescaUltimaCarta(Giocatore g, int r) {
        System.out.println(indice);
        if (indice == 40) {
            g.getMano().set(r, rotateBriscola(this.mazzo.get(0), cartaType));
            this.indice++;
            carteRimanenti.setNumero(40 - (indice - 1));
        } else if (indice <= 39) {
            g.getMano().set(r, this.mazzo.get(this.indice++));
            carteRimanenti.setNumero(40 - (indice - 1));
        }
    }

    private void setUpButton(JButton button) {
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        panel.add(button);
        panel.setComponentZOrder(button, 0);
    }

    private int selectCard(Giocatore g2) {
        return new Random().nextInt(g2.getMano().size());
    }


    public int getIndice() {
        return indice;
    }

    private void cardActionListner(JButton card, Giocatore g1, Giocatore g2, int n) {
        card.addActionListener(e -> {
            g1.lancia(card, g1, g1.getMano().get(n).getCarta());

            lancioBack(g2);

            azioniPartita(card, g1, g2, n, r);
        });

    }


    private void azioniPartita(JButton card, Giocatore g1, Giocatore g2, int n, int r) {
        Timer timer = new Timer(1500, actionEvent -> {

            if (!flags[0] && !flags[1] && !flags[2]) {
                if (g1.getMano().get(n).getCarta().comparaCarte(g1.getMano().get(n).getCarta(),
                        g2.getMano().get(r).getCarta(), briscola)) {
                    animation.presaAnimation(card, backs.get(r), new ImageIcon("res/Cards/Rotate/back.png"), panel);
                    calcoloPunteggio(g1, g2, r, n, punteggio2, punteggio, punti1, punti2, true);
                    if(indice <= 40){
                        pescata(card, g1, r, g2, n);
                    }

                } else {
                    azioniBack(card, g1, g2, n, r);
                }

            } else {
                if (g2.getMano().get(r).getCarta().comparaCarte(g2.getMano().get(r).getCarta(),
                        g1.getMano().get(n).getCarta(), briscola)) {
                    azioniBack(card, g1, g2, n, r);
                    flags[0] = false;
                    flags[1] = false;
                    flags[2] = false;
                } else {
                    animation.presaAnimation(card, backs.get(r), new ImageIcon("res/Cards/Rotate/back.png"), panel);
                    calcoloPunteggio(g1, g2, r, n, punteggio2, punteggio, punti1, punti2, true);
                    if(indice <= 40){
                        pescata(card, g1, r, g2, n);
                    }
                    flags[0] = false;
                    flags[1] = false;
                    flags[2] = false;
                }
            }
        });

        timer.setRepeats(false);
        timer.start();

    }

    private void azioniBack(JButton card, Giocatore g1, Giocatore g2, int n, int r) {
        animation.presaAnimationBack(card, backs.get(r), new ImageIcon("res/Cards/Rotate/back.png"), panel);
        calcoloPunteggio(g1, g2, r, n, punteggio2, punteggio, punti1, punti2, false);
        if(indice <= 40){
            pescataBack(card, g1, r, g2, n);
        }
        Timer t = new Timer(1500, actionEvent1 -> g2.lancia(backs.get(r), g2, g2.getMano().get(r).getCarta()));
        t.setRepeats(false);
        t.start();
    }

    private void calcoloPunteggio(Giocatore g1, Giocatore g2, int r, int n, AtomicInteger punteggio2, AtomicInteger punteggio, CerchioLabel punti1, CerchioLabel punti2, boolean b) {
        if (b) {
            punteggio.addAndGet(g1.getMano().get(n).getCarta().getValore());
            punteggio.addAndGet(g2.getMano().get(r).getCarta().getValore());
            g1.setPunteggio(punteggio.get());
            punti1.setSize(60, 60);
            punti1.calcolaCentro(punti1, animation.getLabel());
            punti1.setNumero(g1.getPunteggio());
            panel.add(punti1);
            panel.setComponentZOrder(punti1, 0);
            panel.repaint();
            punti1.repaint();
        } else {
            punteggio2.addAndGet(g2.getMano().get(r).getCarta().getValore());
            punteggio2.addAndGet(g1.getMano().get(n).getCarta().getValore());
            g2.setPunteggio(punteggio2.get());
            punti2.setSize(60, 60);
            punti2.calcolaCentro(punti2, animation.getLabel2());
            punti2.setNumero(g2.getPunteggio());
            panel.add(punti2);
            panel.setComponentZOrder(punti2, 0);
            panel.repaint();
            punti2.repaint();
        }

    }

    private void lancioBack(Giocatore g2) {
        int i = 0;
        int x = 0;
        for (JButton card : backs) {
            if (card.getLocation().x == 598 && card.getLocation().y == 200) {
                flags[i] = true;
                i++;
            }
        }

        for (boolean flag : flags) {
            if (flag) {
                x = 1;
                break;
            }
        }

        if (x == 0) {
            r = selectCard(g2);
            System.out.println(r);
            g2.lancia(backs.get(r), g2, g2.getMano().get(r).getCarta());
        }

    }
}