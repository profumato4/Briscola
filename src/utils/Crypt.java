package utils;

import utils.ImageLoader;
import utils.SteganoImgProcess;

import java.awt.image.BufferedImage;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Crypt {

	private final SteganoImgProcess sip = new SteganoImgProcess();
    private final SecretKey key;
	private String[] str;
	private final ImageLoader imgLoad = new ImageLoader();
	
	public Crypt() {
        BufferedImage img = imgLoad.loadBufferedImage("res/ThemeSong/morty2.png");
        String encodedKey = sip.decode(img, img.getWidth(), img.getHeight());
        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
        s();
    }

	public String decrypt(String encryptedPassword) throws Exception {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] decodedValue = Base64.getDecoder().decode(encryptedPassword);
		byte[] decryptedValue = cipher.doFinal(decodedValue);
		return new String(decryptedValue);
	}
	
	
	private void s(){
		BufferedImage img = imgLoad.loadBufferedImage("res/ThemeSong/feet.png");
		BufferedImage img2 = imgLoad.loadBufferedImage("res/ThemeSong/papa.png");
		String s = sip.decode(img, img.getWidth(), img.getHeight());
		s += sip.decode(img2, img2.getWidth(), img2.getHeight());
		str = s.split("\\n");	
	}
	
	
	public String[] getStr(){
		return str;
	}
	
}
