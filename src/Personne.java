import java.io.*;
import  java.text.SimpleDateFormat;

import java.util.*;

/**
 * Classe Personne
 */
public class Personne implements Serializable {
    public String id;
    public String arbre;
    public String nom;
    public String prenom;
    public String sexe;
    public Long dateNaissance;
    public String parent;
    public LinkedList<String> enfants;
    public LinkedList<String> fratrie;

    Personne() {
        id = null;
        arbre = null;
        nom = null;
        prenom = null;
        sexe = null;
        dateNaissance = null;
    }

    Personne(String nom, String prenom, String sexe,String arbre, Long dateNaissance, String parent) throws Exception{
        this.id = genererId();
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance ;
        this.parent = parent;
        this.arbre = arbre;
    }
    Personne(String nom, String prenom, String arbre, String sexe, Long dateNaissance) {

        this.id = genererId();

        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.arbre = arbre;

        this.dateNaissance = dateNaissance;

    }

    public int ajouterParent(String idParent){
        if(!(this.parent.equals(""))){
            if (stockage.recupererPersonne(idParent).dateNaissance - dateNaissance <12){
                System.out.println("Le parent doit avoir plus de 12 ans.");
                return -1;
            }
            this.parent = idParent;
        }
        else{
            System.out.println("Cette personne a déjà un parent");
        }
        return 1;
    }


    public int ajouterEnfant(String id){
        if (enfants.isEmpty()){
            enfants.add(id);
        }
        else {
           String aine_id = enfants.getFirst();
           Personne enfantadd = stockage.recupererPersonne(id);
           Personne aine = stockage.recupererPersonne(aine_id);

           if(aine.dateNaissance > enfantadd.dateNaissance){
               enfants.addFirst(id);
           }
           else{
               enfants.add(id);
           }

        }
        return 1;
    }

    public void ajouterFratrie(String id){
        this.fratrie.add(id);
    }
    /*
    public int genererIdentifiant(int borneInf, int borneSup){
        Random random = new Random();
        int nb;
        nb = borneInf+random.nextInt(borneSup-borneInf);
        return nb;
    }*/

    public String genererId() {
        Random rand = new Random(); //instance of random class
        int upperbound = 1000;

        String generatedString = String.valueOf(rand.nextInt(upperbound));
        return generatedString;
    }

    public static void main(String[] args) {

    }
}
