package entites.superclasses;

public class Pix {

	private String chave;
	private double quantia;
	
	
	public Pix() {

	}

	public Pix(String chave) {
		this.chave = chave;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public double getQuantia() {
		return quantia;
	}

	public void setQuantia(double quantia) {
		this.quantia = quantia;
	}

}