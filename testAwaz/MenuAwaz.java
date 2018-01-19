package testAwaz;

import awaz.Awaz;
import awaz.AwazImage;
import java.util.Scanner;

public class MenuAwaz {
    public static void main(String[] args) {
        Awaz melodie = new Awaz();
	String str;
	boolean end = false;
	while (!end) {
	    System.out.println("\t\tApplication interactive");
	    System.out.println("1. Nouvelle mélodie");
	    System.out.println("2. Ajouter une note");
	    System.out.println("3. Fixer le titre de la mélodie");
	    System.out.println("4. Créer une mélodie à partir d'un fichier");
	    System.out.println("5. Afficher la mélodie");
	    System.out.println("6. Transposer la mélodie");
	    System.out.println("7. Enregistrer la mélodie");
	    System.out.println("8. Nombre de note de la mélodie");
	    System.out.println("9. Afficher le titre de la mélodie");
	    System.out.println("10. Afficher une note");
	    System.out.println("11. Est-ce que la mélodie est vide ?");
	    System.out.println("12. Quitter le menu");
	    Scanner sc = new Scanner(System.in);
	    
	    switch (sc.nextInt()) {
	    case 1:
		break;
	    case 2:
		System.out.println("Quelle note voulez-vous ajouter ? (Do Do# Ré Ré# Mi Fa Fa# Sol Sol# La La# Si)");
		str = sc.next(); 
		melodie.add(str);
		break;
	    case 3:
		System.out.println("Quel titre voulez-vous donner à votre mélodie?");
		str = sc.next();
		melodie.setTitre(str);
		break;
	    case 4:
		System.out.println("Quel est le nom du fichier où est stockée la mélodie?");
		str = sc.next();
		melodie.ouvrir(str);
		break;
	    case 5:
		System.out.println("\t\tAffichage de la mélodie");
		System.out.println("1. Au format ABC");
		System.out.println("2. Au format chaine de caractère");
		System.out.println("3. En partition");
		switch (sc.nextInt()) {
		case 1:
		    System.out.println(melodie.toABC());
		    break;
		case 2:
		    System.out.println(melodie.toString());
		    break;
		case 3:
		    AwazImage image = new AwazImage();
		    image.setMelodie(melodie.toABC());
		    image.setTitre(melodie.getTitre());
		    break;
		default:
		    System.out.println("Erreur");
		    break;
		}
		break;
	    case 6:
		System.out.println("De combien de demi-ton voulez vous transposer la mélodie?");
		melodie.transposer(sc.nextInt());
		break;
	    case 7:
		System.out.println("Quel est le nom du fichier dans lequel vous voulez sauvegarder la mélodie?");
		str = sc.next();
		melodie.enregistrer(str);
		break;
	    case 8:
		System.out.println("Nombre de notes :" + melodie.nbNotes());
		break;
	    case 10:
		int n;
		System.out.println("Quelle note voulez vous afficher?");
		n = sc.nextInt();
		System.out.println"note n°"+ n +" de la mélodie :" + melodie.ieme(n));
		break;
	    case 11:
		System.out.println((melodie.estVide()) ? "La mélodie est vide" : "La mélodie n'est pas vide" );
		break;
	    case 12:
		end = true;
		break;
	    default:
		System.out.println("erreur");
		break;
	    }
	}
    }
}
