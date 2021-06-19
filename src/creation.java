import java.net.InetAddress;
import java.util.Scanner;
import java.lang.String;

public class creation {

    public static int creation_arbre(){

        arbre a = new arbre();
        stockage.stockerArbre(a);

        return 1;
    }
    public static int creation_personne(String id){
        Scanner sc = new Scanner(System.in);
        System.out.println("CREATION d'UNE PERSONNE");
        System.out.println("nom: ");
        String nom = sc.nextLine();
        System.out.println("prenom: ");
        String prenom = sc.nextLine();
        System.out.println("Sexe: ");
        String  sexe = sc.nextLine();
        System.out.println("Date de naissance (Ex: 25/05/1996): ");
        String naissance = sc.nextLine();
        System.out.println("Voulez-vous ajouter un parent?(O/N) ");
        String choix = sc.nextLine();
        if(choix.equals("O") ){
            System.out.println("A modifier");
        }
        try{
            Personne p = new Personne(nom, prenom, id, sexe, naissance);
            stockage.stockerPersonne(p);
        }
        catch (Exception e){
            System.out.println("Format de date incorrect!!");
        }

        return 1;

    }

    public static void main(String[] args) {
        stockage ss = new stockage();
        //creation_arbre();
        creation_personne("357");

    }
}
