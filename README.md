# JBriscola

[![LICENSE](https://img.shields.io/badge/LICENSE-MIT-blue?style=for-the-badge)](https://github.com/profumato4/Briscola/blob/master/LICENSE.md)
[![Download](https://img.shields.io/github/downloads/profumato4/Briscola/total?style=for-the-badge)](https://github.com/profumato4/Briscola/releases)
[![GitHub Repo stars](https://img.shields.io/github/stars/profumato4/Briscola?style=for-the-badge&logo=github)](https://github.com/profumato4/Briscola)





## Index

1. **[Italiano](#)**
    - **[Perché JBriscola?](#perchè-jbriscola)**
    - **[Cartteristiche Principali](#caratteristiche-principali)**
    - **[Tecnologie Utilizzate](#tecnologie-utilizzate)**
    - **[Configurazione ed Uso](#configurazione-ed-uso)**
    - **[Requisiti di Sistema](#requisiti-di-sistema)**
    - **[Installazione](#installazione)**
    - **[Come Iniziare](#come-iniziare)**
    - **[Video Demo](#video-demo)**
    - **[Licenza](#domande-o-problemi)**
    - **[Domande o Problemi](#domande-o-problemi)**

2. **[English](#-1)**
    - **[Why JBriscola?](#why-jbriscola)**
    - **[Main Features](#main-features)**
    - **[Used Technologies](#used-technologies)**
    - **[Configuration and Use](#configuration-and-use)**
    - **[System requirements](#system-requirements)**
    - **[Installation](#installation)**
    - **[How to get started](#how-to-get-started)**
    - **[DEMO Video](#demo-video)**
    - **[License](#license)**
    - **[Questions or problems?](#questions-or-problems)**
# 🇮🇹 

# Perchè JBriscola?
JBriscola è stato concepito come una soluzione sofisticata per gli amanti dei giochi di carte e degli appassionati di programmazione Java. Il suo nome, "JBriscola", nasce dalla combinazione della lettera "J", che rappresenta il linguaggio di programmazione Java, e il famoso gioco di carte italiano, la "briscola".

Questo progetto è nato con l'obiettivo di offrire un'esperienza di gioco coinvolgente e divertente, mentre allo stesso tempo dimostra le capacità e la versatilità del linguaggio Java nel contesto dei giochi. JBriscola offre una vasta gamma di funzionalità e possibilità di personalizzazione, garantendo ore di divertimento per gli utenti di tutte le età e livelli di esperienza.

Con una solida architettura e un'interfaccia intuitiva, JBriscola si propone di diventare il punto di riferimento per chiunque cerchi un'esperienza di gioco di carte impeccabile su piattaforma Java. Che tu sia un appassionato di programmazione desideroso di esplorare le potenzialità di Java o semplicemente un giocatore alla ricerca di un nuovo passatempo, JBriscola è qui per offrirti un'esperienza indimenticabile.

# Caratteristiche Principali

JBriscola offre una serie di caratteristiche uniche e interessanti che lo distinguono dagli altri giochi di carte Java. Ecco un'anteprima delle sue funzionalità più significative:

- __GUI__: Grazie all'utilizzo del framework Java Swing, JBriscola vanta un'interfaccia grafica utente intuitiva e user-friendly . Il design moderno, fornito dal look and feel FlatLightLaf, permette agli utenti di navigare agevolmente attraverso il gioco, assicurando un'esperienza di gioco fluida e piacevole.

- __Animazioni__: Il software è provvisto di animazioni create tramite l'utilizzo dell'oggetto `Timer` fornito da `javax.swing`. Questo oggetto ci consente di programmare eventi che si verificano a intervalli regolari, il che è essenziale per creare animazioni fluide e controllate. Tutte le animazioni utilizzate in JBriscola sono implementate nella classe `Animation` come metodi. É possibile trovare la classe all'interno all'interno della directory `Main`. All'interno delle classi `CPU` e `Giocatore` è possibile trovare i metodi per l'animazione del lancio della carta strutturato nello modo. La logica dietro queste animazioni è abbastanza semplice ma efficace. Per esempio, nell'animazione di distribuzione di una carta, utilizziamo il Timer per aggiornare continuamente la posizione della carta finché non raggiunge la sua destinazione finale sul tavolo. Ciò viene fatto controllando le coordinate x e y della carta e aggiornandole gradualmente finché non raggiungono le coordinate desiderate. Una volta raggiunto il punto finale, il Timer viene interrotto e l'animazione viene completata. 
```java

public void distribuisciAnimation(JButton card, ImageIcon img, int x1) {
        timerDistribuisci = new Timer(5, new ActionListener() {
            private int y = 90;
            private int x = 158;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (x == x1 && y == 600) {
                    card.setIcon(img);
                    ((Timer) e.getSource()).stop();
                    System.out.println("Timer stoppato");
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

```

- __Login & Register__: JBriscola implementa un robusto sistema di login e registrazione, consentendo agli utenti di creare e gestire i propri account personali. Questo sistema è integrato con un database MySQL online attivo 24 ore su 24, garantendo la sicurezza e l'accessibilità dei dati degli utenti. Il tutto gestitto dalle classi `Login`, `Register`, `Database` che sono accessibili sempre all'interno della directory `Main`.

- __Classifica__: Per gli utenti competitivi, JBriscola offre una  semplice classifica con il nome dei 5 giocatori con più partite vinte, che tiene traccia dei migliori giocatori e delle loro prestazioni nel gioco. Questo aggiunge un elemento di competizione e sfida, incoraggiando gli utenti a migliorare le proprie abilità e scalare le classifiche.

- __Musica__ : Il gioco è dotato di una colonna sonora che può risultare fastidiosa. Tuttavia, tramite un tasto dedicato nel menu principale, è possibile gestire facilmente l'audio durante il gioco.

- __Menu durante la Partita__: Durante una partita, gli utenti possono accedere a un menu, tramite il tasto esc, che consente di riavviare la partita, tornare al menu principale o mettere la partita in pausa. Questo offre un maggiore controllo e flessibilità durante l'esperienza di gioco.

- __Schermata di Caricamento__: Presente una schermata di caricamento animata per preparare il gioco all'avvio.

- __Selezione del Tipo di Carte__: All'interno del menu principale, gli utenti hanno la possibilità di scegliere il tipo di carte da utilizzare durante il gioco. Attualmente, sono disponibili le carte piacentine, napoletane e siciliane, offrendo agli utenti una varietà di opzioni per personalizzare l'esperienza di gioco secondo le proprie preferenze.

- __Tracciamento dei Punti__: Durante la partita, JBriscola tiene traccia dei punti fatti dai giocatori. Questi punti vengono visualizzati in tempo reale all'interno dell'interfaccia grafica utente (GUI) mentre si gioca, consentendo ai giocatori di monitorare i punteggi e determinare il vincitore della partita in base alle regole del gioco.

- __Schermata Finale__: Alla fine di ogni partita, viene mostrata una schermata di vittoria, sconfitta o pareggio in base ai punti totalizzati dai giocatori. Questo permette ai giocatori di visualizzare chiaramente l'esito della partita e di valutare le proprie prestazioni. Inoltre, i risultati vengono inviati al database, registrando la vittoria, la sconfitta o il pareggio.

- __Navigazione Intuitiva__: Semplicemente cliccando sulla schermata finale, i giocatori possono tornare al menu principale del gioco. Questa funzionalità consente agli utenti di prendere decisioni rapide su cosa fare dopo la fine di una partita, se desiderano iniziare una nuova partita, consultare le impostazioni o effettuare altre azioni.

- __Gioca Contro il Computer__: JBriscola offre la possibilità di giocare contro un avversario controllato dal computer. Attualmente, il bot seleziona le carte casualmente durante la partita.


# Tecnologie Utilizzate
JBriscola è costruito utilizzando una varietà di tecnologie moderne per offrire un'esperienza di gioco fluida e coinvolgente. Ecco una panoramica delle principali tecnologie utilizzate:

- __Java SE__: Linguaggio di programmazione principale utilizzato per lo sviluppo del gioco.
- __Java Swing__: Utilizzato per la creazione dell'interfaccia grafica utente (GUI).
- __FlatLaf__: Look and feel moderno per Java Swing che fornisce un design pulito e professionale.
- __MySQL__: Database relazionale utilizzato per gestire i dati degli utenti, come le credenziali di login e le statistiche di gioco.
- __JDBC (Java Database Connectivity)__: Utilizzato per la connessione e l'interazione con il database MySQL.


# Configurazione ed Uso

# Requisiti di Sistema

- __Sistema Operativo__: Windows, macOS, Linux

- __Java__: Versione 8 o successiva

- __Spazio su Disco__: Almeno 400 MB di spazio libero

- __RAM__: Almeno 512 MB di RAM

# Installazione 

Per poter giocare a JBriscola bisogna questi semplici passi: 

- Installare java sul proprio pc in caso non fosse gia installato seguire questo [link](https://www.java.com/it/download/help/windows_manual_download.html)

- Clonare questa repository tramite il seguente comando (per eseguire il comando c'è bisogno di installare [git](https://git-scm.com/downloads) altrimenti usare la procedura standar ovvero cliccare su code e poi download file zip ed estrarre il contenuto): 
```bash
git clone https://github.com/profumato4/Briscola.git
```

- Fare attenzione ad avere la cartella `res` e il file `Briscola.jar` nella stessa cartella 

- Bene adesso è possibile avviare JBriscola avviando il file Briscola.jar facendo doppio click sopra oppure eseguendo il comando sul terminale: 
```bash
java -jar Briscola.jar
```

# Come iniziare

Benvenuto in JBriscola! Per iniziare a giocare, segui questi semplici passaggi:

- __Registrazione__:  Se non hai ancora un account, clicca su "Register" nel menu principale. Inserisci un nome utente e una password desiderati, quindi conferma la password. Una volta completata la registrazione, sarai pronto per effettuare il login.

- __Login__: Se hai già un account, clicca su "Login" nel menu principale. Inserisci il tuo nome utente e la password registrati durante la fase di registrazione.

- __Avvia una Nuova Partita__: Dopo aver effettuato il login, sei pronto per iniziare una nuova partita! Clicca su "Start New Game".

- __Gioca e Divertiti__: Una volta iniziata la partita, goditi l'emozione della Briscola! Utilizza le carte a tua disposizione per battere il tuo avversario.

- __Esplora le Funzionalità__:Non dimenticare di esplorare tutte le funzionalità offerte da JBriscola, come la gestione del punteggio, le opzioni di personalizzazione e altro ancora. Puoi anche dare un'occhiata alla classifica per vedere come ti confronti con altri giocatori. Vedi la sezione [Caratteristiche Principali](#caratteristiche-principali)

# Video DEMO
https://www.youtube.com/watch?v=46mEq1oxnNQ

# Licenza 

Questo software è rilasciato sotto la licenza MIT. Consulta il file [LICENSE](https://github.com/profumato4/Briscola/blob/master/LICENSE.md) per ulteriori informazioni.


# Domande o problemi?

Se hai domande o riscontri problemi, utilizza [issue tracker](https://github.com/profumato4/Briscola/issues) nel repository per segnalarli.

# Buon Divertimento!
Ora che sei pronto, non resta che giocare! Sfida i tuoi amici, migliora le tue abilità, e goditi ogni momento di gioco. Che le carte ti siano sempre favorevoli!


# 🇬🇧

# Why JBriscola?
JBriscola was designed as a sophisticated solution for card game lovers and Java programming enthusiasts. Its name, "JBriscola", comes from the combination of the letter "J", which represents the Java programming language, and the famous Italian card game, "briscola".

This project was born with the aim of offering an engaging and fun gaming experience, while at the same time demonstrating the capabilities and versatility of the Java language in the context of gaming. JBriscola offers a wide range of features and customization possibilities, ensuring hours of fun for users of all ages and experience levels.

With a solid architecture and an intuitive interface, JBriscola aims to become the point of reference for anyone looking for a flawless card gaming experience on the Java platform. Whether you are a programming enthusiast eager to explore the potential of Java or simply a gamer looking for a new pastime, JBriscola is here to offer an unforgettable experience.

# Main Features
JBriscola offers a number of unique and interesting features that set it apart from other Java card games. Here is a preview of its most significant features:

- __GUI__: Thanks to the use of the Java Swing framework, JBriscola boasts an intuitive and user-friendly graphical user interface. The modern design, provided by the FlatLightLaf look and feel, allows users to navigate smoothly through the game, ensuring a smooth and enjoyable gaming experience.

- __Animations__: The software is equipped with animations created using the `Timer` object provided by `javax.swing`. This object allows us to schedule events that occur at regular intervals, which is essential for creating smooth, controlled animations. All animations used in JBriscola are implemented in the `Animation` class as methods. You can find the class inside the `Main` directory. Within the `CPU` and `Giocatore` classes you can find methods for animating structured card throwing in the way. The logic behind these animations is quite simple but effective. For example, in a card dealing animation, we use the Timer to continuously update the position of the card until it reaches its final destination on the table. This is done by checking the x and y coordinates of the chart and gradually updating them until they reach the desired coordinates. Once the end point is reached, the Timer is stopped and the animation is completed.

```java

public void distribuisciAnimation(JButton card, ImageIcon img, int x1) {
        timerDistribuisci = new Timer(5, new ActionListener() {
            private int y = 90;
            private int x = 158;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (x == x1 && y == 600) {
                    card.setIcon(img);
                    ((Timer) e.getSource()).stop();
                    System.out.println("Timer stoppato");
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

```

- __Login & Register__: JBriscola implements a robust login and registration system, allowing users to create and manage their personal accounts. This system is integrated with a 24-hour online MySQL database, ensuring the security and accessibility of user data. All managed by the `Login`, `Register`, `Database` classes which are always accessible within the `Main` directory.

- __Leaderboard__: For competitive users, JBriscola offers a simple leaderboard with the name of the 5 players with the most match wins, which tracks the best players and their performances in the game. This adds an element of competition and challenge, encouraging users to improve their skills and climb the leaderboards.


- __Music__: The game has a soundtrack that can be annoying. However, via a dedicated button in the main menu, you can easily manage the audio during the game.

- __In Game Menus__: During a game, users can access a menu, via the escape key, that allows them to restart the game, return to the main menu, or pause the game. This offers greater control and flexibility during the gaming experience.

- __Loading Screen__: There is an animated loading screen to prepare the game for launch.

- __Card Type Selection__: Within the main menu, users have the option to choose the type of cards to use during the game. Currently, Piacenza, Neapolitan and Sicilian cards are available, offering users a variety of options to customize the gaming experience to their preferences.

- __Point Tracking__: During the game, JBriscola keeps track of the points scored by the players. These points are displayed in real time within the graphical user interface (GUI) as you play, allowing players to monitor scores and determine the winner of the match based on the game's rules.

- __Final Screen__: At the end of each game, a victory, defeat or draw screen is shown based on the points scored by the players. This allows players to clearly view the outcome of the match and evaluate their performance. Furthermore, the results are sent to the database, recording the win, loss or draw.


- __Intuitive Navigation__: By simply clicking on the end screen, players can return to the game's main menu. This feature allows users to make quick decisions about what to do after a game ends, whether they want to start a new game, review settings, or take other actions.

- __Play Against the Computer__: JBriscola offers the possibility of playing against a computer-controlled opponent. Currently, the bot selects cards randomly during the game.

# Used Technologies

JBriscola is built using a variety of modern technologies to deliver a smooth and immersive gaming experience. Here is an overview of the main technologies used:

- __Java SE__: Linguaggio di programmazione principale utilizzato per lo sviluppo del gioco.

- __Java Swing__: Utilizzato per la creazione dell'interfaccia grafica utente (GUI).

- __FlatLaf__: Look and feel moderno per Java Swing che fornisce un design pulito e professionale.

- __MySQL__: Database relazionale utilizzato per gestire i dati degli utenti, come le credenziali di login e le statistiche di gioco.

- __JDBC (Java Database Connectivity)__: Utilizzato per la connessione e l'interazione con il database MySQL.


# Configuration and Use

# System requirements

- __Operating System__: Windows, macOS, Linux

- __Java__: Version 8 or later

- __Disk Space__: At least 400 MB of free space

- __RAM__: At least 512 MB of RAM

# Installation
To be able to play JBriscola you need these simple steps:

- Install java on your PC if it is not already installed follow this [link](https://www.java.com/it/download/help/windows_manual_download.html)

- Clone this repository using the following command (to execute the command you need to install [git](https://git-scm.com/downloads) otherwise use the standard procedure or click on code and then download zip file and extract the contents):
    ```bash
    git clone https://github.com/profumato4/Briscola.git
    ```

- Be careful to have the `res` folder and the `Briscola.jar` file in the same folder

- Well now it is possible to start JBriscola by starting the Briscola.jar file by double clicking on it or by executing the command on the terminal:
    ```bash
    java -jar Briscola.jar
    ```

# How to get started
Welcome to JBriscola! To start playing, follow these simple steps:

- __Registration__: If you don't have an account yet, click "Register" in the main menu. Enter a desired username and password, then confirm the password. Once registration is complete, you will be ready to log in.

- __Login__: If you already have an account, click "Login" in the main menu. Enter your registered username and password during the registration phase.

- __Start a New Game__: After logging in, you are ready to start a new game! Click on "Start New Game".

- __Play and Have Fun__: Once the game has started, enjoy the excitement of Briscola! Use the cards at your disposal to beat your opponent.

- __Explore Features__: Don't forget to explore all the features offered by JBriscola, such as score management, customization options and more. You can also take a look at the leaderboard to see how you compare to other players. See the section [Main Features](#main-features)

# DEMO Video
https://www.youtube.com/watch?v=46mEq1oxnNQ

# License

This software is released under the MIT license. See the file [LICENSE](https://github.com/profumato4/Briscola/blob/master/LICENSE.md) for further information.


# Questions or problems?

If you have questions or encounter issues, please use [issue tracker](https://github.com/profumato4/Briscola/issues) in the repository to report them.

# Good fun!
Now that you're ready, all that's left to do is play! Challenge your friends, improve your skills, and enjoy every moment of gameplay. May the cards always be in your favor!
