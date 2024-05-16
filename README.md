# JBriscola

## Index

1. **[Italiano](#🇮🇹)**
    1. **[Perché JBriscola?](#perchè-jbriscola)**
2. **[English](#🇬🇧)**

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


# Configurazione ed Uso
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
Ora che conosci i passaggi per iniziare, preparati a immergerti nell'emozionante mondo di JBriscola. Che la fortuna sia sempre dalla tua parte!


# 🇬🇧