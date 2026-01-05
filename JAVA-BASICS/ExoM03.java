public class ExoM03 {

    public static void main(String[] args) {
        String titre = "Reverie";
        String auteur = "Rousseau";
        int nombre_de_page = 115;
        boolean est_dispo = true;

        if (est_dispo == true) {
            System.out.println("Le livre est prêt à être emprunté.");
        } else {
            System.out.println("Désolé, ce livre est déjà sorti.");
        }
    }
}