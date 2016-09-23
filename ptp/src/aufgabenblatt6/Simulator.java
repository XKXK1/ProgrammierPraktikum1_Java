package aufgabenblatt6;

import java.util.ArrayList;
import java.util.Scanner;

public class Simulator {
	private final int SCHRITT = 15;
	private final int MAX_AKTIVE_SENDUNGEN = 20;
	private ArrayList<Sendung> sendungsliste = new ArrayList<Sendung>();
	private int aktiveSendungen = 0;
	Sendung sendung;
	Scanner scanner = new Scanner(System.in);

	/**
	 * Konstruktor fuer eine Simulation
	 * 
	 */
	public Simulator() {
		Sendung.zeitJetzt = 0;
	}

	/**
	 * die Methode durchfuehren() fuehrt die Hilfsmethode listeBefuellen() aus
	 * danach wird eine Switch-Verzweigung zum durchfuehren benutzt case: Ende
	 * beendet den Durchgang case: Schritt fuehrt die Methode schritt() aus bei
	 * ungueltiger Eingabe wird der Nutzer darauf hingewiesen
	 */
	public void durchfuehren() {
		boolean weiter = true;
		listeBefuellen();
		while (weiter) {
			System.out.print("Bitte Kommando eingeben ('ENDE' 'SCHRITT'): ");
			switch (scanner.next().toUpperCase()) {
			case "ENDE":
				weiter = false;
				System.out.println("Simulation beendet.");
				break;
			case "SCHRITT":
				schritt();
				break;
			default:
				System.out.println("Ungültige Eingabe.");
			}
		}
	}

	/**
	 * Eine Methode zum durchfuehren eines Schrittes im Simulator. jetztZeit der
	 * Sendungen wird, um die in Schritt festgelegte Zeit, erhoeht. Alle
	 * Sendungen werden auf ihren ausgeliefert Status abgefragt und bei True
	 * ausgegeben und durch eine neue Sendung ersetzt.
	 * 
	 * Sendungen werden ausserdem mit ihrem Status in Prozent ausgegeben.
	 */
	public void schritt() {
		Sendung.zeitJetzt += SCHRITT;
		for (int i = 0; i < MAX_AKTIVE_SENDUNGEN; i++) {
			if (sendungsliste.get(i).istAusgeliefert()) {
				System.out.println(toString(sendungsliste.get(i)) + " ist ausgeliefert");
				sendungsliste.remove(i);
				sendungsliste.add(i, erzeugeSendung());
				System.out.println(toString(sendungsliste.get(i)) + " erzeugt.");
			}
			int prozent = (((Sendung.zeitJetzt - sendungsliste.get(i).startZeitpunkt) * 100)
					/ (sendungsliste.get(i).transportDauer));
			System.out.println(toString(sendungsliste.get(i)) + " bei " + prozent + " %");
		}
		// System.out.println(sendungsliste.get(i).transportDauer);
	}

	// ----------------------------------------------->Hilfsmethoden

	/**
	 * Ein Hilfsmethode zum erstmaligen befuellen der Sendungsliste.
	 */
	private void listeBefuellen() {
		while (aktiveSendungen < MAX_AKTIVE_SENDUNGEN) {
			Sendung sendung = erzeugeSendung();
			sendungsliste.add(sendung);
			aktiveSendungen++;
			System.out.println(toString(sendung) + " erzeugt.");
		}
	}

	/**
	 * Eine Zufallssendung erzeugen. Die Zufall-Anweisung erstellt zu 50% einen
	 * Brief und im Falle dessen zu 50% ein Einschreiben zu 50% wird ein Paket
	 * erstellt
	 * 
	 * @return Gibt eine zufaellige Sendung zurueck
	 * 
	 */
	private Sendung erzeugeSendung() {
		Person sender = erzeugePerson();
		Person empfaenger = erzeugePerson();
		Sendung sendung;

		int zufall = (int) (Math.random() * 100);

		if (zufall > 50) {
			if (zufall > 75) {
				sendung = new Brief(sender, empfaenger, Sendung.zeitJetzt, true);
			} else {
				sendung = new Brief(sender, empfaenger, Sendung.zeitJetzt, false);
			}
		} else {
			sendung = new Paket(sender, empfaenger, Sendung.zeitJetzt, (int) Math.random() * 6);
		}

		return sendung;

	}

	/**
	 * Eine Zufallsperson erzeugen, durch ausnutzung von Math.Random()
	 * 
	 * @return Gibt eine zufaellige Person zurueck
	 */
	private Person erzeugePerson() {
		Staedte stadt = Staedte.values()[(int) (Math.random() * Staedte.values().length)];
		int randomHausnummer = (int) ((Math.random() * 100) + 1);
		int randomPlz = (int) ((Math.random() * 20000) + 10001);
		String name = randomName();

		Person person = new Person(name, new Adresse(strassenBausetein(), randomHausnummer, randomPlz, stadt));
		return person;
	}

	/**
	 * Eine Hilfsmethode zur Erstellung einer Strasse aus 3 Arrays mit
	 * unterschiedlichen Strassenbausteinen
	 * 
	 * @return Gibt einen zufaelligen Strassennamen zurueck
	 */
	private String strassenBausetein() {
		String strassenName;
		String[] baustein1 = { "Hinrichsen", "Falken", "Schulkamp", "Muster", "Holm", "Berg", "Schuster", };
		String[] baustein2 = { "acker", "kraut", "feld", "-Kirchen ", "" };
		String[] baustein3 = { "weg", "allee", "Strasse", "damm", "moor", "steg", "fleed", "dom", "" };
		strassenName = baustein1[(int) (Math.random() * baustein1.length)];
		strassenName += baustein2[(int) (Math.random() * baustein2.length)];
		strassenName += baustein3[(int) (Math.random() * baustein3.length)];
		return strassenName;
	}

	/**
	 * Eine Hilfsmethode zur Erstellung eines vollstaengigen Namens aus 2 Arrays mit
	 * unterschiedlichen Namensbausteinen
	 * 
	 * @return Gibt einen zufaelligen vollstaendigen Namen zurueck
	 */
	private String randomName() {
		String name;
		String[] vorname = { "Daniel", "Derya", "Damian", "Dennis", "Adem", "Adam", "Bob", "Stefan", "Reinhard", "Max",
				"Muster", "Mann", "Hans", "Kurt", "Carsten", "Dennis", "Carina", "Marie", "Maia", "Christine",
				"Charlotte", "Anita", "Louisa", "Clara", "Hannes", "Hauke", "Peter", "Lars", "Hummel", "Matthias",
				"Günther", "Florian", "Johannes", "Friemke", "Lara", "Laura", "Lorelei", "Lisa", "Maike", "Michael",
				"Ute", "Miriam", "Sabrina", "Swanche", "Max", "John", "Jaine", "Santa", "Peter", "Lois", "Stewie" };
		String[] nachname = { "von Drathen", "Uyargil", "Maffai", "Bopp", "Haus", "Mustermann", "Doe", "Snow",
				"Reinhard", "Harrington", "Cobain", "Lee", "Klaus", "Lackless", "Griffin", "Dexter", "Zorlel", "Jaine",
				"Otto", "Gargamel", "Holle", "Knutz", "Ömer", "Nolte", " van Elst", "Gersting", "Brahm", "Tunnel",
				"Hummel", "Canterburry", "Hopps", "Mops", "Schlund", "Wund", "Hungrig", "Müde", "viel zu spät", "Geh ",
				"Ins", "Bett", "Warum", "Bin", "Ich ", "Noch", "Wach" };
		name = vorname[(int) (Math.random() * vorname.length)] + " ";
		name += nachname[(int) (Math.random() * nachname.length)];
		return name;
	}

	/**
	 * Methode zum ausgeben der Sendungen in der Simulation 
	 * eine Sendung wird als Argument erwartet
	 * @param sendung
	 * @return
	 */
	public String toString(Sendung sendung) {
		String ausgabe = sendung.getClass().getSimpleName() + " aus " + sendung.sender.getAdresse().ort + " -> "
				+ sendung.empfaenger.getAdresse().ort + " (start=" + sendung.startZeitpunkt + ", dauer="
				+ sendung.getTransportDauer() + ")";

		return ausgabe;
	}
}
