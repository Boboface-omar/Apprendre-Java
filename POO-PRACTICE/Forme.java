// Classe ABSTRAITE car on ne peut pas créer une "Forme" générique
public abstract class Forme {
    private String couleur;
    
    public Forme(String couleur) {  // ⚠️ SEULEMENT couleur
        setCouleur(couleur);
    }
    
    // ========== GETTERS/SETTERS ==========
    public String getCouleur() {
        return couleur;
    }
    
    public void setCouleur(String couleur) {
        if (couleur == null || couleur.trim().isEmpty()) {
            throw new IllegalArgumentException("Couleur est obligatoire");
        }
        this.couleur = couleur;
    }
    
    // ========== MÉTHODES ABSTRAITES ==========
    // ⚠️ ABSTRAITES car chaque forme calcule différemment
    public abstract double calculerAire();
    public abstract double calculerPerimetre();
    
    // ========== MÉTHODE CONCRETE ==========
    public void afficherInfo() {
        System.out.println("\n=== Information Forme ===");
        System.out.println("Couleur : " + couleur);
        System.out.println("Aire : " + calculerAire());
        System.out.println("Périmètre : " + calculerPerimetre());
        System.out.println("=========================");
    }
    
    // ========== toString() ==========
    @Override
    public String toString() {
        return String.format("Forme[couleur=%s, aire=%.2f, perimetre=%.2f]", 
                           couleur, calculerAire(), calculerPerimetre());
    }
}