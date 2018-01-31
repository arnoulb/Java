package testAwaz;

import awaz.Awaz;
import awaz.AwazImage;
import java.util.Scanner;

/**
 * Cette classe est le point de départ du Tp Awaz
 * @author martine
 * @version Janvier 2018
 */
public class MainAwaz {
    public static void save_file(Awaz melodie) {
	Scanner sc = new Scanner(System.in);
	String path;
	path = sc.next();
	melodie.enregistrer(path);
    }
    public static void main(String[] args) {
        // Création d'une mélodie vide
        Awaz melodie = new Awaz();

	melodie.add("Mi");
	melodie.add("La");
	melodie.add("Ré");
	melodie.add("Sol");
	melodie.add("Si");
	melodie.add("Mi");

	System.out.println("Notes:");
	System.out.print(melodie.toString());

	System.out.println("Nombre de notes :");
	System.out.println(melodie.nbNotes());

	System.out.println("Transposition :");
	melodie.transposer(2);

	melodie.nouveau();
	
	melodie.add("Sol");
	melodie.add("Ré");
	melodie.add("La");
	melodie.add("Mi");
	int i = -1;
	while (++i < melodie.nbNotes()){
	    System.out.print(melodie.ieme(i) + ((i < melodie.nbNotes() - 1)? " " : "\n"));
	}

	save_file(melodie);

	melodie.add("Sol");
	System.out.println(melodie.toABC());

	AwazImage image = new AwazImage();
	image.setMelodie(melodie.toABC());
	image.setTitre("test");
    }
}
