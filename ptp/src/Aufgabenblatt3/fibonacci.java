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
 * Aufgabe 3.2: Fibonacci–Zahlen
 * 
 * Schreiben Sie ein Programm Fibonacci-Zahlen, das vom Anwender abfragt, die wievielte Fibonacci-Zahl
 * berechnet werden soll, die zugehörige Zahl berechnet und diese ausgibt. Die Anwender-Eingabe soll in einer
 * Variablen mit Namen eingabe vom geeigneten Typ abgelegt werden. Erstellen Sie zunächst wieder einen
 * Entwurf, bevor Sie den Quellcode entwickeln. Gehen Sie davon aus, dass der Anwender nur positive ganzen
 * Zahlen >= 2 eingibt. Verwenden Sie eine while-Schleife.
 * Beispiel: Anwender-Eingabe: 4, Ausgabe: 3
 */

package Aufgabenblatt3;

import java.util.Scanner;

public class fibonacci {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ausgabe der x-ten Fibonacci Zahl.\nBitte positive gerade Zahl >=2 Eingeben:");
		int eingabe = scan.nextInt(), i=0, fzahl0=0, fzahl1=1, fzahl2=-1;
		// int fzahl0 = deklaration und Initialisierung der 0ten Fibonacci-Zahl
		// int fzahl1 = deklaration und Initialisierung der 1ten Fibonacci-Zahl
		// int fzahl2 =deklaration der 2ten Fibonacci-Zahl(dient als Zwischenspeicher, 
		// zur Übergabe an die nächste Fibonacci-Zahl)
		scan.close();
		
		if(eingabe<2){
			System.out.println("Die eingegebene Zahl muss über >=2 sein");

		}
		
		if(eingabe>=2){
		while(i<eingabe){
			fzahl2=fzahl0+fzahl1;
			fzahl0=fzahl1;
			fzahl1=fzahl2;
			i++;
			// 
			}
		System.out.println("Die " + eingabe + "te Fibonacci Zahl ist: "+fzahl0);
		}

	}
}
