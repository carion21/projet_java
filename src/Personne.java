import java.io.*;
import  java.text.SimpleDateFormat;

import java.util.*;

/**
 * Classe Personne
 */
public class Personne {
    public String id;
    public String arbre;
    public String nom;
    public String prenom;
    public String sexe;
    public Date dateNaissance;
    public String parent;
    public LinkedList<String> enfants;
    public LinkedList<String> fratrie;

    Personne() {
        this.id = genererId(1000, 9999);
    }

    Personne(String nom, String prenom, String sexe,String arbre, String dateNaissance, String parent) throws Exception{

        this.id = genererId(1000, 9999);
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = new SimpleDateFormat("dd/MM/yyyy").parse(dateNaissance) ;
        this.parent = parent;
        this.arbre = arbre;
    }
    Personne(String nom, String prenom, String arbre, String sexe, String dateNaissance) throws Exception{

        this.id = genererId(1000, 9999);

        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = new SimpleDateFormat("dd/MM/yyyy").parse(dateNaissance);
        this.arbre = arbre;
    }

    public int  ajouterParent(String idParent){
        if(!(this.parent.equals(""))){
            if (stockage.recupererPersonne(idParent).dateNaissance.getYear() - dateNaissance.getYear() == 15){
                this.parent = idParent;
            }
            else return -1;
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

           if(aine.dateNaissance.getYear() > enfantadd.dateNaissance.getYear()){
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

    public String genererId(int binf, int bsup){
        Random random = new Random();
        id = String.valueOf(random.nextInt(bsup-binf));
        return id;
    }

    public static void main(String[] args) {

    }
}
