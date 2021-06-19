import java.util.Scanner;

public class Menu {
	
	
	public static void main(String[] args) {
	
	int monChoix;
	// Menu Accueil
	MenuClass.afficherAcc();
	
	   while(true)
	   {
		   monChoix = MenuClass.choix();
		   switch(monChoix)
		   {
				case 1 :break;
				case 2 : 
				{	// Menu Modifier Arbre
					MenuClass.afficheModif();
					
				}
				
				case 3 : 
					// Menu afficher Arbre
					MenuClass.afficherCons();
					
				break;
				case 4: 
					System.exit(0);
					break;
				default :
					System.out.println("Veuillez entrez un nombre entre 1-4");	
		   }  
	   }
	   
	}
	
	}


