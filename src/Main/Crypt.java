package Main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;

public class Crypt {
	
	private SteganoImgProcess sip = new SteganoImgProcess();
	private String encodedKey;
	private byte[] decodedKey;
	private SecretKey key;
	
	public Crypt() {
		try {
			BufferedImage img = ImageIO.read(new File("res//ThemeSong//morty2.png"));
			encodedKey = sip.decode(img, img.getWidth(), img.getHeight());
			decodedKey = Base64.getDecoder().decode(encodedKey);
			key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String decrypt(String encryptedPassword) throws Exception {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] decodedValue = Base64.getDecoder().decode(encryptedPassword);
		byte[] decryptedValue = cipher.doFinal(decodedValue);
		return new String(decryptedValue);
	}
	
	
	
	
	
	
	
}