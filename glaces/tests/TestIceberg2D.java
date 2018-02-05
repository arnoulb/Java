package glaces.tests;
import glaces.Iceberg2D;
import geometrie.Point;
    
public class TestIceberg2D {
    public static void main (String[] a) {
	testCasserDroite();
    }

    private static void testCasserDroite() {
	Iceberg2D i1 = new Iceberg2D(new Point(5, 5), new Point(15, 15));
	System.out.println(i1);
	i1.casserDroite(0.5);
	System.out.println(i1);
    }
}
