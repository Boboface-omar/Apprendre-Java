// Encapsulation (getters/setters) :

public class ExoM07 {
    private String titre; // private pour l'encapsulation
    private String auteur;
    private int pages;
    private boolean estDispo; // Convention camelCase

    // Getters
    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getPages() {
        return pages;
    }

    public boolean isEstDispo() {
        return estDispo;
    }

    // Setters (avec validation si besoin)
    public void setTitre(String titre) {
        if (titre != null && !titre.trim().isEmpty()) {
            this.titre = titre;
        }
    }
}
