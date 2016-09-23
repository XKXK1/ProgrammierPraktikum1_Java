package aufgabenblatt7;

public class DoubleWert{
  private Double doubleWert;
  

  /**
   * Der Konstruktor DoubleWert erwartet einen Argument des komplexen Datentyps 'Double'
   * @param wert
   */
  public DoubleWert(Double wert){
    doubleWert = wert;
  }

  @Override
  /**
   * Ueberschreiben von hashCode. Diese Methode returned nun einen auf 'int' gecasteten Double-Wert.
   * Der Wert wird mit 10000 multipliziert um ihn eindeutig vergleichbar zu machen.
   */
  public int hashCode(){
    return (int) (doubleWert * 10000);
  }
  
  @Override
  /**
   * Ueberschreiben von equals. Diese Methode erwartet ein Argument der Klasse Object.
   * Der hashCode des einen Objects wird mit einem anderen verglichen.
   */
  public boolean equals(Object anderesObject){
    if (anderesObject.hashCode()==this.hashCode()){
    return true;
    }
    else {
      return false;
    }
  }
  
  /**
   * Getter fuer die Variable doubleWert.
   */
  public double getWert(){
    return doubleWert;
  }
  
  /**
   * toString fuer den doubleWert.
   */
  public String toString(){
    return (String) doubleWert.toString();
  }
  
}
