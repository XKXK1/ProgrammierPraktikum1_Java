package aufgabenblatt7;
/**
 * Die Klasse QuadratischeFunktion Erbt das Interface Funktionen und definiert
 * somit die Methoden zur Berechnung einer Funktion und der Ableitung einer
 * Funktion.
 *
 */
public class QuadratischeFunktion implements Funktionen {
	//Variablen fuer die Berechnung der Funktionen
	private double a;
	private double b;
	private double c;

	/**
	 * Der Konstruktor Erwartet 3 Variablen des primitiven Datentyps double.
	 * @param a
	 * @param b
	 * @param c
	 */
	public QuadratischeFunktion(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;	
	}

	@Override
	/**
	 * Methode zur Berechnung der Quadratischen Funktion 'f(x) = ax2 + bx +c' mit einer Variablen 'x'.
	 */
	public double funktion(double x) {
		return (a * (Math.pow(x, 2))) + b * (x) + c;
	}

	@Override
	/**
	 * Methode zur Berechnung der Ableitung 2ax + b mit einer Variablen 'x'.
	 */
	public double funktionAbleitung(double x) {
		return (2 * a * x) + b;
	}
}
