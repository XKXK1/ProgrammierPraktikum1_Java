/**
 * Praktikum TIPTP1, SS 2016
 * Gruppe: Daniel von Drathen,
 * Derya Uyargil
 * Aufgabe: Aufgabenblatt 5, Aufgabe 2
 */

/**
 * Die Klasse Zug repraesentiert einen Eisanbahnzug. Er besteht aus einer Lokomotive und einer beliebigen Anzahl an Wagen. Er muss aber nicht unbedingt ueber Wagen verfuegen.
 * Es koennen auch mehrere Zuege aneinander gehaengt werden und somit zu einem Zug fusionieren.
 * Fuer die Klasse Zug gibt es folgende Methoden:
 * wagenHinzufuegen();
 * erstenWagenhinzufuegen();
 * zugAnhaengen();
 * getWagenAnzahl();
 * getKapazitaet();
 * findeLetztenWagen();
 * getLaenge();
 * toString();
 * Die Namen dieser Methoden sind so selbsterklärend wie möglich. Ihre Funktion wird im Quellcode dennoch Erlaeutert.
 */
package aufgabenblatt5Eisenbahn;

public class Zug {
	private Lokomotive lok;
	private int kapazitaet;
	private int laenge;
	private int anzahlWagen;

	// Konstruktur

	public Zug(Lokomotive lok) {
		this.lok = lok;
		anzahlWagen = 0;
	}

	// Methoden

	/**
	 * Ein Wagen wird ans Ende des Zugs angehaengt.
	 * 
	 * @param wagen
	 *          Ein Argument des Referenztyps Wagen wird erwartet.
	 */
	public void wagenHinzufuegen(Wagen wagen) {
		// Wenn noch kein Wagen vorhanden ist, wird der hinzugefuegte Wagen als
		// erster Wagen gesettet.
		if (anzahlWagen == 0) {
			lok.setErsterWagen(wagen);
			// Falls schon ein Wagen vorhanden ist, wird per Hilfsmethode ein Wagen an
			// den letzten Wagen angehaengt.
		} else {
			findeLetztenWagen().setNaechsterWagen(wagen);
		}
		anzahlWagen++;
	}

	/**
	 * Der erste Wagen, d.h. direkt hinter der Lokomotive, wird entfernt. Der
	 * naechste Wagen genau hinter dem ersten wird nun zum ersten wagen gesettet.
	 * 
	 * @return Der entfernte Wagen wird ausgegeben. Falls kein Wagen entfernt
	 *         werden kann, wird "null" ausgegeben.
	 */
	public Wagen erstenWagenEntfernen() {
		if (anzahlWagen > 0) {
			Wagen alterWagen = lok.getErsterWagen();
			lok.setErsterWagen(lok.getErsterWagen().getnaechsterWagen());
			anzahlWagen--;
			return alterWagen;
		}
		return null;
	}

	/**
	 * Ein Zug wird an einen anderen angehaengt. Der erste Wagen des naechsten
	 * Zuges wird an den letzten Wagen des erstes zuges angehaengt.
	 * 
	 * @param naechsterZug
	 *          Der anzuhaengende Zug wird als Argument erwartet.
	 */
	public void zugAnhaengen(Zug naechsterZug) {
		if (naechsterZug.getWagenAnzahl() > 0) {
			Wagen letzterWagen = findeLetztenWagen();
			letzterWagen.setNaechsterWagen(naechsterZug.lok.getErsterWagen());
		} else {
			throw new IllegalArgumentException(
			    "Zug kann nicht angehaengt werden, da er weniger als 1 Wagen hat");
		}
	}

	/**
	 * Getter
	 * 
	 * @return return der Wagenanzahl des Zuges.
	 */
	public int getWagenAnzahl() {
		return anzahlWagen;
	}

	/**
	 * Getter
	 * 
	 * @return return der Kapazitaet des Zuges.
	 */
	public int getKapazitaet() {
		kapazitaet = 0;
		// naechsterWagen und letzterWagen wird als ersterWagen gesetzt, damit der
		// Zug von Vorne bis Hinten durchgegangen werden kann.
		Wagen naechsterWagen = lok.getErsterWagen();
		Wagen letzterWagen = lok.getErsterWagen();
		// Solange ein Wagen als naechsterWagen gefunden wird, wird dessen
		// Kapazitaet zur Gesamtkapazitaet des Zuges hinzugefuegt
		if (anzahlWagen > 0) {
			do {
				letzterWagen = naechsterWagen;
				naechsterWagen = naechsterWagen.getnaechsterWagen();
				kapazitaet += letzterWagen.getKapazitaet();
			} while (naechsterWagen != null);
		}

		// Die Gesamtkapazitaet des Zuges wird ausgegeben, wenn die Do-While
		// Anweisung beendet wurde.
		return kapazitaet;
	}

	/**
	 * Hilfsmethode zum finden des letzten Wagens eines Zuges. Diese Methode wird
	 * verwendet, um andere Methoden zu vereinfachen.
	 * 
	 * @return Der letzte Wagen eines Zuges wird ausgegeben.
	 */
	public Wagen findeLetztenWagen() {
		// naechsterWagen und letzterWagen wird als ersterWagen gesetzt, damit der
		// Zug von Vorne bis Hinten durchgegangen werden kann.
		Wagen naechsterWagen = lok.getErsterWagen();
		Wagen letzterWagen = lok.getErsterWagen();

		// Solange es mehr als 1 Wagen gibt, welcher als naechsterWagen uebergeben
		// werden kann, wird die Anweisung ausgefuehrt.
		if (anzahlWagen > 1) {
			do {
				letzterWagen = naechsterWagen;
				naechsterWagen = naechsterWagen.getnaechsterWagen();
			} while (naechsterWagen != null);
		}
		// Der letzte Wagen des Zuges wird ausgegeben, wenn die Do-While Anweisung
		// beendet wurde.
		return letzterWagen;
	}

	/**
	 * Getter
	 * 
	 * @return return der Laenge des Zuges
	 */
	public int getLaenge() {
		laenge = 0;
		laenge += lok.getLaenge();
		// naechsterWagen und letzterWagen wird als ersterWagen gesetzt, damit der
		// Zug von Vorne bis Hinten durchgegangen werden kann.
		Wagen naechsterWagen = lok.getErsterWagen();
		Wagen letzterWagen = lok.getErsterWagen();
		// Solange ein Wagen als naechsterWagen gefunden wird, wird dessen
		// Laenge zur Gesamtlaenge des Zuges hinzugefuegt.
		if (anzahlWagen > 0) {
			do {
				letzterWagen = naechsterWagen;
				naechsterWagen = naechsterWagen.getnaechsterWagen();
				laenge += letzterWagen.getLaenge();
			} while (naechsterWagen != null);
		}
		// Die Gesamtlaenge des Zuges wird ausgegeben, wenn die Do-While
		// Anweisung beendet wurde
		return laenge;
	}

	/**
	 * Ein ausgabeString wird erstellt, um den Typ, die Wagenanzahl, die laenge
	 * und die Kapazitaet des Zuges auszugeben. Darueber hinaus wird die
	 * Wagennummer, die Seriennummer, die Laenge und die Kapazitaet der einzelnen
	 * Wagen ausgegeben.
	 */
	public String toString() {
		String ausgabeString;
		ausgabeString = "Loktyp: " + lok.getTyp();
		ausgabeString += "\nAnzahl Wagen: " + this.getWagenAnzahl();
		ausgabeString += "\nGesamtlaenge: " + getLaenge();
		ausgabeString += "\nPersonenkapazitaet: " + getKapazitaet();

		Wagen wagen = lok.getErsterWagen();
		int i = 1;
		// Solange ein naechsterWagen gefunden wird, werden seine Eigenschaften an
		// den ausgabeString uebergeben.
		while (wagen != null) {
			ausgabeString += "\n" + i + ". Wagen: ";
			ausgabeString += "\nSeriennummer: " + wagen.getSeriennummer();
			ausgabeString += "\nWagenlaenge: " + wagen.getLaenge();
			ausgabeString += "\nPassagierkapazitaet: " + wagen.getKapazitaet();

			wagen = wagen.getnaechsterWagen();
			i++;
		}
		// Der Gesamte ausgabeString wird ausgegeben.
		return ausgabeString;
	}
}