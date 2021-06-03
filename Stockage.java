import java.io.*;
import java.util.*;

/**
 * Classe Stockage
 */
public class Stockage {

    Stockage() {}

    public int stockerPersonne(Personne personne) {
        try {
            String filename = "./personne/"+personne.id + ".dat";

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

    public Personne recupererPersonne(String id) {
        try {
            String filename = "./personne/"+id + ".dat";

            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Personne personne = (Personne) ois.readObject();

            fis.close();
            ois.close();

            return personne;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
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

    public Personne [] recupererPersonnes(String [] ids) {
        Personne [] personnes = {};
        for (int i = 0; i < ids.length; i++) {
            String id = ids[i];
            Personne personne = recupererPersonne(id);
            personnes[i] = personne;
        }
        return personnes;
    }
}
