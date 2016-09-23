package aufgabenblatt6;
/**
 * 
 * Die Klasse Brief erbt von der Klasse Sendung
 *
 */
public class Brief extends Sendung {
	private boolean istEinschreiben;
//	private boolean istAusgeliefert;

	/**
	 * Der Konstrukter fuer ein Objekt der Klasse Brief erwartet folgende Argumente
	 * @param sender
	 * @param empfaenger
	 * @param startZeitpunkt, wann die Sendung abgeschickt wird
	 * @param istEinschreiben
	 */
  public Brief(Person sender, Person empfaenger, int startZeitpunkt,
      boolean istEinschreiben) {

		super(sender, empfaenger, startZeitpunkt);
		this.istEinschreiben = istEinschreiben;

	}

  /**
   * istEinschreiben erwartet ein boolean als Argument
   * falls true dann wird der Anwender aufgefordert zu unterschreiben
   * @param istEinschreiben
   */
	public void istEinschreiben(boolean istEinschreiben) {
		if (istEinschreiben) {
			System.out.println("Bitte Unterschreiben!");
		}
	}

	/**
	 * ein String zum ergaenzen der geerbten toString() Methode
	 */
	public String toString() {
		String ausgabe = super.toString();
		if (istEinschreiben) {
			ausgabe += "\nDer Brief wurde per Einschreiben verschickt.\n";
		}
		return ausgabe;
	}

}
