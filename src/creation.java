import java.io.Console;
import java.net.InetAddress;
import java.util.Scanner;
import java.lang.String;

public class creation {

    public static void creation_arbre(){
        Scanner sc = new Scanner(System.in);

        System.out.println("\t\t CREATION D'UN ARBRE GENEALOGIQUE");
        System.out.println("Famille: ");
        String label = sc.nextLine();


        arbre a = new arbre(label);


        System.out.println();
        System.out.println("\n");
        System.out.println("\t\t CREATION DE LA PERSONNE RACINE");
        System.out.println("nom: ");
        String nom = sc.nextLine();
        System.out.println("prenom: ");
        String prenom = sc.nextLine();
        System.out.println("Sexe: ");
        String  sexe = sc.nextLine();
        System.out.println("Année de naissance: ");
        Long naissance = sc.nextLong();
        Personne p = new Personne(nom, prenom, a.id, sexe, naissance);
        System.out.println(p.nom+""+p.prenom);

        a.racine = p.id;
        System.out.println(a.id);
        System.out.println(a.racine);
        System.out.println(p.id);
        stockage.stockerArbre(a);
        stockage.stockerPersonne(p);
        //return a.id;
    }
    public static void creation_personne(String id){
        arbre a = stockage.recupererArbre(id);
        Personne p = stockage.recupererPersonne(a.racine);
        Scanner sc = new Scanner(System.in);
        System.out.println("CREATION d'UNE PERSONNE");
        System.out.println("nom: ");
        String nom = sc.nextLine();
        System.out.println("prenom: ");
        String prenom = sc.nextLine();
        System.out.println("Sexe: ");
        String  sexe = sc.nextLine();
        System.out.println("Année de naissance: ");
        Long naissance = sc.nextLong();
        while (naissance < p.dateNaissance){
            System.out.println("Erreur! Cette personne est plus agée que son ancêtre");
            System.out.println("Entrez une année supérieure à "+p.dateNaissance);
            naissance = sc.nextLong();
        }
        Personne pers = new Personne(nom, prenom, id, sexe, naissance);
        System.out.println("Voulez-vous ajouter un parent?(O/N) ");
        String choix = sc.nextLine();
        if(choix.equals("O") ){
           String id_parent = listing.liste_personne(id);
            lien.pere_fils(pers,id_parent);
        }
        stockage.stockerPersonne(pers);
        //return p.id;

    }

    public static void main(String[] args) {
        stockage ss = new stockage();
        creation_arbre();
        creation_personne("357");

    }
}
