package glaces;
import geometrie.Point ;
import java.util.Random;
import java.util.Scanner;
import glaces.Iceberg2D;
import glaces.Pingouin;
import glaces.Ocean;
import glaces.ArcticImage;

public class Jeu {

    private Ocean	ocean;
    private Pingouin	pinguin;
    private int[][]	map;
    private int		width;
    private int		height;
    private ArcticImage	ai;

    public Jeu() {
	width = 500;
	height = 500;
	ocean = new Ocean(width, height);
	pinguin = new Pingouin();
	map = new int[height][width];
	ai = new ArcticImage(width, height);
	display();
    }

    public void display() {
	Iceberg2D[] icebergs = ocean.getIceberg();
	Point hd, bg;
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
		map[j][i] = 0 ;
            }
        }
	for (int k = 0; k < ocean.getCompte(); ++k) {
	    hd = icebergs[k].coinEnHautADroite();
	    bg = icebergs[k].coinEnBasAGauche();
	    for (int i = (int) bg.getAbscisse(); i < (int) hd.getAbscisse(); ++i) {
		for (int j = (int) bg.getOrdonnee(); j < (int) hd.getOrdonnee(); ++j) {
		    map[j][i] = 1;
		}
	    }
	}
	map[height - 1][width -1] = 2;
	Point pPos = pinguin.getPosition();
	for (int i = (int) pPos.getOrdonnee(); i < pPos.getOrdonnee() + pinguin.getHauteur(); ++i) {
	    for (int j = (int) pPos.getAbscisse(); j < pPos.getAbscisse() + pinguin.getLargeur(); ++j) {
		map[j][i] = 2;
	    }
	}
	ai.setColors(map);
    }
   

    public void jouer() {
	boolean end = false;

	Scanner sc = new Scanner(System.in);
	while (!end) {
	    System.out.println("Appuyez sur Q Z D X pour bouger");
	    display();
	    switch (sc.next().charAt(0)) {
	    case 'z':
		System.out.println("You pressed Z");
		pinguin.moveUp(width, height);
		break;
	    case 'q':
		System.out.println("You pressed Q");
		pinguin.moveLeft(width, height);
		break;
	    case 'd':
		System.out.println("You pressed D");
		pinguin.moveRight(width, height);
		break;
	    case 'x':
		System.out.println("You pressed X");
		pinguin.moveDown(width, height);
		break;
	    default:
		break;
	    }
	}
    }

    public static void main(String[] args) {
	Jeu jeu = new Jeu();
	jeu.jouer();
    }
}
