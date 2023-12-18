
import javax.swing.ImageIcon;

public class Carta {

	private String seme;
	private String nome;
	private int valore;
	private ImageIcon img;

    public Carta(String seme, String nome, Integer valore, ImageIcon img) {
        String[] semi = {"Spade", "Denara", "Coppe", "Bastoni"};
        for (String seme1 : semi) {
			if (seme.equals(seme1)) {
				this.seme = seme;
				break;
			} else {
				this.seme = "Nessun seme";
			}
		}

		this.nome = nome;
		
		if (valore == 11 || valore == 10 || valore == 4 || valore == 3 || valore == 2) {
			this.valore = valore;
		}else {
			this.valore = 0;
		}
		
		this.img = img;
		
	}
	


	public String getSeme() {
		return seme;
	}


	public String getNome() {
		return nome;
	}


	public ImageIcon getImg() {
		return img;
	}
	
	
	public void setImg(ImageIcon img) {
		this.img = img;
	}


	@Override
	public String toString() {
		return "[seme:" + seme + ", nome:" + nome + ", valore:" + valore + "]";
	}

}
