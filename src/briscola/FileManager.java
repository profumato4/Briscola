package briscola;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class manages file reading and writing operations.
 */

public class FileManager {

	private String path; // File path
	private FileWriter fw = null; // FileWriter object for file writing
	private BufferedReader br = null; // BufferedReader object for file reading

	/**
	 * Constructor for the FileManager class.
	 *
	 * @param path The path of the file to perform read and write operations on
	 */

	public FileManager(String path) {

		if(path != null) {
			this.path = path;
		}

	}

	/**
	 * Appends a boolean value to the file.
	 *
	 * @param value The boolean value to append to the file
	 */


	public void append(boolean value) {
		try {
			fw = new FileWriter(path, false);
			fw.append(String.valueOf(value));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Appends a string to the file.
	 *
	 * @param value The string to append to the file
	 */

	public void append(String value) {
		try {
			fw = new FileWriter(path, false);
			fw.append(value);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Reads a boolean value from the file.
	 *
	 * @return The boolean value read from the file
	 */

	public boolean readBoolean() {
		try {
			br = new BufferedReader(new FileReader(path));

			String str;

			if((str = br.readLine()) != null) {
				return Boolean.valueOf(str);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	/**
	 * Reads a string from the file.
	 *
	 * @return The string read from the file
	 */

	public String readString() {

		try {
			br = new BufferedReader(new FileReader(path));

			String str;

			if((str = br.readLine()) != null) {
				return str;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


		return "";
	}

	/**
	 * Sets the file path.
	 *
	 * @param path The new file path
	 */
	public void setPath(String path) {
		if(path != null) {
			this.path = path;
		}
	}
	/**
	 * Gets the file path.
	 *
	 * @return The file path
	 */
	public String getPath() {
		return path;
	}

}
