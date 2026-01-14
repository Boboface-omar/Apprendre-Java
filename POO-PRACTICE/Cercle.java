public class Cercle extends Forme {
    // ⚠️ Un cercle a un RAYON, pas de longueur/largeur
    private double rayon;
    
    public Cercle(String couleur, double rayon) {  // ⚠️ Pas de longueur/largeur
        super(couleur);
        setRayon(rayon);
    }
    
    // ========== GETTERS/SETTERS ==========
    public double getRayon() {
        return rayon;
    }
    
    public void setRayon(double rayon) {
        if (rayon <= 0) {
            throw new IllegalArgumentException("Rayon doit être positif");
        }
        this.rayon = rayon;
    }
    
    public double getDiametre() {
        return 2 * rayon;
    }
    
    // ========== IMPLÉMENTATION DES MÉTHODES ABSTRAITES ==========
    @Override
    public double calculerAire() {
        return Math.PI * rayon * rayon;  // πr²
    }
    
    @Override
    public double calculerPerimetre() {
        return 2 * Math.PI * rayon;  // 2πr
    }
    
    // ========== REDÉFINITION toString() ==========
    @Override
    public String toString() {
        return String.format("Cercle[couleur=%s, rayon=%.2f, aire=%.2f]", 
                           getCouleur(), rayon, calculerAire());
    }
}