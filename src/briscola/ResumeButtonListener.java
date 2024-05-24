package briscola;

/**
 * The ResumeButtonListener interface defines a contract for classes that listen
 * for resume button clicks in a user interface.
 */

public interface ResumeButtonListener {

	/**
	 * Called when the resume button is clicked.
	 *
	 * @param value a byte value associated with the resume button click
	 */

	void onResumeClicked(byte value);
	
}
