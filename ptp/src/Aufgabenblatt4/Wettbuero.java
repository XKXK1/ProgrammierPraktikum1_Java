package Aufgabenblatt4;

public class Wettbuero {
	private int anzahlWetten;
	private double faktor;
	private double gewinn;
	Rennen rennen;
	Wette[] wettListe;

	// Konstruktor
	public Wettbuero(Rennen autorennen, double faktor) {
		this.faktor = faktor;
		rennen = autorennen;
		wettListe = new Wette[1];
		anzahlWetten = 0;
	}

	// public void wetteAnnehmen(String fahrerIn, int wettEinsatz, String
	// Spieler){

	public void addWette(Wette wette) {
		wettListe[anzahlWetten] = wette;
		anzahlWetten++;
		if (anzahlWetten == wettListe.length) {
			Wette[] hilfsListeWette = new Wette[wettListe.length * 2];
			System.arraycopy(wettListe, 0, hilfsListeWette, 0, wettListe.length);
			wettListe = hilfsListeWette;
		}
	}

	public void auswerten() {
		for (int i = 0; i < anzahlWetten; i++) {
			if (rennen.ermittleSieger().getNameFahrerIn() == wettListe[i].getFahrerIn()) {
				gewinn = faktor * wettListe[i].getWettEinsatz();
				System.out.format("\nDer Spieler: %s hatt richtig getippt und %.2f Euronen gewonnen",
						wettListe[i].getSpieler(), gewinn);
			}

		}

	}
}
