package aufgabenblatt6;

public enum Staedte {
	BERLIN, HAMBURG, MUENCHEN, KOELN, FRANKFURT, STUTTGART, DUESSELDORF, DORTMUND, ESSEN, BREMEN;

	/**
	 * Methode zum return einer zufaelligen Stadt 
	 * @return
	 */
	public static Staedte getZufallsStadt()
	  {
	    return values()[(int) (Math.random() * values().length)];
	  }
}
