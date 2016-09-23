package aufgabenblatt7;

/**
 * Eine Eigene Klasse fuer 2 arten von Fehlern bei der NullstellenException.
 */
public class NullstellenException extends Exception {

	/**
	 * Der Konstruktor erwartet als Argument einen Fehler aus dem Enum Fehlertypen. 
	 * Je nachdem welcher Fehler vorkommt, gibt er dem Nutzer die dazugehoerige Rueckmeldung.
	 */
	public NullstellenException(Fehlertypen fehler) {
		super();
		if(fehler==Fehlertypen.DIVISIONDURCHNULL){
			System.out.println("Division durch 0\n");
		}else if(fehler==Fehlertypen.KEINEKONVERGENZ){
			System.out.println("Fehler: Keine Konvergenz\nAbbruch des Programms wird initialisiert");
		}
		else{
			System.out.println("Unbekannter Fehler");
		}		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -5227986757424771222L;

}