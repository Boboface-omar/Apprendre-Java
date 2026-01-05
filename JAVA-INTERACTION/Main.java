import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Livre> bibliotheque = new ArrayList<>();

        // On peut pré-remplir la bibliothèque pour tester plus vite
        bibliotheque.add(new Livre("Le Petit Prince", "Saint-Exupéry", 96));

        while (true) {
            System.out.println("\n--- MA BIBLIOTHÈQUE ---");
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Voir tous les livres");
            System.out.println("3. Quitter");
            System.out.print("Votre choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Consomme le retour à la ligne

            if (choix == 1) {
                System.out.print("Titre : ");
                String titre = scanner.nextLine();
                
                System.out.print("Auteur : ");
                String auteur = scanner.nextLine();
                
                System.out.print("Nombre de pages : ");
                int pages = scanner.nextInt();
                
                // On crée l'objet et on l'ajoute
                Livre nouveauLivre = new Livre(titre, auteur, pages);
                bibliotheque.add(nouveauLivre);
                
                System.out.println("✅ Livre ajouté !");
                
            } else if (choix == 2) {
                System.out.println("--- RAYON LIVRES ---");
                // Ta boucle for-each ici :
                for (Livre unLivre : bibliotheque) {
                    unLivre.afficherInfos();
                }
                
            } else if (choix == 3) {
                System.out.println("Fermeture de la bibliothèque. À bientôt !");
                break;
            } else {
                System.out.println("⚠️ Choix invalide, réessayez.");
            }
        }
    }
}