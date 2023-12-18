import java.util.ArrayList;

@SuppressWarnings("serial")
public class MyArrayList<T> extends ArrayList<T>{
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
        for (int i = 0; i < size(); i++) {
        	str.append("Carta "+(i+1)+" ");
        	str.append(get(i));
            if (i < size() - 1) {
            	str.append("\n");
            }
        }
        str.append("\n");
        return str.toString();
	}
}
