package glaces;
import geometrie.Point ;

/**
 * Un iceberg rectangulaire
 * @author Martine Gautier, Université de Lorraine
 * @version Février 2014
 */
public class Iceberg2D {

    private Point enBasAGauche ;
    private Point enHautADroite ;
    
    /**
     * @param g le coin en bas à gauche
     * @param d le coin en haut à droite
     * uniquement en coordonnées positives
     */
    public Iceberg2D(Point g, Point d) {
	enBasAGauche = g;
	enHautADroite = d;
    }
    
    /** Construction par fusion de deux icebergs qui se touchent
     * @param i1
     * @param i2 
     */
    public Iceberg2D(Iceberg2D i1, Iceberg2D i2) {
         // A compléter
    }
    
    /**
     * @return le coin en bas à gauche
     */
    public Point coinEnBasAGauche() {
        return enBasAGauche ;
    }
    
    /**
     * @return le coin en haut à droite
     */
    public Point coinEnHautADroite() {
        return enHautADroite ;
    }
    
    
    /**
     * @return hauteur
     */
    public double hauteur() {
	double hauteur;
	hauteur = enBasAGauche.getOrdonnee() - enHautADroite.getOrdonnee();
	return (hauteur < 0) ? -hauteur : hauteur;
    }
    
    /**
     * @return largeur
     */
    public double largeur() {
	double largeur;
	largeur = enBasAGauche.getAbscisse() - enHautADroite.getAbscisse();
        return (largeur < 0) ? -largeur : largeur;
    }
    
    /**
     * @return surface totale
     */
    public double surface() {
	double surface;
	surface = this.hauteur() * this.largeur();
        return surface;
    }
    
    /**
     * @param i
     * @return vrai si collision entre les deux icebergs
     */
    public boolean collision(Iceberg2D i) {
	Point ig = i.coinEnBasAGauche();
	Point id = i.coinEnHautADroite(); 

	if (id.getAbscisse() == enHautADroite.getAbscisse() 
	    || id.getAbscisse() == enBasAGauche.getAbscisse()
	    || ig.getAbscisse() == enHautADroite.getAbscisse() 
	    || ig.getAbscisse() == enBasAGauche.getAbscisse()
	    || id.getOrdonnee() == enHautADroite.getOrdonnee() 
	    || id.getOrdonnee() == enBasAGauche.getOrdonnee()
	    || ig.getOrdonnee() == enHautADroite.getOrdonnee() 
	    || ig.getOrdonnee() == enBasAGauche.getOrdonnee()
	    )
	    return true;
	return false ;
    }
    
    /**
     * @param i
     * @return vrai si this est plus volumineux que i
     */
    public boolean estPlusGrosQue(Iceberg2D i) {
        return (this.surface() > i.surface()) ;
    }
    
    public String toString() {
	String str = "Point en bas a gauche  : [x : " + enBasAGauche.getAbscisse() + " || y : " + enBasAGauche.getOrdonnee() + "]\n";
	str += "Point en haut a droite : [x : " + enHautADroite.getAbscisse() + " || y : " + enHautADroite.getOrdonnee() + "]";
	return str;
    }
    
    /**
     * @return le point au centre de l'iceberg
     */
    public Point centre() {
	double x, y;
	x = (enHautADroite.getAbscisse() - enBasAGauche.getAbscisse()) / 2;
	y = (enHautADroite.getOrdonnee() - enBasAGauche.getOrdonnee()) / 2;
	Point p = new Point(x, y);

	return p ;
    }
    
    /** Réduction dans les quatre directions ; le centre ne bouge pas
     * @param fr dans ]0..1[ facteur de réduction
     */ 
    public void fondre(double fr) {
	double largeur = this.largeur() * (fr / 2);
	double hauteur = this.hauteur() * (fr / 2);
	Point orig = this.centre();
	Point hd = new Point(orig.getAbscisse() + (largeur / 2), orig.getOrdonnee() + (hauteur / 2));
	Point bg = new Point(orig.getAbscisse() - (largeur / 2), orig.getOrdonnee() - (hauteur / 2));
    }
    
    /**
     * Casser une partie à droite
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void casserDroite(double fr) {
	Point p1 = new Point((this.largeur() * fr) + enBasAGauche.getAbscisse(), enHautADroite.getOrdonnee());
	enHautADroite = new Point(p1);
    }
    
    /**
     * Casser une partie à gauche
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void casserGauche(double fr) {
	Point p1 = new Point(enHautADroite.getAbscisse() - (this.largeur() * fr), enBasAGauche.getOrdonnee());
	enBasAGauche = new Point(p1);
    }
    
    /**
     * Casser une partie en haut
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void casserHaut(double fr) {
	Point p1 = new Point(enHautADroite.getAbscisse(), (this.hauteur() * fr) + enBasAGauche.getOrdonnee());
	enHautADroite = new Point(p1);
    }
    
   /**
     * Casser une partie en bas
     * @param fr dans ]0..1[ : définit le pourcentage supprimé
     */
    public void casserBas(double fr) {
	Point p1 = new Point(enBasAGauche.getAbscisse(), enHautADroite.getOrdonnee() - (this.hauteur() * fr));
	enBasAGauche = new Point(p1);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // A compléter
	System.out.println("Bienvenue dans Iceberg2D");
	Iceberg2D i1 = new Iceberg2D(new Point(0, 0), new Point(10, 10));
	Iceberg2D i2 = new Iceberg2D(new Point(0, 5), new Point(10, 10));
	System.out.print("Point en bas a gauche : ");
	System.out.println("[x : " + i1.coinEnBasAGauche().getAbscisse() + " || y : " + i1.coinEnBasAGauche().getOrdonnee() + "]");
	System.out.print("Point en haut a droite : ");
	System.out.println("[x : " + i1.coinEnHautADroite().getAbscisse() + " || y : " + i1.coinEnHautADroite().getOrdonnee() + "]");
	System.out.print("To string : ");
	System.out.println(i1.toString());
	System.out.print("Largeur : ");
	System.out.println(i1.largeur());
	System.out.print("Hauteur : ");
	System.out.println(i1.hauteur());
	System.out.print("Surface : ");
	System.out.println(i1.surface());
	System.out.print("Plus gros que i2 : ");
	System.out.println(i1.estPlusGrosQue(i2));
	System.out.print("Point centre : ");
	System.out.println("[x : " + i1.centre().getAbscisse() + " || y : " + i1.centre().getOrdonnee() + "]");
	System.out.print("Colision : ");
	System.out.println(i1.collision(i2));
	i1.fondre(0.5);
	System.out.println(i1.toString());
	System.out.print("Point centre : ");
	System.out.println("[x : " + i1.centre().getAbscisse() + " || y : " + i1.centre().getOrdonnee() + "]");
    }
}
