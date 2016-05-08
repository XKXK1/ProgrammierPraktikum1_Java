package aufgabenblatt5Eisenbahn;

public class LokomotiveTest {

	public static void main(String[] args) {

		Zug zug1 = new Zug(new Lokomotive(5, 1));

		zug1.wagenHinzufuegen(new Wagen(10, 18));
		zug1.wagenHinzufuegen(new Wagen(10, 18));
		zug1.wagenHinzufuegen(new Wagen(10, 18));
		zug1.wagenHinzufuegen(new Wagen(10, 18));
		zug1.erstenWagenEntfernen();

		Zug zug2 = new Zug(new Lokomotive(10, 2));

		zug2.wagenHinzufuegen(new Wagen(10, 18));
		zug2.wagenHinzufuegen(new Wagen(10, 18));
		zug2.wagenHinzufuegen(new Wagen(10, 18));
		zug2.wagenHinzufuegen(new Wagen(10, 18));
		zug2.erstenWagenEntfernen();

		zug1.zugAnhaengen(zug2);

		System.out.println(zug1.toString());

	}

}