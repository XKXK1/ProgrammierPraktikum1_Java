/**
 * Praktikum Programmiertechnik 1 (Technische Informatik)
 * SS 2016, Hochschule für Angewandte Wissenschaften (HAW), Hamburg
 * 
 * Aufgabenblatt 2 Aufgabe 2: Body-Mass-Index
 * Berechnung des Body-Mass-Index durch manuelle Eingabe von Groesse und Gewicht vom Nutzer.
 * 
 * Ersteller: Daniel von Drathen, Derya Uyargil
 * 
 */

package Aufgabenblatt2;

import java.util.Scanner;


public class BMI {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 1,7m, 65kg -> 22

		System.out.print("Bitte geben sie ihre Groesse in Metern an: ");
		double groesse = scan.nextDouble();
		System.out.print("Bitte geben Sie nun ihr Gewicht in Kg an: ");
		double gewicht = scan.nextDouble();

		System.out.print("Ihr BMI beträgt: " + (int) (gewicht / (groesse * groesse)));
		scan.close();
	}
}
