package Aufgabenblatt4;

public class Wette {
	private String fahrerIn;
	private int wettEinsatz;
	private String spieler;
	int anzahlWetten;

	// Konstruktor
	public Wette(String fahrerIn, int wettEinsatz, String spieler) {
		this.fahrerIn = fahrerIn;
		this.wettEinsatz = wettEinsatz;
		this.spieler = spieler;
	}

	// Methoden
	public String getFahrerIn() {
		return fahrerIn;
	}

	public int getWettEinsatz() {
		return wettEinsatz;
	}

	public String getSpieler() {
		return spieler;
	}
}
