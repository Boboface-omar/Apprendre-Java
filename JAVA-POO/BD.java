// Heritage : "extends" signifie que BD récupère tout ce qu'il y a dans Livre
public class BD extends Livre {
    boolean enCouleur;

    // Le constructeur doit être un peu spécial
    public BD(String titre, String auteur, int pages, boolean enCouleur) {
        // 1. D'abord, on construit la partie "Livre" (le parent)
        super(titre, auteur, pages);

        // 2. Ensuite, on règle la partie spécifique à la "BD"
        this.enCouleur = enCouleur;
    }

    // Redéfinition (ou Overriding en anglais): Polymorphisme
    @Override
    public void afficherInfos() {
        super.afficherInfos(); // 1. On lance l'affichage standard du parent (Livre)

        System.out.println("Couleur: " + enCouleur); 
    }
}