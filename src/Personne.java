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

    Personne(String nom, String prenom, String sexe,String arbre, Long dateNaissance, String parent){
        this.id = genererId();
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance ;
        this.parent = parent;
        this.arbre = arbre;
    }


    Personne(String nom, String prenom, String arbre, String sexe, Long dateNaissance){

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

    @Deprecated
    public int ajouterEnfant1(String id){
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

    public int ajouterEnfant(String id){
        int reponse = 0;
        int n = this.enfants.size();
        if (n == 0){
            this.enfants.add(id);
            reponse = 1;
        }else {
            String [] ides = {};
            for (int i = 0; i < n; i++) {
                ides[i] = this.enfants.get(i);
            }

            Integer [] annees = {};
            Personne [] personnes = stockage.recupererPersonnes(ides);
            for (int i = 0; i < n; i++) {
                annees[i] = personnes[i].dateNaissance.getYear();
            }

            List<Integer> lAnnees = Arrays.asList(annees);
            List<Personne> lPersonnes = Arrays.asList(personnes);
            LinkedList<String> enfts = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                Integer [] tAnnees =  (Integer []) lAnnees.toArray();
                Personne [] tPersonnes = (Personne []) lPersonnes.toArray();
                int anneeMin = min(tAnnees);
                String idper = searchPersonneByAnnee(tPersonnes, anneeMin);
                enfts.add(idper);
                lAnnees.remove(i);
                lPersonnes.remove(i);
            }

            this.enfants = null;
            this.enfants = enfts;
            reponse = 1;
        }
        return reponse;
    }

    public int min(Integer [] integers){
        int minVal = Integer.MIN_VALUE;
        for (Integer valeur : integers) {
            if(valeur > minVal)
                minVal = valeur;
        }
        return minVal;
    }

    public String searchPersonneByAnnee(Personne [] personnes , int annee){
        String idPers = "";
        for (Personne p : personnes) {
            if (p.dateNaissance.getYear() == annee) {
                idPers = p.id;
            }
        }
        return idPers;
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
