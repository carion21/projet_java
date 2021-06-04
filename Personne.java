import java.io.*;
import java.util.*;

/**
 * Classe Personne
 */
public class Personne extends Stockage implements Serializable {

    public String id;
    public String nom;
    public String prenom;
    public String sexe;
    public String dateNaissance;
    public String parent;
    public LinkedList<String> enfants;
    public LinkedList<String> fratrie;

    Personne() {
        this.id = String.valueOf(genererIdentifiant(1000, 9999));
    }

    Personne(String nom, String prenom, String sexe, String dateNaissance, String parent) {
        if (this.id == "") {
            this.id = String.valueOf(genererIdentifiant(1000, 9999));
        }
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.parent = parent;
    }

    public void ajouterParent(String idParent){
        if(this.parent != ""){
            this.parent = idParent;
        }
    }

    public void ajouterEnfant(Personne personne){

    }

    public void ajouterFratrie(Personne personne){
        this.fratrie.add(personne.id);
    }

    private int genererIdentifiant(int borneInf, int borneSup){
        Random random = new Random();
        int nb;
        nb = borneInf+random.nextInt(borneSup-borneInf);
        return nb;
     }


}
