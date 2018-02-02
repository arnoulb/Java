package glaces;
import geometrie.Point ;
import glaces.Iceberg2D;
import java.util.Random;

public class Ocean {

    private Iceberg2D[] icebergs;
    private int nbIceberg;
    private int largeur;
    private int hauteur;
    
    public Ocean(int width, int heigh) {
	hauteur = heigh;
	largeur = width;

	nbIceberg = 2;
	icebergs = new Iceberg2D[nbIceberg];

	Random rand = new Random();
	int x1, x2, y1, y2;
	for (int i = 0; i < nbIceberg; ++i) {
	    x1 = rand.nextInt(largeur);
	    y1 = rand.nextInt(hauteur);
	    x2 = x1 + rand.nextInt(largeur - x1);
	    y2 = y1 + rand.nextInt(hauteur - y1);
	    icebergs[i] = new Iceberg2D(new Point(x1, y1), new Point(x2, y2));
	}
    }
    
    public Iceberg2D[] getIceberg(){
	return (this.icebergs);
    }

    public int getHauteur(){
	return (this.hauteur);
    }

    public int getLargeur(){
	return (this.largeur);
    }

    public int getCompte() {
	return (this.icebergs.length());
    }

    public void fondre (double fr){
	for (int i = 0; i < nbIceberg; ++i) {
	    icebergs[i].fondre(fr);
	}
    }

    public void displayIceberg() {
	for (int i = 0; i < nbIceberg; ++i) {
	    System.out.println("Iceberg n" + i);
	    System.out.println(icebergs[i].toString());
	}
    }

    public static void main(String[] args) {
	Ocean o = new Ocean(100, 100);
	o.displayIceberg();
    }
}
