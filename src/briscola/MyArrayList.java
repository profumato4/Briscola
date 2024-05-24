package briscola;

import java.util.ArrayList;

public class MyArrayList<T> extends ArrayList<T>{

	private static final long serialVersionUID = 1L;

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
