import java.util.ArrayList; // 1. L'import indispensable

public class Main {
    public static void main(String[] args) {
        // 2. Création de la liste (le rayon vide)
        ArrayList<Livre> bibliotheque = new ArrayList<>();

        Livre bouquin = new Livre("Harry Potter", "J.K. Rowling", 300);
        BD tintin = new BD ("Tintin", "Hergé", 62, true);

        // 4. Ajout dans la liste
        bibliotheque.add(bouquin);
        bibliotheque.add(tintin);
        // Ajout direct sans variable intermédiaire
        bibliotheque.add(new Livre("Le Hobbit", "Tolkien", 300)); 

        // Petite vérification (Bonus)
        System.out.println("Ma bibliothèque contient " + bibliotheque.size() + " livres.");

        bouquin.afficherInfos();
        tintin.afficherInfos();

    }
}