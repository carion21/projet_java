public class lien {
    public static int pere_fils(Personne p, String id){

        p.ajouterParent(id);
        Personne pers = stockage.recupererPersonne(id);
        pers.ajouterEnfant(p.id);


        return 1;
    }
}
