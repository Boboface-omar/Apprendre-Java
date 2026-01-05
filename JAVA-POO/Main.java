// Creation d'objet concret = Instanciation

public class Main {
    public static void main(String[] args) {
        // 🏗️ Ajout avec Le Constructeur
        Livre bouquin = new Livre("Harry Potter", "J.K. Rowling", 300);
        BD tintin = new BD ("Tintin", "Hergé", 62, true);

        // Methode Simple d'ajout
        // bouquin.titre = "Harry Potter";
        // bouquin.auteur = "J.K. Rowling";
        // bouquin.pages = 300;
        // bouquin.dispo = true;

        // Les Méthodes (Les Actions)
        bouquin.afficherInfos();
        tintin.afficherInfos();

    }
}