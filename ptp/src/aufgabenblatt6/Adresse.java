package aufgabenblatt6;

public class Adresse {
	private String strasse;
	private int hausnr;
	private int plz;
	public Staedte ort;
	
	/**
	 * Der Konstruktur Adresse erwartet folgende Argumente:
	 * @param strasse
	 * @param hausnr
	 * @param plz
	 * @param ort
	 */
	
	public Adresse(String strasse, int hausnr, int plz, Staedte ort){
		this.strasse = strasse;
		this.hausnr = hausnr;
		this.plz = plz;
		this.ort = ort;
	}

	/**
	 * 
	 * @return
	 */
	public String getStrasse(){
		return strasse;
	}
	
	/**
	 *  Getter fuer die Variable hausnummer
	 * @return
	 */
	public int getHausnummer(){
		return hausnr;
	}
	
	/**
	 *  Getter fuer die Variable plz
	 * @return
	 */
	public int getPostleitzahl(){
		return plz;
	}
	
	/**
	 *  Getter fuer die Variable ort
	 * @return
	 */
	public Staedte getOrt(){
		return ort;
	}
	
	
	/**
	 * ein String zur Ausgabe der Variablen von einer Adresse
	 */
	public String toString(){
		String ausgabe = "Straße: " + strasse;
		ausgabe += "\nHausnummer: " + hausnr;
		ausgabe += "\nPostleitzahl: " + plz;
		ausgabe += "\nOrt: " + ort;
		return ausgabe + "\n";
		
	}
}
