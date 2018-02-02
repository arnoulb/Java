package glaces.tests;
import glaces.ArcticImage;
    
public class TestArcticImage {
    public static void main (String[] a) {
	genMap();
    }
    private static void genMap()
    {
	int[][] tab = new int[300][300];
	for (int i = 0; i < 300; ++i) {
	    for (int j = 0; j < 300; ++j) {
		tab[i][j] = (j % 2 == 0) ? 0 : 1 ;
	    }
	}
	ArcticImage ai = new ArcticImage(300, 300);
	ai.setColors(tab);
    }
}
