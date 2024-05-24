package briscola;

/**
 * Represents the statistics of a player, including the number of games won and lost.
 */

public class PlayerStats {

	private int gamesWon;
	private int gamesLost;

	/**
	 * Constructs a PlayerStats object with the specified number of games won and lost.
	 *
	 * @param gamesWon The number of games the player has won
	 * @param gamesLost The number of games the player has lost
	 */

	public PlayerStats(int gamesWon, int gamesLost) {
		this.gamesWon = gamesWon;
		this.gamesLost = gamesLost;
	}

	/**
	 * Returns the number of games won by the player.
	 *
	 * @return The number of games won
	 */

	public int getGamesWon() {
		return gamesWon;
	}

	/**
	 * Returns the number of games lost by the player.
	 *
	 * @return The number of games lost
	 */

	public int getGamesLost() {
		return gamesLost;
	}

}
