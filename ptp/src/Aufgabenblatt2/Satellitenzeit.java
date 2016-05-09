/**
 * Praktikum Programmiertechnik 1 (Technische Informatik)
 * SS 2016, Hochschule für Angewandte Wissenschaften (HAW), Hamburg
 * 
 * Aufgabenblatt 2 Aufgabe 1: Satelitenzeit
 * Schreiben Sie ein Programm "Satellitenzeit", das einen ganzzahligen Sekundenbetrag in eine Zeitspanne in der Form <d> Tage <h>:<m>:<s>
 * umrechnet und ausgibt
 * 
 * Ersteller: Daniel von Drathen, Derya Uyargil
 * 
 */

package Aufgabenblatt2;

public class Satellitenzeit {
	
	public static void main(String[] args) {

		final int SEKUNDEN_PRO_SEKUNDE = 1;
		final int SEKUNDEN_PRO_MINUTE = 60*SEKUNDEN_PRO_SEKUNDE;
		final int MINUTEN_PRO_STUNDE = 60*SEKUNDEN_PRO_MINUTE;
		final int STUNDEN_PRO_TAG = 24*MINUTEN_PRO_STUNDE;
		
		int anzahlSekunden = 10000;
		final int anzahlTage = anzahlSekunden / STUNDEN_PRO_TAG;
		final int anzahlStunden = (anzahlSekunden % STUNDEN_PRO_TAG) / MINUTEN_PRO_STUNDE;
		final int anzahlMinuten = (anzahlSekunden % MINUTEN_PRO_STUNDE) / SEKUNDEN_PRO_MINUTE;
		final int anzahlSekundenErg = (anzahlSekunden % SEKUNDEN_PRO_MINUTE);

		System.out.println(
				anzahlTage + " Tage " + anzahlStunden + ":" + anzahlMinuten + ":" + anzahlSekundenErg);
	}
}
