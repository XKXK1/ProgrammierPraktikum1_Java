package Aufgabenblatt4;

public class Rennen {

	private int anzahlRennautos;
	private double streckenlaenge;
	Rennauto [] autoListe;

	// Konstruktoren
	Rennen(double streckenlaenge) {
		this.streckenlaenge = streckenlaenge;
		autoListe = new Rennauto[1];
	}

	public void addRennauto(Rennauto auto) {
		autoListe[anzahlRennautos]=auto;
		anzahlRennautos++;
		if(anzahlRennautos==autoListe.length){
			Rennauto [] hilfsListe= new Rennauto[autoListe.length*2];
			System.arraycopy(autoListe, 0, hilfsListe, 0, autoListe.length);
			autoListe = hilfsListe;
		}
	}
	



	public Rennauto ermittleSieger() {
		for (int i=0; i<anzahlRennautos; i++){
			if(autoListe[i].getStreckeBisher()>this.streckenlaenge){
				 return autoListe[i];
				 
			}
		}
		return null;
	}
	
	private void schritt(int i){
			autoListe[i].fahren();
		}
	
	public void durchfuehren(){
		while(ermittleSieger()==null){
		for (int i=0; i<anzahlRennautos; i++){
				schritt(i);
			}
		}
		ermittleSieger().ausgeben();
	}
	
	public static void main (String args[]){	
		   Rennauto auto1, auto2, auto3, auto4;
		   Wette wette1, wette2;
		   
		    auto1 = new Rennauto("Mann1", "Typ1", 200);
		    auto2 = new Rennauto("Frau1", "Typ2", 120);
		    auto3 = new Rennauto("Frau2", "Typ3", 80);
		    auto4 = new Rennauto("Mann2", "Typ1", 160);

		    Rennen autorennen = new Rennen(2000);
		    autorennen.addRennauto(auto1);
		    autorennen.addRennauto(auto2);
		    autorennen.addRennauto(auto3);
		    autorennen.addRennauto(auto4);

		    wette1 = new Wette("Mann1", 150, "Derya");
		    wette2 = new Wette("Mann2", 100, "Daniel");
  
		    Wettbuero wettbuero = new Wettbuero(autorennen, 2);
		    wettbuero.addWette(wette1);
		    wettbuero.addWette(wette2);


		    // Nun lediglich noch das rennen starten
		    autorennen.durchfuehren();
		    wettbuero.auswerten();
		
	}
}