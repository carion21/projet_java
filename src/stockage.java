import java.io.*;
import java.io.File;
import java.util.*;

/**
 * Classe Stockage
 */
public class stockage {

    stockage() {
        File rep = new File("data/arbres");
        File rep1 = new File("data/personnes");
        if(!(rep.exists())) {
            rep.mkdir();
        }
        if(!(rep1.exists())) {
            rep1.mkdir();
        }


    }
    public static String search_file(String id){
        File dir = new File("data/personnes") ;
        String [] liste =  dir.list();
        String path="";
        for(String c:liste){
            if(c.matches("."+id+".")){
                path = c;
            }
        }
        return path;
    }
    //lever les erreurs
    public static int stockerArbre(arbre a)  {
        try{
            String filename = "data/arbres/"+a.id+".dat";
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(a);
            oos.close();
            fos.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
     return 1;
    }
    public static int stockerPersonne(Personne personne) {
        try {
            String filename = "data/personnes/"+personne.arbre+"."+personne.id + ".dat";

            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(personne);

            fos.close();
            oos.close();

            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static Personne recupererPersonne(String id) {

        String filename = search_file(id);
        Personne personne = new Personne();
        if (!(filename.equals(""))) {
            try {
                FileInputStream fis = new FileInputStream(filename);
                ObjectInputStream ois = new ObjectInputStream(fis);
                personne = (Personne) ois.readObject();
                fis.close();
                ois.close();

            } catch (Exception e) {
                System.out.println(e);
                return null;
            }
        }
        return personne;
        }

    public int stockerPersonnes(Personne [] personnes) {
        int confirmation = 1;

        for (Personne personne : personnes) {
            int confirmation_locale = stockerPersonne(personne);

            if (confirmation_locale == 0) {
                confirmation = confirmation_locale;
                break;
            }
        }

        return confirmation;
    }

    public static Personne [] recupererPersonnes(String [] ids) {
        Personne [] personnes = {};
        for (int i = 0; i < ids.length; i++) {
            String id = ids[i];
            Personne personne = recupererPersonne(id);
            personnes[i] = personne;
        }
        return personnes;
    }
}

