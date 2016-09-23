package aufgabenblatt7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Nullstellen {
	// Grenzwert fuer das Newton Verfahren um zu Pruefen ob eine Nullstelle
	// gefunden wurde.
	private final double grenzwert = 0.00001;
	Funktionen funktion;
	/**
	 * Default-Konstruktor. Der Anwender kann 3 variablen fuer die Quadratische
	 * Funktion angeben.
	 */
	public Nullstellen() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Erste Variable angeben: ");
		int a = scanner.nextInt();
		System.out.println("Zweite Variable angeben: ");
		int b = scanner.nextInt();
		System.out.println("Dritte Variable angeben: ");
		int c = scanner.nextInt();
		funktion = new QuadratischeFunktion(a, b, c);
		scanner.close();
	}

	/**
	 * Der ueberladene Konstruktor erwartet 3 Argumente des Typs 'int', welche als
	 * Variablen fuer eine Quadratische Funktion dienen.
	 * 
	 * @param a
	 *          - Variable 1
	 * @param b
	 *          - Variable 2
	 * @param c
	 *          - Variable 3
	 */
	public Nullstellen(int a, int b, int c) {
		funktion = new QuadratischeFunktion(a, b, c);
	}

	/**
	 * Die Methode dient zum finden von Nullstellen einer Funktion durch die
	 * Iterative Vorschrift: xn - f(xn) / f'(xn). Die Methode erwartet ein 'int'
	 * als Argument, welches als Annahmewert fuer die Berechnung durch das
	 * Verfahren benutzt wird.
	 * 
	 * Die Methode ist in der Lage zwei Exceptions zu werfen. Die Exception
	 * 'DIVISIONDURCHNULL' wird geworfen, falls der Wert der Ableitung '0' ergeben
	 * sollte.In Diesem Fall wuerde das Programm abstuerzen da eine Division durch
	 * '0' nicht moeglich ist. Die Exception 'KEINEKONVERGENZ' wird geworfen,
	 * falls nach 10 durchlaeufen keine Nullstelle gefunden wurde. Somit hat kein
	 * Wert Konvergiert.
	 * 
	 * Die Nullstelle gilt als gefunden falls der Absolutwert zweier, nacheinander
	 * durch das Verfahren berechneten, Werte subtrahiert von einander kleiner als
	 * der Grenzwert ist.
	 * 
	 * 
	 * @param annahme
	 * @return
	 * @throws NullstellenException
	 */
	public double newtonVerfahren(int annahme) throws NullstellenException {
		int durchlaeufe = 0;
		boolean nochmal = true;
		double altesErgebnis = annahme;
		double neuesErgebnis = -1;
		do {
			if (funktion.funktionAbleitung(altesErgebnis) == 0) {
				throw new NullstellenException(Fehlertypen.DIVISIONDURCHNULL);
			}
			neuesErgebnis = altesErgebnis
			    - (funktion.funktion(altesErgebnis) / funktion.funktionAbleitung(altesErgebnis));
			if (Math
			    .abs(Math.abs(altesErgebnis) - Math.abs(neuesErgebnis)) < grenzwert) {
				nochmal = false;

			}
			altesErgebnis = neuesErgebnis;
			durchlaeufe++;
			if (durchlaeufe == 10) {
				throw new NullstellenException(Fehlertypen.KEINEKONVERGENZ);
			}
		} while (nochmal);
		return neuesErgebnis;

	}

	/**
	 * Die Methode erwartet 3 Argumente. Einen Minimal- und einen Maximalwert fuer
	 * ein Intervall und ein 'int' fuer eine Anzahl an Versuchen. In diesem
	 * Intervall wird durch die Bibliotheksmethode Math.random ein Wert durch
	 * Zufall herausgesucht, welcher als Annahmewert fuer das Durchfuehren des
	 * Newton Verfahrens genutzt wird.
	 * 
	 * Ein HashSet des Typs DoubleWert wird erstellt, welches die Menge an
	 * Nullstellen ohne Doppelung repraesentiert. Die erfolgreich gefundenen
	 * Nullstellen werden in diese Menge uebertragen.
	 * 
	 * Bei der Nutzung des NewtonVerfahrens wird durch eine try/catch Anweisung
	 * vermieden, dass das Programm bei einer Exception abstuerzt.
	 * 
	 * Eine ArrayList des Typs DoubleWert wird erstellt. Die gefundenen
	 * Nullstellen werden in diese Liste uebergeben, aufsteigend sortiert und
	 * ausgegeben.
	 * 
	 * @param min
	 * @param max
	 * @param anzahlVersuche
	 * @return
	 */
	public List<Double> findeNullstellenRandomisiert(int min, int max,
	    int anzahlVersuche) {
		Set<DoubleWert> nullstellenMenge = new HashSet<DoubleWert>();
		max += 1;
		min -= 1;
		DoubleWert nullstelle;
		for (int i = 0; i < anzahlVersuche; i++) {
			int random = (int) ((Math.random() * (max - min)) + min);
			try {
				nullstelle = new DoubleWert(newtonVerfahren(random));
				nullstellenMenge.add(nullstelle);
			} catch (Exception e) {

			}
		}
		List<Double> nullstellenListe = new ArrayList<Double>();
		for (DoubleWert element : nullstellenMenge) {
			nullstellenListe.add(element.getWert());
		}
		Collections.sort(nullstellenListe);

		return nullstellenListe;

	}
}
