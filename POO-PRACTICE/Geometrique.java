import java.util.ArrayList;
import java.util.List;

public class Geometrique {
    public static void main(String[] args) {
        System.out.println("=== PROGRAMME FORMES GÉOMÉTRIQUES ===\n");
        
        try {
            // 1. Création d'un tableau (Liste) de Formes
            List<Forme> formes = new ArrayList<>();
            
            // ⚠️ On ne peut PAS faire: new Forme() car Forme est abstraite
            // Mais on peut créer ses sous-classes :
            
            formes.add(new Rectangle("Rouge", 5.0, 3.0));
            formes.add(new Cercle("Bleu", 2.5));
            formes.add(new Carre("Vert", 4.0));
            formes.add(new Rectangle("Jaune", 6.0, 2.0));
            formes.add(new Cercle("Noir", 3.0));
            
            // 2. Afficher chaque forme
            System.out.println("=== Liste des Formes ===");
            for (Forme forme : formes) {
                // ⚠️ Polymorphisme : chaque forme utilise sa propre méthode
                System.out.println(forme);  // Appelle toString() approprié
                forme.afficherInfo();       // Appelle afficherInfo() de Forme
            }
            
            // 3. Calculer l'aire totale
            System.out.println("\n=== Calcul de l'aire totale ===");
            double aireTotale = 0;
            for (Forme forme : formes) {
                aireTotale += forme.calculerAire();  // ⚠️ Polymorphisme !
            }
            System.out.printf("Aire totale de toutes les formes : %.2f\n", aireTotale);
            
            // 4. Statistiques
            System.out.println("\n=== Statistiques ===");
            int nbRectangles = 0;
            int nbCercles = 0;
            int nbCarres = 0;
            
            for (Forme forme : formes) {
                // ⚠️ instanceof pour connaître le type réel
                if (forme instanceof Carre) {
                    nbCarres++;
                } else if (forme instanceof Rectangle) {
                    nbRectangles++;
                } else if (forme instanceof Cercle) {
                    nbCercles++;
                }
            }
            
            System.out.println("Nombre de rectangles : " + nbRectangles);
            System.out.println("Nombre de cercles : " + nbCercles);
            System.out.println("Nombre de carrés : " + nbCarres);
            
            // 5. Test spécifique avec un carré
            System.out.println("\n=== Test Carré ===");
            Carre monCarre = new Carre("Orange", 5.0);
            System.out.println("Côté initial : " + monCarre.getCote());
            System.out.println("Aire initiale : " + monCarre.calculerAire());
            
            // Modification
            monCarre.setCote(7.0);
            System.out.println("Nouveau côté : " + monCarre.getCote());
            System.out.println("Nouvelle aire : " + monCarre.calculerAire());
            
            // 6. Tests de validation
            System.out.println("\n=== Tests de Validation ===");
            try {
                new Rectangle("", 5, 3);  // Couleur vide
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur attendue : " + e.getMessage());
            }
            
            try {
                new Cercle("Bleu", -2);  // Rayon négatif
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur attendue : " + e.getMessage());
            }
            
        } catch (Exception e) {
            System.out.println("Erreur inattendue : " + e.getMessage());
            e.printStackTrace();
        }
    }
}