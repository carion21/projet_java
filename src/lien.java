public class lien {
    public static void pere_fils(Personne p, String id){

        p.ajouterParent(id);
        Personne pers = stockage.recupererPersonne(id);
        pers.ajouterEnfant(p.id);
    }
}
