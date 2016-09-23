package aufgabenblatt7;

/**
 * Testklasse.
 */

import java.util.ArrayList;
import java.util.List;

public class Newton {

  public static void main(String[] args){
    List<Double>nullstellenListeTest = new
        ArrayList<Double>();   
    Nullstellen test = new Nullstellen();

    nullstellenListeTest = test.findeNullstellenRandomisiert(-5, 5, 100);
    
    System.out.println(nullstellenListeTest);

  }
}
