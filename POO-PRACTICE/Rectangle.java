public class Rectangle extends Forme {
    // ⚠️ Attributs SPÉCIFIQUES à Rectangle
    private double longueur;
    private double largeur;
    
    // ⚠️ Constructeur avec les bons paramètres
    public Rectangle(String couleur, double longueur, double largeur) {
        super(couleur);  // ⚠️ Appelle Forme(couleur)
        setLongueur(longueur);
        setLargeur(largeur);
    }
    
    // ========== GETTERS/SETTERS ==========
    public double getLongueur() {
        return longueur;
    }
    
    public void setLongueur(double longueur) {
        if (longueur <= 0) {
            throw new IllegalArgumentException("Longueur doit être positive");
        }
        this.longueur = longueur;
    }
    
    public double getLargeur() {
        return largeur;
    }
    
    public void setLargeur(double largeur) {
        if (largeur <= 0) {
            throw new IllegalArgumentException("Largeur doit être positive");
        }
        this.largeur = largeur;
    }
    
    // ========== IMPLÉMENTATION DES MÉTHODES ABSTRAITES ==========
    @Override
    public double calculerAire() {
        return longueur * largeur;
    }
    
    @Override
    public double calculerPerimetre() {
        return 2 * (longueur + largeur);
    }
    
    // ========== REDÉFINITION toString() ==========
    @Override
    public String toString() {
        return String.format("Rectangle[couleur=%s, longueur=%.2f, largeur=%.2f, aire=%.2f]", 
                           getCouleur(), longueur, largeur, calculerAire());
    }
}