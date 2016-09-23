/**
 * Praktikum TIPTP1, SS 2016
 * Gruppe: Daniel von Drathen,
 * Derya Uyargil
 * Aufgabe: Aufgabenblatt 6
 */

/**
 * Eine Simulation eines vereinfachten Logistikzentrums.
 * Schaetzung von Transportdauern zwischen zwei Staedten. Zwei verschieden Sendungstypen koennen erstellt werden.
 * Einmal ein Brief mit der Moeglichkeit ein Einschreiben zu veranlassen, sowie ein Paket, mit einem anzugebenden Gewicht.
 * Es sollte dabei eine vorgegebene Klasse namens GoogleSendungsSchaetzer verwendet werden, allerdings ebenfalls eine Oflinevariante implementiert werden.
*/

package aufgabenblatt6;

import aufgabenblatt6.Staedte;

public class TestPost {

	public static void main(String[] args) {

		Person Daniel = new Person("Daniel", new Adresse("Hinrichsenstrasse", 28, 20535, Staedte.HAMBURG));
		Person Derya = new Person("Derya", new Adresse("Königsallee", 28, 40212, Staedte.DUESSELDORF));

		Sendung post = new Brief(Daniel, Derya, 3, true);

		System.out.println(post.istAusgeliefert());
		System.out.println(post);

		Sendung post2 = new Paket(Daniel, Derya, 3, 40);

		System.out.println(post2.istAusgeliefert());
		System.out.println(post2);

		//Testen von istAusgeliefertOffline()
		System.out.println(post2.istAusgeliefertOffline());
		System.out.println(post2);
		post2.aktualisiereZeitpunkt(240);
		System.out.println(post2.istAusgeliefertOffline());

		Simulator sim1 = new Simulator();
		sim1.durchfuehren();
	}

}
