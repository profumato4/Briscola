package Main;

public class PlayerStats {

	private int gamesWon;
	private int gamesLost;

	PlayerStats(int gamesWon, int gamesLost) {
		this.gamesWon = gamesWon;
		this.gamesLost = gamesLost;
	}

	public int getGamesWon() {
		return gamesWon;
	}

	public int getGamesLost() {
		return gamesLost;
	}

}
