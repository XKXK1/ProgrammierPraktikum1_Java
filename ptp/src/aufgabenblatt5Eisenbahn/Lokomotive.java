package aufgabenblatt5Eisenbahn;

public class Lokomotive {
	private final int laenge;
	private final int typ;
	private Wagen ersterWagen;

	public Lokomotive(int laenge, int typ) {
		this.laenge = laenge;
		this.typ = typ;
	}

	public Wagen getErsterWagen() {
		return ersterWagen;

	}

	public void setErsterWagen(Wagen ersterWagen) {
		this.ersterWagen = ersterWagen;

	}

	public int getTyp() {
		return typ;
	}

	public int getLaenge() {
		return laenge;
	}
}
// comment
//comment