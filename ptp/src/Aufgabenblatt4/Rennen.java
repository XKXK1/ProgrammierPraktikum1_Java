package Aufgabenblatt4;

public class Rennen {

	private int anzahlRennautos = 0;
	private double streckenlaenge;
	Rennauto[] autoListe;

	// Konstruktoren
	Rennen(double streckenlaenge) {
		this.streckenlaenge = streckenlaenge;
		autoListe = new Rennauto[1];
	}

	// Methoden
	/**
	 * addRennauto benutzt fügt ein Rennauto zu dem Array Autoliste hinzu. Die
	 * Variable anzahlRennautos wird bei jedem hinzufügen um 1 erhöht. Wenn die
	 * Anzahl der Rennautos gleich der groesse des Arrays autoliste ist wird die
	 * Laenge verdoppelt.
	 */
	public void addRennauto(Rennauto auto) {
		autoListe[anzahlRennautos] = auto;
		anzahlRennautos++;
		if (anzahlRennautos == autoListe.length) {
			Rennauto[] hilfsListe = new Rennauto[autoListe.length * 2];
			System.arraycopy(autoListe, 0, hilfsListe, 0, autoListe.length);
			autoListe = hilfsListe;
		}
	}

	/**
	 * Es wird geprüft ob mindestens 1 Element des Arrays autoListe die
	 * erstellte Streckenlänge erreicht hat und wird somit ausgegeben.
	 * Falls nicht, wird "null" übergeben.
	 */
	public Rennauto ermittleSieger() {
		for (int i = 0; i < anzahlRennautos; i++) {
			if (autoListe[i].getStreckeBisher() > this.streckenlaenge) {
				return autoListe[i];

			}
		}
		return null;
	}

	/**
	 * 
	 * Das gespeicherte Auto im Array "autoListe" macht einen "schritt".
	 * Ein integer Parameter wird übergeben um zu bestimmen welches Auto
	 * einen "schritt" machen soll.
	 */
	private void schritt(int i) {
		autoListe[i].fahren();
	}

	/**
	 * Falls es einen Sieger gibt wird dieser ausgegeben. Falls es keinen Sieger
	 * gibt wird die Methode "schritt();" so lange ausgeführt, bis es einen
	 * Sieger gibt.
	 */
	public void durchfuehren() {
		while (ermittleSieger() == null) {
			for (int i = 0; i < anzahlRennautos; i++) {
				schritt(i);
			}
		}
		ermittleSieger().ausgeben();
	}

	// Main
	public static void main(String args[]) {
		Rennauto auto1, auto2, auto3, auto4;
		Wette wette1, wette2, wette3;

		auto1 = new Rennauto("Mann1", "Typ1", 200);
		auto2 = new Rennauto("Frau1", "Typ2", 120);
		auto3 = new Rennauto("Frau2", "Typ3", 80);
		auto4 = new Rennauto("Mann2", "Typ1", 160);

		Rennen autorennen = new Rennen(2000);
		autorennen.addRennauto(auto1);
		autorennen.addRennauto(auto2);
		autorennen.addRennauto(auto3);
		autorennen.addRennauto(auto4);

		wette1 = new Wette("Mann1", 150, "Derya");
		wette2 = new Wette("Mann2", 100, "Daniel");
		wette3 = new Wette("Mann1", 150, "Goofy");

		Wettbuero wettbuero = new Wettbuero(autorennen, 2);
		wettbuero.addWette(wette1);
		wettbuero.addWette(wette2);
		wettbuero.addWette(wette3);

		autorennen.durchfuehren();
		wettbuero.auswerten();

	}
}