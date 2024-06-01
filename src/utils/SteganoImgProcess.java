package utils;

import java.awt.image.BufferedImage;
import java.util.ArrayDeque;
import java.util.Deque;

public class SteganoImgProcess {
	

	public String decode(BufferedImage input, int width, int height) {
		
		
		int msgLength = getEncodedLength(input, width, height);
				
		StringBuilder decodedMsg = new StringBuilder();
		Deque<Integer> listChar = new ArrayDeque<>();
		
		int pixel, temp, charOut, ignore = 0, count = 0;
		loop: for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				if(ignore < 36 + 4*(String.valueOf(msgLength).length()+1)) {
					ignore++;
					continue;
				}
				
				if(count++ == 4*msgLength) {
					break loop;
				}
				pixel = input.getRGB(i, j); //grab RGB value at specified pixel
				temp = pixel & 0x03; //extract 2 LSB from encoded data
				
				listChar.add(temp); //add the extracted data to a queue for later processing
				
				if(listChar.size() >=4) { //once we have 8 bits of data extracted
					//combine them to create a byte, and store this byte as a character
					charOut = (listChar.pop() << 6) | (listChar.pop() << 4) | (listChar.pop() << 2) | listChar.pop() ;
					decodedMsg.append((char)charOut);
				}
			}
			
		}

        return new String(decodedMsg);
	} //end of decode()
	
	
	public int getEncodedLength(BufferedImage input, int width, int height) { //method to get actual length of message encoded
		
		StringBuilder decodedMsg = new StringBuilder();
		Deque<Integer> listChar = new ArrayDeque<>();
		
		int pixel, temp, charOut, count = 0;
		loop: for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				if(count < 36) { //ignore the 36 bits or 9 bytes, equal to "!encoded!"
					count++;
					continue;
				}
				
				pixel = input.getRGB(i, j); //grab RGB value at specified pixel
				temp = pixel & 0x03; //extract 2 LSB from encoded data
				
				listChar.add(temp); //add the extracted data to a queue for later processing
				
				if(listChar.size() >=4) { //once we have 8 bits of data extracted
					//combine them to create a byte, and store this byte as a character
					charOut = (listChar.pop() << 6) | (listChar.pop() << 4) | (listChar.pop() << 2) | listChar.pop() ;
					if((char)charOut == '!') { //terminate process if character extracted is '!'
						break loop;
					} else {
						decodedMsg.append((char)charOut); //else add character to a StringBuffer
					}
				}
			}
			
		}
		
		String length = new String(decodedMsg);

		return Integer.parseInt(length);
	} //end of getEncodedLength() method
	
}
