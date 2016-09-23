package aufgabenblatt6;

public class Sendung {
  protected Person sender;
  protected Person empfaenger;
  protected int startZeitpunkt;
  protected int transportDauer;
  protected static int sendungsnummerZaehler = 1;
  protected int sendungsNummer;
  protected static int zeitJetzt;
  protected SendungsdauerSchaetzer schaetzung = new GoogleSendungsdauerSchaetzer();
  protected SendungsdauerSchaetzer schaetzungOffline = new OfflineSendungsdauerSchaetzer();
  protected boolean istAusgeliefert;

  /**
   * Konstruktor zum erstellen einer Sendung.
   * Sendungsnummern werden hochgezaehlt
   * @param sender
   * @param empfaenger
   * @param startZeitpunkt
   */
  public Sendung(Person sender, Person empfaenger, int startZeitpunkt) {

    this.sender = sender;
    this.empfaenger = empfaenger;
    this.startZeitpunkt = startZeitpunkt;
    sendungsNummer = sendungsnummerZaehler;
    sendungsnummerZaehler++;
  }

  public int getSendungsnummer() {
    return sendungsNummer;
  }

  /**
   * transportdauer zwischen zwei Staedten wird geschaetzt und wird returned
   * @return
   */
  public int getTransportDauer() {

    transportDauer = schaetzung.getSendungsTransportDauer(
        sender.getAdresse().getOrt(), empfaenger.getAdresse().getOrt());
    return transportDauer;
  }

  /**
   * transportdauer wird aus einer Offlinetabelle bezogen und wird returned
   * @return
   */
  public int getOfflineTransportDauer() {

    transportDauer = schaetzungOffline.getSendungsTransportDauer(
        sender.getAdresse().getOrt(), empfaenger.getAdresse().getOrt());
    return transportDauer;
  }

  public int getStartZeitpunkt() {
    return startZeitpunkt;
  }

  /**
   * ein String zur Ausgabe von einer Sendung
   */
  public String toString() {
    String ausgabe;
    ausgabe = "\nAbsender: " + sender;
    ausgabe += "\nEmpfänger: " + empfaenger;
    ausgabe += "\nStart: " + startZeitpunkt;
    ausgabe += "\nDauer: " + transportDauer;
    ausgabe += "\nSendungsnummer: " + sendungsNummer;
    return ausgabe;
  }

  /**
   * Methode zur Ausgabe des Sendungsstatus 
   * @return
   */
  public boolean istAusgeliefert() {
    if (zeitJetzt >= getStartZeitpunkt() + getTransportDauer()) {
      istAusgeliefert = true;
    }
    return istAusgeliefert;
  }

  /**
   * Methode zur Ausgabe des Sendungsstatus  mit der Offlinertransportdauer
   * @return
   */
  public boolean istAusgeliefertOffline() {
    if (zeitJetzt >= getStartZeitpunkt() + getOfflineTransportDauer()) {
      istAusgeliefert = true;
    }
    return istAusgeliefert;
  }

  /**
   * Zeitpunkt wird aktualisiert
   * @param zeitpunkt
   */
  public void aktualisiereZeitpunkt(int zeitpunkt) {
    zeitJetzt = zeitpunkt;
  }
}
