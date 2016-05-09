/**
 * Praktikum TIPTP1, SS 2016
 * Gruppe: Daniel von Drathen,
 * Derya Uyargil
 * Aufgabe: Aufgabenblatt 4, Aufgabe 2
 */

/**
 * Die Klasse Lokomotive repraesentiert Lokomotive die sich allen Wagen vorraus am Zuganfang befindet.
 * Fuer die Klasse Lokomotive gibt es folgende Methoden:
 * getErsterWagen();
 * setErsterWagen();
 * getTyp();
 * getLaenge;
 * Die Namen dieser Methoden sind so selbsterklärend wie möglich. Ihre Funktion wird im Quellcode dennoch Erlaeutert.
 * Diese Methoden dieser Klasse sind ausschliesslich Getter/Setter zum uebermitteln von Variablen.
 */

package aufgabenblatt5Eisenbahn;

public class Lokomotive {
	private final int laenge;
	private final int typ;
	private Wagen ersterWagen;

	// Konstruktor

	public Lokomotive(int laenge, int typ) {
		this.laenge = laenge;
		this.typ = typ;
	}

	// Methoden

	/**
	 * Getter
	 * 
	 * @return return vom ersten Wagen
	 */
	public Wagen getErsterWagen() {
		return ersterWagen;
	}

	/**
	 * Setter
	 * 
	 * @param ersterWagen
	 *          wird gesettet
	 */
	public void setErsterWagen(Wagen ersterWagen) {
		this.ersterWagen = ersterWagen;
	}

	/**
	 * Getter
	 * 
	 * @return return vom Typ der Lokomotive
	 */
	public int getTyp() {
		return typ;
	}

	/**
	 * Getter
	 * 
	 * @return return der Laenge der Lokomotive
	 */
	public int getLaenge() {
		return laenge;
	}
}
