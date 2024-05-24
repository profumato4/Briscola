package briscola;

import javax.swing.*;

public class Setup {

    public void setup(String str, MyArrayList<Carta> mazzo){
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
        } else if (str.equals("Siciliane")) {
            // spade
            mazzo.add(new Carta("Spade", "Asso", 11, new ImageIcon("res/Cards/Siciliane/carta_31.png")));
            mazzo.add(new Carta("Spade", "2", 0, new ImageIcon("res/Cards/Siciliane/carta_32.png")));
            mazzo.add(new Carta("Spade", "3", 10, new ImageIcon("res/Cards/Siciliane/carta_33.png")));
            mazzo.add(new Carta("Spade", "4", 0, new ImageIcon("res/Cards/Siciliane/carta_34.png")));
            mazzo.add(new Carta("Spade", "5", 0, new ImageIcon("res/Cards/Siciliane/carta_35.png")));
            mazzo.add(new Carta("Spade", "6", 0, new ImageIcon("res/Cards/Siciliane/carta_36.png")));
            mazzo.add(new Carta("Spade", "7", 0, new ImageIcon("res/Cards/Siciliane/carta_37.png")));
            mazzo.add(new Carta("Spade", "Fante", 2, new ImageIcon("res/Cards/Siciliane/carta_38.png")));
            mazzo.add(new Carta("Spade", "Cavallo", 3, new ImageIcon("res/Cards/Siciliane/carta_39.png")));
            mazzo.add(new Carta("Spade", "Re", 4, new ImageIcon("res/Cards/Siciliane/carta_40.png")));
            // coppe
            mazzo.add(new Carta("Coppe", "Asso", 11, new ImageIcon("res/Cards/Siciliane/carta_1.png")));
            mazzo.add(new Carta("Coppe", "2", 0, new ImageIcon("res/Cards/Siciliane/carta_2.png")));
            mazzo.add(new Carta("Coppe", "3", 10, new ImageIcon("res/Cards/Siciliane/carta_3.png")));
            mazzo.add(new Carta("Coppe", "4", 0, new ImageIcon("res/Cards/Siciliane/carta_4.png")));
            mazzo.add(new Carta("Coppe", "5", 0, new ImageIcon("res/Cards/Siciliane/carta_5.png")));
            mazzo.add(new Carta("Coppe", "6", 0, new ImageIcon("res/Cards/Siciliane/carta_6.png")));
            mazzo.add(new Carta("Coppe", "7", 0, new ImageIcon("res/Cards/Siciliane/carta_7.png")));
            mazzo.add(new Carta("Coppe", "Fante", 2, new ImageIcon("res/Cards/Siciliane/carta_8.png")));
            mazzo.add(new Carta("Coppe", "Cavallo", 3, new ImageIcon("res/Cards/Siciliane/carta_9.png")));
            mazzo.add(new Carta("Coppe", "Re", 4, new ImageIcon("res/Cards/Siciliane/carta_10.png")));
            // denara
            mazzo.add(new Carta("Denara", "Asso", 11, new ImageIcon("res/Cards/Siciliane/11.png")));
            mazzo.add(new Carta("Denara", "2", 0, new ImageIcon("res/Cards/Siciliane/carta_12.png")));
            mazzo.add(new Carta("Denara", "3", 10, new ImageIcon("res/Cards/Siciliane/carta_13.png")));
            mazzo.add(new Carta("Denara", "4", 0, new ImageIcon("res/Cards/Siciliane/carta_14.png")));
            mazzo.add(new Carta("Denara", "5", 0, new ImageIcon("res/Cards/Siciliane/carta_15.png")));
            mazzo.add(new Carta("Denara", "6", 0, new ImageIcon("res/Cards/Siciliane/carta_16.png")));
            mazzo.add(new Carta("Denara", "7", 0, new ImageIcon("res/Cards/Siciliane/carta_17.png")));
            mazzo.add(new Carta("Denara", "Fante", 2, new ImageIcon("res/Cards/Siciliane/carta_18.png")));
            mazzo.add(new Carta("Denara", "Cavallo", 3, new ImageIcon("res/Cards/Siciliane/carta_19.png")));
            mazzo.add(new Carta("Denara", "Re", 4, new ImageIcon("res/Cards/Siciliane/carta_20.png")));
            // bastoni
            mazzo.add(new Carta("Bastoni", "Asso", 11, new ImageIcon("res/Cards/Siciliane/carta_21.png")));
            mazzo.add(new Carta("Bastoni", "2", 0, new ImageIcon("res/Cards/Siciliane/carta_22.png")));
            mazzo.add(new Carta("Bastoni", "3", 10, new ImageIcon("res/Cards/Siciliane/carta_23.png")));
            mazzo.add(new Carta("Bastoni", "4", 0, new ImageIcon("res/Cards/Siciliane/carta_24.png")));
            mazzo.add(new Carta("Bastoni", "5", 0, new ImageIcon("res/Cards/Siciliane/carta_25.png")));
            mazzo.add(new Carta("Bastoni", "6", 0, new ImageIcon("res/Cards/Siciliane/carta_26.png")));
            mazzo.add(new Carta("Bastoni", "7", 0, new ImageIcon("res/Cards/Siciliane/carta_27.png")));
            mazzo.add(new Carta("Bastoni", "Fante", 2, new ImageIcon("res/Cards/Siciliane/carta_28.png")));
            mazzo.add(new Carta("Bastoni", "Cavallo", 3, new ImageIcon("res/Cards/Siciliane/carta_29.png")));
            mazzo.add(new Carta("Bastoni", "Re", 4, new ImageIcon("res/Cards/Siciliane/carta_30.png")));
        }else if (str.equals("Napoletane")) {
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
        } else if (cartaType.equals("Siciliane")) {
            // spade

            if (carta.getNome().equals("Asso") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_31.png"));
            } else if (carta.getNome().equals("2") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_32.png"));
            } else if (carta.getNome().equals("3") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_33.png"));
            } else if (carta.getNome().equals("4") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_34.png"));
            } else if (carta.getNome().equals("5") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_35.png"));
            } else if (carta.getNome().equals("6") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_36.png"));
            } else if (carta.getNome().equals("7") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_37.png"));
            } else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_38.png"));
            } else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_39.png"));
            } else if (carta.getNome().equals("Re") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_40.png"));
            }

            // coppe

            else if (carta.getNome().equals("Asso") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_1.png"));
            } else if (carta.getNome().equals("2") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_2.png"));
            } else if (carta.getNome().equals("3") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_3.png"));
            } else if (carta.getNome().equals("4") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_4.png"));
            } else if (carta.getNome().equals("5") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_5.png"));
            } else if (carta.getNome().equals("6") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_6.png"));
            } else if (carta.getNome().equals("7") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_7.png"));
            } else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_8.png"));
            } else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_9.png"));
            } else if (carta.getNome().equals("Re") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_10.png"));
            }

            // denara

            else if (carta.getNome().equals("Asso") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_11.png"));
            } else if (carta.getNome().equals("2") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_12.png"));
            } else if (carta.getNome().equals("3") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_13.png"));
            } else if (carta.getNome().equals("4") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_14.png"));
            } else if (carta.getNome().equals("5") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_15.png"));
            } else if (carta.getNome().equals("6") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_16.png"));
            } else if (carta.getNome().equals("7") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_17.png"));
            } else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_18.png"));
            } else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_19.png"));
            } else if (carta.getNome().equals("Re") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_20.png"));
            }

            // bastoni

            else if (carta.getNome().equals("Asso") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_21.png"));
            } else if (carta.getNome().equals("2") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_22.png"));
            } else if (carta.getNome().equals("3") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_23.png"));
            } else if (carta.getNome().equals("4") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_24.png"));
            } else if (carta.getNome().equals("5") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_25.png"));
            } else if (carta.getNome().equals("6") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_26.png"));
            } else if (carta.getNome().equals("7") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_27.png"));
            } else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_28.png"));
            } else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_29.png"));
            } else if (carta.getNome().equals("Re") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/rotate/carta_30.png"));
            }
        }

        return carta;
    }

    public Carta rotateBriscola(Carta carta, String cartaType) {
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
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/00.png"));
            } else if (carta.getNome().equals("2") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/10.png"));
            } else if (carta.getNome().equals("3") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/20.png"));
            } else if (carta.getNome().equals("4") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/30.png"));
            } else if (carta.getNome().equals("5") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/40.png"));
            } else if (carta.getNome().equals("6") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/50.png"));
            } else if (carta.getNome().equals("7") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/60.png"));
            } else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/100.png"));
            } else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/110.png"));
            } else if (carta.getNome().equals("Re") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/120.png"));
            }

            // coppe

            else if (carta.getNome().equals("Asso") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/02.png"));
            } else if (carta.getNome().equals("2") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/12.png"));
            } else if (carta.getNome().equals("3") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/22.png"));
            } else if (carta.getNome().equals("4") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/32.png"));
            } else if (carta.getNome().equals("5") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/42.png"));
            } else if (carta.getNome().equals("6") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/52.png"));
            } else if (carta.getNome().equals("7") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/62.png"));
            } else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/102.png"));
            } else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/112.png"));
            } else if (carta.getNome().equals("Re") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/122.png"));
            }

            // denara

            else if (carta.getNome().equals("Asso") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/01.png"));
            } else if (carta.getNome().equals("2") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/11.png"));
            } else if (carta.getNome().equals("3") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/21.png"));
            } else if (carta.getNome().equals("4") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/31.png"));
            } else if (carta.getNome().equals("5") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/41.png"));
            } else if (carta.getNome().equals("6") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/51.png"));
            } else if (carta.getNome().equals("7") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/61.png"));
            } else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/101.png"));
            } else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/111.png"));
            } else if (carta.getNome().equals("Re") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/121.png"));
            }

            // bastoni

            else if (carta.getNome().equals("Asso") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/03.png"));
            } else if (carta.getNome().equals("2") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/13.png"));
            } else if (carta.getNome().equals("3") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/23.png"));
            } else if (carta.getNome().equals("4") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/33.png"));
            } else if (carta.getNome().equals("5") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/43.png"));
            } else if (carta.getNome().equals("6") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/53.png"));
            } else if (carta.getNome().equals("7") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/63.png"));
            } else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/103.png"));
            } else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/113.png"));
            } else if (carta.getNome().equals("Re") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Napoletane/2/123.png"));
            }
        } else if (cartaType.equals("Siciliane")) {
            // spade

            if (carta.getNome().equals("Asso") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_31.png"));
            } else if (carta.getNome().equals("2") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_32.png"));
            } else if (carta.getNome().equals("3") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_33.png"));
            } else if (carta.getNome().equals("4") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_34.png"));
            } else if (carta.getNome().equals("5") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_35.png"));
            } else if (carta.getNome().equals("6") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_36.png"));
            } else if (carta.getNome().equals("7") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_37.png"));
            } else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_38.png"));
            } else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_39.png"));
            } else if (carta.getNome().equals("Re") && carta.getSeme().equals("Spade")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_40.png"));
            }

            // coppe

            else if (carta.getNome().equals("Asso") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_1.png"));
            } else if (carta.getNome().equals("2") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_2.png"));
            } else if (carta.getNome().equals("3") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_3.png"));
            } else if (carta.getNome().equals("4") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_4.png"));
            } else if (carta.getNome().equals("5") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_5.png"));
            } else if (carta.getNome().equals("6") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_6.png"));
            } else if (carta.getNome().equals("7") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_7.png"));
            } else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_8.png"));
            } else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_9.png"));
            } else if (carta.getNome().equals("Re") && carta.getSeme().equals("Coppe")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_10.png"));
            }

            // denara

            else if (carta.getNome().equals("Asso") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_11.png"));
            } else if (carta.getNome().equals("2") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_12.png"));
            } else if (carta.getNome().equals("3") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_13.png"));
            } else if (carta.getNome().equals("4") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_14.png"));
            } else if (carta.getNome().equals("5") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_15.png"));
            } else if (carta.getNome().equals("6") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_16.png"));
            } else if (carta.getNome().equals("7") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_17.png"));
            } else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_18.png"));
            } else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_19.png"));
            } else if (carta.getNome().equals("Re") && carta.getSeme().equals("Denara")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_20.png"));
            }

            // bastoni

            else if (carta.getNome().equals("Asso") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_21.png"));
            } else if (carta.getNome().equals("2") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_22.png"));
            } else if (carta.getNome().equals("3") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_23.png"));
            } else if (carta.getNome().equals("4") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_24.png"));
            } else if (carta.getNome().equals("5") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_25.png"));
            } else if (carta.getNome().equals("6") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_26.png"));
            } else if (carta.getNome().equals("7") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_27.png"));
            } else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_28.png"));
            } else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_29.png"));
            } else if (carta.getNome().equals("Re") && carta.getSeme().equals("Bastoni")) {
                carta.setImg(new ImageIcon("res/Cards/Siciliane/carta_30.png"));
            }
        }

        return carta;
    }

}
