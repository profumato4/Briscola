import java.util.ArrayList;

public class Giocatore {
	
	private final String nickName;
	private ArrayList<Carta> mano;
	private int punteggio;

	public Giocatore(String nickName) {
		this.nickName = nickName;
		this.mano = new ArrayList<Carta>();
		this.punteggio = 0;
	}

	public ArrayList<Carta> getMano() {
		return mano;
	}

	public String getNickName() {
		return nickName;
	}
	
	
}
