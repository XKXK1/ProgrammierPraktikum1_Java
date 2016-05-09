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
 * Aufgabe 3.1: Flächeninhalt(if else)
 * 
 * Schreiben Sie ein Programm, eine Größe x (Fließkommazahl) und einen Index index (Dezimalzahl)
 * einließt. Abhängig von dem eingegeben Index berechnet das Programm den Flächeninhalt eines Kreises mit
 * dem Radius x (Index 1), den Flächeninhalt eines Quadrats mit der Seitenlänge x (Index 2) oder den
 * Flächeninhalt eines Sechsecks (https://de.wikipedia.org/wiki/Sechseck) mit der Seitenlänge x (Index 3). Der
 * berechnete Flächeninhalt wird in einer Variablen abgelegt und am Ende des Programms ausgegeben. Für
 * ungültige Indizes ist der Flächeninhalt -1. Schreiben Sie zwei Versionen des Programms, 
 * eine mit Verwendung von if-else, eine mit Verwendung von switch.
 */

package Aufgabenblatt3;

import java.util.Scanner;

public class Flächeninhalt {

	public static void main(String[] args) {
		int index = -1;
		double radius, flaecheninhalt;
		Scanner scan = new Scanner(System.in);

		System.out.println("Wählen sie eine Berechnung?\n " + "\n1 = Flächeninhalt eines Kreises "
				+ "\n2 = Flächeninhalt eines Quadrats" + "\n3 = Flächeninhalt eines Sechsecks");
		index = scan.nextInt();

		System.out.println("Bitte gebe den Radius/die Seitenlänge ein.");
		radius = scan.nextDouble();
		scan.close();

		if (index == 1) {
			flaecheninhalt = radius * radius * Math.PI;
		} else if (index == 2) {
			flaecheninhalt = radius * radius;
		} else if (index == 3) {
			flaecheninhalt = (radius * radius) * 1.5 * Math.sqrt(3);
		} else {
			flaecheninhalt = -1;
			System.out.println("Ungueltige Eingabe");

		}

		System.out.format("Flaecheninhalt betraegt %.2f cm^2", flaecheninhalt);
	}
}
