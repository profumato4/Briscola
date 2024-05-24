package briscola;

import java.util.ArrayList;

/**
 * MyArrayList is a custom implementation of an ArrayList that overrides the toString method
 * to provide a formatted string representation of the list elements.
 *
 * @param <T> the type of elements in this list
 */

public class MyArrayList<T> extends ArrayList<T>{

	private static final long serialVersionUID = 1L;

	/**
	 * Returns a string representation of the list. Each element is preceded by "Carta" and its index.
	 *
	 * @return a formatted string representation of the list elements
	 */

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
        for (int i = 0; i < size(); i++) {
        	str.append("Carta ").append(i + 1).append(" ");
        	str.append(get(i));
            if (i < size() - 1) {
            	str.append("\n");
            }
        }
        str.append("\n");
        return str.toString();
	}
}
