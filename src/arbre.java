import java.io.Serializable;
import java.util.*;
public class arbre implements Serializable {

    public String id;
    public String label;
    public String racine;


    arbre(){}
    arbre(String  label, String racine){
        id = genererId();
        this.label = label;
        this.racine = racine;

    }
    arbre(String label){
        id = genererId();
        this.label = label;

    }
    // fonction de genération d'un code unique pour l'arbre
    //public String genererId(int binf, int bsup){
      //  Random random = new Random();
      //  id = String.valueOf(random.nextInt(bsup-binf));
      //  return id;
    //}
    public String genererId() {
        Random rand = new Random(); //instance of random class
        int lowerbound = 100;
        int upperbound = 10000;

        String generatedString = String.valueOf(rand.nextInt(upperbound - lowerbound)+1);
        double double_random=rand.nextDouble();
        float float_random=rand.nextFloat();


        return generatedString;
    }


    public static void main(String[] args) {

    }

}
