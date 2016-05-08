package aufgabenblatt5Eisenbahn;

public class Zug {
	private Lokomotive lok;
	private int kapazitaet;
	private int laenge;
	private int anzahlWagen;

	public Zug(Lokomotive lok) {
		this.lok = lok;
		anzahlWagen = 0;
	}

	public void wagenHinzufuegen(Wagen wagen) {
		if (anzahlWagen == 0) {
			lok.setErsterWagen(wagen);
		} else {
			findeLetztenWagen().setNaechsterWagen(wagen);
		}
		anzahlWagen++;

	}

	public Wagen erstenWagenEntfernen() {
		if (anzahlWagen > 0) {
			Wagen alterWagen = lok.getErsterWagen();
			lok.setErsterWagen(lok.getErsterWagen().getnaechsterWagen());
			anzahlWagen--;
			return alterWagen;
		}
		return null;
	}

	public void zugAnhaengen(Zug naechsterZug) {
		if (naechsterZug.getWagenAnzahl() > 0) {
			Wagen letzterWagen = findeLetztenWagen();
			letzterWagen.setNaechsterWagen(naechsterZug.lok.getErsterWagen());
		}
	}

	public int getWagenAnzahl() {
		return anzahlWagen;
	}

	public int getKapazitaet() {
		kapazitaet = 0;
		Wagen naechsterWagen = lok.getErsterWagen();
		Wagen letzterWagen = lok.getErsterWagen();
		if (anzahlWagen > 0) {
			do {
				letzterWagen = naechsterWagen;
				naechsterWagen = naechsterWagen.getnaechsterWagen();
				kapazitaet += letzterWagen.getKapazitaet();
			} while (naechsterWagen != null);
		}

		return kapazitaet;
	}

	public Wagen findeLetztenWagen() {
		Wagen naechsterWagen = lok.getErsterWagen();
		Wagen letzterWagen = lok.getErsterWagen();
		if (anzahlWagen > 1) {
			do {
				letzterWagen = naechsterWagen;
				naechsterWagen = naechsterWagen.getnaechsterWagen();
			} while (naechsterWagen != null);
		}
		return letzterWagen;
	}

	public int getLaenge() {
		laenge = 0;
		laenge += lok.getLaenge();
		Wagen naechsterWagen = lok.getErsterWagen();
		Wagen letzterWagen = lok.getErsterWagen();
		if (anzahlWagen > 0) {
			do {
				letzterWagen = naechsterWagen;
				naechsterWagen = naechsterWagen.getnaechsterWagen();
				laenge += letzterWagen.getLaenge();
			} while (naechsterWagen != null);
		}

		return laenge;
	}

	public String toString() {
		String ausgabeString;
		ausgabeString = "Loktyp: " + lok.getTyp();
		ausgabeString += "\nAnzahl Wagen: " + this.getWagenAnzahl();
		ausgabeString += "\nGesamtlaenge: " + getLaenge();
		ausgabeString += "\nPersonenkapazitaet: " + getKapazitaet();

		Wagen wagen = lok.getErsterWagen();
		int i = 1;
		while (wagen != null) {
			ausgabeString += "\n" + i + ". Wagen: ";
			ausgabeString += "\nSeriennummer: " + wagen.getSeriennummer();
			ausgabeString += "\nWagenlaenge: " + wagen.getLaenge();
			ausgabeString += "\nPassagierkapazitaet: " + wagen.getKapazitaet();

			wagen = wagen.getnaechsterWagen();
			i++;
		}
		return ausgabeString;

	}
	// comment
}