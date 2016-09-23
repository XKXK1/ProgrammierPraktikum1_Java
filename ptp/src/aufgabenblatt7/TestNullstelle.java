package aufgabenblatt7;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class TestNullstelle {
	@Test
	public void Test1() {
		Nullstellen testBeispiel = new Nullstellen(6, 16, -5);
		double ergebnis;
		try {
			ergebnis = testBeispiel.newtonVerfahren(2);
			double erwartet = 0.28255;
			assertEquals(erwartet, ergebnis, 0.0001);
		} catch (Exception e) {
		}
	}

	@Test
	public void Test2() {
		List<Double> nullstellenListeTest = new ArrayList<Double>();
		double ersteStelleErwartet = -1.00;
		double zweiteStelleErwartet = 1.00;

		Nullstellen test = new Nullstellen(1, 0, -1);
		nullstellenListeTest = test.findeNullstellenRandomisiert(-5, 5, 100);
		double ersteStelle = nullstellenListeTest.get(0);
		double zweiteStelle = nullstellenListeTest.get(1);

		assertEquals(2, nullstellenListeTest.size());
		assertEquals(ersteStelleErwartet, ersteStelle, 0.0001);
		assertEquals(zweiteStelleErwartet, zweiteStelle, 0.0001);
	}
}
