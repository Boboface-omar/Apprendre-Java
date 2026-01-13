// Creation de la classe livre

public class Livre {

        // Declaration des Variables
        String titre;
        String auteur;
        int pages;
        boolean dispo;
 
        // // 🏗️ Le Constructeur
        public Livre(String titre, String auteur, int pages) {
                this.titre = titre;
                this.auteur = auteur;
                this.pages = pages;
                this.dispo = true; // Par défaut, un livre neuf est toujours disponible !
        }

        // Les Méthodes (Les Actions)
        public void afficherInfos() {
                System.out.println("--- Fiche Livre ---");
                System.out.println("Titre : " + titre); // Ici, pas besoin de 'bouquin.titre', car on EST dans le livre
                System.out.println("Auteur : " + auteur);
                System.out.println("Pages : " + pages);
                System.out.println("-------------------");
        }
}