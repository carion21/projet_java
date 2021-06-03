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
    }

    Personne(String nom, String prenom, String sexe, String dateNaissance, String parent) {
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
        Stockage stockage = new Stockage();
        int stockerPersonne = stockage.stockerPersonne(this);
    }
    

    

}
