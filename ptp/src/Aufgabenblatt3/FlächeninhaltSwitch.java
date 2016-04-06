package Aufgabenblatt3;

import java.util.Scanner;

public class FlächeninhaltSwitch {

	public static void main(String[] args) {
		float x = -1;
		int index = -1;
		Scanner scan = new Scanner(System.in);

		System.out.println("Wählen sie eine Berechnung?\n " + "\n1 = Flächeninhalt eines Kreises "
				+ "\n2 = Flächeninhalt eines Quadrats" + "\n3 = Flächeninhalt eines Sechsecks");
		index = scan.nextInt();

		switch (index) {

		case 1: {
			System.out.println("Bitte Fliesskommazahl in cm zur Berechnung des Flächeninhalts eines Kreises");
			x = scan.nextFloat();
			System.out.println("Der Flächeninhalt des Kreises beträgt " + Math.PI * (x * x) + " cm^2");
			break;
		}
		case 2: {
			System.out.println("Bitte Fliesskommazahl in cm zur Berechnung der Seitenlänge eines Quadrats angeben");
			x = scan.nextFloat();
			System.out.println("Der Flächeninhalt des Quadrats beträgt " + x * x + " cm^2");
			break;
		}

		case 3: {
			System.out.println("Bitte Fliesskommazahl in cm zur Berechnung der Seitenlänge angeben eines Sechsecks");
			x = scan.nextFloat();
			System.out.println("Der Flächeninhalt des Quadrats beträgt " + 1.5 * (x * x) * (Math.sqrt(3)) + " cm^2");
			break;
		}
		default: {

			System.out.println("Ungültige Eingabe");

		}
			scan.close();
		}
	}
}
