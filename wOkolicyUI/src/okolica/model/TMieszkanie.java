package okolica.model;

public class TMieszkanie extends TEntity{

	private int numer;
	private String adres;
	private short klatka;
	private short pietro;
	
	public int getNumer() {
		return numer;
	}
	public void setNumer(int numer) {
		this.numer = numer;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public short getKlatka() {
		return klatka;
	}
	public void setKlatka(short klatka) {
		this.klatka = klatka;
	}
	public short getPietro() {
		return pietro;
	}
	public void setPietro(short pietro) {
		this.pietro = pietro;
	}
	
	
}
