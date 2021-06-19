import java.io.Serializable;
import java.util.*;
public class arbre implements Serializable {

    public String id;
    public String label;

    arbre(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Création d'un arbre généalogique");
        System.out.println("Famille: ");
        label = sc.nextLine();
        id = genererId(1000, 9999);
    }
    // fonction de genération d'un code unique pour l'arbre
    public String genererId(int binf, int bsup){
        Random random = new Random();
        id = String.valueOf(random.nextInt(bsup-binf));
        return id;
    }

    public static void main(String[] args) {

    }

}
