/**
 * Praktikum TIPTP1, SS 2016
 * Gruppe: Daniel von Drathen,
 * Derya Uyargil
 * Aufgabe: Aufgabenblatt 5, Aufgabe 1
 */

/**
 * Eine Edelsteinbox soll als Behaelter fuer Edelsteine verschiedener Sorten dienen. 
 * Es gibt 3 Sorten: Diamant, Rubin und Smaragdt.
 * Fuer diese Edelsteinbox gibt es folgende Methoden.
 * hineinlegen();
 * herausnehmen();
 * leeren();
 * umwandeln();
 * ausgeben();
 * toString();
 * getAnzahl();
 * Die Namen dieser Methoden sind so selbsterklärend wie möglich. Ihre Funktion wird im Quellcode dennoch Erlaeutert.
 */

package aufgabenblatt5;

enum Edelstein {
	RUBIN, DIAMANT, SMARAGD
}

public class Edelsteinbox {

	private int diamantAnzahl = 0;
	private int rubinAnzahl = 0;
	private int smaragdAnzahl = 0;
	private String umgewandelt = "";

	// Konstruktor
	/**
	 * 
	 * @param sorte
	 *          Einer oder mehrere Edelsteine koennen als Argument uebergeben
	 *          werden.
	 */
	public Edelsteinbox(Edelstein... sorte) {
		for (int i = 0; i < sorte.length; i++) {
			switch (sorte[i]) {
				case DIAMANT :
					diamantAnzahl++;
					break;
				case SMARAGD :
					smaragdAnzahl++;
					break;
				case RUBIN :
					rubinAnzahl++;
					break;
			}
		}
	}

	// Methoden

	/**
	 * 
	 * @param sorte
	 * @param anzahl
	 *          Die hineinzulegende Sorte und Anzahl kann als Argument uebergeben
	 *          werden. Per Switch-Case werden die uebergebenen Edelsteine
	 *          hinzugefuegt.
	 */
	public void hineinlegen(Edelstein sorte, int anzahl) {
		switch (sorte) {
			case DIAMANT :
				diamantAnzahl += anzahl;
				break;
			case RUBIN :
				rubinAnzahl += anzahl;
				break;
			case SMARAGD :
				smaragdAnzahl += anzahl;
				break;
		}
	}

	/**
	 * 
	 * @param sorte
	 * @param anzahl
	 *          Die herauszunehmende Sorte und Anzahl kann als Argument uebergeben
	 *          werden. Per Switch-Case werden die uebergebenen Edelsteine
	 *          hinzugefuegt. Falls die uebergebene Anzahl groesser sein sollte
	 *          als die vorhandene Anzahl des Edelsteins, wird der Wert auf 0
	 *          gesetzt.
	 * 
	 */
	public void herausnehmen(Edelstein sorte, int anzahl) {
		switch (sorte) {
			case DIAMANT :
				if (diamantAnzahl < anzahl) {
					diamantAnzahl -= anzahl;
				} else {
					diamantAnzahl = 0;
				}
				break;
			case RUBIN :
				if (rubinAnzahl < anzahl) {
					rubinAnzahl -= anzahl;
				} else {
					rubinAnzahl = 0;
				}
				break;
			case SMARAGD :
				if (smaragdAnzahl < anzahl) {
					smaragdAnzahl -= anzahl;
				} else {
					smaragdAnzahl = 0;
				}
				break;
		}
	}

	/**
	 * Die Edelsteinbox wird geleert, indem die Anzahl jedes Edelsteins auf 0
	 * gesetz wird.
	 */
	public void leeren() {
		diamantAnzahl = 0;
		rubinAnzahl = 0;
		smaragdAnzahl = 0;
	}

	/**
	 * Per Switch-Case werden die uebergebenen Edelsteine hinzugefuegt. Als Case
	 * wird ein Argument erwartet, welches einen Edelstein repraesentiert. Da alle
	 * Edelsteine einer Sorte umgewandelt werden, wird die Anzahl des
	 * ausgetauschten Edelsteins auf 0 gesetzt.
	 * 
	 * 
	 * @param vonSorte
	 *          Parameter fuer die Eingabe des Edelsteins der umgewandelt werden
	 *          soll
	 * @param zuSorte
	 *          Parameter fuer die Eingabe des Edelsteins der in die Edelsteinbox
	 *          hineingelegt werden soll.
	 */
	public void umwandeln(Edelstein vonSorte, Edelstein zuSorte) {
		switch (vonSorte) {
			case DIAMANT :
				hineinlegen(zuSorte, diamantAnzahl);
				diamantAnzahl = 0;
				break;

			case RUBIN :
				hineinlegen(zuSorte, rubinAnzahl);
				rubinAnzahl = 0;
				break;

			case SMARAGD :
				hineinlegen(zuSorte, smaragdAnzahl);
				smaragdAnzahl = 0;
				break;
		}
	}

	/**
	 * Gibt die toString(); Methode auf der Konsole aus.
	 */
	public void ausgeben() {
		System.out.println(toString());
	}

	/**
	 * Wandelt die Anzahl der Diamanten in einen String um. Um die korrekte Anzahl
	 * der Diamanten auszugeben, wird durch eine for-Schleife fuer jeden Edelstein
	 * der jeweilige Buchstabe uebergeben.
	 */
	public String toString() {
		umgewandelt = "";
		for (int i = 1; i <= diamantAnzahl; i++) {
			umgewandelt += "D";
		}
		for (int i = 1; i <= rubinAnzahl; i++) {
			umgewandelt += "R";
		}
		for (int i = 1; i <= smaragdAnzahl; i++) {
			umgewandelt += "S";
		}
		return "(" + umgewandelt + ")";
	}

	/**
	 * Gibt die Anzahl der Edelsteine einer Bestimmten Sorte zurueck.
	 * 
	 * @param sorte
	 *          Parameter zum uebergeben der Sorte welche ausgegeben werden soll.
	 * @return
	 */
	public int getAnzahl(Edelstein sorte) {
		switch (sorte) {

			case DIAMANT :
				return diamantAnzahl;

			case RUBIN :
				return rubinAnzahl;

			case SMARAGD :
				return smaragdAnzahl;

			default :
				return 0;
		}
	}
}
