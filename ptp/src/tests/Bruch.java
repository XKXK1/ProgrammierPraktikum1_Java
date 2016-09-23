package tests;

/**
 * Ein Bruch besteht aus einem Zähler und einem Nenner.
 */
class Bruch {

  int zaehler;
  int nenner;
  void print() {
    System.out.format("%d/%d\n", zaehler, nenner);
  }

 
  void initialisiere(int zaehler, int nenner) {
    this.zaehler = zaehler;
    this.nenner = nenner;
  }

 
  void initialisiere(int wert) {
    this.zaehler = wert;
    this.nenner = 1;
  }

  /**
   * Vereinfache den Bruch soweit möglich (durch Division durch den GGT).
   */
  void vereinfache() {
    int ggt = berechneGgt(zaehler, nenner);
    zaehler /= ggt;
    nenner /= ggt;
  }

  /**
   * Erweiterung des Bruches um einen Faktor (Multiplikation von Zaehler und
   * Nenner).
   */
  void erweitere(int faktor) {
    zaehler *= faktor;
    nenner *= faktor;
  }

  /**
   * Berechnet den GGT (größten gemeinsamen Teiler) zweier Zahlen mit dem
   * Algorithmus von Euklid. Liefert das Ergebnis zurück.
   */
  int berechneGgt(int zahl1, int zahl2) {
    // Sicherstellung, dass beide Zahlen positiv sind
    zahl1 = Math.abs(zahl1);
    zahl2 = Math.abs(zahl2);

    // Algorithmus von Euklid
    int ergebnis = 0;
    if (zahl1 == 0) {
      ergebnis = zahl2;
    } else {
      while (zahl2 != 0) {
        if (zahl1 > zahl2) {
          zahl1 = zahl1 - zahl2;
        } else {
          zahl2 = zahl2 - zahl1;
        }
      }
      ergebnis = zahl1;
    }
    return ergebnis;
  }

  /**
   * Addiere zweiten Bruch zum this-Objekt, speichere Ergebnis im this-Objekt.
   */
  void addiereDazu(Bruch andererBruch) {
    zaehler = zaehler * andererBruch.nenner + andererBruch.zaehler * nenner;
    nenner = nenner * andererBruch.nenner;
    vereinfache();
  }

  /**
   * Liefert den (Fließkomma-)Wert des Bruches.
   */
  double getWert() {
    return (double) zaehler / (double) nenner;
  }

  /**
   * Verdoppelt den Wert des Bruchs (Verdopplung des Zählers).
   */
  void verdopple() {
    zaehler *= 2;
  }

  /**
   * Subtrahiere zweiten Bruch vom this-Objekt, speichere Ergebnis im
   * this-Objekt.
   */
  void subtrahiereDavon(Bruch andererBruch) {
    zaehler = zaehler * andererBruch.nenner - andererBruch.zaehler * nenner;
    nenner = nenner * andererBruch.nenner;
    vereinfache();
  }

  /**
   * Prädikat, das wahr liefert, wenn der Bruch einen kleinern Wert hat, als der
   * Bruch, der sich aus den Parametern ergibt.
   */
  boolean istKleiner(int zaehler, int nenner) {
    return getWert() < (double) zaehler / (double) nenner;
  }

  /**
   * Prädikat, das wahr liefert, wenn der Bruch einen kleineren Wert hat, als
   * die Parameter-Zahl.
   */
  boolean istKleiner(int zahl) {
    return istKleiner(zahl, 1);
  }

}
