package main;


import javax.swing.ImageIcon;

public class Carta {

	private String seme;
	private String nome;
	private int valore;
	private ImageIcon img;

    public Carta(String seme, String nome, int valore, ImageIcon img) {
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
	
    public boolean isBriscola(String briscola){
        return (this.seme.equalsIgnoreCase(briscola));
      }
    
    public boolean comparaCarte(Carta c1, Carta c2, String briscola){
    	// se entrambe le carte sono briscole
        if(c1.isBriscola(briscola) && c2.isBriscola(briscola)) { 
        	// si controlla se la prima carta ha valore maggiore
        	if(c1.getValore() > c2.getValore()) {
        		// true per la prima carta vincente false per la seconda carta vincente
        		return true;
        		// se entrambe sono briscole e il loro valore è 0	
        	}else if(c1.getValore() == 0  && c2.getValore() == 0) {	
        		// allora controlliamo il nome
        		if(Integer.valueOf(c1.getNome()) > Integer.valueOf(c2.getNome())) {
        			return true;
        		}
        	}
        // se la prima carta è una briscola ma la seconda non lo è allora vince la prima carta	
        }else if(c1.isBriscola(briscola) && !c2.isBriscola(briscola)){
        	return true;
        // se la prima carta non è una briscola ma la seconda lo è allora vince la seconda carta
        }else if(!c1.isBriscola(briscola) && c2.isBriscola(briscola)) {
        	return false;
        // se hanno seme uguale e non sono briscole 
        }else if(c1.getSeme().equals(c2.getSeme()) && !(c1.isBriscola(briscola) && c2.isBriscola(briscola))) {
        	// allora controlliamo se la prima carta ha valore maggiore
        	if(c1.getValore() > c2.getValore()) {
        		return true;
        	// se entrambe le carte hanno valore = a 0
        	}else if(c1.getValore() == 0  && c2.getValore() == 0) {
        		// allora andiamo a controllare il nome
        		if(Integer.valueOf(c1.getNome()) > Integer.valueOf(c2.getNome())) {
        			return true;
        		}
        	}
        // se le due carte hanno seme diverso e nessuna delel due è una briscola allora vince la prima carta lanciata
        }else if(!(c1.getSeme().equals(c2.getSeme())) && !(c1.isBriscola(briscola) && c2.isBriscola(briscola))) {
        	return true;
        }
    	return false;
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
	
	
	
	public int getValore() {
		return valore;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}
	
	public Carta getCarta() {
		return this;
	}
	
	@Override
	public String toString() {
		return "[seme:" + seme + ", nome:" + nome + ", valore:" + valore + "]";
	}

}
