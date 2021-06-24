import java.util.Scanner;

public class MenuClass {
	
	static void afficherAcc()
	{
		System.out.println("\t--------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\t|  ****************      *****************   **                     **    *****************             **                |");
		System.out.println("\t|  **                    **                  **  *                  **    **                           **  **             |");
		System.out.println("\t|  **                    **                  **    *                **    **                          **    **            |");
		System.out.println("\t|  **                    **                  **       *             **    **                         **      **           |");
		System.out.println("\t|  **                    **                  **         *           **    **                        **         **         |");
		System.out.println("\t|  **         *******    ****************    **           *         **    ****************         ***************        |");
		System.out.println("\t|  **         *     *    **                  **             *       **    **                      **             **       |");
		System.out.println("\t|  **               *    **                  **                *    **    **                     **                **     |");
		System.out.println("\t|  **               *    **                  **                  *  **    **                    **                  **    |");
		System.out.println("\t|  *****************     ******************  **                     **    ******************   **                    **   |");
		System.out.println("\t--------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\t==========================================================================================================================");
		System.out.print("                       1.Creer un arbre  ");
		System.out.print("  2.Modifier un arbre  ");
		System.out.print("  3.Consulter un arbre  ");
		System.out.println("  4.Quitter  ");
		System.out.println("\t==========================================================================================================================");
	}
	
	// fonction choix
	static int choix()
	
	{	
		System.out.print("Votre choix  : ");
		Scanner sc = new Scanner(System.in);
		
		int choix = sc.nextInt();
		return choix;
	}
	// fonction modifier
	static void afficheModif()
	{
		String id  = listing.liste_arbre();
		System.out.println("__________________________________________________________________________________________________________________________________");
		System.out.print("                1. Ajouter une personne");
		System.out.print(" 2. Editer un lien de parenter");
		System.out.print(" 3. Modifier une personne");
		System.out.print(" 4. Retour");
		System.out.println(" 5. Quiter");
		System.out.println("__________________________________________________________________________________________________________________________________");
		
		while(true)
		{
			int monChoix1 = choix();
			switch(monChoix1)
			{
			case 1 : {

				creation.creation_personne(id);
				break;
			}
			case 2 : {
				lien.edit_lien(id);
				break;
			}

			case 3 : {
				Scanner sc = new Scanner(System.in);
				listing.liste_personne(id);
				System.out.println("Entrer l'id: ");
				String id_pers = sc.nextLine();
				Personne p = stockage.recupererPersonne(id_pers);
				System.out.println("Entrer * pour les champs qui ne changent pas.");
				System.out.println("nom: ");
				String nom = sc.nextLine();
				if(nom.equals("*")){
					nom = p.nom;
				}

				System.out.println("prenoms: ");
				String prenom = sc.nextLine();
				if(prenom.equals("*")){
					prenom = p.prenom;
				}

				System.out.println("Sexe: ");
				String sexe = sc.nextLine();
				if(sexe.equals("*")){
					sexe = p.sexe;
				}
				int a = p.update(nom, prenom, sexe);
				if (a == 1){
					System.out.println("SUCCES");
				}
				break;
			}
			case 4: break;
			case 5 : 
				System.exit(0);
				break;
			default:
				System.out.println("Veuillez entrez un nombre entre 1-5");
				;
			}
		}
	}
	
	// fonction afficher consulter genealogie
	static void afficherCons()
	{
		System.out.println("__________________________________________________________________________________________________________________________________");
		System.out.println("1. Afficher Un Arbre Complet");
		System.out.println("2. Afficher Arbre d'une personne");
		System.out.println("3. Consulter la fratrie");
		System.out.println("4. Consulter les cousins");
		System.out.println("5. Consulter les enfants");
		System.out.println("6. Retour");
		System.out.println("7. Quiter");
		System.out.println("__________________________________________________________________________________________________________________________________");
		
		while(true)
		{
			int monChoix1 = choix();
			switch(monChoix1)
			{
			case 1 : break;
			case 2 : break;
			case 3 : break;
			case 4: System.out.println("cccccc"); break;
			case 5 : break;
			case 6 : break;
			case 7 : 
				System.exit(0);
				break;
			default:
				System.out.println("Veuillez entrez un nombre entre 1-7");
				;
			}
		}
	}

	static void retour_princ(){
		System.out.println("0. retour");
		int choix = choix();
		if(choix == 0){
			afficherAcc();
		}
	}
	static void effacer(){
		try {
			Runtime.getRuntime().exec("clear");
		}
		catch (Exception e){
			System.out.println("error!");
		}
	}
}
