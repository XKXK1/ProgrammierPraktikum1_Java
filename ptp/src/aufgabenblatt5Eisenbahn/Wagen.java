/**
 * Praktikum TIPTP1, SS 2016
 * Gruppe: Daniel von Drathen,
 * Derya Uyargil
 * Aufgabe: Aufgabenblatt 5, Aufgabe 2
 */

/**
 * Die Klasse Wagen repraesentiert einen Wagen der an einen Zug gehaengt werden kann.
 * Fuer die Klasse Wagen gibt es folgende Methoden:
 * getnaechsterWagen();
 * getKapazitaet();
 * getLaenge();
 * getSeriennummer();
 * setNaechsterWagen();
 * Die Namen dieser Methoden sind so selbsterklärend wie möglich. Ihre Funktion wird im Quellcode dennoch Erlaeutert.
 * Diese Methoden dieser Klasse sind ausschliesslich Getter/Setter zum uebermitteln von Variablen.
 */

package aufgabenblatt5Eisenbahn;

public class Wagen {
	private final int laenge;
	private final int kapazitaet;
	private Wagen naechsterWagen;

	static int wagenZaehler = 1;
	private final int Seriennummer;

	// Konstruktor

	public Wagen(int laenge, int kapazitaet) {
		this.laenge = laenge;
		this.kapazitaet = kapazitaet;

		Seriennummer = wagenZaehler;
		Wagen.wagenZaehler++;
		// Da beim erstellen eines Wagens keiner nach hinten Verknuepft ist wird
		// dieser wert auf "null" gesetzt.
		naechsterWagen = null;
	}

	/**
	 * Getter
	 * 
	 * @return return vom naechsten Wagen.
	 */
	public Wagen getnaechsterWagen() {
		return naechsterWagen;
	}

	/**
	 * Getter
	 * 
	 * @return return von der Kapazitaet des Wagens.
	 */
	public int getKapazitaet() {
		return kapazitaet;
	}

	/**
	 * Getter
	 * 
	 * @return return von der Laenge des Wagens.
	 */
	public int getLaenge() {
		return laenge;
	}

	/**
	 * Getter
	 * 
	 * @return return von der Seriennummer des Wagens
	 */
	public int getSeriennummer() {
		return Seriennummer;
	}

	/**
	 * Setter
	 * 
	 * @param naechsterWagen
	 *          wird gesettet.
	 */
	public void setNaechsterWagen(Wagen naechsterWagen) {
		this.naechsterWagen = naechsterWagen;
	}
}