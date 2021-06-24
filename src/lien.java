import java.util.ArrayList;
import java.util.Scanner;

public class lien {


    public static void pere_fils(Personne p, String id){

        p.ajouterParent(id);
        Personne pers = stockage.recupererPersonne(id);
        pers.ajouterEnfant(p.id);
    }

    public static void fils_pere(Personne p, String id){
        p.ajouterEnfant(id);
        Personne pers = stockage.recupererPersonne(id);
        pers.ajouterParent(p.id);
    }

    public  static void frere(Personne p, String id){
        p.ajouterFratrie(id);
        Personne pers = stockage.recupererPersonne(id);
        pers.ajouterFratrie(p.id);
    }
    public static void edit_lien(String id ){ //id arbre
        Scanner sc = new Scanner(System.in);
        listing.liste_personne(id);
        String [] type = {"1. lien pere-fils", "2. lien fils-pere", "3. lien frere-frere"};
        for(String i: type){
            System.out.print(i+"\t");
        }
        System.out.println("");
        int c = MenuClass.choix();
        switch (c){
            case 1: {
                System.out.println("Entrer l'ID du fils: ");
                String filsid = sc.nextLine();
                Personne fils = stockage.recupererPersonne(filsid);
                System.out.println("Entrer l'ID du pere: ");
                String pereid = sc.nextLine();
                pere_fils(fils, pereid);
                break;
            }
            case 2:{
                System.out.println("Entrer l'ID du fils: ");
                String filsid = sc.nextLine();

                System.out.println("Entrer l'ID du pere: ");
                String pereid = sc.nextLine();
                Personne pere = stockage.recupererPersonne(pereid);
                pere_fils(pere, filsid);
                break;
            }

            case 3:{
                System.out.println("Entrer l'ID de la personne 1: ");
                String frere1id = sc.nextLine();

                System.out.println("Entrer l'ID de la personne 2: ");
                String frere2id = sc.nextLine();
                Personne frere1 = stockage.recupererPersonne(frere1id);
                pere_fils(frere1, frere2id);
            }
        }


    }

}
