/**
 * Praktikum Programmiertechnik 1 (Technische Informatik)
 * SS 2016, Hochschule für Angewandte Wissenschaften (HAW), Hamburg
 * 
 * Aufgabenblatt 2 Aufgabe 3: Modulo
 * Berechnung des Restes der Division zweier Zahlen mittels Operator "%" ,sowie manueller Formel a-(b*(a/b).
 * 
 * Ersteller: Daniel von Drathen, Derya Uyargil
 * 
 */

package Aufgabenblatt2;
import java.util.Scanner;

public class Modulo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Geben Sie eine echte Zahl ein: ");
		int zahl1 = scan.nextInt();
		System.out.print("Geben Sie eine zweite echte Zahl ein: ");
		int zahl2 = scan.nextInt();
		int ergebnisModul = zahl1%zahl2;
		int ergebnisMan = zahl1-(zahl2*(zahl1/zahl2));
		System.out.println(zahl1+" Modulo "+zahl2+" Ergibt: "+ergebnisModul+"\nDie Manuelle Rechnung 'a-(b*(a/b)' ergibt: "+ergebnisMan);		
		scan.close();
	}
}
