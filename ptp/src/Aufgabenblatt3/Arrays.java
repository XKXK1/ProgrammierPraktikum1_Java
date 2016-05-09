/**
 * Praktikum Programmiertechnik (Technische Informatik)
 * SS 2016, Hochschule für Angewandte Wissenschaften (HAW), Hamburg
 * Prof. Dr. Philipp Jenke, Prof. Dr. Axel Schmolitzky, Norbert Kasperczyk-Borgmann
 * 
 * Gruppe: Derya Uyargil, Daniel von Drathen
 * 
 * 
 * Aufgabenblatt 3: Bedingte Anweisungen, Schleifen und Arrays
 * 
 * Aufgabe 3.3: Arrays
 * 
 * a) Legen Sie alle Zahlen in einem geeigneten mehrdimensionalen Array ab.
 * b) Berechnen Sie die Durchschnittstemperatur für die zwei Wochen und geben sie auf der Konsole aus.
 * c) Berechnen Sie maximale und minimale Temperatur und geben sie auf der Konsole aus.
 * d Finden Sie die beiden aufeinanderfolgenden Tage mit der größten Temperaturumschwung und geben sie
 * auf der Konsole aus.
 * Aufgabe: Hinweis: Den Betrag einer Zahl x kann man mit Math.abs(x) berechnen.
 * e) Geben Sie die Tabelle schön tabellarisch auf der Konsole aus.
 */

package Aufgabenblatt3;

public class Arrays {

	public static void main(String[] args) {
		// a) Mehrdimensionaler Array
		int[] tag = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
		int[] temperatur = { 12, 14, 9, 12, 15, 16, 15, 15, 11, 8, 13, 13, 15, 12 };

		// b) Mittelwert bestimmen
		double mittelwert = 0;
		for (int i = 0; i < temperatur.length; i++) {
			mittelwert += temperatur[i];
		}
		mittelwert /= temperatur.length;
		// Mittelwert = Nachdem alle Temperaturwerte addiert wurden werden sie durch die Anzahl
		// der Temperaturwerte geteilt. 
		System.out.format("Die Durchschnittstemperatur für die zwei Wochen beträgt: %.1f Grad Celsius.\n", mittelwert);

		// c) Maximum bestimmen
		int tempmax = temperatur[0];
		for (int i = 0; i < temperatur.length; i++) {
			if (tempmax < temperatur[i]) {
				tempmax = temperatur[i];
				// Wenn neuer Wert groesser ist als der Temporaere Wert tempmin wird dieser
				// als neuer tempmax Wert gespeichert
			}
		}
		System.out.println("\nDie höchste Temperatur beträgt: " + tempmax + " Grad Celsius.");

		// c) Minimum bestimmen
		int tempmin = temperatur[0];
		for (int i = 0; i < temperatur.length; i++) {
			if (tempmin > temperatur[i]) {
				tempmin = temperatur[i];
				// Wenn neuer Wert kleiner ist als der Temporaere Wert tempmin wird dieser
				// als neuer tempmin Wert gespeichert
			}
		}
		System.out.println("\nDie niedrigste Temperatur beträgt: " + tempmin + " Grad Celsius.");

		// d) Temperaturunterschied

		int indextag1 = +1;
		int indextag2 = 0;
		int diffmax = 0;
		int diff = Math.abs(temperatur[0] - temperatur[1]);
		for (int i = 1; i < temperatur.length; i++) {
			if (diff < Math.abs(temperatur[i] - temperatur[i - 1])) {
				diff = Math.abs(temperatur[i] - temperatur[i - 1]);
				diffmax = diff;
				indextag2 = i;
				// Wenn  der Differenzbetrag von 2 Tagen groesser ist als der im 
				// temporaer int diff wird dieser in diffmax gespeichert.
				
				 
			}
		}

		System.out.println("\nDer Höchste Temperaturunterschied von zwei auffeinanderfolgenden Tagen beträgt: "
				+ diffmax + " Grad Celsius und ist zwischen Tag " + indextag1 + " und Tag " + indextag2 + ".");

		// e) Table
		System.out.println("\n| *****TAG***** |  *TEMPERATUR* |");

		for (int i = 0; i < temperatur.length; i++) {
			System.out.println("|\t" + tag[i] + "\t|\t" + temperatur[i] + "\t|");

		}

	}

}