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
		System.out.print("                       1.Initialiser un arbre  ");
		System.out.print("  2.Modifier un arbre  ");
		System.out.print("  3.Consulter un arbre  ");
		System.out.println("  4.Quitter  ");
		System.out.println("\t==========================================================================================================================");
	}
	
	// fonction choix
	static int choix()
	
	{	
		System.out.print("ENTREZ UN CHOIX  : ");
		Scanner sc = new Scanner(System.in);
		
		int choix = 0;
		choix = sc.nextInt();
		return choix;
	}
	// fonction modifier
	static void afficheModif()
	{
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
			case 1 : break;
			case 2 : break;
			case 3 : break;
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

}
